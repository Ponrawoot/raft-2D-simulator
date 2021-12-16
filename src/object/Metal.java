package object;

import game.Cell;
import game.Player;
import game.base.Removable;
import object.base.ApplicationType;
import object.base.MaterialType;

public class Metal extends Material implements Removable {

	public Metal(Cell position) {
		super(position);
	}

	@Override
	public void beRemoved(Player player) {
		if (player.getCurrentShovel() == null)
			return;
		if (player.getCurrentPosition().isNextTo(position) && present
				&& (player.getCurrentShovel().getMaterial() == MaterialType.METAL)) {
			player.setMetal(player.getMetal() + 1);
			present = false;
			player.decreaseLifetime(ApplicationType.SHOVEL);
			player.decreaseHP();
		}
	}

	public void refresh() {
		if (!present) {
			present = true;
			position.setStatus(false);
		}
	}

	@Override
	public String toString() {
		return "metal";
	}

}