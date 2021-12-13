package component.base;

import game.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MarketButton extends Button{
	
	public MarketButton(Player player) {
		//setText("MarketButton");
		ImageView ImageView = new ImageView(new Image("market.jpg"));
		this.setGraphic(ImageView);
		ImageView.setFitHeight(60);
		ImageView.setFitWidth(60);
		setCursor(Cursor.HAND);
		this.setTooltip();
		setOnAction(new EventHandler<ActionEvent>() {
			@Override
			
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage stage = new Stage();
				stage.setTitle("Market");
				
				ListView<MarketPane> root = new ListView<MarketPane>();
				root.setPrefWidth(400);
				root.setPrefHeight(150);
				MarketPane market0 = new MarketPane("Canvas", player);
				MarketPane market1 = new MarketPane("Steering", player);
				MarketPane market2 = new MarketPane("Petrol", player);
				MarketPane market3 = new MarketPane("Engine", player);
				root.getItems().addAll(market0, market1, market2, market3);
				
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.initOwner(getScene().getWindow());
				stage.showAndWait();
			}
		});
	}
	
	private void setTooltip() {
		Tooltip tooltip = new Tooltip();
		tooltip.setFont(new Font(12));
		tooltip.setText("Market");
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}
}

