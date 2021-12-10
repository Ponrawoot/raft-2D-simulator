package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import game.base.Coordinate;
import game.base.Database;
import object.Animal;
import object.Bird;
import object.Fish;
import object.Material;
import object.Metal;
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

	public Map() {
		this.setMorning(true);
		Database database = new Database();
		area = database.getArea();
//		timeInGame = ;
//		birdTime = ;
//		fishTime = ;
//		metalTime = ;
//		scrapeTime = ;
//		stoneTime = ;
//		plasticTime =;
//		eagleTime = ;
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
		for (Cell x : middleIslandArea) {
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

}
