package component.base;

import game.Market;
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

public class MarketButton extends Button {
	private Market[] markets;

	public MarketButton(Player player) {
		// setText("MarketButton");
		markets = new Market[4];
		markets[0] = new Market("Canvas");
		markets[1] = new Market("Steering");
		markets[2] = new Market("Petrol");
		markets[3] = new Market("Engine");
		
		ImageView ImageView = new ImageView(new Image("Market.png"));
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
				root.setPrefWidth(350);
				for (Market m : markets) {
					MarketPane market = new MarketPane(player, m);
					root.getItems().add(market);
				}

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
