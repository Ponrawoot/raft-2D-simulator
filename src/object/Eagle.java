package object;

import java.util.Timer;
import java.util.TimerTask;

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
		defaultPosition = new Cell(new Coordinate(3, 2), false, true, true); // position can change
	}

	public void moveToPlayer(Player player) {
		if (!Map.getMoveableForEagleArea().contains(player.getCurrentPosition()))
			return;
		int xPlayer = player.getCurrentPosition().getCoCell().getX();
		int yPlayer = player.getCurrentPosition().getCoCell().getY();
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
		hitPlayer(player);
	}

	public void hitPlayer(Player player) {
		while (position.isSamePosition(player.getCurrentPosition()) && move && alive) {
			player.decreaseHP();
		}
	}

	public void kill(Player player) {
		if ((player.getCurrentPosition().isNextTo(position) || player.getCurrentPosition().isSamePosition(position))
				&& player.getCurrentSpear().getMaterial() == MaterialType.METAL && alive) {
			setAlive(false);
			player.setBird(player.getBird() + 2);
			player.setEagleHead(player.getEagleHead() + 1);
			player.setFeather(player.getFeather() + 3);
			player.decreaseLifetime(ApplicationType.SPEAR);
			player.decreaseHP();

			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				int i = 15; // (second) can change

				@Override
				public void run() {
					// TODO Auto-generated method stub
					i--;
					if (i < 0) {
						timer.cancel();
						refresh();
					}
				}
			}, 0, 1000);
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
