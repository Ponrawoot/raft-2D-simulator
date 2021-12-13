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

public class Main extends Application {
	private static RootPane rootPane;
	private Player player;

	public void start(Stage primaryStage) throws Exception {
		player = new Player("player");
		rootPane = new RootPane(player);

		Scene scene = new Scene(rootPane, 1000, 1000);

		primaryStage.setTitle("Survival Simulator");
		primaryStage.setScene(scene);
		primaryStage.show();

		player.setRaft(true);
		rootPane.setOnKeyPressed((KeyEvent e) -> {
			KeyCode code = e.getCode();
			int x = player.getCurrentPosition().getCoCell().getX();
			int y = player.getCurrentPosition().getCoCell().getY();
			Cell c = Map.getCellFromCoordinate(new Coordinate(x, y));
			switch (code) {
			case W:
				player.move(Direction.UP);
				break;
			case S:
				player.move(Direction.DOWN);
				break;
			case A:
				player.move(Direction.LEFT);
				break;
			case D:
				player.move(Direction.RIGHT);
				break;
			default:
				System.out.println("Invalid Key.");
				break;
			}
			RootPane.redraw(player, c);
		});

	}

	public static void main(String[] args) {
		launch(args);
	}

}
