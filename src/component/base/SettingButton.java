package component.base;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SettingButton extends Button{
	
	public SettingButton() {
		//setText("setting");
		setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ImageView imageView = new ImageView();
		imageView.setFitHeight(60);
		imageView.setFitWidth(60);
		setGraphic(imageView);
	}
}
