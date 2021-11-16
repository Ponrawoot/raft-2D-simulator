package game;

import java.util.ArrayList;
import java.util.Random;

import game.base.Coordinate;
import object.Bird;
import object.Fish;
import object.Metal;
import object.Plastic;
import object.Scrape;
import object.Stone;

public class Map {
	private boolean isMorning;
	int timeInGame,birdTime,fishTime,metalTime,scrapeTime,stoneTime,plasticTime,eagleTime;
	private static ArrayList<Cell> area;
	private static ArrayList<Cell> plantableArea;
	private static ArrayList<Cell> moveableForEagleArea;
	private ArrayList<Fish> availableFish;
	private ArrayList<Cell> randomFishCell;
	private ArrayList<Bird> availableBird;
	private ArrayList<Cell> randomBirdCell;
	private ArrayList<Metal> availableMetal;
	private static ArrayList<Scrape> availableScrape;
	private ArrayList<Stone> availableStone;
	private ArrayList<Plastic> availablePlastic;
	private ArrayList<Cell> middleIslandArea;
	private ArrayList<Cell> repairableArea;
	private ArrayList<Tree> Tree;
	
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

	public ArrayList<Fish> getAvailableFish() {
		return availableFish;
	}

	public void setAvailableFish(ArrayList<Fish> availableFish) {
		this.availableFish = availableFish;
	}

	public ArrayList<Bird> getAvailableBird() {
		return availableBird;
	}

	public void setAvailableBird(ArrayList<Bird> availableBird) {
		this.availableBird = availableBird;
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

	public ArrayList<Tree> getTree() {
		return Tree;
	}
	
	public void checkTimeAndPositon() {
		if (!middleIslandArea.contains(Player.getCurrentPosition()) && !isMorning) {
			Player.resetPosition();
		}
	}
	
	public Cell getCellFromCoordinate(Coordinate other) {
		for (Cell x: area) {
			if (x.getCoCell()==other) return x;
		}
		return null;
	}
	
	public static int getRandomInteger(int maximum, int minimum) {
		return ((int) (Math.random()*(maximum - minimum))) + minimum; 
		}
	
	public void givenList_whenNumberElementsChosen_shouldReturnRandomElementsRepeat() {
	    Random rand = new Random();
	    List<String> givenList = Arrays.asList("one", "two", "three", "four");

	    int numberOfElements = 2;

	    for (int i = 0; i < numberOfElements; i++) {
	        int randomIndex = rand.nextInt(givenList.size());
	        String randomElement = givenList.get(randomIndex);
	    }
	}
	

}
