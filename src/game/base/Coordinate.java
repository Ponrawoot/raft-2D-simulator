package game.base;

public class Coordinate {
	private int x, y;

	public Coordinate() {
//		setX();
//		setY();
	}

	public Coordinate(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isNextTo(Coordinate other) {
		if (Math.abs(other.getX() - x) == 1 && Math.abs(other.getY() - y) == 0) {
			return true;
		} else if (Math.abs(other.getX() - x) == 0 && Math.abs(other.getY() - y) == 1) {
			return true;
		}
		return false;
	}

}
