package object;

import component.TopBar;
import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;
import object.base.ApplicationType;

public class Scrape extends Material implements Removeable {

	public Scrape(Cell position) {
		super(position);
	}

	@Override
	public void beRemoved(Player player) {
		if (player.getCurrentShovel() == null)
			return;
		if (player.getCurrentPosition().isNextTo(position) && present) {
			player.setScrape(player.getScrape() + 1);
			present = false;
			position.setStatus(true);
			player.decreaseLifetime(ApplicationType.SHOVEL);
			player.decreaseHP();
			TopBar.setHp(player);
		}

//		try {
//			Thread.sleep(15000); // (millisecond) can change
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Map.refreshScrape(Map.getRandomInteger(1, 10));
	}

	public void refresh(Cell position) {
		if (!present) {
			this.setPresent(true);
			this.setPosition(position);
			this.position.setStatus(false);
		}
	}

}
