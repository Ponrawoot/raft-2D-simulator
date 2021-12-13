package component;

import game.Player;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class RootPane extends VBox {
	private static TopBar topBar;
	private static GameDisplay gameDisplay;
	private static BottomBar bottomBar;

	public RootPane(Player player) {
		super();
		topBar = new TopBar(player);
		gameDisplay = new GameDisplay();
		bottomBar = new BottomBar(player);
		this.getChildren().add(topBar);
		this.getChildren().add(gameDisplay);
		bottomBar.setAlignment(Pos.BOTTOM_LEFT);
		this.getChildren().add(bottomBar);
	}

}
