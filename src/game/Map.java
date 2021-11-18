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
import object.Tree;

public class Map {
	private boolean isMorning;
	int timeInGame,birdTime,fishTime,metalTime,scrapeTime,stoneTime,plasticTime,eagleTime;
	private static ArrayList<Cell> area;
	private static ArrayList<Cell> plantableArea;
	private static ArrayList<Cell> moveableForEagleArea;
	private static ArrayList<Fish> availableFish;
	private static ArrayList<Cell> randomFishCell;
	private static ArrayList<Bird> availableBird;
	private static ArrayList<Cell> randomBirdCell;
	private static ArrayList<Metal> availableMetal;
	private static ArrayList<Scrape> availableScrape;
<<<<<<< HEAD
	private static ArrayList<Plastic> availablePlastic;
	private static ArrayList<Cell> middleIslandArea;
	private static ArrayList<Cell> repairableArea;
	private static ArrayList<Tree> Tree;
	private static ArrayList<Stone> availableStone;
	private static ArrayList<Tree> trees;

=======
	private ArrayList<Stone> availableStone;
	private ArrayList<Plastic> availablePlastic;
	private ArrayList<Cell> middleIslandArea;
	private ArrayList<Cell> repairableArea;
	private static ArrayList<Tree> trees;


>>>>>>> 5cc7ae2d279deedc18decd8e1ddae91d1b301e05
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

	public static void setAvailableFish(ArrayList<Fish> availableFish) {
		Map.availableFish = availableFish;
	}

	public ArrayList<Bird> getAvailableBird() {
		return availableBird;
	}

	public static void setAvailableBird(ArrayList<Bird> availableBird) {
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
		for (Cell x: area) {
			if (x.getCoCell()==other) return x;
		}
		return null;
	}
	
	public static int getRandomInteger(int maximum, int minimum) {
		return ((int) (Math.random()*(maximum - minimum))) + minimum; 
		}
	
	public void randomAvailableFishArea(int random) {
	    Random rand = new Random();
	    ArrayList<Cell> givenList = new ArrayList<Cell>();
	    for (Cell x: area) {
	    	if (x.getStatus()&&!x.isClosed()&&x.isSea())  {
	    		givenList.add(x);
	    	}
	    }

	    for (int i = 0; i < random; i++) {
	        int randomIndex = rand.nextInt(givenList.size());
	        Cell randomElement = givenList.get(randomIndex);
	        Fish e = new Fish(randomElement);
	        availableFish.add(e);	
	        }
	        
	    }
	
	public void randomAvailableBirdArea(int random) {
	    Random rand = new Random();
	    ArrayList<Cell> givenList = new ArrayList<Cell>();
	    for (Cell x: area) {
	    	if (x.getStatus()&&!x.isClosed())  {
	    		givenList.add(x);
	    	}
	    }

	    for (int i = 0; i < random; i++) {
	        int randomIndex = rand.nextInt(givenList.size());
	        Cell randomElement = givenList.get(randomIndex);
	        Bird e = new Bird(randomElement);
	        availableBird.add(e);	
	        }
	        
	    }
	
	public void randomAvailableScrapeArea(int random) {
	    Random rand = new Random();
	    ArrayList<Cell> givenList = new ArrayList<Cell>();
	    for (Cell x: area) {
	    	if (x.getStatus()&&!x.isClosed())  {
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
	    for (Cell x: area) {
	    	if (x.getStatus()&&!x.isClosed())  {
	    		givenList.add(x);
	    	}
	    }

	    for (int i = 0; i < random; i++) {
	        int randomIndex = rand.nextInt(givenList.size());
	        Cell randomElement = givenList.get(randomIndex);
	        Plastic e = new Plastic(randomElement);
	        availablePlastic.add(e);	
	        }   
	    }
	
	public void randomAvailableStoneArea(int random) {
	    Random rand = new Random();
	    ArrayList<Cell> givenList = new ArrayList<Cell>();
	    for (Cell x: middleIslandArea) {
	    	if (x.getStatus()&&!x.isClosed())  {
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
