package component.base;

import game.Mission;
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

public class MissionButton extends Button {
	private Mission mission;
	
	public MissionButton(Player player) {
		// setText("MissionButton");
		mission = new Mission();
		ImageView ImageView = new ImageView(new Image("Mission.png"));
		ImageView.setFitHeight(60);
		ImageView.setFitWidth(60);
		this.setGraphic(ImageView);
		setCursor(Cursor.HAND);
		this.setTooltip();
		setOnAction(new EventHandler<ActionEvent>() {
			@Override

			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage stage = new Stage();
				stage.setTitle("Mission");

				ListView<MissionPane> root = new ListView<MissionPane>();
				root.setPrefWidth(350);
				for (int i = 0; i < 9; i++) {
					root.getItems().add(new MissionPane(mission, i, player));
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
		tooltip.setText("Mission");
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}
}
