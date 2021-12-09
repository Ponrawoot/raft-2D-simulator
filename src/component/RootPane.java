package component;

import javax.swing.GroupLayout.Alignment;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class RootPane extends VBox {
	private static TopBar topBar;
	private static GameDisplay gameDisplay;
	private static BottomBar bottomBar;
	
	public RootPane() {
		topBar = new TopBar();
		gameDisplay = new GameDisplay();
		bottomBar = new BottomBar();
		this.getChildren().add(topBar);
		this.getChildren().add(gameDisplay);
		bottomBar.setAlignment(Pos.BOTTOM_LEFT);
		this.getChildren().add(bottomBar);
	}

}
