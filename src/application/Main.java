package application;

import component.RootPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private static RootPane rootPane;
	public void start(Stage primaryStage) throws Exception {
		rootPane = new RootPane();
		
		Scene scene = new Scene(rootPane, 512,480);
		
		primaryStage.setTitle("Survival Simulator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	

}
