package game;

import game.base.Coordinate;

public class Cell {
	private Coordinate coCell;
	private boolean isSea;
	private boolean closed;
	private boolean status;

	public Cell(Coordinate coCell, boolean isSea, boolean closed, boolean status) {
		this.setCoCell(coCell);
		this.setSea(isSea);
		this.setClosed(closed);
		this.setStatus(status);
	}

	public Coordinate getCoCell() {
		return coCell;
	}

	public void setCoCell(Coordinate coCell) {
		this.coCell = coCell;
	}

	public boolean isSea() {
		return isSea;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		if (closed)
			status = false;
		this.status = status;
	}

	public boolean isClosed() {
		return closed;
	}

	private void setSea(boolean isSea) {
		this.isSea = isSea;
	}

	private void setClosed(boolean closed) {
		this.closed = closed;
	}

	public boolean isNextTo(Cell cell) {
		return getCoCell().isNextTo(cell.getCoCell());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		return getCoCell().getX() == other.getCoCell().getX() && getCoCell().getY() == other.getCoCell().getY();
	}

}
