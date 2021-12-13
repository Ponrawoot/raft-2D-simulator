package component.base;

import game.Market;
import game.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class MarketPane extends BorderPane{
	private Market market;
	
	public MarketPane(String tradeObject, Player player) {
		super(); 
		market = new Market(tradeObject);
		Button tradeButton = new Button("Trade");
		tradeButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				boolean traded = market.trade(player);
				if (traded) {
					tradeButton.setDisable(true);
				}
				else {
					showWarning();
				}
			}
		});
		
		Text text = new Text(tradeObject);
		setLeft(text);
		setRight(tradeButton);
	}

	public void showWarning() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Trade failed");
		alert.setHeaderText(null);
		alert.setContentText("Please check your object amount." );
		alert.showAndWait();
	}
}
