package component.base;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class InventoryButton extends Button {
	public InventoryButton() {
		//setText("InventoryButton");
		ImageView ImageView = new ImageView(new Image("CategoryOther.png"));
		this.setGraphic(ImageView);
		ImageView.setFitHeight(60);
		ImageView.setFitWidth(60);
		setOnAction(new EventHandler<ActionEvent>() {
			@Override
			
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
			}
		});
	}
}
