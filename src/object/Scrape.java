package object;

import java.util.Timer;
import java.util.TimerTask;

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
		}
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			int i = 15; // (second) can change

			@Override
			public void run() {
				// TODO Auto-generated method stub
				i--;
				if (i < 0) {
					timer.cancel();
					Map.refreshScrape(Map.getRandomInteger(1, 10));
				}
			}
		}, 0, 1000);
	}

	public void refresh(Cell position) {
		if (!present) {
			this.setPresent(true);
			this.setPosition(position);
			this.position.setStatus(false);
		}
	}

}
