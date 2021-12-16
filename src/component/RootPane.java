package component;

import component.base.GameDisplayCell;
import game.Cell;
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
		topBar.setAlignment(Pos.TOP_CENTER);
		this.getChildren().add(topBar);

		gameDisplay = new GameDisplay();
		this.getChildren().add(gameDisplay);

		bottomBar = new BottomBar(player);
		bottomBar.setAlignment(Pos.BOTTOM_CENTER);
		this.getChildren().add(bottomBar);
	}

	public static void redraw(Cell newCell, Cell cell, String string) {
		// TODO Auto-generated method stub
		if (string == "")
			return;
		if (string == "Clear") {
			for (GameDisplayCell x : gameDisplay.cellList) {
				if (x.getCell().equals(cell)) {
					x.SetImageViewBlank();
				}
			}
			return;
		}
		for (GameDisplayCell x : gameDisplay.cellList) {
			if (x.getCell().equals(cell)) {
				x.SetImageViewBlank();
			}
		}
		for (GameDisplayCell x : gameDisplay.cellList) {
			if (x.getCell().equals(newCell)) {
				x.SetImageView(string);
			}
		}

	}

	public static void redraw2(Cell cell) {
		for (GameDisplayCell x : gameDisplay.cellList) {
			if (x.getCell().equals(cell)) {
				x.SetImageView("TreeStump");
			}
		}
	}

}
