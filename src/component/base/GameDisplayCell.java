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
		this.setPrefHeight(15);
		this.setPrefWidth(15);
		this.setBackground(new Background(new BackgroundFill(Color.MOCCASIN, CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
