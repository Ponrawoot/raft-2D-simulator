package component;

import java.text.SimpleDateFormat;
import java.util.Date;

import application.Main;
import component.base.CurrentWeaponPane;
import component.base.InformationPane;
import game.Map;
import game.Player;
import game.base.Coordinate;
import game.base.Direction;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TopBar extends FlowPane {
	private static ImageView imageView;
	private static ProgressBar hp;
	private static Text hpText;
	private static CurrentWeaponPane weaponPane;
	private static InformationPane informationPane;
	private Button muteButton;

	public TopBar(Player player) {
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);

		imageView = new ImageView(new Image("MyGame.png"));
		imageView.setFitHeight(100);
		imageView.setFitWidth(180);
		hp = new ProgressBar(0);
		hpText = new Text();
		setHp(player);

		weaponPane = new CurrentWeaponPane(player);
		informationPane = new InformationPane(player);
		muteButton = new Button("Mute");
		muteButton.setOnAction(event -> {
			if (Main.getSound()[0].isPlaying()) {
				Main.getSound()[0].stop();
				Main.getSound()[1].setVolume(0);
				Main.getSound()[2].setVolume(0);
				Main.getSound()[3].setVolume(0);
				muteButton.setText("Unmute");
			}
			else {
				Main.getSound()[0].play();
				Main.getSound()[1].setVolume(0.3);
				Main.getSound()[2].setVolume(0.3);
				Main.getSound()[3].setVolume(0.3);
				muteButton.setText("Mute");
			}
		});
		muteButton.setAlignment(Pos.TOP_RIGHT);
		getChildren().addAll(imageView, hpText, hp, weaponPane, informationPane, muteButton);
	}

	public static void setHp(Player player) {
		hpText.setText("HP: " + player.getHP());
		hp.setProgress((double) player.getHP() / player.getMaxHP());
	}



	public static boolean showHpWarning(Player player) {
		if (player.getHP() != 0)
			return false;
		if (player.getHP() == 0) {
			Main.getSound()[3].play();
			Stage stage = new Stage();
			stage.setTitle("Warning");
			VBox root = new VBox();
			root.setPrefWidth(150);
			root.setSpacing(20);
			root.setPadding(new Insets(10));
			root.setAlignment(Pos.CENTER);
			Text text = new Text("You don't have enough HP. Please eat something.");
			Button btn = new Button("get 1 extra HP");
			
			RootPane.redraw(Map.getCellFromCoordinate(new Coordinate()),player.getCurrentPosition(),"Front");
			player.resetPosition();
			
			btn.setOnAction(event -> {
				player.increaseHP();		
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
