package object;

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
		if (readyToCut && player.getCurrentPosition().isNextTo(position) && checkWeaponCondition(player)) {
			player.decreaseLifetime(ApplicationType.AXE);
			player.setWood(player.getWood() + wood);
			player.setLeaf(player.getLeaf() + leaf);
			setWood(0);
			setLeaf(0);
			setReadyToCut(false);
			player.decreaseHP();
		}
	}

	@Override
	public void grow() {
		if (!readyToCut) {
			super.setWood(3);
			super.setLeaf(3);

//			try {
//				Thread.sleep(15000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			setReadyToCut(true);
		}
	}

	@Override
	public boolean checkWeaponCondition(Player player) {
		return player.getCurrentAxe() != null;
	}

	@Override
	public String toString() {
		return "palm tree." + " You got 3 woods, 3 leaves,";
	}
}
