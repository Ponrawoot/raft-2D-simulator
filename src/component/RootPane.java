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
		gameDisplay = new GameDisplay();
		bottomBar = new BottomBar(player);
		this.getChildren().add(topBar);
		this.getChildren().add(gameDisplay);
		bottomBar.setAlignment(Pos.BOTTOM_LEFT);
		this.getChildren().add(bottomBar);
	}

	public static void redraw(Cell newCell, Cell cell, String string) {
		// TODO Auto-generated method stub
		if (string=="") return;
		if (string=="Clear") {
			for (GameDisplayCell x: gameDisplay.cellList) {
				if (x.getCell().isSamePosition(cell)) {
					x.SetImageViewBlank();
				}
			}
			return;
		}
		for (GameDisplayCell x: gameDisplay.cellList) {
			if (x.getCell().isSamePosition(cell)) {
				x.SetImageViewBlank();
			}
		}
		for (GameDisplayCell x: gameDisplay.cellList) {
			if (x.getCell().isSamePosition(newCell)) {
				x.SetImageView(string);
			}
		}
		
	}
	
	public static void redraw2(Cell cell) {
		for (GameDisplayCell x: gameDisplay.cellList) {
			if (x.getCell().isSamePosition(cell)) {
				x.SetImageView("TreeStump");
			}
		}
	}

}
