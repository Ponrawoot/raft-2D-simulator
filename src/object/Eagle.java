package object;

<<<<<<< HEAD
import component.RootPane;
import component.TopBar;
||||||| cfd121d
import component.TopBar;
=======
>>>>>>> 8f35dd103d0414137a7d647637efc13074ee8768
import game.Cell;
import game.Map;
import game.Player;
import game.base.Coordinate;
import javafx.application.Platform;
import object.base.ApplicationType;
import object.base.MaterialType;
import java.lang.*;

public class Eagle extends Animal {

	private boolean move;
	private static final Cell defaultPosition = new Cell(new Coordinate(4, 1), false, false, true);

	public Eagle() {
		super(defaultPosition); // same position every time
		// TODO Auto-generated constructor stub
		super.getPosition().setStatus(true);
		setMove(true);
	}

	public boolean moveToPlayer(Player player) {
		boolean c = false;
		for (Cell x: Map.getMoveableForEagleArea()) {
			if (x.isSamePosition(player.getCurrentPosition())) {
				//RootPane.redraw(Map.getCellFromCoordinate(new Coordinate(5,5)), defaultPosition, "Eagle");
				c = true;
				break;
			}
		}
		if (c) {
			int xEagle = getPosition().getCoCell().getX();
			int yEagle = getPosition().getCoCell().getY();
			Cell prev = Map.getCellFromCoordinate(new Coordinate(xEagle, yEagle));
			int xPlayer = player.getCurrentPosition().getCoCell().getX();
			int yPlayer = player.getCurrentPosition().getCoCell().getY();
			if (Math.abs(yPlayer-position.getCoCell().getY())>0) {
					int dy;
					if (yPlayer>position.getCoCell().getY()) dy=1;
					else dy=-1;
					prev.getCoCell().setY(prev.getCoCell().getY()+dy);
					Thread thread = new Thread(() -> {
						try {
							Thread.sleep(2000);
							Platform.runLater(() -> {
									RootPane.redraw(position, prev, "Eagle");
							});
							/* ======================================================== */

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
					thread.start();
					position.getCoCell().setY(position.getCoCell().getY() + dy);
					return true;
//					if (!Map.getMoveableForEagleArea().contains(player.getCurrentPosition()))
//						setPosition(defaultPosition);
			} 
			if (Math.abs(xPlayer-position.getCoCell().getX())>0) {
					int dx;
					if (xPlayer>position.getCoCell().getX()) dx=1;
					else dx=-1;
					prev.getCoCell().setX(prev.getCoCell().getX()+dx);
					Thread thread = new Thread(() -> {
						try {
							Thread.sleep(2000);
							Platform.runLater(() -> {
									RootPane.redraw(position, prev, "Eagle");
							});
							/* ======================================================== */

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
					thread.start();
					position.getCoCell().setX(position.getCoCell().getX() + dx);
					return true;
//					if (!Map.getMoveableForEagleArea().contains(player.getCurrentPosition()))
//						setPosition(defaultPosition);
				}
//			hitPlayer(player);
		}
		return false;
//		if (!(Map.getMoveableForEagleArea().contains(player.getCurrentPosition()))) return;
		

	}

	public void hitPlayer(Player player) {
		if (position.isSamePosition(player.getCurrentPosition()) && move && alive) {
			player.decreaseHP();
		}
//			Thread thread = new Thread(() -> {
//				try {
//					Thread.sleep(2000);
//					/* ======================================================== */
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			});
//		}
		
	}

	public void killed(Player player) {
		if (player.getCurrentSpear() == null)
			return;
		if ((player.getCurrentPosition().isNextTo(position) || player.getCurrentPosition().isSamePosition(position))
				&& player.getCurrentSpear().getMaterial() == MaterialType.METAL && alive) {
			setAlive(false);
			player.setBird(player.getBird() + 2);
			player.setEagleHead(player.getEagleHead() + 1);
			player.setFeather(player.getFeather() + 3);
			player.decreaseLifetime(ApplicationType.SPEAR);
			player.decreaseHP();

//			try {
//				Thread.sleep(15000); // (millisecond) can change
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			refresh();
		}
	}

	public void refresh() {
		if (!alive) {
			setPosition(defaultPosition);
			setAlive(true);
			setMove(true);
		}
	}

	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

}
