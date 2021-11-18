package game;

import java.util.ArrayList;
import java.util.Random;

import game.base.Coordinate;
import object.Animal;
import object.Bird;
import object.Fish;
import object.Metal;
import object.Plastic;
import object.Scrape;
import object.Stone;
import object.Tree;

public class Map {
	private boolean isMorning;
	int timeInGame, birdTime, fishTime, metalTime, scrapeTime, stoneTime, plasticTime, eagleTime;
	private static ArrayList<Cell> area;
	private static ArrayList<Cell> plantableArea;
	private static ArrayList<Cell> moveableForEagleArea;
	private static ArrayList<Animal> availableFish;
	private static ArrayList<Cell> randomFishCell;
	private static ArrayList<Animal> availableBird;
	private static ArrayList<Cell> randomBirdCell;
	private static ArrayList<Metal> availableMetal;
	private static ArrayList<Scrape> availableScrape;
	private static ArrayList<Plastic> availablePlastic;
	private static ArrayList<Cell> middleIslandArea;
	private static ArrayList<Cell> repairableArea;
	private static ArrayList<Stone> availableStone;
	private static ArrayList<Tree> trees;

	public Map() {
		this.setMorning(true);
//		timeInGame = ;
//		birdTime = ;
//		fishTime = ;
//		metalTime = ;
//		scrapeTime = ;
//		stoneTime = ;
//		plasticTime =;
//		eagleTime = ;
//		area = ;
//		plantableArea = ;
//		moveableForEagleArea = ;
//		availableFish = ;
//		randomFishCell = ;
//		availableBird = ;
//		randomBirdCell = ;
//		availableMetal = ;
//		availableScrape = ;
//		availableStone = ;
//		availablePlastic = ;
//		middleIslandArea = ;
//		repairableArea = ;
//		Tree = ;
	}

	public boolean isMorning() {
		return isMorning;
	}

	public void setMorning(boolean isMorning) {
		this.isMorning = isMorning;
	}

	public ArrayList<Animal> getAvailableFish() {
		return availableFish;
	}

	public static void setAvailableFish(ArrayList<Animal> availableFish) {
		Map.availableFish = availableFish;
	}

	public ArrayList<Animal> getAvailableBird() {
		return availableBird;
	}

	public static void setAvailableBird(ArrayList<Animal> availableBird) {
		Map.availableBird = availableBird;
	}

	public int getTimeInGame() {
		return timeInGame;
	}

	public int getBirdTime() {
		return birdTime;
	}

	public int getFishTime() {
		return fishTime;
	}

	public int getMetalTime() {
		return metalTime;
	}

	public int getScrapeTime() {
		return scrapeTime;
	}

	public int getStoneTime() {
		return stoneTime;
	}

	public int getPlasticTime() {
		return plasticTime;
	}

	public int getEagleTime() {
		return eagleTime;
	}

	public static ArrayList<Cell> getArea() {
		return area;
	}

	public static ArrayList<Cell> getPlantableArea() {
		return plantableArea;
	}

	public static ArrayList<Cell> getMoveableForEagleArea() {
		return moveableForEagleArea;
	}

	public ArrayList<Cell> getRandomFishCell() {
		return randomFishCell;
	}

	public ArrayList<Cell> getRandomBirdCell() {
		return randomBirdCell;
	}

	public ArrayList<Metal> getAvailableMetal() {
		return availableMetal;
	}

	public static ArrayList<Scrape> getAvailableScrape() {
		return availableScrape;
	}

	public ArrayList<Stone> getAvailableStone() {
		return availableStone;
	}

	public ArrayList<Plastic> getAvailablePlastic() {
		return availablePlastic;
	}

	public ArrayList<Cell> getMiddleIslandArea() {
		return middleIslandArea;
	}

	public ArrayList<Cell> getRepairableArea() {
		return repairableArea;
	}

	public ArrayList<Tree> getTrees() {
		return trees;
	}

	public static void removeTree(Tree tree) {
		trees.remove(tree);
	}

	public void checkTimeAndPositon() {
		if (!middleIslandArea.contains(Player.getCurrentPosition()) && !isMorning) {
			Player.resetPosition();
		}
	}

	public static Cell getCellFromCoordinate(Coordinate other) {
		for (Cell x : area) {
			if (x.getCoCell() == other)
				return x;
		}
		return null;
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

	public void randomAvailableScrapeArea(int random) {
		Random rand = new Random();
		ArrayList<Cell> givenList = new ArrayList<Cell>();
		for (Cell x : area) {
			if (x.getStatus() && !x.isClosed()) {
				givenList.add(x);
			}
		}

		for (int i = 0; i < random; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			Cell randomElement = givenList.get(randomIndex);
			Scrape e = new Scrape(randomElement);
			availableScrape.add(e);
		}
	}

	public void randomAvailablePlasticArea(int random) {
		Random rand = new Random();
		ArrayList<Cell> givenList = new ArrayList<Cell>();
		for (Cell x : area) {
			if (x.getStatus() && !x.isClosed()) {
				givenList.add(x);
			}
		}

		for (int i = 0; i < random; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			Cell randomElement = givenList.get(randomIndex);
//	        Plastic e = new Plastic(randomElement);
//	        availablePlastic.add(e);	
		}
	}

	public void randomAvailableStoneArea(int random) {
		Random rand = new Random();
		ArrayList<Cell> givenList = new ArrayList<Cell>();
		for (Cell x : middleIslandArea) {
			if (x.getStatus() && !x.isClosed()) {
				givenList.add(x);
			}
		}

		for (int i = 0; i < random; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			Cell randomElement = givenList.get(randomIndex);
			Scrape e = new Scrape(randomElement);
			availableScrape.add(e);
		}

	}

}
