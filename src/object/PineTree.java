package object;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removable;
import object.base.ApplicationType;
import object.base.MaterialType;

public class PineTree extends Tree implements Removable {

	private int pinecone;

	public PineTree(Cell position) {
		super(position);
		// TODO Auto-generated constructor stub
		super.setWood(5);
		super.setLeaf(2);
		pinecone = 2;
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
			pinecone = 0;
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
			super.setWood(5);
			super.setLeaf(2);
			pinecone = 2;
			this.position.setStatus(false);
			setReadyToCut(true);
		}
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
		return "pine tree." + " You got 5 woods, 2 leaves, 2 pinecone,";
	}

}
