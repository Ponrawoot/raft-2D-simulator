package component.base;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class MarketButton extends Button{
	public MarketButton() {
		setText("MarketButton");
		setOnAction(new EventHandler<ActionEvent>() {
			@Override
			
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
			}
		});
	}
}

