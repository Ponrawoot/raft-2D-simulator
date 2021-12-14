package object;

import component.TopBar;
import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;
import object.base.ApplicationType;
import object.base.MaterialType;

public class Bird extends Animal implements Removeable {

	public Bird(Cell position) {
		super(position);
	}

	@Override
	public void beRemoved(Player player) {
		// TODO Auto-generated method stub
		if ((player.getCurrentSpear().getMaterial() == MaterialType.STONE
				|| player.getCurrentSpear().getMaterial() == MaterialType.METAL)
				&& player.getCurrentPosition().isNextTo(position) && alive) {
			player.setBird(player.getBird() + 1);
			player.setFeather(player.getFeather() + 2);
			position.setStatus(true);
			setAlive(false);
			player.decreaseHP();
			player.decreaseLifetime(ApplicationType.SPEAR);
			TopBar.setHp(player);

//			try {
//				Thread.sleep(15000); // (millisecond) can change
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			Map.refreshBird(Map.getRandomInteger(1, 10)); // min, max can change
		}
	}

	public void refresh(Cell position) {
		if (!alive) {
			setPosition(position);
			setAlive(true);
			this.position.setStatus(false);
		}
	}
}
