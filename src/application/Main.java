package application;

import component.RootPane;
import game.Cell;
import game.Map;
import game.Player;
import game.base.Coordinate;
import game.base.Direction;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import object.base.MaterialType;
import object.Weapon;
import object.base.ApplicationType;

public class Main extends Application {
	private static RootPane rootPane;
	private Player player;

	public void start(Stage primaryStage) throws Exception {
		player = new Player("player");
		rootPane = new RootPane(player);

		Scene scene = new Scene(rootPane, 1000, 1000);


//Cheat
		player.setRaft(true);
		player.setWood(1);
		player.setCurrentAxe(new Weapon(MaterialType.METAL, ApplicationType.AXE));
		player.setCurrentShovel(new Weapon(MaterialType.METAL, ApplicationType.SHOVEL));
		player.setCurrentSpear(new Weapon(MaterialType.METAL, ApplicationType.SPEAR));
//

		scene.setOnKeyPressed((KeyEvent e) -> {
			String string = null;
			Direction direction = player.getDirection();
			KeyCode code = e.getCode();
			int x = player.getCurrentPosition().getCoCell().getX();
			int y = player.getCurrentPosition().getCoCell().getY();
			Cell cell = Map.getCellFromCoordinate(new Coordinate(x, y));
			switch (code) {
			case W:
				string = "Back";
				if (!player.control(Direction.UP)) {
					player.move(Direction.UP);
				}
				break;
			case S:
				string = "Front";
				if (!player.control(Direction.DOWN)) {
					player.move(Direction.DOWN);
				}
				break;
			case A:
				string = "Left";
				if (!player.control(Direction.LEFT)) {
					player.move(Direction.LEFT);
				}
				break;
			case D:
				string = "Right";
				if (!player.control(Direction.RIGHT)) {
					player.move(Direction.RIGHT);
				}
				break;
			case P:
				string = "";
				cell = Map.getCellFromDirection(direction, new Coordinate(x,y));
				if (player.takeActionOnObject(Map.getCellFromDirection(direction, new Coordinate(x,y)))) {
					string = "Clear";
				}
			break;
			default:
				string = "";
				System.out.println(code);
				System.out.println("Invalid Key.");
				break;
			}
			RootPane.redraw(player.getCurrentPosition(), cell, string);
		});

		primaryStage.setTitle("Survival Simulator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
