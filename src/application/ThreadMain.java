package application;

import component.RootPane;
import game.Cell;
import game.Map;
import game.Player;
import javafx.application.Platform;
import object.Animal;
import object.Bird;
import object.Fish;
import object.MangoTree;
import object.Material;
import object.Metal;
import object.PalmTree;
import object.PineconeTree;
import object.Plastic;
import object.Scrape;
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
		if (object instanceof Fish) {
			if (Map.readyForRandomAnimal(Map.getAvailableFish())) {
				Map.refreshFish(Map.getRandomInteger(1, 10));
				Thread thread = new Thread(() -> {
					try {
						Thread.sleep(2000);
						Platform.runLater(() -> {
							for (Animal x: Map.getAvailableFish()) {
								if (x.isAlive()) RootPane.redraw(x.getPosition(), x.getPosition(), "Fish");
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
		if (object instanceof Bird) {
			if (Map.readyForRandomAnimal(Map.getAvailableBird())) {
				Map.refreshBird(Map.getRandomInteger(1, 10));
				Thread thread = new Thread(() -> {
					try {
						Thread.sleep(2000);
						Platform.runLater(() -> {
							for (Animal x: Map.getAvailableBird()) {
								if (x.isAlive()) RootPane.redraw(x.getPosition(), x.getPosition(), "Bird");
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
		if (object instanceof PalmTree) {
			Cell cell = ((PalmTree) object).getPosition();
			RootPane.redraw2(cell);
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
		if (object instanceof Metal) {
			Cell cell = ((Metal) object).getPosition();
			Thread thread = new Thread(() -> {
				try {
					Thread.sleep(2000);
					Platform.runLater(() -> {
						RootPane.redraw(cell, cell, "Metal");
					});
					/* ======================================================== */

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			thread.start();
			((Metal) object).refresh();
		}
		if (object instanceof Stone) {
			if (Map.readyForRandomMaterial(Map.getAvailableStone())) {
				Map.refreshStone(Map.getRandomInteger(1, 10));
				Thread thread = new Thread(() -> {
					try {
						Thread.sleep(2000);
						Platform.runLater(() -> {
							for (Material x: Map.getAvailableStone()) {
								if (x.isPresent()) RootPane.redraw(x.getPosition(), x.getPosition(), "Stone");
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
		if (object instanceof Plastic) {
			if (Map.readyForRandomMaterial(Map.getAvailablePlastic())) {
				Map.refreshPlastic(Map.getRandomInteger(1, 10));
				Thread thread = new Thread(() -> {
					try {
						Thread.sleep(2000);
						Platform.runLater(() -> {
							for (Material x: Map.getAvailablePlastic()) {
								if (x.isPresent()) RootPane.redraw(x.getPosition(), x.getPosition(), "Plastic");
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
		if (object instanceof Scrape) {
			if (Map.readyForRandomMaterial(Map.getAvailableScrape())) {
				Map.refreshScrape(Map.getRandomInteger(1, 10));
				Thread thread = new Thread(() -> {
					try {
						Thread.sleep(2000);
						Platform.runLater(() -> {
							for (Material x: Map.getAvailableScrape()) {
								if (x.isPresent()) RootPane.redraw(x.getPosition(), x.getPosition(), "Scrap");
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

	public void activateEagle(Player player) {
		// TODO Auto-generated method stub
		boolean check = Map.getEagle().moveToPlayer(player);
		while (check) {
			try {
				Thread.sleep(2000);
				Platform.runLater(() -> {
					Map.getEagle().hitPlayer(player);
					Map.getEagle().moveToPlayer(player);
				});
				/* ======================================================== */
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
