package object;

import game.Cell;
import game.Player;
import game.base.Removeable;
import object.base.ApplicationType;
import object.base.MaterialType;

public class Metal extends Material implements Removeable {

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
			//position.setStatus(true);
		}
//		refresh();
	}

	public void refresh() {
		if (!present) {
//			try {
//				Thread.sleep(15000); // (millisecond) can change
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		present = true;
		position.setStatus(false);
		}
	}

}