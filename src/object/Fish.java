package object;

import java.util.Timer;
import java.util.TimerTask;

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
	public void beRemoved() {
		// TODO Auto-generated method stub
		if (Player.getCurrentSpear() != null && Player.getCurrentPosition().isNextTo(position) && alive) {
			Player.setFish(Player.getFish() + 1);
			position.setStatus(true);
			setAlive(false);
			Player.decreaseHP();
			Player.decreaseLifetime(ApplicationType.SPEAR);

			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				int i = 15; // (second) can change

				@Override
				public void run() {
					// TODO Auto-generated method stub
					i--;
					if (i < 0) {
						timer.cancel();
						Map.refreshFish(Map.getRandomInteger(1, 10)); // min, max can change
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
