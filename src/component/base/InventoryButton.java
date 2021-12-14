package component.base;

import game.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InventoryButton extends Button {
	public InventoryButton(Player player) {
		// setText("InventoryButton");
		ImageView ImageView = new ImageView(new Image("CategoryOther.png"));
		this.setGraphic(ImageView);
		ImageView.setFitHeight(60);
		ImageView.setFitWidth(60);
		setCursor(Cursor.HAND);
		this.setTooltip();
		setOnAction(new EventHandler<ActionEvent>() {
			@Override

			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage stage = new Stage();
				stage.setTitle("Inventory");

				InventoryPane inventoryPane = new InventoryPane(player);
				CraftPane craftPane = new CraftPane(player, inventoryPane);
				
				TabPane root = new TabPane();
				
				Tab inventoryTab = new Tab("Inventory", inventoryPane);
				inventoryTab.setClosable(false);
				Tab craftTab = new Tab("Craft", craftPane);
				craftTab.setClosable(false);
				root.getTabs().addAll(inventoryTab, craftTab);
				
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.initOwner(getScene().getWindow());
				stage.showAndWait();
			}
		});
	}

	private void setTooltip() {
		Tooltip tooltip = new Tooltip();
		tooltip.setFont(new Font(12));
		tooltip.setText("Inventory");
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}
}
