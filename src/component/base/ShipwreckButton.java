package component.base;

import game.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import object.Shipwreck;

public class ShipwreckButton extends Button {
	private Shipwreck shipwreck;
	
	public ShipwreckButton(Player player) {
		// setText("ShipwreckButton");
		shipwreck = new Shipwreck();
		ImageView ImageView = new ImageView(new Image("shipwreck.png"));
		this.setGraphic(ImageView);
		ImageView.setFitHeight(60);
		ImageView.setFitWidth(60);
		setCursor(Cursor.HAND);
		this.setTooltip();
		setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Stage stage = new Stage();
				stage.setTitle("Shipwreck");

				ListView<ShipwreckPane> root = new ListView<ShipwreckPane>();
				root.setPrefWidth(350);
				
				ShipwreckPane part0 = new ShipwreckPane("Wood", player, shipwreck);
				ShipwreckPane part1 = new ShipwreckPane("Hinge", player, shipwreck);
				ShipwreckPane part2 = new ShipwreckPane("Nail", player, shipwreck);
				ShipwreckPane part3 = new ShipwreckPane("Rope", player, shipwreck);
				ShipwreckPane part4 = new ShipwreckPane("Canvas", player, shipwreck);
				ShipwreckPane part5 = new ShipwreckPane("Steering", player, shipwreck);
				ShipwreckPane part6 = new ShipwreckPane("Engine", player, shipwreck);
				ShipwreckPane part7 = new ShipwreckPane("Petrol", player, shipwreck);
				ShipwreckPane part8 = new ShipwreckPane("Titanium", player, shipwreck);
				ShipwreckPane part9 = new ShipwreckPane("Receiver", player, shipwreck);
				ShipwreckPane part10 = new ShipwreckPane("Antenna", player, shipwreck);
				root.getItems().addAll(part0, part1, part2, part3, part4, part5, part6, part7, part8, part9, part10);
				
				if (shipwreck.checkWinCondition()) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setContentText("YOU WIN !!!");
					alert.showAndWait();
				}
				else{
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(getScene().getWindow());
					stage.showAndWait();
				}
			}
		});
	}

	private void setTooltip() {
		Tooltip tooltip = new Tooltip();
		tooltip.setFont(new Font(12));
		tooltip.setText("Shipwreck");
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}
}
