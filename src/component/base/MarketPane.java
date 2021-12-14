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
	private Button tradeButton;
	private Text text;
	
	public MarketPane(String tradeObject, Player player) {
		super();
		setPrefHeight(80);
		market = new Market(tradeObject);
		tradeButton = new Button("Trade");
		text = new Text();
		setButtonAndText(tradeObject, player);
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
		
		setLeft(text);
		setRight(tradeButton);
	}
	
	private void setButtonAndText(String tradeObject, Player player) {
		switch(tradeObject) {
		case "Canvas":
			if (player.hasCanvas()) tradeButton.setDisable(true);
			text.setText(tradeObject + "\nRequirement:\n" + " - metal 10\n - scrap 20\n - plastic 20");
			break;
		case "Steering":
			if (player.hasSteering()) tradeButton.setDisable(true);
			text.setText(tradeObject + "\nRequirement:\n" + " - metal 15\n - scrap 30\n - plastic 30");
			break;
		case "Petrol":
			if (player.hasPetrol()) tradeButton.setDisable(true);
			text.setText(tradeObject + "\nRequirement:\n" + " - bird 40\n - fish 20");
			break;
		case "Engine":
			if (player.hasEngine()) tradeButton.setDisable(true);
			text.setText(tradeObject + "\nRequirement:\n" + " - eagle head 5");
			break;
		}
	}

	public void showWarning() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Trade failed");
		alert.setHeaderText(null);
		alert.setContentText("Please check your object amount." );
		alert.showAndWait();
	}
}
