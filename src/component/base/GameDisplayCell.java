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
	private Cell cell;
	private ImageView ImageView;
	public GameDisplayCell(int x,int y) {
		this.x = x;
		this.y = y;
		map = new Map();
		Coordinate coCell = new Coordinate(x,y);
		cell = Map.getCellFromCoordinate(coCell);
		this.setPrefHeight(40);
		this.setPrefWidth(40);
		if (cell==null) {
			this.setBackground(new Background(new BackgroundFill(Color.MOCCASIN, CornerRadii.EMPTY, Insets.EMPTY)));
		} else if (cell.isSea()&&!cell.isClosed()) {
			this.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
		} else if (!cell.isSea()&&cell.isClosed()&&!cell.getStatus()) {
			this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
//		} else if (!cell.isSea()&&!cell.isClosed()&&!cell.getStatus()) {
//			this.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		} else if (!cell.isSea()&&!cell.isClosed()) {
			this.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			if (Map.getPlantableArea().contains(cell)) {
				this.setBackground(new Background(new BackgroundFill(Color.YELLOWGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		}
		
		ImageView = null;
		
		for (Animal fish : Map.getAvailableFish()) {
			if (fish.getPosition().isSamePosition(cell)) {
				ImageView = new ImageView(new Image("fish001.png"));
				ImageView.setFitHeight(40);
				ImageView.setFitWidth(40);
				this.getChildren().add(ImageView);
				break;
			}
		}
		
		for (Animal bird : Map.getAvailableBird()) {
			if (bird.getPosition().isSamePosition(cell)) {
				ImageView = new ImageView(new Image("Seagull.png"));
				ImageView.setFitHeight(40);
				ImageView.setFitWidth(40);
				this.getChildren().add(ImageView);
				break;
			}
		}
		
		for (Material metal : Map.getAvailableMetal()) {
			if (metal.getPosition().isSamePosition(cell)) {
				ImageView = new ImageView(new Image("Metal001.png"));
				ImageView.setFitHeight(40);
				ImageView.setFitWidth(40);
				this.getChildren().add(ImageView);
				break;
			}
		}
		
		for (Material scrap : Map.getAvailableScrape()) {
			if (scrap.getPosition().isSamePosition(cell)) {
				ImageView = new ImageView(new Image("Scrap.png"));
				ImageView.setFitHeight(40);
				ImageView.setFitWidth(40);
				this.getChildren().add(ImageView);
				break;
			}
		}
		
		for (Material plastic : Map.getAvailablePlastic()) {
			if (plastic.getPosition().isSamePosition(cell)) {
				ImageView = new ImageView(new Image("Plastic.png"));
				ImageView.setFitHeight(40);
				ImageView.setFitWidth(40);
				this.getChildren().add(ImageView);
				break;
			}
		}
		
		for (Material stone : Map.getAvailableStone()) {
			if (stone.getPosition().isSamePosition(cell)) {
				ImageView = new ImageView(new Image("Stone.png"));
				ImageView.setFitHeight(40);
				ImageView.setFitWidth(40);
				this.getChildren().add(ImageView);
				break;
			}
		}
		
		for (Tree tree : Map.getTrees()) {
			if (tree.getPosition().isSamePosition(cell)) {
				if (tree instanceof PalmTree) {
					ImageView = new ImageView(new Image("PalmTree.png"));
					ImageView.setFitHeight(40);
					ImageView.setFitWidth(40);
					this.getChildren().add(ImageView);
					break;
				} else if (tree instanceof PineconeTree) {
					ImageView = new ImageView(new Image("PineTree.png"));
					ImageView.setFitHeight(40);
					ImageView.setFitWidth(40);
					this.getChildren().add(ImageView);
					break;
				} else if (tree instanceof MangoTree) {
					ImageView = new ImageView(new Image("MangoTree.png"));
					ImageView.setFitHeight(40);
					ImageView.setFitWidth(40);
					this.getChildren().add(ImageView);
					break;
				}
			}
		}
		if (Map.getEagle().getPosition().isSamePosition(cell)) {
			ImageView = new ImageView(new Image("Eagle.png"));
			ImageView.setFitHeight(40);
			ImageView.setFitWidth(40);
			this.getChildren().add(ImageView);
		}
		
		if (cell.getCoCell().isSamePosition(new Coordinate(9,12))) {
			ImageView = new ImageView(new Image("Front.png"));
			ImageView.setFitHeight(40);
			ImageView.setFitWidth(40);
			this.getChildren().add(ImageView);
		}
	}
	public Cell getCell() {
		return cell;
	}
	
	public void SetImageViewBlank() {
		this.getChildren().clear();
		//this.setBackground(new Background(new BackgroundFill(Color.MOCCASIN, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	public void SetImageView(String string) {
		// TODO Auto-generated method stub
		String url;
		switch(string) {
		case "Front" :		url = "Front.png";	break;
		case "Right" : 	url = "Right.png"; break;
		case "Left" : 	url = "Left.png";  break;
		case "Back" : url = "Back.png"; break;
		case "TreeStump" : url = "TreeStump.png"; break;
		case "PalmTree" : url = "PalmTree.png"; break;
		case "MangoTree" : url = "MangoTree.png"; break;
		case "PineconeTree" : url = "PineTree.png"; break;
		case "Stone" : url = "Stone.png"; break;
		case "Plastic" : url = "Plastic.png"; break;
		case "Scrap" : url = "Scrap.png"; break;
		case "Metal" : url = "Metal001.png"; break;
		case "Fish" : url = "fish001.png"; break;
		case "Bird" : url = "Seagull.png"; break;
		case "Eagle" : url = "Eagle.png"; break;
		case "Mango seed" : url = "Mango seed.png"; break;
		case "Pinecone seed" : url = "Pinecone seed.png"; break;
		default : 	url = null; break;
	}
		ImageView = new ImageView(new Image(url));
		ImageView.setFitHeight(40);
		ImageView.setFitWidth(40);
		this.getChildren().add(ImageView);
		
	}
}
