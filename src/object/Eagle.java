package object;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Coordinate;
import object.base.ApplicationType;
import object.base.MaterialType;

public class Eagle extends Animal {

	private boolean move;
	private Cell defaultPosition;

	public Eagle(Cell position) {
		super(position); // same position every time
		// TODO Auto-generated constructor stub
		setMove(true);
//		defaultPosition = new Cell(new Coordinate( , ), false, true, true);
	}

	public void moveToPlayer() {
		if (!Map.getMoveableForEagleArea().contains(Player.getCurrentPosition()))
			return;
		int xPlayer = Player.getCurrentPosition().getCoCell().getX();
		int yPlayer = Player.getCurrentPosition().getCoCell().getY();
		if (yPlayer > position.getCoCell().getY()) {
			while (position.getCoCell().getY() < yPlayer) {
				position.getCoCell().setY(position.getCoCell().getY() + 1);
			}
		} else {
			while (position.getCoCell().getY() > yPlayer) {
				position.getCoCell().setY(position.getCoCell().getY() - 1);
			}
		}
		if (xPlayer > position.getCoCell().getX()) {
			while (position.getCoCell().getX() < xPlayer) {
				position.getCoCell().setX(position.getCoCell().getX() + 1);
			}
		} else {
			while (position.getCoCell().getX() > xPlayer) {
				position.getCoCell().setX(position.getCoCell().getX() - 1);
			}
		}
		hitPlayer();
	}

	public void hitPlayer() {
		while (position.isSamePosition(Player.getCurrentPosition()) && move && alive) {
			Player.decreaseHP();
		}
	}

	public void kill() {
		if ((Player.getCurrentPosition().isNextTo(position) || Player.getCurrentPosition().isSamePosition(position))
				&& Player.getCurrentSpear().getMaterial() == MaterialType.METAL && alive) {
			setAlive(false);
			Player.setBird(Player.getBird() + 1);
			Player.setEagleHead(Player.getEagleHead() + 1);
			Player.setFeather(Player.getFeather() + 1);
			Player.decreaseLifetime(ApplicationType.SPEAR);
			Player.decreaseHP();
		}
	}

	public void refresh() {
		if (!alive) {
			setPosition(defaultPosition);
			setAlive(true);
			setMove(true);
		}
	}

	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

}
