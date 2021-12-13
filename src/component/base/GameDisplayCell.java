package component.base;

import game.Map;
import game.Cell;
import game.base.Coordinate;
import javafx.geometry.Insets;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class GameDisplayCell extends Pane {
	private int x,y;
	private Map map;
	public GameDisplayCell(int x,int y) {
		this.x = x;
		this.y = y;
		map = new Map();
		Coordinate coCell = new Coordinate(x,y);
		Cell cell = Map.getCellFromCoordinate(coCell);
		this.setPrefHeight(30);
		this.setPrefWidth(30);
		if (cell==null) {
			this.setBackground(new Background(new BackgroundFill(Color.MOCCASIN, CornerRadii.EMPTY, Insets.EMPTY)));
		} else if (cell.isSea()&&!cell.isClosed()&&cell.getStatus()) {
			this.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
		} else if (!cell.isSea()&&cell.isClosed()&&!cell.getStatus()) {
			this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		} else if (!cell.isSea()&&!cell.isClosed()&&!cell.getStatus()) {
			this.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		} else if (!cell.isSea()&&!cell.isClosed()&&cell.getStatus()) {
			this.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		}
	}
}
