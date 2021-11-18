package object;

import java.util.ArrayList;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;
import object.base.ApplicationType;

public class Scrape implements Removeable {
	private boolean scrape;
	private Cell position;
	private int time;

	public Scrape(Cell position) {
		scrape = true;
		this.position = position;
	}

	@Override
	public void beRemoved() {
		if (Player.getCurrentShovel() == null)
			return;
		if (Player.getCurrentPosition().isNextTo(position) && scrape) {
			Player.setScrape(Player.getScrape() + 1);
			position.setStatus(true);
			Player.decreaseLifetime(ApplicationType.SHOVEL);
			Player.decreaseHP();
		}
		for (Scrape x : Map.getAvailableScrape()) {
			if (x.isScrape())
				return;
		}
		// time = ;
		// TODO Auto-generated method stub

	}

//	public void refresh() {
//		for (Scrape x : Map.getAvailableScrape()) {
//			if (x.isScrape())
//				return;
//		}
//		int c = Map.getRandomInteger(10, 1);
//		ArrayList<Scrape> replace = new ArrayList<Scrape>(c);
//
//		// CheckTime
//
//	}

	public boolean isScrape() {
		return scrape;
	}

	public Cell getPosition() {
		return position;
	}

}
