package object;

import component.TopBar;
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
				TopBar.setHp(player);
			}
		}
	}
	
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
	public void grow(Player player) {
		// TODO Auto-generated method stub
//		if (!readyToCut) {
//			super.setWood(3);
//			super.setLeaf(3);
//
//			try {
//				Thread.sleep(15000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			setReadyToCut(true);
//		}
	}
}
