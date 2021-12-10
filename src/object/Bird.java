package object;

import java.util.Timer;
import java.util.TimerTask;

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

			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				int i = 15; // (second) can change

				@Override
				public void run() {
					// TODO Auto-generated method stub
					i--;
					if (i < 0) {
						timer.cancel();
						Map.refreshBird(Map.getRandomInteger(1, 10)); // min, max can change
					}
				}
			}, 0, 1000);
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
