package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import game.base.Coordinate;
import game.base.Database;
import game.base.Direction;
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

public class Map {
	private boolean isMorning;
//	int timeInGame, birdTime, fishTime, metalTime, scrapeTime, stoneTime, plasticTime, eagleTime;
	private static ArrayList<Cell> area;
	private static ArrayList<Cell> plantableArea;
	private static ArrayList<Cell> moveableForEagleArea;
	private static ArrayList<Animal> availableFish;
	private static ArrayList<Cell> randomFishCell;
	private static ArrayList<Animal> availableBird;
	private static ArrayList<Cell> randomBirdCell;
	private static ArrayList<Material> availableMetal;
	private static ArrayList<Material> availableScrape;
	private static ArrayList<Material> availablePlastic;
	private static ArrayList<Material> availableStone;
	private static ArrayList<Cell> middleIslandArea;
	private static ArrayList<Cell> repairableArea;
	private static ArrayList<Tree> trees;
	private static Eagle eagle;
	

	public static Eagle getEagle() {
		return eagle;
	}

	public Map() {
		this.setMorning(true);
		Database database = new Database();
		area = database.getArea();
		plantableArea = database.getPlantableArea();
		moveableForEagleArea = database.getMoveableForEagleArea();
		middleIslandArea = database.getMiddleIslandArea();
		repairableArea = database.getRepairableArea();
		randomFishCell = database.getRandomFishCell();
		randomBirdCell = database.getRandomBirdCell();
		availableFish = database.getAvailableFish();
		availableBird = database.getAvailableBird();
		availableMetal = database.getAvailableMetal();
		availableScrape = database.getAvailableScrape();
		availablePlastic = database.getAvailablePlastic();
		availableStone = database.getAvailableStone();
		trees = database.getTrees();
		eagle = new Eagle();
//		timeInGame = ;
//		birdTime = ;
//		fishTime = ;
//		metalTime = ;
//		scrapeTime = ;
//		stoneTime = ;
//		plasticTime =;
//		eagleTime = ;
	}

	public boolean isMorning() {
		return isMorning;
	}

	public void setMorning(boolean isMorning) {
		this.isMorning = isMorning;
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			int i = 15; // (second) can change

			@Override
			public void run() {
				// TODO Auto-generated method stub
				i--;
				if (i < 0) {
					timer.cancel();
					setMorning(!isMorning); 
				}
			}
		}, 0, 1000);
	}

	public static ArrayList<Animal> getAvailableFish() {
		return availableFish;
	}

	public static void setAvailableFish(ArrayList<Animal> availableFish) {
		Map.availableFish = availableFish;
	}

	public static ArrayList<Animal> getAvailableBird() {
		return availableBird;
	}

	public static void setAvailableBird(ArrayList<Animal> availableBird) {
		Map.availableBird = availableBird;
	}

//	public int getTimeInGame() {
//		return timeInGame;
//	}
//
//	public int getBirdTime() {
//		return birdTime;
//	}
//
//	public int getFishTime() {
//		return fishTime;
//	}
//
//	public int getMetalTime() {
//		return metalTime;
//	}
//
//	public int getScrapeTime() {
//		return scrapeTime;
//	}
//
//	public int getStoneTime() {
//		return stoneTime;
//	}
//
//	public int getPlasticTime() {
//		return plasticTime;
//	}
//
//	public int getEagleTime() {
//		return eagleTime;
//	}

	public static ArrayList<Cell> getArea() {
		return area;
	}

	public static ArrayList<Cell> getPlantableArea() {
		return plantableArea;
	}

	public static ArrayList<Cell> getMoveableForEagleArea() {
		return moveableForEagleArea;
	}

	public static ArrayList<Cell> getRandomFishCell() {
		return randomFishCell;
	}

	public static ArrayList<Cell> getRandomBirdCell() {
		return randomBirdCell;
	}

	public static ArrayList<Material> getAvailableMetal() {
		return availableMetal;
	}

	public static ArrayList<Material> getAvailableScrape() {
		return availableScrape;
	}

	public static ArrayList<Material> getAvailableStone() {
		return availableStone;
	}

	public static ArrayList<Material> getAvailablePlastic() {
		return availablePlastic;
	}

	public static ArrayList<Cell> getMiddleIslandArea() {
		return middleIslandArea;
	}

	public static ArrayList<Cell> getRepairableArea() {
		return repairableArea;
	}

	public static ArrayList<Tree> getTrees() {
		return trees;
	}

	public static void removeTree(Tree tree) {
		trees.remove(tree);
	}

	public void checkTimeAndPositon(Player player) {
		if (!middleIslandArea.contains(player.getCurrentPosition()) && !isMorning) {
			player.resetPosition();
		}
	}

	public static Cell getCellFromCoordinate(Coordinate other) {
		for (Cell x : area) {
			if (x.getCoCell().isSamePosition(other)) 
				return x;
		}
		return null;
	}
	
	public static Object getObjectFromCoordinate(Coordinate coordinate) {
		Cell cell = getCellFromCoordinate(coordinate);
		if (cell.getStatus()) return null;
		for (Animal x: Map.getAvailableFish()) {
			if (x.getPosition().isSamePosition(cell)) {
				Fish fish = (Fish) x;
				return fish;
			}
		}
		for (Animal x: Map.getAvailableBird()) {
			if (x.getPosition().isSamePosition(cell)) {
				Bird bird = (Bird) x;
				return bird;
			}
		}
		for (Material x: Map.getAvailableMetal()) {
			if (x.getPosition().isSamePosition(cell)) {
				Metal metal = (Metal) x;
				return metal;
			}
		}
		for (Material x: Map.getAvailablePlastic()) {
			if (x.getPosition().isSamePosition(cell)) {
				Plastic plastic = (Plastic) x;
				return plastic;
			}
		}
		for (Material x: Map.getAvailableScrape()) {
			if (x.getPosition().isSamePosition(cell)) {
				Scrape scrape = (Scrape) x;
				return scrape;
			}
		}
		for (Material x: Map.getAvailableStone()) {
			if (x.getPosition().isSamePosition(cell)) {
				Stone stone = (Stone) x;
				return stone;
			}
		}
		for (Tree x: Map.getTrees()) {
			if (x.getPosition().isSamePosition(cell)) {
				if (x instanceof PalmTree) {
					 return (PalmTree) x;
				 } 
				 if (x instanceof PineconeTree) {
					 return (PineconeTree) x;
				 } 
				 if (x instanceof MangoTree) {
					 return (MangoTree) x;
				 }
			}
		}
		if (Map.getEagle().getPosition().isSamePosition(cell)) {
			return Map.eagle;
		}
		return null;
		
	}

	public static Cell getCellFromDirection(Direction direction,Coordinate coordinate) {
		
		Coordinate c = coordinate;
		if (direction==Direction.UP) c.setY(c.getY()-1);
		if (direction==Direction.DOWN) c.setY(c.getY()+1);
		if (direction==Direction.RIGHT) c.setX(c.getX()+1);
		if (direction==Direction.LEFT) c.setX(c.getX()-1);
		
		return getCellFromCoordinate(c);
		
		
		
	}

	public static int getRandomInteger(int maximum, int minimum) {
		return ((int) (Math.random() * (maximum - minimum))) + minimum;
	}

	public static boolean readyForRandomAnimal(ArrayList<Animal> animals) {
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).isAlive()) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean readyForRandomMaterial(ArrayList<Material> material) {
		for (int i = 0; i < material.size(); i++) {
			if (material.get(i).isPresent()) {
				return false;
			}
		}
		return true;
	}


	public static void refreshFish(int random) {
		if (!readyForRandomAnimal(availableFish))
			return;
		Random rand = new Random();
		ArrayList<Cell> givenList = new ArrayList<Cell>();
		for (Cell x : area) {
			if (x.getStatus() && !x.isClosed() && x.isSea()) {
				givenList.add(x);
			}
		}

		for (int i = 0; i < random; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			Cell randomCell = givenList.get(randomIndex);
			if (i < availableFish.size()) {
				((Fish) availableFish.get(i)).refresh(randomCell);
			} else {
				Fish e = new Fish(randomCell);
				availableFish.add(e);
			}
		}
	}

	public static void refreshBird(int random) {
		if (!readyForRandomAnimal(availableBird))
			return;
		Random rand = new Random();
		ArrayList<Cell> givenList = new ArrayList<Cell>();
		for (Cell x : area) {
			if (x.getStatus() && !x.isClosed()) {
				givenList.add(x);
			}
		}

		for (int i = 0; i < random; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			Cell randomCell = givenList.get(randomIndex);
			if (i < availableBird.size()) {
				((Bird) availableBird.get(i)).refresh(randomCell);
			} else {
				Bird e = new Bird(randomCell);
				availableBird.add(e);
			}
		}

	}

	public static void refreshScrape(int random) {
		if (!readyForRandomMaterial(availableScrape)) return;
		Random rand = new Random();
		ArrayList<Cell> givenList = new ArrayList<Cell>();
		for (Cell x : area) {
			if (x.getStatus() && !x.isClosed()) {
				givenList.add(x);
			}
		}

		for (int i = 0; i < random; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			Cell randomCell = givenList.get(randomIndex);
			if (i < availableScrape.size()) {
				((Scrape) availableScrape.get(i)).refresh(randomCell);
			} else {
				Scrape e = new Scrape(randomCell);
				availableScrape.add(e);
			}
		}
	}

	public static void refreshPlastic(int random) {
		if (!readyForRandomMaterial(availablePlastic)) return;
		Random rand = new Random();
		ArrayList<Cell> givenList = new ArrayList<Cell>();
		for (Cell x : area) {
			if (x.getStatus() && !x.isClosed()) {
				givenList.add(x);
			}
		}

		for (int i = 0; i < random; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			Cell randomCell = givenList.get(randomIndex);
	        if (i < availablePlastic.size()) {
				((Plastic) availablePlastic.get(i)).refresh(randomCell);
			} else {
				Plastic e = new Plastic(randomCell);
				availablePlastic.add(e);
			}	
		}
	}

	public static void refreshStone(int random) {
		if (!readyForRandomMaterial(availableStone)) return;
		Random rand = new Random();
		ArrayList<Cell> givenList = new ArrayList<Cell>();
		for (Cell x : area) {
			if (x.getStatus() && !x.isClosed()) {
				givenList.add(x);
			}
		}

		for (int i = 0; i < random; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			Cell randomCell = givenList.get(randomIndex);
			if (i < availableStone.size()) {
				((Stone) availableStone.get(i)).refresh(randomCell);
			} else {
				Stone e = new Stone(randomCell);
				availableStone.add(e);
			}	
		}

	}
	
	//public static void 


	
	

}
