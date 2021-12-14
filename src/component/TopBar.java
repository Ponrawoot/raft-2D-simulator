package component;

import java.text.SimpleDateFormat;
import java.util.Date;

import component.base.PauseButton;
import component.base.SettingButton;
import game.Player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	private SettingButton settingButton;
	private PauseButton pauseButton;

	public TopBar(Player player) {
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		playerName = new Text("Name: " + player.getName());
		hp = new ProgressBar(1);
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

		settingButton = new SettingButton();
		pauseButton = new PauseButton();
		pauseButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		hpText = new Text("HP: " + player.getHP());
		getChildren().addAll(playerName, hpText, hp, time, settingButton, pauseButton);
	}

	public static void setHp(Player player) {
		hpText.setText("HP: " + player.getHP());
		hp.setProgress((double) player.getHP() / player.getMaxHP());
	}

	public void setPlayerName(Player player) {
		playerName.setText(player.getName());
	}

	public static void showHpWarning(Player player) {
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
			});
			root.getChildren().addAll(text, btn);

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.showAndWait();
		}
	}

}
