package object;

import game.Cell;

public abstract class Animal {
	
	protected boolean alive;
	protected Cell position;
	
	public Animal(Cell position) {
		setAlive(true);
		setPosition(position);
		this.position.setStatus(false);
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Cell getPosition() {
		return position;
	}

	public void setPosition(Cell position) {
		this.position = position;
	}
}
