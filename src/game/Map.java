package game;

import java.util.ArrayList;

public class Map {
	private boolean isMorning;
	int timeInGame;
	int birdTime;
	int fishTime;
	int metalTime;
	int scrapeTime;
	int stoneTime;
	int plasticTime;
	int eagleTime;
	private static ArrayList<Cell> area;
	private static ArrayList<Cell> plantableArea;
	private static ArrayList<Cell> moveableForEagleArea;
	private ArrayList<Fish> availableFish;
	private ArrayList<Cell> randomFishCell;
	private ArrayList<Bird> availableBird;
	private ArrayList<Cell> randomBirdCell;
	private ArrayList<Metal> availableMetal;
	private ArrayList<Scrape> availableScrape;
	private ArrayList<Stone> availableStone;
	private ArrayList<Plastic> availablePlastic;
	private ArrayList<Cell> middleIslandArea;
	private ArrayList<Cell> repairableArea;
	private ArrayList<Tree> Tree;
	
	public Map() {
		this.setMorning(true);
		timeInGame = ;
		birdTime = ;
		fishTime = ;
		metalTime = ;
		scrapeTime = ;
		stoneTime = ;
		plasticTime =;
		eagleTime = ;
		area = ;
		plantableArea = ;
		moveableForEagleArea = ;
		availableFish = ;
		randomFishCell = ;
		availableBird = ;
		randomBirdCell = ;
		availableMetal = ;
		availableScrape = ;
		availableStone = ;
		availablePlastic = ;
		middleIslandArea = ;
		repairableArea = ;
		Tree = ;
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

	public ArrayList<Scrape> getAvailableScrape() {
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
		if (middleIslandArea.contains(Player.getCurrentPosition()) && !isMorning) {
			Player.resetPosition();
		}
	}
	

}
