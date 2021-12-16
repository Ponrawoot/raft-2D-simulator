package object;

import game.Cell;

public abstract class Material {
	protected boolean present;
	protected Cell position;

	public Material(Cell position) {
		this.present = true;
		this.position = position;
		this.position.setStatus(false);
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public Cell getPosition() {
		return position;
	}

	public void setPosition(Cell position) {
		this.position = position;
	}

}
