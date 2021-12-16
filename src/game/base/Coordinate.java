package game.base;

public class Coordinate {
	private int x, y;

	public Coordinate() {
		setX(9);
		setY(12);
	}

	public Coordinate(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x < 0)
			x = 0;
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y < 0)
			y = 0;
		this.y = y;
	}

	public boolean isSamePosition(Coordinate other) {
		return this.getX() == other.getX() && this.getY() == other.getY();
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
