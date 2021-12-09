package component;

import component.base.PauseButton;
import component.base.SettingButton;
import game.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class TopBar extends FlowPane{
	private Text playerName;
	private ProgressBar hp;
	//show time
	private SettingButton settingButton;
	private PauseButton pauseButton;
	
	
	public TopBar() {
		setPadding(new Insets(5));
		playerName = new Text(Player.getName());
		hp = new ProgressBar(1);
		settingButton = new SettingButton();
		pauseButton = new PauseButton();
		pauseButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		getChildren().addAll(playerName, hp, settingButton, pauseButton);
	}

	public void setHp() {
		hp.setProgress(Player.getHP() / Player.getMaxHP());
	}

	public void setPlayerName() {
		playerName.setText(Player.getName());
	}

}

