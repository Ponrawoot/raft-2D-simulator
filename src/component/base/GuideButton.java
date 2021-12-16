package component.base;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GuideButton extends Button {
	public GuideButton() {
		ImageView ImageView = new ImageView(new Image("guide.png"));
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
				stage.setTitle("Guide");
				ScrollPane root = new ScrollPane();
				VBox guide = new VBox();
				ImageView ImageView1 = new ImageView(new Image("Project_002.jpg"));
				ImageView1.setFitWidth(700);
				ImageView1.setFitHeight(1000);
				ImageView ImageView2 = new ImageView(new Image("Project_003.jpg"));
				ImageView2.setFitWidth(700);
				ImageView2.setFitHeight(1000);
				ImageView ImageView3 = new ImageView(new Image("Project_004.jpg"));
				ImageView3.setFitWidth(700);
				ImageView3.setFitHeight(1000);
				ImageView ImageView4 = new ImageView(new Image("Project_005.jpg"));
				ImageView4.setFitWidth(700);
				ImageView4.setFitHeight(1000);
				guide.getChildren().addAll(ImageView1, ImageView2, ImageView3, ImageView4);
				root.setContent(guide);
				root.setPrefViewportHeight(700);
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
		tooltip.setText("Guide");
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}
}
