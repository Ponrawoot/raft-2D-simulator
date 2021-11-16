package object;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;
import object.base.ApplicationType;
import object.base.MaterialType;

public class MangoTree extends Tree implements Removeable {

	private int fruit;
	private int mangoSeed;
//	private int timePlant;

	public MangoTree(Cell position) {
		super(position);
		// TODO Auto-generated constructor stub
//		super.setWood();
//		super.setLeaf();
//		setFruit();
//		setMangoSeed();
//		setTimePlant();
	}

	@Override
	public void beRemoved() {
		// TODO Auto-generated method stub
		if (!cutted && Player.getCurrentPosition().getCoCell().isNextTo(position.getCoCell())) {
			if (Player.getCurrentAxe().getMaterial() == MaterialType.STONE
					|| Player.getCurrentAxe().getMaterial() == MaterialType.METAL) {
				Player.decreaseLifetime(ApplicationType.AXE);
				Player.setWood(Player.getWood() + wood);
				Player.setLeaf(Player.getLeaf() + leaf);
				Player.setFruit(Player.getFruit() + fruit);
				Player.setMangoSeed(Player.getMangoSeed() + mangoSeed);
				super.setWood(0);
				super.setLeaf(0);
				setFruit(0);
				setMangoSeed(0);
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
		if (Player.getMangoSeed() > 0) { // && check time
//			super.setWood();
//			super.setLeaf();
//			setFruit();
//			setMangoSeed();
			Player.setMangoSeed(Player.getMangoSeed() - 1);
		}
	}

	public void setFruit(int fruit) {
		this.fruit = fruit;
	}

	public void setMangoSeed(int mangoSeed) {
		this.mangoSeed = mangoSeed;
	}

//	public void setTimePlant(int timePlant) {
//		this.timePlant = timePlant;
//	}

}
