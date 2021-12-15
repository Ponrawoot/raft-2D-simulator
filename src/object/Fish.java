package object;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;
import object.base.ApplicationType;

public class Fish extends Animal implements Removeable {

	public Fish(Cell position) {
		super(position);
	}

	@Override
	public void beRemoved(Player player) {
		// TODO Auto-generated method stub
		if (player.getCurrentSpear() != null && player.getCurrentPosition().isNextTo(position) && alive) {
			player.setFish(player.getFish() + 1);
			position.setStatus(true);
			setAlive(false);
			player.decreaseHP();
			player.decreaseLifetime(ApplicationType.SPEAR);

//			try {
//				Thread.sleep(15000); // (millisecond) can change
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			Map.refreshFish(Map.getRandomInteger(1, 10)); // min, max can change
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
