package component;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class RootPane extends VBox {
	//private static TopBar topBar;
	private static GameDisplay gameDisplay;
	private static BottomBar bottomBar;

	public RootPane() {
		super();
		//topBar = new TopBar(null);
		gameDisplay = new GameDisplay();
		bottomBar = new BottomBar();
		//this.getChildren().add(topBar);
		this.getChildren().add(gameDisplay);
		bottomBar.setAlignment(Pos.BOTTOM_LEFT);
		this.getChildren().add(bottomBar);
	}

}
