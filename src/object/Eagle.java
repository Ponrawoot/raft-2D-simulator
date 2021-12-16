package object;

import component.RootPane;
import component.TopBar;
import game.Cell;
import game.Map;
import game.Player;
import game.base.Coordinate;
import object.base.ApplicationType;
import object.base.MaterialType;

public class Eagle extends Animal {

	private static final Cell defaultPosition = new Cell(new Coordinate(4, 1), false, true, true);

	public Eagle() {
		super(defaultPosition); // same position every time
	}

	public Eagle(Cell cell) {
		super(cell);
	}

	public boolean checkMoving(Player player) {
		boolean c = false;
		for (Cell x : Map.getMoveableForEagleArea()) {
			if (x.equals(player.getCurrentPosition())) {
				c = true;
				break;
			}
		}
		if (c && alive) {
			int xPlayer = player.getCurrentPosition().getCoCell().getX();
			int yPlayer = player.getCurrentPosition().getCoCell().getY();
			if (Math.abs(yPlayer - position.getCoCell().getY()) == 1
					&& Math.abs(xPlayer - position.getCoCell().getX()) == 0) {
				return true;
			}
			if (Math.abs(yPlayer - position.getCoCell().getY()) == 0
					&& Math.abs(xPlayer - position.getCoCell().getX()) == 1) {
				return true;
			}
			if (Math.abs(yPlayer - position.getCoCell().getY()) > 0) {
				return true;

			}
			if (Math.abs(xPlayer - position.getCoCell().getX()) > 0) {
				return true;
			}
		}
		return false;
	}

	public boolean moveToPlayer(Player player) {
		boolean c = false;
		for (Cell x : Map.getMoveableForEagleArea()) {
			if (x.equals(player.getCurrentPosition())) {
				c = true;
				break;
			}
		}
		if (c && alive) {
			int xEagle = getPosition().getCoCell().getX();
			int yEagle = getPosition().getCoCell().getY();
			Cell prev = Map.getCellFromCoordinate(new Coordinate(xEagle, yEagle));
			int xPlayer = player.getCurrentPosition().getCoCell().getX();
			int yPlayer = player.getCurrentPosition().getCoCell().getY();
			if (Math.abs(yPlayer - position.getCoCell().getY()) == 1
					&& Math.abs(xPlayer - position.getCoCell().getX()) == 0) {
				return true;
			}
			if (Math.abs(yPlayer - position.getCoCell().getY()) == 0
					&& Math.abs(xPlayer - position.getCoCell().getX()) == 1) {
				return true;
			}
			if (Math.abs(yPlayer - position.getCoCell().getY()) > 0) {
				int dy;
				if (yPlayer > position.getCoCell().getY()) {
					dy = 1;
				} else {
					dy = -1;
				}
				Cell next = Map.getCellFromCoordinate(new Coordinate(xEagle, yEagle + dy));
				Map.setEagle(next);
				prev.setStatus(true);
				RootPane.redraw(next, prev, "Eagle");
				return true;
			}
			if (Math.abs(xPlayer - position.getCoCell().getX()) > 0) {
				int dx;
				if (xPlayer > position.getCoCell().getX()) {
					dx = 1;
				} else {
					dx = -1;
				}
				Cell next = Map.getCellFromCoordinate(new Coordinate(xEagle + dx, yEagle));
				Map.setEagle(next);
				prev.setStatus(true);
				RootPane.redraw(next, prev, "Eagle");
			}
			return true;
		}
		return false;
	}

	public boolean hitPlayer(Player player) {
		if (position.isNextTo(player.getCurrentPosition()) && alive) {
			player.decreaseHP();
			TopBar.getInformationPane().update(true);
			TopBar.showHpWarning(player);
			return true;
		}
		return false;
	}

	public void killed(Player player) {
		setAlive(false);
		player.setBird(player.getBird() + 2);
		player.setEagleHead(player.getEagleHead() + 1);
		player.setFeather(player.getFeather() + 3);
		player.decreaseLifetime(ApplicationType.SPEAR);
		player.decreaseHP();
	}

	public void refresh() {
		if (!alive) {
			Map.setEagle(defaultPosition);
		}
	}

	@Override
	public boolean checkWeaponCondition(Player player) {
		return player.getCurrentSpear() != null && player.getCurrentSpear().getMaterial() == MaterialType.METAL;
	}

	@Override
	public String toString() {
		return "eagle." + "\nYou got 2 bird, 1 eagle head, 3 feathers,";
	}

}
