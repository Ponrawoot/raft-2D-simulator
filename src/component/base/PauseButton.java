package component.base;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PauseButton extends Button{
	private boolean pause;
	
	public PauseButton() {
		pause = true;
		//setText(status); 
		setImage("pausebutton.png");
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if (pause) {
					setImage("Play.png");
					pause=false;;
				}
				else {
					setImage("pausebutton.png");
					pause=true;
				}
			}
		});
		
	}
	
	public void setImage(String url) {
		ImageView imageView = new ImageView(new Image(url)); 
		imageView.setFitHeight(60);
		imageView.setFitWidth(60);
		setGraphic(imageView);
	}

	public boolean isPause() {
		return pause;
	}

}
