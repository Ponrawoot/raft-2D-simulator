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
import object.base.MaterialType;
import object.MangoTree;
import object.PalmTree;
import object.PineconeTree;
import object.Tree;
import object.Weapon;
import object.base.ApplicationType;

public class Main extends Application {
	private static RootPane rootPane;
	private Player player;
	private ThreadMain threadMain;
	private static AudioClip sound;

	public void start(Stage primaryStage) throws Exception {
		player = new Player("player");
//Cheat
		player.setHP(100);
		player.setMaxHP(100);
		player.setRaft(true);
		Weapon w1 = new Weapon(MaterialType.METAL, ApplicationType.AXE);
		player.setCurrentAxe(w1);
		player.addWeapon(w1);
		Weapon w2 = new Weapon(MaterialType.METAL, ApplicationType.SHOVEL);
		player.setCurrentShovel(w2);
		player.addWeapon(w2);
		Weapon w3 = new Weapon(MaterialType.METAL, ApplicationType.SPEAR);
		player.setCurrentSpear(w3);
		player.addWeapon(w3);
		player.setFish(5);
		player.setFruit(5);
		player.setBird(5);
		player.setMetal(100);
		player.setScrape(100);
		player.setPlastic(100);
		player.setWood(100);
		player.setRope(100);
		player.setLeaf(10);
		player.setStone(100);
//		player.setMangoSeed(10);
//		player.setPineconeSeed(10);
//	
		rootPane = new RootPane(player);
		threadMain = new ThreadMain();

		sound = new AudioClip(ClassLoader.getSystemResource("audio/Raft.wav").toString());
		sound.setCycleCount(MediaPlayer.INDEFINITE);
		sound.setVolume(20);
		sound.play();

		Scene scene = new Scene(rootPane, 1000, 1000);
		addEventListener(scene);

		primaryStage.setTitle("Raft 2D Simulator");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(event -> {
			sound.stop();
			Platform.exit();
			System.exit(0);
		});
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
					player.move(Direction.UP);
				}
				TopBar.getInformationPane().update(player, direction);
				RootPane.redraw(player.getCurrentPosition(), cell, string);
				break;
			case S:
				string = "Front";
				if (!player.control(Direction.DOWN)) {
					player.move(Direction.DOWN);
				}
				TopBar.getInformationPane().update(player, direction);
				RootPane.redraw(player.getCurrentPosition(), cell, string);
				break;
			case A:
				string = "Left";
				if (!player.control(Direction.LEFT)) {
					player.move(Direction.LEFT);
				}
				TopBar.getInformationPane().update(player, direction);
				RootPane.redraw(player.getCurrentPosition(), cell, string);
				break;
			case D:
				string = "Right";
				if (!player.control(Direction.RIGHT)) {
					player.move(Direction.RIGHT);
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

				}
				TopBar.getInformationPane().update(player, object);
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
				boolean planted2 = player.plant("Pinecone seed", cell);
				if (planted2) {
					RootPane.redraw(cell, cell, "Pinecone seed");
					PineconeTree object2 = (PineconeTree) Map.getObjectFromCoordinate(cell.getCoCell());
					threadMain.setGrow(object2);
				}
				TopBar.getInformationPane().update(cell, planted2, "pinecone");
				break;
			default:
				string = "";
				System.out.println(code);
				System.out.println("Invalid Key.");
				break;
			}
			if (redraw2) {
				RootPane.redraw2(cell);
				// threadmain.refreshPalmTree(cell);
			}

			if (player.isReset()) {
				RootPane.redraw(Map.getCellFromCoordinate(new Coordinate(9, 12)), cell2, "Front");
				player.setReset(false);
			}
			threadMain.activateEagle(player);
		});
	}

	public static AudioClip getSound() {
		return sound;
	}

}
