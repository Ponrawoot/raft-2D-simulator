package component.base;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Coordinate;
import game.base.Direction;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import object.Animal;
import object.Bird;
import object.Fish;
import object.MangoTree;
import object.Metal;
import object.PalmTree;
import object.PineconeTree;
import object.Plastic;
import object.Scrape;
import object.Stone;
import object.Tree;
import object.base.MaterialType;

public class InformationPane extends Label {

	public InformationPane(Player player) {
		super();
		setPadding(new Insets(10));
		setText("Ready !!");
	}
	
	public void update(Player player, Direction direction) {
		int x = player.getCurrentPosition().getCoCell().getX();
		int y = player.getCurrentPosition().getCoCell().getY();
		Cell cell = Map.getCellFromDirection(direction, new Coordinate(x, y));
		if (cell.isSea() && !player.hasRaft()) {
			setText("You don't have raft.");
		}
	}

	public void update(Player player, Object object) {
		if (object instanceof Tree) {
			if (object instanceof PalmTree && player.getCurrentAxe() != null) {
				setText("You just cut down a palm tree."
						+ "\nYou got 3 woods, 3 leaves and your current axe lifetime has been reduced.");
			} else if (object instanceof MangoTree && player.getCurrentAxe() != null
					&& player.getCurrentAxe().getMaterial() != MaterialType.WOOD) {
				setText("You just cut down a mango tree."
						+ "\nYou got 1 wood, 2 leaves, 1 fruit, 1 mango seed and your current axe lifetime has been reduced");
			} else if (object instanceof PineconeTree && player.getCurrentAxe() != null
					&& player.getCurrentAxe().getMaterial() == MaterialType.METAL) {
				setText("You just cut down a pinecone tree."
						+ "\nYou got 2 woods, 2 leaves, 1 pinecone seed and your current axe lifetime has been reduced.");
			} else {
				setText("Please check your current axe");
			}
		}

		else if (object instanceof Stone) {
			setText("You just collect a stone.");
		}

		else if (object instanceof Plastic) {
			setText("You just collect a plastic.");
		}

		else if (object instanceof Metal) {
			if (player.getCurrentShovel() != null && player.getCurrentShovel().getMaterial() == MaterialType.METAL) {
				setText("You just collect a metal and your current shovel lifetime has been reduced.");
			} else {
				setText("Please check your current shovel.");
			}
		}

		else if (object instanceof Scrape) {
			if (player.getCurrentShovel() != null) {
				setText("You just collect a scrap and your current shovel lifetime has been reduced.");
			} else {
				setText("Please check your current shovel.");
			}
		}

		else if (object instanceof Animal) {
			if (object instanceof Fish && player.getCurrentSpear() != null) {
				setText("You just collect fish and your current spear lifetime has been reduced.");
			} else if (object instanceof Bird && player.getCurrentSpear() != null
					&& player.getCurrentSpear().getMaterial() != MaterialType.WOOD) {
				setText("You just collect bird and your current spear lifetime has been reduced.");
			} else {
				setText("Please check your current spear.");
			}
		}

		else {
			return;
		}
	}
}
