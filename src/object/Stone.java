package object;

import java.util.Timer;
import java.util.TimerTask;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;

public class Stone extends Material implements Removeable {

	public Stone(Cell position) {
		super(position);
	}

	@Override
	public void beRemoved(Player player) {
		// TODO Auto-generated method stub
		if (player.getCurrentPosition().isNextTo(position) && present) {
			player.setStone(player.getStone() + 1);
			present = false;
			position.setStatus(true);
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
					Map.refreshStone(Map.getRandomInteger(1, 10));
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
