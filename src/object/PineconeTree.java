package object;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;
import object.base.ApplicationType;
import object.base.MaterialType;

public class PineconeTree extends Tree implements Removeable {

	private int pineconeSeed;
//	private int timePlant;

	public PineconeTree(Cell position) {
		super(position);
		// TODO Auto-generated constructor stub
//		super.setWood();
//		super.setLeaf();
//		setPineconeSeed();
//		setTimePlant();
	}

	@Override
	public void beRemoved() {
		// TODO Auto-generated method stub
		if (!cutted && Player.getCurrentPosition().isNextTo(position)) {
			if (Player.getCurrentAxe().getMaterial() == MaterialType.METAL) {
				Player.decreaseLifetime(ApplicationType.AXE);
				Player.setWood(Player.getWood() + wood);
				Player.setLeaf(Player.getLeaf() + leaf);
				Player.setPineconeSeed(Player.getPineconeSeed() + pineconeSeed);
				super.setWood(0);
				super.setLeaf(0);
				setPineconeSeed(0);
				super.setCutted(true);
				Map.removeTree(this);
				Player.decreaseHP();
//				timePlant = ;
			}
		}
	}

	@Override
	public void grow() {
		// TODO Auto-generated method stub
		if (Player.getPineconeSeed() > 0) { // && check time
//			super.setWood();
//			super.setLeaf();
//			setPineconeSeed();
			Player.setPineconeSeed(Player.getPineconeSeed() - 1);
		}
	}

	public void setPineconeSeed(int pineconeSeed) {
		this.pineconeSeed = pineconeSeed;
	}

//	public void setTimePlant(int timePlant) {
//		this.timePlant = timePlant;
//	}

}
