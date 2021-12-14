package application;

import component.RootPane;
import game.Cell;
import game.Map;
import game.Player;
import javafx.application.Platform;
import object.MangoTree;
import object.Material;
import object.PalmTree;
import object.PineconeTree;
import object.Shipwreck;
import object.Stone;
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
		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(2000);
				Platform.runLater(() -> {
					RootPane.redraw(cell, cell, "PalmTree");
				});
				/* ======================================================== */

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		thread.start();
		for (Tree x : Map.getTrees()) {
			if (x.getPosition().isSamePosition(cell)) {
				PalmTree palmTree = (PalmTree) x;
				palmTree.grow();
			}
		}	
	}

	public void refreshObject(Object object) {
		// TODO Auto-generated method stub
		if (object instanceof Stone) {
			if (Map.readyForRandomMaterial(Map.getAvailableStone())) {
				Map.refreshStone(Map.getRandomInteger(1, 10));
				Thread thread = new Thread(() -> {
					try {
						Thread.sleep(2000);
						Platform.runLater(() -> {
							for (Material x: Map.getAvailableStone()) {
								RootPane.redraw(x.getPosition(), x.getPosition(), "Stone");
							}
						});
						/* ======================================================== */

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				thread.start();
			}
			
		}
			
	}
}
