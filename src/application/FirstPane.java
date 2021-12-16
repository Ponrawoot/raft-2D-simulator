package application;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class FirstPane extends Pane {
	static Button playButton = new Button("Play");
	public FirstPane() {
		this.getChildren().add(playButton);
		}
	public static Button getPlayButton() {
		return playButton;
		
	}
}
