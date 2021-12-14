package component.base;

import game.Player;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class CraftPane extends ListView<BorderPane> {
	private String[] craftObjects;

	public CraftPane(Player player, InventoryPane inventoryPane) {
		super();
		initCraftObjects();

		for (int i = 0; i < 15; i++) {
			BorderPane pane = new BorderPane();
			String object = craftObjects[i];
			Text text = new Text(object + "\n" + getRequirement(i));
			Button btn = new Button("Craft");
			btn.setOnAction(event -> {
				boolean complete = player.craft(object);
				if (!complete)
					showWarning();
				else
					inventoryPane.update(player);
			});
			pane.setLeft(text);
			pane.setRight(btn);
			pane.setPrefHeight(110);
			getItems().add(pane);
		}

	}

	private void initCraftObjects() {
		craftObjects = new String[15];
		craftObjects[0] = "Raft";
		craftObjects[1] = "Rope";
		craftObjects[2] = "Wood Axe";
		craftObjects[3] = "Stone Axe";
		craftObjects[4] = "Metal Axe";
		craftObjects[5] = "Stone Shovel";
		craftObjects[6] = "Metal Shovel";
		craftObjects[7] = "Wood Spear";
		craftObjects[8] = "Stone Spear";
		craftObjects[9] = "Metal Spear";
		craftObjects[10] = "Hinge";
		craftObjects[11] = "Nail";
		craftObjects[12] = "Circuit";
		craftObjects[13] = "Receiver";
		craftObjects[14] = "Anthena";
	}

	private String getRequirement(int i) {
		String s = "Requirement:\n";
		switch (i) {
		case 0:
			s += " - wood 20\n - rope 10";
			break;
		case 1:
			s += " - leaf 5";
			break;
		case 2:
			s += " - wood 10\n - rope 3";
			break;
		case 3:
			s += " - wood 5\n - stone 5\n - rope 3";
			break;
		case 4:
			s += " - wood 5\n - metal 5\n - rope 3";
			break;
		case 5:
			s += " - wood 5\n - stone 7\n - rope 3";
			break;
		case 6:
			s += " - wood 5\n - metal 4\n - rope 3";
			break;
		case 7:
			s += " - wood 10";
			break;
		case 8:
			s += " - wood 5\n - stone 6\n - rope 3";
			break;
		case 9:
			s += " - wood 5\n - metal 5\n - rope 3";
			break;
		case 10:
			s += " - metal 2";
			break;
		case 11:
			s += " - scrap 3";
			break;
		case 12:
			s += " - copper 2\n - plastic 4";
			break;
		case 13:
			s += " - circuit 10\n - wood 10\n - plastic 15\n - hinge 7";
			break;
		case 14:
			s += " - plastic 8\n - scrap 15\n - nail 15";
			break;
		}
		return s;
	}

	public void showWarning() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Craft failed");
		alert.setHeaderText(null);
		alert.setContentText("Please check your object amount.");
		alert.showAndWait();
	}
}