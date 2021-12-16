package application;

import java.util.HashMap;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class ScreenController {
    private static HashMap<String, Pane> screenMap = new HashMap<>();
    private static Scene main;
    private static boolean state;

 
	public ScreenController(Scene main) {
        ScreenController.main = main;
    }

    public static void add(String name, Pane pane){
         screenMap.put(name, pane);
    }

    public static void removeScreen(String name){
        screenMap.remove(name);
    }

    public static  void activate(String name){
        main.setRoot( screenMap.get(name) );
        
    }

	public static boolean isState() {
		return state;
	}



}