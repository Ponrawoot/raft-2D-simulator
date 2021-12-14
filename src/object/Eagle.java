package object;

import component.TopBar;
import game.Cell;
import game.Map;
import game.Player;
import game.base.Coordinate;
import object.base.ApplicationType;
import object.base.MaterialType;

public class Eagle extends Animal {

	private boolean move;
	private static final Cell defaultPosition = new Cell(new Coordinate(4, 1), false, false, true);

	public Eagle() {
		super(defaultPosition); // same position every time
		// TODO Auto-generated constructor stub
		super.getPosition().setStatus(true);
		setMove(true);
	}

	public void moveToPlayer(Player player) {
		if (!Map.getMoveableForEagleArea().contains(player.getCurrentPosition()))
			return;
		int xPlayer = player.getCurrentPosition().getCoCell().getX();
		int yPlayer = player.getCurrentPosition().getCoCell().getY();
		if (yPlayer > position.getCoCell().getY()) {
			while (position.getCoCell().getY() < yPlayer && move) {
				position.getCoCell().setY(position.getCoCell().getY() + 1);
				if (!Map.getMoveableForEagleArea().contains(player.getCurrentPosition()))
					setPosition(defaultPosition);
			}
		} else {
			while (position.getCoCell().getY() > yPlayer && move) {
				position.getCoCell().setY(position.getCoCell().getY() - 1);
				if (!Map.getMoveableForEagleArea().contains(player.getCurrentPosition()))
					setPosition(defaultPosition);
			}
		}
		if (xPlayer > position.getCoCell().getX()) {
			while (position.getCoCell().getX() < xPlayer && move) {
				position.getCoCell().setX(position.getCoCell().getX() + 1);
				if (!Map.getMoveableForEagleArea().contains(player.getCurrentPosition()))
					setPosition(defaultPosition);
			}
		} else {
			while (position.getCoCell().getX() > xPlayer && move) {
				position.getCoCell().setX(position.getCoCell().getX() - 1);
				if (!Map.getMoveableForEagleArea().contains(player.getCurrentPosition()))
					setPosition(defaultPosition);
			}
		}
		hitPlayer(player);
	}

	public void hitPlayer(Player player) {
		while (position.isSamePosition(player.getCurrentPosition()) && move && alive) {
			player.decreaseHP();
		}
	}

	public void killed(Player player) {
		if ((player.getCurrentPosition().isNextTo(position) || player.getCurrentPosition().isSamePosition(position))
				&& player.getCurrentSpear().getMaterial() == MaterialType.METAL && alive) {
			setAlive(false);
			player.setBird(player.getBird() + 2);
			player.setEagleHead(player.getEagleHead() + 1);
			player.setFeather(player.getFeather() + 3);
			player.decreaseLifetime(ApplicationType.SPEAR);
			player.decreaseHP();

			try {
				Thread.sleep(15000); // (millisecond) can change
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			refresh();
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
