package component.base;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class GuideButton extends Button{
	public GuideButton() {
		setText("GuideButton");
		setOnAction(new EventHandler<ActionEvent>() {
			@Override
			
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
			}
		});
	}
}

