package component.base;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MissionButton extends Button {
	public MissionButton() {
		//setText("MissionButton");
		ImageView ImageView = new ImageView(new Image("mission.png"));
		ImageView.setFitHeight(60);
		ImageView.setFitWidth(60);
		this.setGraphic(ImageView);
		setOnAction(new EventHandler<ActionEvent>() {
			@Override
			
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
			}
		});
	}
}
