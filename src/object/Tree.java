package object;

import game.Cell;

public abstract class Tree {
	protected int wood;
	protected int leaf;
	protected Cell position;
	protected boolean cutted;

	public Tree(Cell position) {
		setPosition(position);
		setCutted(false);
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

	protected void setCutted(boolean cutted) {
		this.cutted = cutted;
	}

}
