package game;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import game.base.Coordinate;
import game.base.Direction;
import game.base.Moveable;
import object.Animal;
import object.Bird;
import object.Eagle;
import object.Fish;
import object.MangoTree;
import object.Material;
import object.Metal;
import object.PalmTree;
import object.PineconeTree;
import object.Plastic;
import object.Scrape;
import object.Stone;
import object.Tree;
import object.Weapon;
import object.base.ApplicationType;
import object.base.MaterialType;

public class Player implements Moveable {
	private String name;
	private int maxHP, HP, wood, leaf, mangoSeed, pineconeSeed, fruit, plastic, feather, titanium, copper, metal, stone,
			scrape, hinge, nail, rope, circuit, fish, bird, eagleHead;
	private boolean raft, receiver, anthena, canvas, steering, petrol, engine;
	private Weapon currentAxe;
	private Weapon currentShovel;
	private Weapon currentSpear;
	private Cell currentPosition;
	private ArrayList<Weapon> playerWeapon;
	private Direction direction;

	public Player(String name) {
		setMaxHP(10);
		this.name = name;
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
		direction = Direction.DOWN;
	}

	public void checkHP() {
		if (HP == 0) {
			// pop up
			HP++;
			resetPosition();
		}
	}

	public void resetPosition() {
		currentPosition.getCoCell().setX(9);
		currentPosition.getCoCell().setY(12);
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
			wood -= 20;
			rope -= 10;
			break;
		case "Rope":
			leaf -= 5;
			rope++;
			break;
		case "Wooden Axe":
			wood -= 10;
			rope -= 3;
			playerWeapon.add(new Weapon(MaterialType.WOOD, ApplicationType.AXE));
			break;
		case "Stone Axe":
			wood -= 5;
			stone -= 5;
			rope -= 3;
			playerWeapon.add(new Weapon(MaterialType.STONE, ApplicationType.AXE));
			break;
		case "Metal Axe":
			wood -= 5;
			metal -= 5;
			rope -= 3;
			playerWeapon.add(new Weapon(MaterialType.METAL, ApplicationType.AXE));
			break;
		case "Stone Shovel":
			wood -= 5;
			stone -= 7;
			rope -= 3;
			playerWeapon.add(new Weapon(MaterialType.STONE, ApplicationType.SHOVEL));
			break;
		case "Metal Shovel":
			wood -= 5;
			metal -= 4;
			rope -= 3;
			playerWeapon.add(new Weapon(MaterialType.METAL, ApplicationType.SHOVEL));
			break;
		case "Wooden Spear":
			wood -= 10;
			playerWeapon.add(new Weapon(MaterialType.WOOD, ApplicationType.SPEAR));
			break;
		case "Stone Spear":
			wood -= 5;
			stone -= 6;
			rope -= 3;
			playerWeapon.add(new Weapon(MaterialType.STONE, ApplicationType.SPEAR));
			break;
		case "Metal Spear":
			wood -= 5;
			metal -= 5;
			rope -= 3;
			playerWeapon.add(new Weapon(MaterialType.METAL, ApplicationType.SPEAR));
			break;
		case "Hinge":
			metal -= 2;
			hinge++;
			break;
		case "Nail":
			scrape -= 3;
			nail++;
			break;
		case "Circuit":
			copper -= 2;
			plastic -= 4;
			circuit++;
			break;
		case "Receiver":
			circuit -= 10;
			wood -= 10;
			plastic -= 15;
			hinge -= 7;
			receiver = true;
			break;
		case "Anthena":
			circuit -= 8;
			scrape -= 15;
			nail -= 15;
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
		increaseHP();
	}

	public void feed(Eagle eagle) {
		if (fish > 3 && Map.getMoveableForEagleArea().contains(currentPosition)) {
			fish -= 3;
			eagle.setMove(false);

			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				int i = 15; // (second) can change

				@Override
				public void run() {
					// TODO Auto-generated method stub
					i--;
					if (i < 0) {
						timer.cancel();
						eagle.setMove(true);
					}
				}
			}, 0, 1000);
		}
	}

	public boolean plant(String object, Cell position) {
		if (Map.getPlantableArea().contains(position) && position.getStatus()) {
			switch (object) {
			case "Mango seed":
				new MangoTree(position);
				mangoSeed--;
				break;
			case "Pinecone seed":
				new PineconeTree(position);
				pineconeSeed--;
				break;
			}
			decreaseHP();
			position.setStatus(false);
			return true;
		}
		return false;
	}

	public boolean control(Direction direction) {
		if (this.direction != direction) {
			setDirection(direction);
			return true;
		}
		return false;
	}

	public void takeActionOnObject(Cell cell) {
		// TODO Auto-generated method stub
		if (!cell.getStatus())
			return;
		for (Animal x : Map.getAvailableFish()) {
			if (x.getPosition().isSamePosition(cell)) {
				Fish fish = (Fish) x;
				fish.beRemoved(this);
				return;
			}
		}
		for (Animal x : Map.getAvailableBird()) {
			if (x.getPosition().isSamePosition(cell)) {
				Bird bird = (Bird) x;
				bird.beRemoved(this);
				return;
			}
		}
		for (Material x : Map.getAvailableMetal()) {
			if (x.getPosition().isSamePosition(cell)) {
				Metal metal = (Metal) x;
				metal.beRemoved(this);
				return;
			}
		}
		for (Material x : Map.getAvailablePlastic()) {
			if (x.getPosition().isSamePosition(cell)) {
				Plastic plastic = (Plastic) x;
				plastic.beRemoved(this);
				return;
			}
		}
		for (Material x : Map.getAvailableScrape()) {
			if (x.getPosition().isSamePosition(cell)) {
				Scrape scrpe = (Scrape) x;
				scrpe.beRemoved(this);
				return;
			}
		}
		for (Material x : Map.getAvailableStone()) {
			if (x.getPosition().isSamePosition(cell)) {
				Stone stone = (Stone) x;
				stone.beRemoved(this);
				return;
			}
		}
		for (Tree x : Map.getTrees()) {
			if (x.getPosition().isSamePosition(cell))
				;
			if (x instanceof PalmTree) {
				((PalmTree) x).collect(this);
				return;
			} else if (x instanceof PineconeTree) {
				((PineconeTree) x).beRemoved(this);
				return;
			} else if (x instanceof MangoTree) {
				((MangoTree) x).beRemoved(this);
				return;
			}
		}
		if (Map.getEagle().getPosition().isSamePosition(cell)) {
			Map.getEagle().killed(this);
			return;
		}

	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	private boolean checkMove(Direction direction) {
		// TODO Auto-generated method stub
		int x = currentPosition.getCoCell().getX();
		int y = currentPosition.getCoCell().getY();
		if (direction == Direction.UP) {
			Cell cell = Map.getCellFromCoordinate(new Coordinate(x, y - 1));
			if (cell != null && cell.getStatus() && !cell.isSea() && !cell.isClosed())
				return true;
		} else if (direction == Direction.DOWN) {
			Cell cell = Map.getCellFromCoordinate(new Coordinate(x, y + 1));
			if (cell != null && cell.getStatus() && !cell.isSea() && !cell.isClosed())
				return true;
		} else if (direction == Direction.LEFT) {
			Cell cell = Map.getCellFromCoordinate(new Coordinate(x - 1, y));
			if (cell != null && cell.getStatus() && !cell.isSea() && !cell.isClosed())
				return true;
		} else {
			Cell cell = Map.getCellFromCoordinate(new Coordinate(x + 1, y));
			if (cell != null && cell.getStatus() && !cell.isSea() && !cell.isClosed())
				return true;
		}
		return false;
	}
	@Override
	public void move(Direction direction) {
		// TODO Auto-generated method stub
		int x = currentPosition.getCoCell().getX();
		int y = currentPosition.getCoCell().getY();
		if (checkMove(direction)||(checkSail(direction))) {
			if (direction == Direction.UP) {
				setCurrentPosition(x, y - 1);
			} else if (direction == Direction.DOWN) {
				setCurrentPosition(x, y + 1);
			} else if (direction == Direction.LEFT) {
				setCurrentPosition(x - 1, y);
			} else {
				setCurrentPosition(x + 1, y);
			}
		}
		// cell = position that player want to move to
	
	}

	private boolean checkSail(Direction direction) {
		// TODO Auto-generated method stub
		int x = currentPosition.getCoCell().getX();
		int y = currentPosition.getCoCell().getY();
		if (raft) {
			if (direction == Direction.UP) {
				Cell cell = Map.getCellFromCoordinate(new Coordinate(x, y - 1));
				if (cell != null && cell.getStatus() && cell.isSea() && !cell.isClosed())
					return true;
			} else if (direction == Direction.DOWN) {
				Cell cell = Map.getCellFromCoordinate(new Coordinate(x, y + 1));
				if (cell != null && cell.getStatus() && cell.isSea() && !cell.isClosed())
					return true;
			} else if (direction == Direction.LEFT) {
				Cell cell = Map.getCellFromCoordinate(new Coordinate(x - 1, y));
				if (cell != null && cell.getStatus() && cell.isSea() && !cell.isClosed())
					return true;
			} else {
				Cell cell = Map.getCellFromCoordinate(new Coordinate(x + 1, y));
				if (cell != null && cell.getStatus() && cell.isSea() && !cell.isClosed())
					return true;
			}
		}
		return false;
	}

//	public void sail(Direction direction) {
//		int x = currentPosition.getCoCell().getX();
//		int y = currentPosition.getCoCell().getY();
//
//		// cell = position that player want to move to
//		if (raft) {
//			if (direction == Direction.UP) {
//				Cell cell = Map.getCellFromCoordinate(new Coordinate(x, y - 1));
//				if (cell != null && cell.getStatus() && cell.isSea() && !cell.isClosed())
//					setCurrentPosition(x, y - 1);
//			} else if (direction == Direction.DOWN) {
//				Cell cell = Map.getCellFromCoordinate(new Coordinate(x, y + 1));
//				if (cell != null && cell.getStatus() && cell.isSea() && !cell.isClosed())
//					setCurrentPosition(x, y + 1);
//			} else if (direction == Direction.LEFT) {
//				Cell cell = Map.getCellFromCoordinate(new Coordinate(x - 1, y));
//				if (cell != null && cell.getStatus() && cell.isSea() && !cell.isClosed())
//					setCurrentPosition(x - 1, y);
//			} else {
//				Cell cell = Map.getCellFromCoordinate(new Coordinate(x + 1, y));
//				if (cell != null && cell.getStatus() && cell.isSea() && !cell.isClosed())
//					setCurrentPosition(x + 1, y);
//			}
//		}
//	}

	public void addWeapon(Weapon weapon) {
		playerWeapon.add(weapon);
	}

	public void setCurrentPosition(int x, int y) {
		currentPosition.setCoCell(new Coordinate(x, y));
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		if (maxHP > 0)
			this.maxHP = maxHP;
	}

	public int getHP() {
		return HP;
	}

	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public int getLeaf() {
		return leaf;
	}

	public void setLeaf(int leaf) {
		this.leaf = leaf;
	}

	public int getMangoSeed() {
		return mangoSeed;
	}

	public void setMangoSeed(int mangoSeed) {
		this.mangoSeed = mangoSeed;
	}

	public int getPineconeSeed() {
		return pineconeSeed;
	}

	public void setPineconeSeed(int pineconeSeed) {
		this.pineconeSeed = pineconeSeed;
	}

	public int getFruit() {
		return fruit;
	}

	public void setFruit(int fruit) {
		this.fruit = fruit;
	}

	public int getPlastic() {
		return plastic;
	}

	public void setPlastic(int plastic) {
		this.plastic = plastic;
	}

	public int getFeather() {
		return feather;
	}

	public void setFeather(int feather) {
		this.feather = feather;
	}

	public int getTitanium() {
		return titanium;
	}

	public void setTitanium(int titanium) {
		this.titanium = titanium;
	}

	public int getCopper() {
		return copper;
	}

	public void setCopper(int copper) {
		this.copper = copper;
	}

	public int getMetal() {
		return metal;
	}

	public void setMetal(int metal) {
		this.metal = metal;
	}

	public int getStone() {
		return stone;
	}

	public void setStone(int stone) {
		this.stone = stone;
	}

	public int getScrape() {
		return scrape;
	}

	public void setScrape(int scrape) {
		this.scrape = scrape;
	}

	public int getHinge() {
		return hinge;
	}

	public void setHinge(int hinge) {
		this.hinge = hinge;
	}

	public int getNail() {
		return nail;
	}

	public void setNail(int nail) {
		this.nail = nail;
	}

	public int getRope() {
		return rope;
	}

	public void setRope(int rope) {
		this.rope = rope;
	}

	public int getCircuit() {
		return circuit;
	}

	public int getFish() {
		return fish;
	}

	public void setFish(int fish) {
		this.fish = fish;
	}

	public int getBird() {
		return bird;
	}

	public void setBird(int bird) {
		this.bird = bird;
	}

	public int getEagleHead() {
		return eagleHead;
	}

	public void setEagleHead(int eagleHead) {
		this.eagleHead = eagleHead;
	}

	public boolean hasRaft() {
		return raft;
	}

	public boolean hasReceiver() {
		return receiver;
	}

	public void setReceiver(boolean receiver) {
		this.receiver = receiver;
	}

	public boolean hasAnthena() {
		return anthena;
	}

	public void setAnthena(boolean anthena) {
		this.anthena = anthena;
	}

	public boolean hasCanvas() {
		return canvas;
	}

	public Weapon getCurrentAxe() {
		return currentAxe;
	}

	public void setCurrentAxe(Weapon currentAxe) {
		addWeapon(this.currentAxe);
		this.currentAxe = currentAxe;
	}

	public Weapon getCurrentShovel() {
		return currentShovel;
	}

	public void setCurrentShovel(Weapon currentShovel) {
		addWeapon(this.currentShovel);
		this.currentShovel = currentShovel;
	}

	public Weapon getCurrentSpear() {
		return currentSpear;
	}

	public void setCurrentSpear(Weapon currentSpear) {
		addWeapon(this.currentSpear);
		this.currentSpear = currentSpear;
	}

	public Cell getCurrentPosition() {
		return currentPosition;
	}

	public ArrayList<Weapon> getPlayerWeapon() {
		return playerWeapon;
	}

	public void setCanvas(boolean other) {
		canvas = other;
	}

	public boolean hasSteering() {
		return steering;
	}

	public void setSteering(boolean other) {
		steering = other;
	}

	public boolean hasPetrol() {
		return petrol;
	}

	public void setPetrol(boolean other) {
		petrol = other;
	}

	public boolean hasEngine() {
		return engine;
	}

	public void setEngine(boolean other) {
		engine = other;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void decreaseLifetime(ApplicationType type) {
		if (type == ApplicationType.SHOVEL)
			currentShovel.setLifetime(currentShovel.getLifetime() - 1);
		if (type == ApplicationType.AXE)
			currentAxe.setLifetime(currentAxe.getLifetime() - 1);
		if (type == ApplicationType.SPEAR)
			currentSpear.setLifetime(currentSpear.getLifetime() - 1);
		checkLifetime();
	}

	public void checkLifetime() {
		if (currentShovel != null && currentShovel.getLifetime() == 0)
			setCurrentShovel(null);
		if (currentAxe != null && currentAxe.getLifetime() == 0)
			setCurrentAxe(null);
		if (currentSpear != null && currentSpear.getLifetime() == 0)
			setCurrentSpear(null);

	}

	public void setRaft(boolean raft) {
		this.raft = raft;
	}

}
