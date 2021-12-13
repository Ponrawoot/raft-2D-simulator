package component.base;

import game.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import object.Shipwreck;

public class ShipwreckPane extends BorderPane {
	private Label label;

	public ShipwreckPane(String repairPart, Player player, Shipwreck shipwreck) {
		super();
		label = new Label();
		label.setText(repairPart);
		Button repairButton = new Button("Repair");
		repairButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				boolean complete = shipwreck.repair(repairPart, player);
				if (complete) {
					repairButton.setText("complete");
					repairButton.setDisable(true);
				} else {
					showWarning();
				}
			}
		});
		setLeft(label);
		setRight(repairButton);
	}

	public void showWarning() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Fail to repair shipwreck");
		alert.setHeaderText(null);
		alert.setContentText("Please check your object.");
		alert.showAndWait();
	}
	
}
