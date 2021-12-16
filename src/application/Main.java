package application;

import component.RootPane;
import component.TopBar;
import game.Cell;
import game.Map;
import game.Player;
import game.base.Coordinate;
import game.base.Direction;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import object.MangoTree;
import object.PalmTree;
import object.PineTree;
import object.Weapon;
import object.base.ApplicationType;
import object.base.MaterialType;

public class Main extends Application {
	private static RootPane rootPane;
	private Player player;
	private ThreadMain threadMain;
	private static AudioClip themeSound = new AudioClip(ClassLoader.getSystemResource("audio/Raft.wav").toString());
	private static AudioClip walkingSound = new AudioClip(ClassLoader.getSystemResource("audio/sound1.mp3").toString());
	private static AudioClip actionSound = new AudioClip(ClassLoader.getSystemResource("audio/sound2.mp3").toString());
	private static AudioClip warningSound = new AudioClip(ClassLoader.getSystemResource("audio/sound3.mp3").toString());
	private static AudioClip[] sound = { themeSound, walkingSound, actionSound, warningSound };

	public void start(Stage primaryStage) throws Exception {
		player = new Player("player");
		rootPane = new RootPane(player);
		threadMain = new ThreadMain();

		Main.getSound()[0].setCycleCount(MediaPlayer.INDEFINITE);
		Main.getSound()[0].play();
		Main.getSound()[0].setVolume(0.5);

		walkingSound.setVolume(0.1);
		actionSound.setVolume(0.1);
		warningSound.setVolume(0.1);

		Scene scene = new Scene(rootPane, 1000, 1000);

		addEventListener(scene);
		primaryStage.setTitle("Raft 2D Simulator");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(event -> {
			themeSound.stop();
			Platform.exit();
			System.exit(0);
		});
	}

	public static AudioClip[] getSound() {
		return sound;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void addEventListener(Scene scene) {
		scene.setOnKeyPressed((KeyEvent e) -> {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String string = null;
			boolean redraw2 = false;
			Direction direction = player.getDirection();
			KeyCode code = e.getCode();
			int x = player.getCurrentPosition().getCoCell().getX();
			int y = player.getCurrentPosition().getCoCell().getY();
			Cell cell = Map.getCellFromCoordinate(new Coordinate(x, y));
			Cell cell2 = Map.getCellFromCoordinate(new Coordinate(x, y));

			switch (code) {
			case W:
				string = "Back";
				if (!player.control(Direction.UP)) {
					if ((player.checkMove(direction) || (player.checkSail(direction)))) {
						player.move(direction);
						walkingSound.play();
					}
				}
				TopBar.getInformationPane().update(player, direction);
				RootPane.redraw(player.getCurrentPosition(), cell, string);
				break;
			case S:
				string = "Front";
				if (!player.control(Direction.DOWN)) {
					if ((player.checkMove(direction) || (player.checkSail(direction)))) {
						player.move(direction);
						walkingSound.play();
					}
				}
				TopBar.getInformationPane().update(player, direction);
				RootPane.redraw(player.getCurrentPosition(), cell, string);
				break;
			case A:
				string = "Left";
				if (!player.control(Direction.LEFT)) {
					if ((player.checkMove(direction) || (player.checkSail(direction)))) {
						player.move(direction);
						walkingSound.play();
					}
				}
				TopBar.getInformationPane().update(player, direction);
				RootPane.redraw(player.getCurrentPosition(), cell, string);
				break;
			case D:
				string = "Right";
				if (!player.control(Direction.RIGHT)) {
					if ((player.checkMove(direction) || (player.checkSail(direction)))) {
						player.move(direction);
						walkingSound.play();
					}
				}
				TopBar.getInformationPane().update(player, direction);
				RootPane.redraw(player.getCurrentPosition(), cell, string);
				break;
			case P:
				string = "";
				cell = Map.getCellFromDirection(direction, new Coordinate(x, y));
				Object object = Map.getObjectFromCoordinate(cell.getCoCell());
				if (player.takeActionOnObject(Map.getCellFromDirection(direction, new Coordinate(x, y)))) {
					string = "Clear";
					threadMain.refreshObject(object);
					if ((object instanceof PalmTree))
						redraw2 = true;
					actionSound.play();

				}
				TopBar.getInformationPane().update(player, object);
				TopBar.showHpWarning(player);
				RootPane.redraw(player.getCurrentPosition(), cell, string);
				break;
			case OPEN_BRACKET:
				cell = Map.getCellFromDirection(direction, new Coordinate(x, y));
				boolean planted = player.plant("Mango seed", cell);
				if (planted) {
					RootPane.redraw(cell, cell, "Mango seed");
					MangoTree object1 = (MangoTree) Map.getObjectFromCoordinate(cell.getCoCell());
					threadMain.setGrow(object1);
				}
				TopBar.getInformationPane().update(cell, planted, "mango");
				break;
			case CLOSE_BRACKET:
				cell = Map.getCellFromDirection(direction, new Coordinate(x, y));
				boolean planted2 = player.plant("Pinecone", cell);
				if (planted2) {
					RootPane.redraw(cell, cell, "Pinecone");
					PineTree object2 = (PineTree) Map.getObjectFromCoordinate(cell.getCoCell());
					threadMain.setGrow(object2);
				}
				TopBar.getInformationPane().update(cell, planted2, "Pine");
				break;
			default:
				string = "";
				System.out.println(code);
				System.out.println("Invalid Key.");
				break;
			}
			if (redraw2) {
				RootPane.redrawTreeStump(cell);
			}

			if (player.isReset()) {
				RootPane.redraw(Map.getCellFromCoordinate(new Coordinate(9, 12)), cell2, "Front");
				player.setReset(false);
			}
			if (threadMain.activateEagle(player)) {
				TopBar.showHpWarning(player);
			}

		});
	}
}
