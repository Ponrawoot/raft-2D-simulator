package component.base;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Coordinate;
import game.base.Direction;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import object.Animal;
import object.Metal;
import object.Plastic;
import object.Scrap;
import object.Stone;
import object.Tree;
import object.base.ApplicationType;
import object.base.MaterialType;

public class InformationPane extends Label {

	public InformationPane(Player player) {
		super();
		setPadding(new Insets(10));
		setPrefWidth(300);
		setWrapText(true);
		setText("Ready !!");
	}

	public void update(Player player, Direction direction) {
		int x = player.getCurrentPosition().getCoCell().getX();
		int y = player.getCurrentPosition().getCoCell().getY();
		Cell cell = Map.getCellFromDirection(direction, new Coordinate(x, y));
		if (cell == null
				|| (player.getCurrentPosition().getCoCell().getX() == 0 && player.getDirection() == Direction.LEFT)
				|| (player.getCurrentPosition().getCoCell().getY() == 0 && player.getDirection() == Direction.UP)) {
			setText("You can't go out without Ship");
		} else if (cell.isSea() && !player.hasRaft()) {
			setText("You don't have raft.");
		}
	}

	public void update(Player player, Object object) {
		if (object instanceof Tree) {
			boolean check = ((Tree) object).checkWeaponCondition(player);
			setText(genInformText(check, (Tree) object, ApplicationType.AXE));
		}

		else if (object instanceof Stone) {
			setText("You just collect 1 stone.");
		}

		else if (object instanceof Plastic) {
			setText("You just collect 1 plastic.");
		}

		else if (object instanceof Metal) {
			boolean check = player.getCurrentShovel() != null
					&& player.getCurrentShovel().getMaterial() == MaterialType.METAL;
			setText(genInformText(check, (Metal) object, ApplicationType.SHOVEL));
		}

		else if (object instanceof Scrap) {
			setText(genInformText(player.getCurrentShovel() != null, (Scrap) object, ApplicationType.SHOVEL));
		}

		else if (object instanceof Animal) {
			boolean check = ((Animal) object).checkWeaponCondition(player);
			setText(genInformText(check, (Animal) object, ApplicationType.SPEAR));
		}

		else {
			return;
		}
	}

	public void update(Cell cell, boolean planted, String tree) {
		if (planted) {
			setText("You just plant " + tree + " tree.");
		} else {
			if (!Map.getPlantableArea().contains(cell))
				setText("Out of plantable area.");
			else if (!cell.getStatus())
				setText("The position is not available.");
			else
				setText("You don't have enough " + tree + " seed.");
		}
	}

	private String genInformText(boolean check, Object object, ApplicationType applicationType) {
		if (check) {
			if (object instanceof Tree) {
				return "You just cut down a " + object.toString() + " and your current " + applicationType
						+ " lifetime has been reduced.";
			} else {
				return "You just collect 1 " + object.toString() + " and your current " + applicationType
						+ " lifetime has been reduced.";
			}
		} else {
			return "Please check your current " + applicationType + ".";
		}

	}
}
