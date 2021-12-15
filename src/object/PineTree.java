package object;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;
import object.base.ApplicationType;
import object.base.MaterialType;

public class PineTree extends Tree implements Removeable {

	private int pinecone;

	public PineTree(Cell position) {
		super(position);
		// TODO Auto-generated constructor stub
		super.setWood(2);
		super.setLeaf(2);
		setPinecone(2);
	}

	@Override
	public void beRemoved(Player player) {
		// TODO Auto-generated method stub
		if (readyToCut && player.getCurrentPosition().isNextTo(position) && checkWeaponCondition(player)) {
			player.decreaseLifetime(ApplicationType.AXE);
			player.setWood(player.getWood() + wood);
			player.setLeaf(player.getLeaf() + leaf);
			player.setPineconeSeed(player.getPineconeSeed() + pinecone);
			setWood(0);
			setLeaf(0);
			setPinecone(0);
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
			super.setWood(2);
			super.setLeaf(2);
			setPinecone(2);
			this.position.setStatus(false);
			setReadyToCut(true);
		}
	}

	public void setPinecone(int pinecone) {
		this.pinecone = pinecone;
	}

	public int getPinecone() {
		return pinecone;
	}

	@Override
	public boolean checkWeaponCondition(Player player) {
		return player.getCurrentAxe() != null && player.getCurrentAxe().getMaterial() == MaterialType.METAL;
	}

	@Override
	public String toString() {
		return "pine tree." + " You got 2 woods, 2 leaves, 1 pine seed,";
	}

}
