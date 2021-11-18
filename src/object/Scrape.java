package object;

import java.util.ArrayList;

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
	public void beRemoved() {
		if (Player.getCurrentShovel() == null)
			return;
		if (Player.getCurrentPosition().isNextTo(position) && present) {
			Player.setScrape(Player.getScrape()+1);
			present = false;
			position.setStatus(true);
			Player.decreaseLifetime(ApplicationType.SHOVEL);
			Player.decreaseHP();
		}
	}

	public void refresh(Cell position) {
		if (!present) {
			this.setPresent(true);
			this.setPosition(position);
			this.position.setStatus(false);
		}
	}

}
