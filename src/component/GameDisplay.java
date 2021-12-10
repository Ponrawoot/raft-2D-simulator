package component;

import java.util.ArrayList;

import component.base.GameDisplayCell;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class GameDisplay extends GridPane {
	ArrayList<GameDisplayCell> cellList;
	public GameDisplay() {
		cellList = new ArrayList<GameDisplayCell>();
		GameDisplayCell cell;
		this.setHgap(1);
		this.setVgap(1);
		this.setPrefHeight(300);
		this.setPrefWidth(300);
		for (int i=0;i<20;i++) {
			for (int j=0;j<20;j++) {
				cell = new GameDisplayCell(i, j);
				this.add(cell,i,j);
				cellList.add(cell);
			}
		}
	}
}
	
