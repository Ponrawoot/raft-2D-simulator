package game;

import java.util.ArrayList;

import game.base.Coordinate;
import game.base.Direction;
import game.base.Moveable;
import object.Eagle;
import object.MangoTree;
import object.PineconeTree;
import object.Weapon;
import object.base.ApplicationType;
import object.base.MaterialType;

public class Player implements Moveable {

	private static int maxHP, HP, wood, leaf, mangoSeed, pineconeSeed, fruit, plastic, feather, titanium, copper, metal,
			stone, scrape, hinge, nail, rope, circuit, fish, bird, eagleHead;
	private static boolean raft, receiver, anthena, canvas, steering, petrol, engine;
	private Weapon currentAxe;
	private Weapon currentShovel;
	private Weapon currentSpear;
	private static Cell currentPosition;
	private ArrayList<Weapon> playerWeapon;

	public Player() {
		// setMaxHP();
		HP = maxHP;
		wood = 0;
		leaf = 0;
		mangoSeed = 0;
		pineconeSeed = 0;
		plastic = 0;
		feather = 0;
		titanium = 0;
		copper = 0;
		metal = 0;
		stone = 0;
		scrape = 0;
		hinge = 0;
		nail = 0;
		rope = 0;
		circuit = 0;
		fish = 0;
		bird = 0;
		eagleHead = 0;
		raft = false;
		receiver = false;
		anthena = false;
		canvas = false;
		steering = false;
		petrol = false;
		engine = false;
		currentAxe = null;
		currentShovel = null;
		currentSpear = null;
		currentPosition = new Cell(new Coordinate(), false, false, true);
		playerWeapon = new ArrayList<Weapon>();
		playerWeapon.add(new Weapon(MaterialType.WOOD, ApplicationType.AXE));
	}

	public void checkHP() {
		if (HP == 0) {
			// pop up
			HP++;
			resetPosition();
		}
	}

	public static void resetPosition() {
//		currentPosition.getCoCell().setX();
//		currentPosition.getCoCell().setY();
	}

	public void decreaseHP() {
		if (HP > 0)
			HP--;
		checkHP();
	}

	public boolean increaseHP() {
		if (HP < maxHP) {
			HP++;
			return true;
		}
		return false;
	}

	public void increaseMaxHP(int n) {
		maxHP += n;
	}

	public void craft(String object) {
		switch (object) {
		case "Raft":
			raft = true;
//			wood -= ;
//			rope -= ;
			break;
		case "Rope":
//			leaf -= ;
			rope++;
			break;
		case "Wooden Axe":
//			wood -= ;
//			rope -= ;
			playerWeapon.add(new Weapon(MaterialType.WOOD, ApplicationType.AXE));
			break;
		case "Stone Axe":
//			wood -= ;
//			stone -=;
//			rope -= ;
			playerWeapon.add(new Weapon(MaterialType.STONE, ApplicationType.AXE));
			break;
		case "Metal Axe":
//			wood -= ;
//			metal -= ;
//			rope -= ;
			playerWeapon.add(new Weapon(MaterialType.METAL, ApplicationType.AXE));
			break;
		case "Stone Shovel":
//			wood -=;
//			stone -= ;
//			rope -= ;
			playerWeapon.add(new Weapon(MaterialType.STONE, ApplicationType.SHOVEL));
			break;
		case "Metal Shovel":
//			wood -=;
//			metal -= ;
//			rope  -= ;
			playerWeapon.add(new Weapon(MaterialType.METAL, ApplicationType.SHOVEL));
			break;
		case "Wooden Spear":
//			wood -= ;
			playerWeapon.add(new Weapon(MaterialType.WOOD, ApplicationType.SPEAR));
			break;
		case "Stone Spear":
//			wood -= ;
//			stone -= ;
//			rope -= ;
			playerWeapon.add(new Weapon(MaterialType.STONE, ApplicationType.SPEAR));
			break;
		case "Metal Spear":
//			wood -= ;
//			metal -= ;
//			rope -= ;
			playerWeapon.add(new Weapon(MaterialType.METAL, ApplicationType.SPEAR));
			break;
		case "Hinge":
//			metal -=;
			hinge++;
			break;
		case "Nail":
//			scrape -=;
			nail++;
			break;
		case "Circuit":
//			copper -= ;
//			plastic -= ;
			circuit++;
			break;
		case "Receiver":
//			circuit -= ;
//			wood -= ;
//			plastic -= ;
//			hinge -= ;
			receiver = true;
			break;
		case "Anthena":
//			circuit -= ;
//			scrape -= ;
//			nail -= ;
			anthena = true;
			break;
		}
		decreaseHP();
	}

	public void consume(String object) {
		switch (object) {
		case "Fruit":
			fruit--;
			break;
		case "Fish":
			fish--;
			break;
		case "Bird":
			bird--;
			break;
		}
		decreaseHP();
	}

	public void feed(Eagle eagle) {
		if (fish > 0 && Map.getMoveableForEagleArea().contains(currentPosition)) {
//			fish -= ;
//			eagle.setMove(false);
		}
	}

	public boolean plant(String object, Cell position) {
		if (Map.getPlantableArea().contains(position)) {
			switch (object) {
			case "Mango seed":
//				new MangoTree(position, false);
				mangoSeed--;
				break;
			case "Pinecone seed":
//				new PineconeTree(position, false);
				pineconeSeed--;
				break;
			}
			decreaseHP();
			position.setStatus(false);
			return true;
		}
		return false;
	}

	@Override
	public void move(Direction direction) {
		// TODO Auto-generated method stub
		int x = currentPosition.getCoCell().getX();
		int y = currentPosition.getCoCell().getY();

		// cell = position that player want to move to
		if (direction == Direction.UP) {
//			Cell cell = Map.getCellFromCoordinate(new Coordinate(x,y+1));
//			if (cell != null && cell.getStatus() && !cell.isSea() && !cell.isClosed()) setCurrentPosition(x, y+1);
		} else if (direction == Direction.DOWN) {
//			Cell cell = Map.getCellFromCoordinate(new Coordinate(x,y-1));
//			if (cell != null && cell.getStatus() && !cell.isSea() && !cell.isClosed()) setCurrentPosition(x, y-1);
		} else if (direction == Direction.LEFT) {
//			Cell cell = Map.getCellFromCoordinate(new Coordinate(x-1,y));
//			if (cell != null && cell.getStatus() && !cell.isSea() && !cell.isClosed()) setCurrentPosition(x-1, y);
		} else {
//			Cell cell = Map.getCellFromCoordinate(new Coordinate(x+1,y));
//			if (cell != null && cell.getStatus() && !cell.isSea() && !cell.isClosed()) setCurrentPosition(x+1, y);
		}
	}

	public void sail(Direction direction) {
		int x = currentPosition.getCoCell().getX();
		int y = currentPosition.getCoCell().getY();

		// cell = position that player want to move to
		if (raft) {
			if (direction == Direction.UP) {
//				Cell cell = Map.getCellFromCoordinate(new Coordinate(x,y+1));
//				if (cell != null && cell.getStatus() && cell.isSea() && !cell.isClosed())
//					setCurrentPosition(x, y + 1);
			} else if (direction == Direction.DOWN) {
//				Cell cell = Map.getCellFromCoordinate(new Coordinate(x,y-1));
//				if (cell != null && cell.getStatus() && cell.isSea() && !cell.isClosed())
//					setCurrentPosition(x, y - 1);
			} else if (direction == Direction.LEFT) {
//				Cell cell = Map.getCellFromCoordinate(new Coordinate(x-1,y));
//				if (cell != null && cell.getStatus() && cell.isSea() && !cell.isClosed())
//					setCurrentPosition(x - 1, y);
			} else {
//				Cell cell = Map.getCellFromCoordinate(new Coordinate(x+1,y));
//				if (cell != null && cell.getStatus() && cell.isSea() && !cell.isClosed())
//					setCurrentPosition(x + 1, y);
			}
		}
	}

	public static void setCurrentPosition(int x, int y) {
		Player.currentPosition.setCoCell(new Coordinate(x, y));
	}

	public int getMaxHP() {
		return maxHP;
	}

	public int getHP() {
		return HP;
	}

	public static int getWood() {
		return wood;
	}

	public static void setWood(int wood) {
		Player.wood = wood;
	}

	public int getLeaf() {
		return leaf;
	}

	public int getMangoSeed() {
		return mangoSeed;
	}

	public int getPineconeSeed() {
		return pineconeSeed;
	}

	public int getFruit() {
		return fruit;
	}

	public int getPlastic() {
		return plastic;
	}

	public int getFeather() {
		return feather;
	}

	public static int getTitanium() {
		return titanium;
	}

	public static void setTitanium(int titanium) {
		Player.titanium = titanium;
	}

	public int getCopper() {
		return copper;
	}

	public int getMetal() {
		return metal;
	}

	public int getStone() {
		return stone;
	}

	public int getScrape() {
		return scrape;
	}

	public static int getHinge() {
		return hinge;
	}

	public static void setHinge(int hinge) {
		Player.hinge = hinge;
	}

	public static int getNail() {
		return nail;
	}

	public static void setNail(int nail) {
		Player.nail = nail;
	}

	public static int getRope() {
		return rope;
	}

	public static void setRope(int rope) {
		Player.rope = rope;
	}

	public int getCircuit() {
		return circuit;
	}

	public int getFish() {
		return fish;
	}

	public int getBird() {
		return bird;
	}

	public int getEagleHead() {
		return eagleHead;
	}

	public boolean isRaft() {
		return raft;
	}

	public static boolean isReceiver() {
		return receiver;
	}

	public static void setReceiver(boolean receiver) {
		Player.receiver = receiver;
	}

	public static boolean isAnthena() {
		return anthena;
	}

	public static void setAnthena(boolean anthena) {
		Player.anthena = anthena;
	}

	public static boolean isCanvas() {
		return canvas;
	}

	public Weapon getCurrentAxe() {
		return currentAxe;
	}

	public Weapon getCurrentShovel() {
		return currentShovel;
	}

	public Weapon getCurrentSpear() {
		return currentSpear;
	}

	public static Cell getCurrentPosition() {
		return currentPosition;
	}

	public ArrayList<Weapon> getPlayerWeapon() {
		return playerWeapon;
	}

	public void setMaxHP(int maxHP) {
		if (maxHP > 0)
			this.maxHP = maxHP;
	}

	public static void setCanvas(boolean other) {
		canvas = other;
	}

	public static boolean isSteering() {
		return steering;
	}

	public static void setSteering(boolean other) {
		steering = other;
	}

	public static boolean isPetrol() {
		return petrol;
	}

	public static void setPetrol(boolean other) {
		petrol = other;
	}

	public static boolean isEngine() {
		return engine;
	}

	public static void setEngine(boolean other) {
		engine = other;
	}

}
