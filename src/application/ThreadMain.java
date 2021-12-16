package application;

import component.RootPane;
import game.Cell;
import game.Map;
import game.Player;
import game.base.Coordinate;
import javafx.application.Platform;
import object.Animal;
import object.Bird;
import object.Fish;
import object.Eagle;
import object.MangoTree;
import object.Material;
import object.Metal;
import object.PalmTree;
import object.PineTree;
import object.Plastic;
import object.Scrap;
import object.Stone;
import object.Tree;

public class ThreadMain {

	public void refreshObject(Object object) {
		// TODO Auto-generated method stub
		if (object instanceof Fish) {
			if (Map.readyForRandomAnimal(Map.getAvailableFish())) {
				Map.refreshFish(Map.getRandomInteger(1, 10));
				Thread thread = new Thread(() -> {
					try {
						Thread.sleep(2000);
						Platform.runLater(() -> {
							for (Animal x : Map.getAvailableFish()) {
								if (x.isAlive())
									RootPane.redraw(x.getPosition(), x.getPosition(), "Fish");
							}
						});
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
							for (Animal x : Map.getAvailableBird()) {
								if (x.isAlive())
									RootPane.redraw(x.getPosition(), x.getPosition(), "Bird");
							}
						});
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
					Thread.sleep(5000);
					Platform.runLater(() -> {
						RootPane.redraw(cell, cell, "PalmTree");
						for (Tree x : Map.getTrees()) {
							if (x.getPosition().isSamePosition(cell)) {
								PalmTree palmTree = (PalmTree) x;
								palmTree.grow();
							}
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
		if (object instanceof Eagle) {
			Cell cell = ((Eagle) object).getPosition();
			cell.setStatus(true);
			Thread thread = new Thread(() -> {
				try {
					Thread.sleep(10000);
					Platform.runLater(() -> {
						((Eagle) object).refresh();
						RootPane.redraw(Map.getCellFromCoordinate(new Coordinate(4, 1)), cell, "Eagle");
					});
					/* ======================================================== */

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			thread.start();
		}
		if (object instanceof Metal) {
			Cell cell = ((Metal) object).getPosition();
			Thread thread = new Thread(() -> {
				try {
					Thread.sleep(2000);
					Platform.runLater(() -> {
						RootPane.redraw(cell, cell, "Metal");
						((Metal) object).refresh();
					});
					/* ======================================================== */

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			thread.start();
		}
		if (object instanceof Stone) {
			if (Map.readyForRandomMaterial(Map.getAvailableStone())) {
				Map.refreshStone(Map.getRandomInteger(1, 10));
				Thread thread = new Thread(() -> {
					try {
						Thread.sleep(2000);
						Platform.runLater(() -> {
							for (Material x : Map.getAvailableStone()) {
								if (x.isPresent())
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
		if (object instanceof Plastic) {
			if (Map.readyForRandomMaterial(Map.getAvailablePlastic())) {
				Map.refreshPlastic(Map.getRandomInteger(1, 10));
				Thread thread = new Thread(() -> {
					try {
						Thread.sleep(2000);
						Platform.runLater(() -> {
							for (Material x : Map.getAvailablePlastic()) {
								if (x.isPresent())
									RootPane.redraw(x.getPosition(), x.getPosition(), "Plastic");
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
		if (object instanceof Scrap) {
			if (Map.readyForRandomMaterial(Map.getAvailableScrape())) {
				Map.refreshScrape(Map.getRandomInteger(1, 10));
				Thread thread = new Thread(() -> {
					try {
						Thread.sleep(2000);
						Platform.runLater(() -> {
							for (Material x : Map.getAvailableScrape()) {
								if (x.isPresent())
									RootPane.redraw(x.getPosition(), x.getPosition(), "Scrap");
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

	public boolean activateEagle(Player player) {
		// TODO Auto-generated method stub
		int x = player.getCurrentPosition().getCoCell().getX();
		int y = player.getCurrentPosition().getCoCell().getY();
		Cell prev = Map.getCellFromCoordinate(new Coordinate(x, y));
		Thread thread = new Thread(() -> {
			try {
				while (Map.getEagle().checkMoving(player) && player.getCurrentPosition().isSamePosition(prev)) {
					Thread.sleep(2000);
					Platform.runLater(() -> {
						Map.getEagle().moveToPlayer(player);
						Map.getEagle().hitPlayer(player);
						if (player.getHP() == 0) {
							return;
						}
					});
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		thread.start();
		if (!Map.getEagle().checkMoving(player)) {
			thread.interrupt();
			return false;
		}
		return true;
	}

	public void setGrow(Object object) {
		if (object instanceof MangoTree && (!((Tree) object).isReadyToCut())) {
			Thread thread = new Thread(() -> {
				try {
					Thread.sleep(5000);
					Platform.runLater(() -> {
						RootPane.redraw(((MangoTree) object).getPosition(), ((MangoTree) object).getPosition(),
								"MangoTree");
					});
					/* ======================================================== */

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			thread.start();
			((MangoTree) object).grow();
		}

		if (object instanceof PineTree && (!((Tree) object).isReadyToCut())) {
			Thread thread = new Thread(() -> {
				try {
					Thread.sleep(5000);
					Platform.runLater(() -> {
						RootPane.redraw(((PineTree) object).getPosition(), ((PineTree) object).getPosition(),
								"PineTree");
					});
					/* ======================================================== */

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			thread.start();
			((PineTree) object).grow();
		}
	}
}
