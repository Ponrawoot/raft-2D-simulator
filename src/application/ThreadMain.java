package application;

import component.RootPane;
import game.Cell;
import game.Map;
import game.Player;
import javafx.application.Platform;
import object.MangoTree;
import object.PalmTree;
import object.PineconeTree;
import object.Shipwreck;
import object.Tree;

public class ThreadMain {
	
//	protected void runGame(Player player) {
//		Thread t = new Thread(() -> {
//			try {		
//				while(!Shipwreck.checkWinCondition()) {
//					
//					/*===================!DO NOT CHANGE THIS LINE!===========*/
//					Thread.sleep(1000);
//					
//					/*========================================================*/
//					
//					/*====================FILL CODE============================
//					There is JavaFX commands inside the code below
//					Add something to the code below to make JavaFX commands can
//					function in the thread
//					*/
//					// Hint : Player use ImageView, which is related to JavaFX.
//					Platform.runLater(() -> {
//					});
//					/*========================================================*/	
//				}
//			} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//			}	
//		});
//		t.start();	
//	}

	protected void refreshPalmTree(Cell cell) {
		try {		
			Thread.sleep(2000);
			Platform.runLater(() -> {
				RootPane.redraw(cell, cell, "PalmTree");
			});
			/*========================================================*/	
		
	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		for (Tree x: Map.getTrees()) {
			if (x.getPosition().isSamePosition(cell)) {
				PalmTree palmTree = (PalmTree) x;
				palmTree.grow();
			}
	}
//		// TODO Auto-generated method stub
//
//		Thread t = new Thread(() -> {
//			try {		
//					/*===================!DO NOT CHANGE THIS LINE!===========*/
//					Thread.sleep(1000);
//					/*========================================================*/
//					/*====================FILL CODE============================
//					There is JavaFX commands inside the code below
//					Add something to the code below to make JavaFX commands can
//					function in the thread
//					*/
//					// Hint : Player use ImageView, which is related to JavaFX.
//					Platform.runLater(() -> {
//						
//					});
//					/*========================================================*/	
//				
//			} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//			}	
//		});
//		t.start();	
	}
}
