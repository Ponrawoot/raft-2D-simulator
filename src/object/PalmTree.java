package object;

import java.util.Timer;
import java.util.TimerTask;

import game.Cell;
import game.Player;
import object.base.ApplicationType;

public class PalmTree extends Tree {

	public PalmTree(Cell position) {
		super(position);
		// TODO Auto-generated constructor stub
		super.setWood(3);
		super.setLeaf(3);
	}

	public void collect(Player player) {
		if (readyToCut && player.getCurrentPosition().isNextTo(position)) {
			if (player.getCurrentAxe() != null) {
				player.decreaseLifetime(ApplicationType.AXE);
				player.setWood(player.getWood() + wood);
				player.setLeaf(player.getLeaf() + leaf);
				setWood(0);
				setLeaf(0);
				setReadyToCut(false);
				player.decreaseHP();
			}
		}
	}

	@Override
	public void grow(Player player) {
		// TODO Auto-generated method stub
		if (!readyToCut) {
			super.setWood(3);
			super.setLeaf(3);

			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				int i = 15; // (second) can change

				@Override
				public void run() {
					// TODO Auto-generated method stub
					i--;
					if (i < 0) {
						timer.cancel();
						setReadyToCut(true);
					}
				}
			}, 0, 1000);
		}
	}
}
