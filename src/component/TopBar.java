package component;

import java.text.SimpleDateFormat;
import java.util.Date;

import application.Main;
import component.base.CurrentWeaponPane;
import component.base.InformationPane;
import game.Player;
import game.base.Direction;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TopBar extends FlowPane {
	private Text playerName;
	private static ProgressBar hp;
	private static Text hpText;
	private Label time;
	private static CurrentWeaponPane weaponPane;
	private static InformationPane informationPane;
	private Button muteButton;

	public TopBar(Player player) {
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);

		playerName = new Text("Name: " + player.getName());

		hp = new ProgressBar(0);
		hpText = new Text();
		setHp(player);

		time = new Label();
		Thread thread = new Thread(() -> {
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println(e);
				}
				final String timenow = sdf.format(new Date());
				Platform.runLater(() -> {
					time.setText(timenow);
				});
			}
		});
		thread.start();

		weaponPane = new CurrentWeaponPane(player);
		informationPane = new InformationPane(player);
		muteButton = new Button("Mute");
		muteButton.setOnAction(event -> {
			if (Main.getSound().isPlaying()) {
				Main.getSound().stop();
				muteButton.setText("Unmute");
			}
			else {
				Main.getSound().play();
				muteButton.setText("Mute");
			}
		});
		muteButton.setAlignment(Pos.TOP_RIGHT);
		getChildren().addAll(playerName, hpText, hp, time, weaponPane, informationPane, muteButton);
	}

	public static void setHp(Player player) {
		hpText.setText("HP: " + player.getHP());
		hp.setProgress((double) player.getHP() / player.getMaxHP());
	}

	public void setPlayerName(Player player) {
		playerName.setText(player.getName());
	}

	public static boolean showHpWarning(Player player) {
		if (player.getHP() != 0)
			return false;
		if (player.getHP() == 0) {
			Stage stage = new Stage();
			stage.setTitle("Warning");

			VBox root = new VBox();
			root.setPrefWidth(150);
			root.setSpacing(20);
			root.setPadding(new Insets(10));
			root.setAlignment(Pos.CENTER);
			Text text = new Text("You don't have enough HP. Please eat something.");
			Button btn = new Button("get 1 extra HP");
			btn.setOnAction(event -> {
				player.increaseHP();
				player.resetPosition();
				stage.close();
				TopBar.setHp(player);
				player.setReset(true);
				player.setDirection(Direction.DOWN);
			});
			root.getChildren().addAll(text, btn);

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.showAndWait();

		}
		return true;
	}

	public static CurrentWeaponPane getWeaponPane() {
		return weaponPane;
	}

	public static InformationPane getInformationPane() {
		return informationPane;
	}

}
