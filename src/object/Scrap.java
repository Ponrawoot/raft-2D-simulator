package object;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;
import object.base.ApplicationType;

public class Scrap extends Material implements Removeable {

	public Scrap(Cell position) {
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

	}

	public void refresh(Cell position) {
		if (!present) {
			this.setPresent(true);
			this.setPosition(position);
			this.position.setStatus(false);
		}
	}
	
	@Override
	public String toString() {
		return "scrap";
	}

}
