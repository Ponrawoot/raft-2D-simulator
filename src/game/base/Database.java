package game.base;

import java.util.ArrayList;

import game.Cell;
import object.Animal;
import object.Bird;
import object.Fish;
import object.MangoTree;
import object.Material;
import object.Metal;
import object.PalmTree;
import object.PineTree;
import object.Plastic;
import object.Scrape;
import object.Stone;
import object.Tree;

public class Database {
	private  ArrayList<Cell> area;
	private  ArrayList<Cell> plantableArea;
	private  ArrayList<Cell> moveableForEagleArea;
	private  ArrayList<Cell> randomFishCell;
	private  ArrayList<Cell> randomBirdCell;
	private  ArrayList<Cell> middleIslandArea;
	private  ArrayList<Cell> repairableArea;
	private  ArrayList<Tree> trees;
	private ArrayList<Animal> availableFish;
	private ArrayList<Animal> availableBird;
	private ArrayList<Material> availableMetal;
	private ArrayList<Material> availableScrape;
	private ArrayList<Material> availablePlastic;
	private ArrayList<Material> availableStone;

	public Database() {
		Cell x0y0 = new Cell(new Coordinate(0, 0), false, true, false);
		Cell x1y0 = new Cell(new Coordinate(1, 0), false, true, false);
		Cell x2y0 = new Cell(new Coordinate(2, 0), false, true, false);
		Cell x3y0 = new Cell(new Coordinate(3, 0), false, true, true);
		Cell x4y0 = new Cell(new Coordinate(4, 0), false, false, true);
		Cell x5y0 = new Cell(new Coordinate(5, 0), true, false, true);
		Cell x6y0 = new Cell(new Coordinate(6, 0), true, false, true);
		Cell x7y0 = new Cell(new Coordinate(7, 0), true, false, true);
		Cell x8y0 = new Cell(new Coordinate(8, 0), true, false, true);
		Cell x9y0 = new Cell(new Coordinate(9, 0), true, false, true);
		Cell x10y0 = new Cell(new Coordinate(10, 0), true, false, true);
		Cell x11y0 = new Cell(new Coordinate(11, 0), true, false, true);
		Cell x12y0 = new Cell(new Coordinate(12, 0), true, false, true);
		Cell x13y0 = new Cell(new Coordinate(13, 0), true, false, true);
		Cell x14y0 = new Cell(new Coordinate(14, 0), false, false, true);
		Cell x15y0 = new Cell(new Coordinate(15, 0), false, false, true);
		Cell x16y0 = new Cell(new Coordinate(16, 0), false, false, true);
		Cell x17y0 = new Cell(new Coordinate(17, 0), false, false, true);
		Cell x18y0 = new Cell(new Coordinate(18, 0), false, false, true);
		Cell x19y0 = new Cell(new Coordinate(19, 0), false, false, true);
		Cell x0y1 = new Cell(new Coordinate(0, 1), false, false, true);
		Cell x1y1 = new Cell(new Coordinate(1, 1), false, true, true);
		Cell x2y1 = new Cell(new Coordinate(2, 1), false, false, true);
		Cell x3y1 = new Cell(new Coordinate(3, 1), false, false, true);
		Cell x4y1 = new Cell(new Coordinate(4, 1), false, true, true);
		Cell x5y1 = new Cell(new Coordinate(5, 1), true, false, true);
		Cell x6y1 = new Cell(new Coordinate(6, 1), true, false, true);
		Cell x7y1 = new Cell(new Coordinate(7, 1), true, false, true);
		Cell x8y1 = new Cell(new Coordinate(8, 1), true, false, true);
		Cell x9y1 = new Cell(new Coordinate(9, 1), true, false, true);
		Cell x10y1 = new Cell(new Coordinate(10, 1), true, false, true);
		Cell x11y1 = new Cell(new Coordinate(11, 1), true, false, true);
		Cell x12y1 = new Cell(new Coordinate(12, 1), true, false, true);
		Cell x13y1 = new Cell(new Coordinate(13, 1), true, false, true);
		Cell x14y1 = new Cell(new Coordinate(14, 1), false, false, true);
		Cell x15y1 = new Cell(new Coordinate(15, 1), false, false, true);
		Cell x16y1 = new Cell(new Coordinate(16, 1), false, false, true);
		Cell x17y1 = new Cell(new Coordinate(17, 1), false, false, true);
		Cell x18y1 = new Cell(new Coordinate(18, 1), false, false, true);
		Cell x19y1 = new Cell(new Coordinate(19, 1), false, false, true);
		Cell x0y2 = new Cell(new Coordinate(0, 2), false, false, true);
		Cell x1y2 = new Cell(new Coordinate(1, 2), false, false, true);
		Cell x2y2 = new Cell(new Coordinate(2, 2), false, false, true);
		Cell x3y2 = new Cell(new Coordinate(3, 2), false, false, true);
		Cell x4y2 = new Cell(new Coordinate(4, 2), true, false, true);
		Cell x5y2 = new Cell(new Coordinate(5, 2), true, false, true);
		Cell x6y2 = new Cell(new Coordinate(6, 2), true, false, true);
		Cell x7y2 = new Cell(new Coordinate(7, 2), true, false, true);
		Cell x8y2 = new Cell(new Coordinate(8, 2), true, false, true);
		Cell x9y2 = new Cell(new Coordinate(9, 2), true, false, true);
		Cell x10y2 = new Cell(new Coordinate(10, 2), true, false, true);
		Cell x11y2 = new Cell(new Coordinate(11, 2), true, false, true);
		Cell x12y2 = new Cell(new Coordinate(12, 2), true, false, true);
		Cell x13y2 = new Cell(new Coordinate(13, 2), true, false, true);
		Cell x14y2 = new Cell(new Coordinate(14, 2), false, false, true);
		Cell x15y2 = new Cell(new Coordinate(15, 2), false, false, true);
		Cell x16y2 = new Cell(new Coordinate(16, 2), false, false, true);
		Cell x17y2 = new Cell(new Coordinate(17, 2), false, false, true);
		Cell x18y2 = new Cell(new Coordinate(18, 2), false, false, true);
		Cell x19y2 = new Cell(new Coordinate(19, 2), false, false, true);
		Cell x0y3 = new Cell(new Coordinate(0, 3), false, true, true);
		Cell x1y3 = new Cell(new Coordinate(1, 3), false, false, true);
		Cell x2y3 = new Cell(new Coordinate(2, 3), false, false, true);
		Cell x3y3 = new Cell(new Coordinate(3, 3), false, false, true);
		Cell x4y3 = new Cell(new Coordinate(4, 3), true, false, true);
		Cell x5y3 = new Cell(new Coordinate(5, 3), true, false, true);
		Cell x6y3 = new Cell(new Coordinate(6, 3), true, false, true);
		Cell x7y3 = new Cell(new Coordinate(7, 3), true, false, true);
		Cell x8y3 = new Cell(new Coordinate(8, 3), true, false, true);
		Cell x9y3 = new Cell(new Coordinate(9, 3), true, false, true);
		Cell x10y3 = new Cell(new Coordinate(10, 3), true, false, true);
		Cell x11y3 = new Cell(new Coordinate(11, 3), true, false, true);
		Cell x12y3 = new Cell(new Coordinate(12, 3), true, false, true);
		Cell x13y3 = new Cell(new Coordinate(13, 3), true, false, true);
		Cell x14y3 = new Cell(new Coordinate(14, 3), false, false, true);
		Cell x15y3 = new Cell(new Coordinate(15, 3), false, false, true);
		Cell x16y3 = new Cell(new Coordinate(16, 3), false, false, true);
		Cell x17y3 = new Cell(new Coordinate(17, 3), false, false, true);
		Cell x18y3 = new Cell(new Coordinate(18, 3), false, false, true);
		Cell x19y3 = new Cell(new Coordinate(19, 3), false, false, true);
		Cell x0y4 = new Cell(new Coordinate(0, 4), false, false, true);
		Cell x1y4 = new Cell(new Coordinate(1, 4), false, false, true);
		Cell x2y4 = new Cell(new Coordinate(2, 4), false, false, true);
		Cell x3y4 = new Cell(new Coordinate(3, 4), true, false, true);
		Cell x4y4 = new Cell(new Coordinate(4, 4), true, false, true);
		Cell x5y4 = new Cell(new Coordinate(5, 4), true, false, true);
		Cell x6y4 = new Cell(new Coordinate(6, 4), false, false, true);
		Cell x7y4 = new Cell(new Coordinate(7, 4), false, false, true);
		Cell x8y4 = new Cell(new Coordinate(8, 4), false, false, true);
		Cell x9y4 = new Cell(new Coordinate(9, 4), true, false, true);
		Cell x10y4 = new Cell(new Coordinate(10, 4), true, false, true);
		Cell x11y4 = new Cell(new Coordinate(11, 4), true, false, true);
		Cell x12y4 = new Cell(new Coordinate(12, 4), true, false, true);
		Cell x13y4 = new Cell(new Coordinate(13, 4), true, false, true);
		Cell x14y4 = new Cell(new Coordinate(14, 4), true, false, true);
		Cell x15y4 = new Cell(new Coordinate(15, 4), true, false, true);
		Cell x16y4 = new Cell(new Coordinate(16, 4), true, false, true);
		Cell x17y4 = new Cell(new Coordinate(17, 4), true, false, true);
		Cell x18y4 = new Cell(new Coordinate(18, 4), true, false, true);
		Cell x19y4 = new Cell(new Coordinate(19, 4), true, false, true);
		Cell x0y5 = new Cell(new Coordinate(0, 5), false, false, true);
		Cell x1y5 = new Cell(new Coordinate(1, 5), false, false, true);
		Cell x2y5 = new Cell(new Coordinate(2, 5), false, false, true);
		Cell x3y5 = new Cell(new Coordinate(3, 5), true, false, true);
		Cell x4y5 = new Cell(new Coordinate(4, 5), true, false, true);
		Cell x5y5 = new Cell(new Coordinate(5, 5), true, false, true);
		Cell x6y5 = new Cell(new Coordinate(6, 5), false, false, true);
		Cell x7y5 = new Cell(new Coordinate(7, 5), false, false, false);
		Cell x8y5 = new Cell(new Coordinate(8, 5), false, false, true);
		Cell x9y5 = new Cell(new Coordinate(9, 5), false, false, true);
		Cell x10y5 = new Cell(new Coordinate(10, 5), false, false, true);
		Cell x11y5 = new Cell(new Coordinate(11, 5), false, false, true);
		Cell x12y5 = new Cell(new Coordinate(12, 5), false, false, true);
		Cell x13y5 = new Cell(new Coordinate(13, 5), false, false, true);
		Cell x14y5 = new Cell(new Coordinate(14, 5), true, false, true);
		Cell x15y5 = new Cell(new Coordinate(15, 5), true, false, true);
		Cell x16y5 = new Cell(new Coordinate(16, 5), true, false, true);
		Cell x17y5 = new Cell(new Coordinate(17, 5), true, false, true);
		Cell x18y5 = new Cell(new Coordinate(18, 5), true, false, true);
		Cell x19y5 = new Cell(new Coordinate(19, 5), true, false, true);
		Cell x0y6 = new Cell(new Coordinate(0, 6), true, false, true);
		Cell x1y6 = new Cell(new Coordinate(1, 6), true, false, true);
		Cell x2y6 = new Cell(new Coordinate(2, 6), true, false, true);
		Cell x3y6 = new Cell(new Coordinate(3, 6), true, false, true);
		Cell x4y6 = new Cell(new Coordinate(4, 6), true, false, true);
		Cell x5y6 = new Cell(new Coordinate(5, 6), true, false, true);
		Cell x6y6 = new Cell(new Coordinate(6, 6), false, false, true);
		Cell x7y6 = new Cell(new Coordinate(7, 6), false, false, true);
		Cell x8y6 = new Cell(new Coordinate(8, 6), false, false, true);
		Cell x9y6 = new Cell(new Coordinate(9, 6), false, false, true);
		Cell x10y6 = new Cell(new Coordinate(10, 6), false, false, true);
		Cell x11y6 = new Cell(new Coordinate(11, 6), false, false, true);
		Cell x12y6 = new Cell(new Coordinate(12, 6), false, false, true);
		Cell x13y6 = new Cell(new Coordinate(13, 6), false, false, true);
		Cell x14y6 = new Cell(new Coordinate(14, 6), false, false, true);
		Cell x15y6 = new Cell(new Coordinate(15, 6), false, false, true);
		Cell x16y6 = new Cell(new Coordinate(16, 6), false, false, true);
		Cell x17y6 = new Cell(new Coordinate(17, 6), false, false, true);
		Cell x18y6 = new Cell(new Coordinate(18, 6), true, false, true);
		Cell x19y6 = new Cell(new Coordinate(19, 6), true, false, true);
		Cell x0y7 = new Cell(new Coordinate(0, 7), true, false, true);
		Cell x1y7 = new Cell(new Coordinate(1, 7), true, false, true);
		Cell x2y7 = new Cell(new Coordinate(2, 7), true, false, true);
		Cell x3y7 = new Cell(new Coordinate(3, 7), true, false, true);
		Cell x4y7 = new Cell(new Coordinate(4, 7), true, false, true);
		Cell x5y7 = new Cell(new Coordinate(5, 7), true, false, true);
		Cell x6y7 = new Cell(new Coordinate(6, 7), false, false, true);
		Cell x7y7 = new Cell(new Coordinate(7, 7), false, false, true);
		Cell x8y7 = new Cell(new Coordinate(8, 7), false, false, true);
		Cell x9y7 = new Cell(new Coordinate(9, 7), false, false, true);
		Cell x10y7 = new Cell(new Coordinate(10, 7), false, false, true);
		Cell x11y7 = new Cell(new Coordinate(11, 7), false, false, true);
		Cell x12y7 = new Cell(new Coordinate(12, 7), false, false, true);
		Cell x13y7 = new Cell(new Coordinate(13, 7), false, false, true);
		Cell x14y7 = new Cell(new Coordinate(14, 7), false, false, true);
		Cell x15y7 = new Cell(new Coordinate(15, 7), true, false, true);
		Cell x16y7 = new Cell(new Coordinate(16, 7), false, false, false);
		Cell x17y7 = new Cell(new Coordinate(17, 7), false, false, true);
		Cell x18y7 = new Cell(new Coordinate(18, 7), true, false, true);
		Cell x19y7 = new Cell(new Coordinate(19, 7), true, false, true);
		Cell x0y8 = new Cell(new Coordinate(0, 8), true, false, true);
		Cell x1y8 = new Cell(new Coordinate(1, 8), true, false, true);
		Cell x2y8 = new Cell(new Coordinate(2, 8), true, false, true);
		Cell x3y8 = new Cell(new Coordinate(3, 8), true, false, true);
		Cell x4y8 = new Cell(new Coordinate(4, 8), true, false, true);
		Cell x5y8 = new Cell(new Coordinate(5, 8), true, false, true);
		Cell x6y8 = new Cell(new Coordinate(6, 8), false, false, true);
		Cell x7y8 = new Cell(new Coordinate(7, 8), false, false, true);
		Cell x8y8 = new Cell(new Coordinate(8, 8), false, false, true);
		Cell x9y8 = new Cell(new Coordinate(9, 8), false, false, true);
		Cell x10y8 = new Cell(new Coordinate(10, 8), false, false, true);
		Cell x11y8 = new Cell(new Coordinate(11, 8), false, false, true);
		Cell x12y8 = new Cell(new Coordinate(12, 8), false, false, true);
		Cell x13y8 = new Cell(new Coordinate(13, 8), false, false, true);
		Cell x14y8 = new Cell(new Coordinate(14, 8), false, false, true);
		Cell x15y8 = new Cell(new Coordinate(15, 8), true, false, true);
		Cell x16y8 = new Cell(new Coordinate(16, 8), true, false, true);
		Cell x17y8 = new Cell(new Coordinate(17, 8), true, false, true);
		Cell x18y8 = new Cell(new Coordinate(18, 8), true, false, true);
		Cell x19y8 = new Cell(new Coordinate(19, 8), true, false, true);
		Cell x0y9 = new Cell(new Coordinate(0, 9), true, false, true);
		Cell x1y9 = new Cell(new Coordinate(1, 9), true, false, true);
		Cell x2y9 = new Cell(new Coordinate(2, 9), true, false, true);
		Cell x3y9 = new Cell(new Coordinate(3, 9), true, false, true);
		Cell x4y9 = new Cell(new Coordinate(4, 9), true, false, true);
		Cell x5y9 = new Cell(new Coordinate(5, 9), true, false, true);
		Cell x6y9 = new Cell(new Coordinate(6, 9), true, false, true);
		Cell x7y9 = new Cell(new Coordinate(7, 9), false, false, true);
		Cell x8y9 = new Cell(new Coordinate(8, 9), false, false, false);
		Cell x9y9 = new Cell(new Coordinate(9, 9), false, false, true);
		Cell x10y9 = new Cell(new Coordinate(10, 9), false, false, true);
		Cell x11y9 = new Cell(new Coordinate(11, 9), false, false, true);
		Cell x12y9 = new Cell(new Coordinate(12, 9), false, false, true);
		Cell x13y9 = new Cell(new Coordinate(13, 9), false, false, true);
		Cell x14y9 = new Cell(new Coordinate(14, 9), false, false, true);
		Cell x15y9 = new Cell(new Coordinate(15, 9), true, false, true);
		Cell x16y9 = new Cell(new Coordinate(16, 9), true, false, true);
		Cell x17y9 = new Cell(new Coordinate(17, 9), true, false, true);
		Cell x18y9 = new Cell(new Coordinate(18, 9), true, false, true);
		Cell x19y9 = new Cell(new Coordinate(19, 9), true, false, true);
		Cell x0y10 = new Cell(new Coordinate(0, 10), true, false, true);
		Cell x1y10 = new Cell(new Coordinate(1, 10), true, false, true);
		Cell x2y10 = new Cell(new Coordinate(2, 10), true, false, true);
		Cell x3y10 = new Cell(new Coordinate(3, 10), true, false, true);
		Cell x4y10 = new Cell(new Coordinate(4, 10), true, false, true);
		Cell x5y10 = new Cell(new Coordinate(5, 10), true, false, true);
		Cell x6y10 = new Cell(new Coordinate(6, 10), true, false, true);
		Cell x7y10 = new Cell(new Coordinate(7, 10), false, false, true);
		Cell x8y10 = new Cell(new Coordinate(8, 10), false, false, true);
		Cell x9y10 = new Cell(new Coordinate(9, 10), false, false, true);
		Cell x10y10 = new Cell(new Coordinate(10, 10), false, false, true);
		Cell x11y10 = new Cell(new Coordinate(11, 10), false, false, true);
		Cell x12y10 = new Cell(new Coordinate(12, 10), false, false, true);
		Cell x13y10 = new Cell(new Coordinate(13, 10), false, false, true);
		Cell x14y10 = new Cell(new Coordinate(14, 10), false, false, true);
		Cell x15y10 = new Cell(new Coordinate(15, 10), true, false, true);
		Cell x16y10 = new Cell(new Coordinate(16, 10), true, false, true);
		Cell x17y10 = new Cell(new Coordinate(17, 10), true, false, true);
		Cell x18y10 = new Cell(new Coordinate(18, 10), true, false, true);
		Cell x19y10 = new Cell(new Coordinate(19, 10), true, false, true);
		Cell x0y11 = new Cell(new Coordinate(0, 11), true, false, true);
		Cell x1y11 = new Cell(new Coordinate(1, 11), true, false, true);
		Cell x2y11 = new Cell(new Coordinate(2, 11), true, false, true);
		Cell x3y11 = new Cell(new Coordinate(3, 11), true, false, true);
		Cell x4y11 = new Cell(new Coordinate(4, 11), true, false, true);
		Cell x5y11 = new Cell(new Coordinate(5, 11), true, false, true);
		Cell x6y11 = new Cell(new Coordinate(6, 11), true, false, true);
		Cell x7y11 = new Cell(new Coordinate(7, 11), false, false, true);
		Cell x8y11 = new Cell(new Coordinate(8, 11), false, false, true);
		Cell x9y11 = new Cell(new Coordinate(9, 11), false, false, true);
		Cell x10y11 = new Cell(new Coordinate(10, 11), false, false, true);
		Cell x11y11 = new Cell(new Coordinate(11, 11), false, false, true);
		Cell x12y11 = new Cell(new Coordinate(12, 11), false, false, false);
		Cell x13y11 = new Cell(new Coordinate(13, 11), false, false, true);
		Cell x14y11 = new Cell(new Coordinate(14, 11), true, false, true);
		Cell x15y11 = new Cell(new Coordinate(15, 11), true, false, true);
		Cell x16y11 = new Cell(new Coordinate(16, 11), true, false, true);
		Cell x17y11 = new Cell(new Coordinate(17, 11), true, false, true);
		Cell x18y11 = new Cell(new Coordinate(18, 11), true, false, true);
		Cell x19y11 = new Cell(new Coordinate(19, 11), true, false, true);
		Cell x0y12 = new Cell(new Coordinate(0, 12), true, false, true);
		Cell x1y12 = new Cell(new Coordinate(1, 12), true, false, true);
		Cell x2y12 = new Cell(new Coordinate(2, 12), true, false, true);
		Cell x3y12 = new Cell(new Coordinate(3, 12), true, false, true);
		Cell x4y12 = new Cell(new Coordinate(4, 12), true, false, true);
		Cell x5y12 = new Cell(new Coordinate(5, 12), true, false, true);
		Cell x6y12 = new Cell(new Coordinate(6, 12), false, false, false);
		Cell x7y12 = new Cell(new Coordinate(7, 12), false, false, true);
		Cell x8y12 = new Cell(new Coordinate(8, 12), false, false, true);
		Cell x9y12 = new Cell(new Coordinate(9, 12), false, false, true);
		Cell x10y12 = new Cell(new Coordinate(10, 12), false, false, true);
		Cell x11y12 = new Cell(new Coordinate(11, 12), false, false, true);
		Cell x12y12 = new Cell(new Coordinate(12, 12), true, false, true);
		Cell x13y12 = new Cell(new Coordinate(13, 12), true, false, true);
		Cell x14y12 = new Cell(new Coordinate(14, 12), true, false, true);
		Cell x15y12 = new Cell(new Coordinate(15, 12), true, false, true);
		Cell x16y12 = new Cell(new Coordinate(16, 12), false, false, true);
		Cell x17y12 = new Cell(new Coordinate(17, 12), false, true, false);
		Cell x18y12 = new Cell(new Coordinate(18, 12), false, false, true);
		Cell x19y12 = new Cell(new Coordinate(19, 12), false, false, true);
		Cell x0y13 = new Cell(new Coordinate(0, 13), true, false, true);
		Cell x1y13 = new Cell(new Coordinate(1, 13), true, false, true);
		Cell x2y13 = new Cell(new Coordinate(2, 13), true, false, true);
		Cell x3y13 = new Cell(new Coordinate(3, 13), false, false, true);
		Cell x4y13 = new Cell(new Coordinate(4, 13), false, false, true);
		Cell x5y13 = new Cell(new Coordinate(5, 13), false, false, true);
		Cell x6y13 = new Cell(new Coordinate(6, 13), false, false, true);
		Cell x7y13 = new Cell(new Coordinate(7, 13), false, false, true);
		Cell x8y13 = new Cell(new Coordinate(8, 13), false, false, true);
		Cell x9y13 = new Cell(new Coordinate(9, 13), false, false, true);
		Cell x10y13 = new Cell(new Coordinate(10, 13), false, false, true);
		Cell x11y13 = new Cell(new Coordinate(11, 13), false, false, true);
		Cell x12y13 = new Cell(new Coordinate(12, 13), false, false, true);
		Cell x13y13 = new Cell(new Coordinate(13, 13), true, false, true);
		Cell x14y13 = new Cell(new Coordinate(14, 13), true, false, true);
		Cell x15y13 = new Cell(new Coordinate(15, 13), true, false, true);
		Cell x16y13 = new Cell(new Coordinate(16, 13), false, false, true);
		Cell x17y13 = new Cell(new Coordinate(17, 13), false, true, false);
		Cell x18y13 = new Cell(new Coordinate(18, 13), false, true, false);
		Cell x19y13 = new Cell(new Coordinate(19, 13), false, true, false);
		Cell x0y14 = new Cell(new Coordinate(0, 14), true, false, true);
		Cell x1y14 = new Cell(new Coordinate(1, 14), true, false, true);
		Cell x2y14 = new Cell(new Coordinate(2, 14), true, false, true);
		Cell x3y14 = new Cell(new Coordinate(3, 14), false, false, true);
		Cell x4y14 = new Cell(new Coordinate(4, 14), false, false, true);
		Cell x5y14 = new Cell(new Coordinate(5, 14), false, false, true);
		Cell x6y14 = new Cell(new Coordinate(6, 14), false, false, true);
		Cell x7y14 = new Cell(new Coordinate(7, 14), false, false, true);
		Cell x8y14 = new Cell(new Coordinate(8, 14), false, false, true);
		Cell x9y14 = new Cell(new Coordinate(9, 14), false, false, true);
		Cell x10y14 = new Cell(new Coordinate(10, 14), false, false, false);
		Cell x11y14 = new Cell(new Coordinate(11, 14), false, false, true);
		Cell x12y14 = new Cell(new Coordinate(12, 14), false, false, true);
		Cell x13y14 = new Cell(new Coordinate(13, 14), true, false, true);
		Cell x14y14 = new Cell(new Coordinate(14, 14), true, false, true);
		Cell x15y14 = new Cell(new Coordinate(15, 14), true, false, true);
		Cell x16y14 = new Cell(new Coordinate(16, 14), false, false, true);
		Cell x17y14 = new Cell(new Coordinate(17, 14), false, true, false);
		Cell x18y14 = new Cell(new Coordinate(18, 14), false, true, false);
		Cell x19y14 = new Cell(new Coordinate(19, 14), false, true, false);
		Cell x0y15 = new Cell(new Coordinate(0, 15), true, false, true);
		Cell x1y15 = new Cell(new Coordinate(1, 15), true, false, true);
		Cell x2y15 = new Cell(new Coordinate(2, 15), true, false, true);
		Cell x3y15 = new Cell(new Coordinate(3, 15), false, false, true);
		Cell x4y15 = new Cell(new Coordinate(4, 15), false, false, true);
		Cell x5y15 = new Cell(new Coordinate(5, 15), false, false, true);
		Cell x6y15 = new Cell(new Coordinate(6, 15), false, false, false);
		Cell x7y15 = new Cell(new Coordinate(7, 15), false, false, true);
		Cell x8y15 = new Cell(new Coordinate(8, 15), false, false, true);
		Cell x9y15 = new Cell(new Coordinate(9, 15), false, false, true);
		Cell x10y15 = new Cell(new Coordinate(10, 15), false, false, true);
		Cell x11y15 = new Cell(new Coordinate(11, 15), false, false, true);
		Cell x12y15 = new Cell(new Coordinate(12, 15), false, false, true);
		Cell x13y15 = new Cell(new Coordinate(13, 15), false, false, true);
		Cell x14y15 = new Cell(new Coordinate(14, 15), true, false, true);
		Cell x15y15 = new Cell(new Coordinate(15, 15), true, false, true);
		Cell x16y15 = new Cell(new Coordinate(16, 15), false, false, true);
		Cell x17y15 = new Cell(new Coordinate(17, 15), false, true, false);
		Cell x18y15 = new Cell(new Coordinate(18, 15), false, true, false);
		Cell x19y15 = new Cell(new Coordinate(19, 15), false, true, false);
		Cell x0y16 = new Cell(new Coordinate(0, 16), true, false, true);
		Cell x1y16 = new Cell(new Coordinate(1, 16), true, false, true);
		Cell x2y16 = new Cell(new Coordinate(2, 16), true, false, true);
		Cell x3y16 = new Cell(new Coordinate(3, 16), false, false, true);
		Cell x4y16 = new Cell(new Coordinate(4, 16), false, false, true);
		Cell x5y16 = new Cell(new Coordinate(5, 16), false, false, true);
		Cell x6y16 = new Cell(new Coordinate(6, 16), false, false, true);
		Cell x7y16 = new Cell(new Coordinate(7, 16), false, false, true);
		Cell x8y16 = new Cell(new Coordinate(8, 16), false, false, true);
		Cell x9y16 = new Cell(new Coordinate(9, 16), false, false, true);
		Cell x10y16 = new Cell(new Coordinate(10, 16), false, false, true);
		Cell x11y16 = new Cell(new Coordinate(11, 16), false, false, true);
		Cell x12y16 = new Cell(new Coordinate(12, 16), false, false, true);
		Cell x13y16 = new Cell(new Coordinate(13, 16), false, false, true);
		Cell x14y16 = new Cell(new Coordinate(14, 16), true, false, true);
		Cell x15y16 = new Cell(new Coordinate(15, 16), true, false, true);
		Cell x16y16 = new Cell(new Coordinate(16, 16), false, false, true);
		Cell x17y16 = new Cell(new Coordinate(17, 16), false, false, true);
		Cell x18y16 = new Cell(new Coordinate(18, 16), false, false, true);
		Cell x19y16 = new Cell(new Coordinate(19, 16), false, true, false);
		Cell x0y17 = new Cell(new Coordinate(0, 17), true, false, true);
		Cell x1y17 = new Cell(new Coordinate(1, 17), true, false, true);
		Cell x2y17 = new Cell(new Coordinate(2, 17), true, false, true);
		Cell x3y17 = new Cell(new Coordinate(3, 17), false, false, false);
		Cell x4y17 = new Cell(new Coordinate(4, 17), false, false, true);
		Cell x5y17 = new Cell(new Coordinate(5, 17), false, false, true);
		Cell x6y17 = new Cell(new Coordinate(6, 17), false, false, true);
		Cell x7y17 = new Cell(new Coordinate(7, 17), false, false, true);
		Cell x8y17 = new Cell(new Coordinate(8, 17), false, false, true);
		Cell x9y17 = new Cell(new Coordinate(9, 17), true, false, true);
		Cell x10y17 = new Cell(new Coordinate(10, 17), true, false, true);
		Cell x11y17 = new Cell(new Coordinate(11, 17), false, false, true);
		Cell x12y17 = new Cell(new Coordinate(12, 17), false, false, true);
		Cell x13y17 = new Cell(new Coordinate(13, 17), false, false, true);
		Cell x14y17 = new Cell(new Coordinate(14, 17), true, false, true);
		Cell x15y17 = new Cell(new Coordinate(15, 17), true, false, true);
		Cell x16y17 = new Cell(new Coordinate(16, 17), false, false, true);
		Cell x17y17 = new Cell(new Coordinate(17, 17), false, false, true);
		Cell x18y17 = new Cell(new Coordinate(18, 17), false, false, true);
		Cell x19y17 = new Cell(new Coordinate(19, 17), false, false, true);
		Cell x0y18 = new Cell(new Coordinate(0, 18), true, false, true);
		Cell x1y18 = new Cell(new Coordinate(1, 18), true, false, true);
		Cell x2y18 = new Cell(new Coordinate(2, 18), true, false, true);
		Cell x3y18 = new Cell(new Coordinate(3, 18), false, false, true);
		Cell x4y18 = new Cell(new Coordinate(4, 18), false, false, true);
		Cell x5y18 = new Cell(new Coordinate(5, 18), false, false, true);
		Cell x6y18 = new Cell(new Coordinate(6, 18), false, false, true);
		Cell x7y18 = new Cell(new Coordinate(7, 18), true, false, true);
		Cell x8y18 = new Cell(new Coordinate(8, 18), true, false, true);
		Cell x9y18 = new Cell(new Coordinate(9, 18), true, false, true);
		Cell x10y18 = new Cell(new Coordinate(10, 18), true, false, true);
		Cell x11y18 = new Cell(new Coordinate(11, 18), false, false, true);
		Cell x12y18 = new Cell(new Coordinate(12, 18), false, false, true);
		Cell x13y18 = new Cell(new Coordinate(13, 18), false, false, true);
		Cell x14y18 = new Cell(new Coordinate(14, 18), true, false, true);
		Cell x15y18 = new Cell(new Coordinate(15, 18), true, false, true);
		Cell x16y18 = new Cell(new Coordinate(16, 18), true, false, true);
		Cell x17y18 = new Cell(new Coordinate(17, 18), true, false, true);
		Cell x18y18 = new Cell(new Coordinate(18, 18), true, false, true);
		Cell x19y18 = new Cell(new Coordinate(19, 18), true, false, true);
		Cell x0y19 = new Cell(new Coordinate(0, 19), true, false, true);
		Cell x1y19 = new Cell(new Coordinate(1, 19), true, false, true);
		Cell x2y19 = new Cell(new Coordinate(2, 19), true, false, true);
		Cell x3y19 = new Cell(new Coordinate(3, 19), true, false, true);
		Cell x4y19 = new Cell(new Coordinate(4, 19), true, false, true);
		Cell x5y19 = new Cell(new Coordinate(5, 19), true, false, true);
		Cell x6y19 = new Cell(new Coordinate(6, 19), true, false, true);
		Cell x7y19 = new Cell(new Coordinate(7, 19), true, false, true);
		Cell x8y19 = new Cell(new Coordinate(8, 19), true, false, true);
		Cell x9y19 = new Cell(new Coordinate(9, 19), true, false, true);
		Cell x10y19 = new Cell(new Coordinate(10, 19), true, false, true);
		Cell x11y19 = new Cell(new Coordinate(11, 19), true, false, true);
		Cell x12y19 = new Cell(new Coordinate(12, 19), true, false, true);
		Cell x13y19 = new Cell(new Coordinate(13, 19), true, false, true);
		Cell x14y19 = new Cell(new Coordinate(14, 19), true, false, true);
		Cell x15y19 = new Cell(new Coordinate(15, 19), true, false, true);
		Cell x16y19 = new Cell(new Coordinate(16, 19), true, false, true);
		Cell x17y19 = new Cell(new Coordinate(17, 19), true, false, true);
		Cell x18y19 = new Cell(new Coordinate(18, 19), true, false, true);
		Cell x19y19 = new Cell(new Coordinate(19, 19), true, false, true);
		
		area = new ArrayList<Cell>();
		
		area.add(x0y0);area.add(x1y0);area.add(x2y0);area.add(x3y0);area.add(x4y0);area.add(x5y0);area.add(x6y0);area.add(x7y0);area.add(x8y0);area.add(x9y0);area.add(x10y0);area.add(x11y0);area.add(x12y0);area.add(x13y0);area.add(x14y0);area.add(x15y0);area.add(x16y0);area.add(x17y0);area.add(x18y0);area.add(x19y0);
		area.add(x0y1);area.add(x1y1);area.add(x2y1);area.add(x3y1);area.add(x4y1);area.add(x5y1);area.add(x6y1);area.add(x7y1);area.add(x8y1);area.add(x9y1);area.add(x10y1);area.add(x11y1);area.add(x12y1);area.add(x13y1);area.add(x14y1);area.add(x15y1);area.add(x16y1);area.add(x17y1);area.add(x18y1);area.add(x19y1);
		area.add(x0y2);area.add(x1y2);area.add(x2y2);area.add(x3y2);area.add(x4y2);area.add(x5y2);area.add(x6y2);area.add(x7y2);area.add(x8y2);area.add(x9y2);area.add(x10y2);area.add(x11y2);area.add(x12y2);area.add(x13y2);area.add(x14y2);area.add(x15y2);area.add(x16y2);area.add(x17y2);area.add(x18y2);area.add(x19y2);
		area.add(x0y3);area.add(x1y3);area.add(x2y3);area.add(x3y3);area.add(x4y3);area.add(x5y3);area.add(x6y3);area.add(x7y3);area.add(x8y3);area.add(x9y3);area.add(x10y3);area.add(x11y3);area.add(x12y3);area.add(x13y3);area.add(x14y3);area.add(x15y3);area.add(x16y3);area.add(x17y3);area.add(x18y3);area.add(x19y3);
		area.add(x0y4);area.add(x1y4);area.add(x2y4);area.add(x3y4);area.add(x4y4);area.add(x5y4);area.add(x6y4);area.add(x7y4);area.add(x8y4);area.add(x9y4);area.add(x10y4);area.add(x11y4);area.add(x12y4);area.add(x13y4);area.add(x14y4);area.add(x15y4);area.add(x16y4);area.add(x17y4);area.add(x18y4);area.add(x19y4);
		area.add(x0y5);area.add(x1y5);area.add(x2y5);area.add(x3y5);area.add(x4y5);area.add(x5y5);area.add(x6y5);area.add(x7y5);area.add(x8y5);area.add(x9y5);area.add(x10y5);area.add(x11y5);area.add(x12y5);area.add(x13y5);area.add(x14y5);area.add(x15y5);area.add(x16y5);area.add(x17y5);area.add(x18y5);area.add(x19y5);
		area.add(x0y6);area.add(x1y6);area.add(x2y6);area.add(x3y6);area.add(x4y6);area.add(x5y6);area.add(x6y6);area.add(x7y6);area.add(x8y6);area.add(x9y6);area.add(x10y6);area.add(x11y6);area.add(x12y6);area.add(x13y6);area.add(x14y6);area.add(x15y6);area.add(x16y6);area.add(x17y6);area.add(x18y6);area.add(x19y6);
		area.add(x0y7);area.add(x1y7);area.add(x2y7);area.add(x3y7);area.add(x4y7);area.add(x5y7);area.add(x6y7);area.add(x7y7);area.add(x8y7);area.add(x9y7);area.add(x10y7);area.add(x11y7);area.add(x12y7);area.add(x13y7);area.add(x14y7);area.add(x15y7);area.add(x16y7);area.add(x17y7);area.add(x18y7);area.add(x19y7);
		area.add(x0y8);area.add(x1y8);area.add(x2y8);area.add(x3y8);area.add(x4y8);area.add(x5y8);area.add(x6y8);area.add(x7y8);area.add(x8y8);area.add(x9y8);area.add(x10y8);area.add(x11y8);area.add(x12y8);area.add(x13y8);area.add(x14y8);area.add(x15y8);area.add(x16y8);area.add(x17y8);area.add(x18y8);area.add(x19y8);
		area.add(x0y9);area.add(x1y9);area.add(x2y9);area.add(x3y9);area.add(x4y9);area.add(x5y9);area.add(x6y9);area.add(x7y9);area.add(x8y9);area.add(x9y9);area.add(x10y9);area.add(x11y9);area.add(x12y9);area.add(x13y9);area.add(x14y9);area.add(x15y9);area.add(x16y9);area.add(x17y9);area.add(x18y9);area.add(x19y9);
		area.add(x0y10);area.add(x1y10);area.add(x2y10);area.add(x3y10);area.add(x4y10);area.add(x5y10);area.add(x6y10);area.add(x7y10);area.add(x8y10);area.add(x9y10);area.add(x10y10);area.add(x11y10);area.add(x12y10);area.add(x13y10);area.add(x14y10);area.add(x15y10);area.add(x16y10);area.add(x17y10);area.add(x18y10);area.add(x19y10);
		area.add(x0y11);area.add(x1y11);area.add(x2y11);area.add(x3y11);area.add(x4y11);area.add(x5y11);area.add(x6y11);area.add(x7y11);area.add(x8y11);area.add(x9y11);area.add(x10y11);area.add(x11y11);area.add(x12y11);area.add(x13y11);area.add(x14y11);area.add(x15y11);area.add(x16y11);area.add(x17y11);area.add(x18y11);area.add(x19y11);
		area.add(x0y12);area.add(x1y12);area.add(x2y12);area.add(x3y12);area.add(x4y12);area.add(x5y12);area.add(x6y12);area.add(x7y12);area.add(x8y12);area.add(x9y12);area.add(x10y12);area.add(x11y12);area.add(x12y12);area.add(x13y12);area.add(x14y12);area.add(x15y12);area.add(x16y12);area.add(x17y12);area.add(x18y12);area.add(x19y12);
		area.add(x0y13);area.add(x1y13);area.add(x2y13);area.add(x3y13);area.add(x4y13);area.add(x5y13);area.add(x6y13);area.add(x7y13);area.add(x8y13);area.add(x9y13);area.add(x10y13);area.add(x11y13);area.add(x12y13);area.add(x13y13);area.add(x14y13);area.add(x15y13);area.add(x16y13);area.add(x17y13);area.add(x18y13);area.add(x19y13);
		area.add(x0y14);area.add(x1y14);area.add(x2y14);area.add(x3y14);area.add(x4y14);area.add(x5y14);area.add(x6y14);area.add(x7y14);area.add(x8y14);area.add(x9y14);area.add(x10y14);area.add(x11y14);area.add(x12y14);area.add(x13y14);area.add(x14y14);area.add(x15y14);area.add(x16y14);area.add(x17y14);area.add(x18y14);area.add(x19y14);
		area.add(x0y15);area.add(x1y15);area.add(x2y15);area.add(x3y15);area.add(x4y15);area.add(x5y15);area.add(x6y15);area.add(x7y15);area.add(x8y15);area.add(x9y15);area.add(x10y15);area.add(x11y15);area.add(x12y15);area.add(x13y15);area.add(x14y15);area.add(x15y15);area.add(x16y15);area.add(x17y15);area.add(x18y15);area.add(x19y15);
		area.add(x0y16);area.add(x1y16);area.add(x2y16);area.add(x3y16);area.add(x4y16);area.add(x5y16);area.add(x6y16);area.add(x7y16);area.add(x8y16);area.add(x9y16);area.add(x10y16);area.add(x11y16);area.add(x12y16);area.add(x13y16);area.add(x14y16);area.add(x15y16);area.add(x16y16);area.add(x17y16);area.add(x18y16);area.add(x19y16);
		area.add(x0y17);area.add(x1y17);area.add(x2y17);area.add(x3y17);area.add(x4y17);area.add(x5y17);area.add(x6y17);area.add(x7y17);area.add(x8y17);area.add(x9y17);area.add(x10y17);area.add(x11y17);area.add(x12y17);area.add(x13y17);area.add(x14y17);area.add(x15y17);area.add(x16y17);area.add(x17y17);area.add(x18y17);area.add(x19y17);
		area.add(x0y18);area.add(x1y18);area.add(x2y18);area.add(x3y18);area.add(x4y18);area.add(x5y18);area.add(x6y18);area.add(x7y18);area.add(x8y18);area.add(x9y18);area.add(x10y18);area.add(x11y18);area.add(x12y18);area.add(x13y18);area.add(x14y18);area.add(x15y18);area.add(x16y18);area.add(x17y18);area.add(x18y18);area.add(x19y18);
		area.add(x0y19);area.add(x1y19);area.add(x2y19);area.add(x3y19);area.add(x4y19);area.add(x5y19);area.add(x6y19);area.add(x7y19);area.add(x8y19);area.add(x9y19);area.add(x10y19);area.add(x11y19);area.add(x12y19);area.add(x13y19);area.add(x14y19);area.add(x15y19);area.add(x16y19);area.add(x17y19);area.add(x18y19);area.add(x19y19);
		
		plantableArea = new ArrayList<Cell>();
		
		plantableArea.add(x15y0);plantableArea.add(x16y0);plantableArea.add(x17y0);plantableArea.add(x18y0);plantableArea.add(x19y0);
		plantableArea.add(x15y1);plantableArea.add(x16y1);plantableArea.add(x17y1);plantableArea.add(x18y1);plantableArea.add(x19y1);
		plantableArea.add(x15y2);plantableArea.add(x16y2);plantableArea.add(x17y2);plantableArea.add(x18y2);plantableArea.add(x19y2);
		plantableArea.add(x11y6);plantableArea.add(x12y6);plantableArea.add(x11y7);plantableArea.add(x12y7);plantableArea.add(x11y8);plantableArea.add(x12y8);
		
		moveableForEagleArea = new ArrayList<Cell>();
		
		moveableForEagleArea.add(x4y0);
		moveableForEagleArea.add(x0y1);moveableForEagleArea.add(x1y1);moveableForEagleArea.add(x2y1);moveableForEagleArea.add(x3y1);moveableForEagleArea.add(x4y1);
		moveableForEagleArea.add(x0y2);moveableForEagleArea.add(x1y2);moveableForEagleArea.add(x2y2);moveableForEagleArea.add(x3y2);moveableForEagleArea.add(x4y2);
		moveableForEagleArea.add(x0y3);moveableForEagleArea.add(x1y3);moveableForEagleArea.add(x2y3);moveableForEagleArea.add(x3y3);moveableForEagleArea.add(x4y3);
		moveableForEagleArea.add(x0y4);moveableForEagleArea.add(x1y4);moveableForEagleArea.add(x2y4);moveableForEagleArea.add(x3y4);moveableForEagleArea.add(x4y4);
		moveableForEagleArea.add(x0y5);moveableForEagleArea.add(x1y5);moveableForEagleArea.add(x2y5);moveableForEagleArea.add(x3y5);moveableForEagleArea.add(x4y5);
		
		middleIslandArea = new ArrayList<Cell>();
		
		middleIslandArea.add(x6y4);middleIslandArea.add(x7y4);middleIslandArea.add(x8y4);middleIslandArea.add(x9y4);
		middleIslandArea.add(x6y5);middleIslandArea.add(x7y5);middleIslandArea.add(x8y5);middleIslandArea.add(x9y5);middleIslandArea.add(x10y5);middleIslandArea.add(x11y5);middleIslandArea.add(x12y5);middleIslandArea.add(x13y5);
		middleIslandArea.add(x6y6);middleIslandArea.add(x7y6);middleIslandArea.add(x8y6);middleIslandArea.add(x9y6);middleIslandArea.add(x10y6);middleIslandArea.add(x11y6);middleIslandArea.add(x12y6);middleIslandArea.add(x13y6);middleIslandArea.add(x14y6);middleIslandArea.add(x15y6);middleIslandArea.add(x16y6);middleIslandArea.add(x17y6);
		middleIslandArea.add(x6y7);middleIslandArea.add(x7y7);middleIslandArea.add(x8y7);middleIslandArea.add(x9y7);middleIslandArea.add(x10y7);middleIslandArea.add(x11y7);middleIslandArea.add(x12y7);middleIslandArea.add(x13y7);middleIslandArea.add(x14y7);middleIslandArea.add(x16y7);middleIslandArea.add(x17y7);
		middleIslandArea.add(x6y8);middleIslandArea.add(x7y8);middleIslandArea.add(x8y8);middleIslandArea.add(x9y8);middleIslandArea.add(x10y8);middleIslandArea.add(x11y8);middleIslandArea.add(x12y8);middleIslandArea.add(x13y8);middleIslandArea.add(x14y8);
		middleIslandArea.add(x7y9);middleIslandArea.add(x8y9);middleIslandArea.add(x9y9);middleIslandArea.add(x10y9);middleIslandArea.add(x11y9);middleIslandArea.add(x12y9);middleIslandArea.add(x13y9);middleIslandArea.add(x14y9);
		middleIslandArea.add(x7y10);middleIslandArea.add(x8y10);middleIslandArea.add(x9y10);middleIslandArea.add(x10y10);middleIslandArea.add(x11y10);middleIslandArea.add(x12y10);middleIslandArea.add(x13y10);middleIslandArea.add(x14y10);
		middleIslandArea.add(x7y11);middleIslandArea.add(x8y11);middleIslandArea.add(x9y11);middleIslandArea.add(x10y11);middleIslandArea.add(x11y11);middleIslandArea.add(x12y11);middleIslandArea.add(x13y11);
		middleIslandArea.add(x6y12);middleIslandArea.add(x7y12);middleIslandArea.add(x8y12);middleIslandArea.add(x9y12);middleIslandArea.add(x10y12);middleIslandArea.add(x11y12);
		middleIslandArea.add(x3y13);middleIslandArea.add(x4y13);middleIslandArea.add(x5y13);middleIslandArea.add(x6y13);middleIslandArea.add(x7y13);middleIslandArea.add(x8y13);middleIslandArea.add(x9y13);middleIslandArea.add(x10y13);middleIslandArea.add(x11y13);middleIslandArea.add(x12y13);
		middleIslandArea.add(x3y14);middleIslandArea.add(x4y14);middleIslandArea.add(x5y14);middleIslandArea.add(x6y14);middleIslandArea.add(x7y14);middleIslandArea.add(x8y14);middleIslandArea.add(x9y14);middleIslandArea.add(x10y14);middleIslandArea.add(x11y14);middleIslandArea.add(x12y14);
		middleIslandArea.add(x3y15);middleIslandArea.add(x4y15);middleIslandArea.add(x5y15);middleIslandArea.add(x6y15);middleIslandArea.add(x7y15);middleIslandArea.add(x8y15);middleIslandArea.add(x9y15);middleIslandArea.add(x10y15);middleIslandArea.add(x11y15);middleIslandArea.add(x12y15);middleIslandArea.add(x13y15);
		middleIslandArea.add(x3y16);middleIslandArea.add(x4y16);middleIslandArea.add(x5y16);middleIslandArea.add(x6y16);middleIslandArea.add(x7y16);middleIslandArea.add(x8y16);middleIslandArea.add(x9y16);middleIslandArea.add(x10y16);middleIslandArea.add(x11y16);middleIslandArea.add(x12y16);middleIslandArea.add(x13y16);
		middleIslandArea.add(x3y17);middleIslandArea.add(x4y17);middleIslandArea.add(x5y17);middleIslandArea.add(x6y17);middleIslandArea.add(x7y17);middleIslandArea.add(x8y17);middleIslandArea.add(x11y17);middleIslandArea.add(x12y17);middleIslandArea.add(x13y17);
		middleIslandArea.add(x3y18);middleIslandArea.add(x4y18);middleIslandArea.add(x5y18);middleIslandArea.add(x6y18);middleIslandArea.add(x11y18);middleIslandArea.add(x12y18);middleIslandArea.add(x13y18);
		
		repairableArea = new ArrayList<Cell>();
		
		repairableArea.add(x16y12);repairableArea.add(x18y12);repairableArea.add(x19y12);
		repairableArea.add(x16y13);
		repairableArea.add(x16y14);
		repairableArea.add(x16y15);
		repairableArea.add(x17y16);repairableArea.add(x18y16);
		repairableArea.add(x19y17);
		
		randomFishCell = new ArrayList<Cell>();
		
		randomFishCell.add(x0y8);randomFishCell.add(x1y8);randomFishCell.add(x2y8);randomFishCell.add(x3y8);
		randomFishCell.add(x0y9);randomFishCell.add(x1y9);randomFishCell.add(x2y9);randomFishCell.add(x3y9);
		randomFishCell.add(x0y10);randomFishCell.add(x1y10);randomFishCell.add(x2y10);randomFishCell.add(x3y10);
		randomFishCell.add(x0y11);randomFishCell.add(x1y11);randomFishCell.add(x2y11);randomFishCell.add(x3y11);
		randomFishCell.add(x0y12);randomFishCell.add(x1y12);
		randomFishCell.add(x0y13);randomFishCell.add(x1y13);
		randomFishCell.add(x0y14);randomFishCell.add(x1y14);
		randomFishCell.add(x0y15);randomFishCell.add(x1y15);
		randomFishCell.add(x0y16);randomFishCell.add(x1y16);
		randomFishCell.add(x0y17);randomFishCell.add(x1y17);
		
		randomBirdCell = new ArrayList<Cell>();
		for (Cell x : area) {
			if (!moveableForEagleArea.contains(x)) {
				randomBirdCell.add(x);
			}
		}
		
		trees = new ArrayList<Tree>();
		
		PalmTree palmTree1 = new PalmTree(x7y5);
		PalmTree palmTree2 = new PalmTree(x16y7);
		PalmTree palmTree3 = new PalmTree(x8y9);
		PalmTree palmTree4 = new PalmTree(x12y11);
		PalmTree palmTree5 = new PalmTree(x6y12);
		PalmTree palmTree6 = new PalmTree(x10y14);
		PalmTree palmTree7 = new PalmTree(x6y15);
		PalmTree palmTree8 = new PalmTree(x3y17);
		PineTree pineTree1 = new PineTree(x12y7);
		PineTree pineTree2 = new PineTree(x19y0);
		PineTree pineTree3 = new PineTree(x16y1);
		MangoTree mangoTree1 = new MangoTree(x11y6);
		MangoTree mangoTree2 = new MangoTree(x11y8);
		MangoTree mangoTree3 = new MangoTree(x17y2);
		MangoTree mangoTree4 = new MangoTree(x15y0);
		palmTree1.grow();palmTree2.grow();palmTree3.grow();palmTree4.grow();palmTree5.grow();palmTree6.grow();palmTree7.grow();palmTree8.grow();
		pineTree1.grow();pineTree2.grow();pineTree3.grow();
		mangoTree1.grow();mangoTree2.grow();mangoTree3.grow();mangoTree4.grow();
		trees.add(palmTree1);trees.add(palmTree2);trees.add(palmTree3);trees.add(palmTree4);trees.add(palmTree5);trees.add(palmTree6);trees.add(palmTree7);trees.add(palmTree8);
		trees.add(pineTree1);trees.add(pineTree2);trees.add(pineTree3);
		trees.add(mangoTree1);trees.add(mangoTree2);trees.add(mangoTree3);trees.add(mangoTree4);
		
		availableFish = new ArrayList<Animal>();
		
		Fish fish1 = new Fish(x2y9);
		Fish fish2 = new Fish(x3y11);
		Fish fish3 = new Fish(x0y12);
		Fish fish4 = new Fish(x1y18);
		availableFish.add(fish1);availableFish.add(fish2);availableFish.add(fish3);availableFish.add(fish4);
		
		availableBird = new ArrayList<Animal>();
		
		Bird bird1 = new Bird(x5y18);
		Bird bird2 = new Bird(x6y7);
		Bird bird3 = new Bird(x14y8);
		availableBird.add(bird1);availableBird.add(bird2);availableBird.add(bird3);
		
		availableMetal = new ArrayList<Material>();
		
		Metal metal1 = new Metal(x3y0);
		Metal metal2 = new Metal(x1y1);
		Metal metal3 = new Metal(x0y3);
		availableMetal.add(metal1);availableMetal.add(metal2);availableMetal.add(metal3);
		
		availableScrape = new ArrayList<Material>();
		
		Scrape scrape1 = new Scrape(x9y4);
		Scrape scrape2 = new Scrape(x17y9);
		Scrape scrape3 = new Scrape(x4y15);
		Scrape scrape4 = new Scrape(x13y19);
		availableScrape.add(scrape1);availableScrape.add(scrape2);availableScrape.add(scrape3);availableScrape.add(scrape4);
		
		availablePlastic = new ArrayList<Material>();
		
		Plastic plastic1 = new Plastic(x10y2);
		Plastic plastic2 = new Plastic(x18y3);
		Plastic plastic3 = new Plastic(x9y6);
		Plastic plastic4 = new Plastic(x8y15);
		availablePlastic.add(plastic1);availablePlastic.add(plastic2);availablePlastic.add(plastic3);availablePlastic.add(plastic4);
		
		availableStone = new ArrayList<Material>();
		
		Stone stone1 = new Stone(x7y1);
		Stone stone2 = new Stone(x14y3);
		Stone stone3 = new Stone(x17y6);
		Stone stone4 = new Stone(x7y10);
		Stone stone5 = new Stone(x3y14);
		Stone stone6 = new Stone(x12y16);
		
		availableStone.add(stone1);availableStone.add(stone2);availableStone.add(stone3);availableStone.add(stone4);availableStone.add(stone5);availableStone.add(stone6);
		}
	

	public ArrayList<Tree> getTrees() {
		return trees;
	}


	public ArrayList<Animal> getAvailableBird() {
		return availableBird;
	}


	public ArrayList<Material> getAvailableScrape() {
		return availableScrape;
	}


	public ArrayList<Material> getAvailablePlastic() {
		return availablePlastic;
	}


	public ArrayList<Material> getAvailableStone() {
		return availableStone;
	}


	public ArrayList<Material> getAvailableMetal() {
		return availableMetal;
	}


	public ArrayList<Animal> getAvailableFish() {
		return availableFish;
	}


	public ArrayList<Cell> getPlantableArea() {
		return plantableArea;
	}


	public ArrayList<Cell> getMoveableForEagleArea() {
		return moveableForEagleArea;
	}


	public ArrayList<Cell> getRandomFishCell() {
		return randomFishCell;
	}


	public ArrayList<Cell> getRandomBirdCell() {
		return randomBirdCell;
	}


	public ArrayList<Cell> getMiddleIslandArea() {
		return middleIslandArea;
	}


	public ArrayList<Cell> getRepairableArea() {
		return repairableArea;
	}


	public ArrayList<Cell> getArea() {
		return area;
	}
}