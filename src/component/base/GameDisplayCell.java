package component.base;

import game.Map;
import game.Cell;
import game.base.Coordinate;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import object.Animal;
import object.MangoTree;
import object.Material;
import object.Tree;
import object.PalmTree;
import object.PineconeTree;

public class GameDisplayCell extends Pane {
	private static final String Tree = null;
	private int x,y;
	private Map map;
	public GameDisplayCell(int x,int y) {
		this.x = x;
		this.y = y;
		map = new Map();
		Coordinate coCell = new Coordinate(x,y);
		Cell cell = Map.getCellFromCoordinate(coCell);
		this.setPrefHeight(40);
		this.setPrefWidth(40);
		if (cell==null) {
			this.setBackground(new Background(new BackgroundFill(Color.MOCCASIN, CornerRadii.EMPTY, Insets.EMPTY)));
		} else if (cell.isSea()&&!cell.isClosed()) {
			this.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
		} else if (!cell.isSea()&&cell.isClosed()&&!cell.getStatus()) {
			this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		} else if (!cell.isSea()&&!cell.isClosed()&&!cell.getStatus()) {
			this.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		} else if (!cell.isSea()&&!cell.isClosed()&&cell.getStatus()) {
			this.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		
		for (Animal fish : Map.getAvailableFish()) {
			if (fish.getPosition().isSamePosition(cell)) {
				ImageView ImageView = new ImageView(new Image("fish001.png"));
				ImageView.setFitHeight(40);
				ImageView.setFitWidth(40);
				this.getChildren().add(ImageView);
				break;
			}
		}
		
		for (Animal bird : Map.getAvailableBird()) {
			if (bird.getPosition().isSamePosition(cell)) {
				ImageView ImageView = new ImageView(new Image("Seagull.png"));
				ImageView.setFitHeight(40);
				ImageView.setFitWidth(40);
				this.getChildren().add(ImageView);
				break;
			}
		}
		
		for (Material metal : Map.getAvailableMetal()) {
			if (metal.getPosition().isSamePosition(cell)) {
				ImageView ImageView = new ImageView(new Image("Metal001.png"));
				ImageView.setFitHeight(40);
				ImageView.setFitWidth(40);
				this.getChildren().add(ImageView);
				break;
			}
		}
		
		for (Material scrap : Map.getAvailableScrape()) {
			if (scrap.getPosition().isSamePosition(cell)) {
				ImageView ImageView = new ImageView(new Image("Scrap.png"));
				ImageView.setFitHeight(40);
				ImageView.setFitWidth(40);
				this.getChildren().add(ImageView);
				break;
			}
		}
		
		for (Material plastic : Map.getAvailablePlastic()) {
			if (plastic.getPosition().isSamePosition(cell)) {
				ImageView ImageView = new ImageView(new Image("Plastic.png"));
				ImageView.setFitHeight(40);
				ImageView.setFitWidth(40);
				this.getChildren().add(ImageView);
				break;
			}
		}
		
		for (Material stone : Map.getAvailableStone()) {
			if (stone.getPosition().isSamePosition(cell)) {
				ImageView ImageView = new ImageView(new Image("Stone.png"));
				ImageView.setFitHeight(40);
				ImageView.setFitWidth(40);
				this.getChildren().add(ImageView);
				break;
			}
		}
		
		for (Tree tree : Map.getTrees()) {
			if (tree.getPosition().isSamePosition(cell)) {
				if (tree instanceof PalmTree) {
					ImageView ImageView = new ImageView(new Image("PalmTree.png"));
					ImageView.setFitHeight(40);
					ImageView.setFitWidth(40);
					this.getChildren().add(ImageView);
					break;
				} else if (tree instanceof PineconeTree) {
					ImageView ImageView = new ImageView(new Image("PineTree.png"));
					ImageView.setFitHeight(40);
					ImageView.setFitWidth(40);
					this.getChildren().add(ImageView);
					break;
				} else if (tree instanceof MangoTree) {
					ImageView ImageView = new ImageView(new Image("MangoTree.png"));
					ImageView.setFitHeight(40);
					ImageView.setFitWidth(40);
					this.getChildren().add(ImageView);
					break;
				}
			}
		}
	}
}
