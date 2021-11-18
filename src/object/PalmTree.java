package object;

import game.Cell;
import game.Player;
import object.base.ApplicationType;

public class PalmTree extends Tree {

//	private int timeCut;

	public PalmTree(Cell position) {
		super(position);
		// TODO Auto-generated constructor stub
//		super.setWood();
//		super.setLeaf();
	}

	public void collect() {
		if (!cutted && Player.getCurrentPosition().isNextTo(position)) {
			if (Player.getCurrentAxe() != null) {
				Player.decreaseLifetime(ApplicationType.AXE);
				Player.setWood(Player.getWood() + wood);
				Player.setLeaf(Player.getLeaf() + leaf);
				super.setWood(0);
				super.setLeaf(0);
				super.setCutted(true);
				Player.decreaseHP();
//				timeCut = ;
			}
		}
	}

//	public void setTimeCut(int timeCut) {
//		this.timeCut = timeCut;
//	}

	@Override
	public void grow() {
		// TODO Auto-generated method stub
		if (cutted) { // && check time)
//			super.setWood();
//			super.setLeaf();
			super.setCutted(false);
		}
	}
}
