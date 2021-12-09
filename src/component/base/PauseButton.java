package component.base;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class PauseButton extends Button{
	private String pauseUrl;
	private String playUrl;
	private String status;
	
	public PauseButton() {
		status = "pause";
		//setText(status); 
		setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (status == "pause") {
					setImage(playUrl);
					status = "play";
				}
				else {
					setImage(pauseUrl);
					status = "pause";
				}
			}
		});
	}
	
	public void setImage(String url) {
		ImageView imageView = new ImageView(new Image(url));
		setGraphic(imageView);
		setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
	}

}
