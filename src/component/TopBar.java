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
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class TopBar extends FlowPane {
	private Text playerName;
	private static ProgressBar hp;
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

		getChildren().addAll(playerName, hp, time, settingButton, pauseButton);
	}

	public static void setHp(Player player) {
		hp.setProgress(player.getHP() / player.getMaxHP());
	}

	public void setPlayerName(Player player) {
		playerName.setText(player.getName());
	}

}

