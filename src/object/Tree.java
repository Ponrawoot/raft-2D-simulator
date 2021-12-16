package object;

import game.Cell;
import game.Player;

public abstract class Tree {
	protected int wood;
	protected int leaf;
	protected Cell position;
	protected boolean readyToCut;

	public Tree(Cell position) {
		setPosition(position);
		this.position.setStatus(false);
		setReadyToCut(false);
	}

	public abstract void grow();

	protected void setWood(int wood) {
		this.wood = wood;
	}

	protected void setPosition(Cell position) {
		this.position = position;
	}

	protected void setLeaf(int leaf) {
		this.leaf = leaf;
	}

	protected void setReadyToCut(boolean readyToCut) {
		this.readyToCut = readyToCut;
	}

	public int getWood() {
		return wood;
	}

	public int getLeaf() {
		return leaf;
	}

	public Cell getPosition() {
		return position;
	}

	public boolean isReadyToCut() {
		return readyToCut;
	}

	public abstract boolean checkWeaponCondition(Player player);

	@Override
	public abstract String toString();

}
