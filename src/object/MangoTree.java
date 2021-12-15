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

	public MangoTree(Cell position) {
		super(position);
		// TODO Auto-generated constructor stub
		super.setWood(1);
		super.setLeaf(2);
		setFruit(1);
		setMangoSeed(2);
	}

	@Override
	public void beRemoved(Player player) {
		// TODO Auto-generated method stub
		if (readyToCut && player.getCurrentPosition().isNextTo(position) && checkWeaponCondition(player)) {
			player.decreaseLifetime(ApplicationType.AXE);
			player.setWood(player.getWood() + wood);
			player.setLeaf(player.getLeaf() + leaf);
			player.setFruit(player.getFruit() + fruit);
			player.setMangoSeed(player.getMangoSeed() + mangoSeed);
			setWood(0);
			setLeaf(0);
			setFruit(0);
			setMangoSeed(0);
			setReadyToCut(false);
			Map.removeTree(this);
			this.position.setStatus(true);
			player.decreaseHP();
		}
	}

	@Override
	public void grow() {
		// TODO Auto-generated method stub
		if (!readyToCut) {
			super.setWood(1);
			super.setLeaf(2);
			setFruit(1);
			setMangoSeed(2);
			this.position.setStatus(false);

//			try {
//				Thread.sleep(15000); // (millisecond) can change
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			setReadyToCut(true);
		}
	}

	public void setFruit(int fruit) {
		this.fruit = fruit;
	}

	public void setMangoSeed(int mangoSeed) {
		this.mangoSeed = mangoSeed;
	}

	public int getFruit() {
		return fruit;
	}

	public int getMangoSeed() {
		return mangoSeed;
	}

	@Override
	public boolean checkWeaponCondition(Player player) {
		return player.getCurrentAxe() != null && player.getCurrentAxe().getMaterial() != MaterialType.WOOD;
	}

	@Override
	public String toString() {
		return "mango tree." + " You got 1 wood, 2 leaves, 1 fruit, 1 mango seed";
	}

}
