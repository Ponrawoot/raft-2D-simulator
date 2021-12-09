package component.base;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShipwreckButton extends Button {
	public ShipwreckButton() {
		//setText("ShipwreckButton");
		ImageView ImageView = new ImageView(new Image("shipwreck.png"));
		this.setGraphic(ImageView);
		ImageView.setFitHeight(60);
		ImageView.setFitWidth(60);
	}
}
