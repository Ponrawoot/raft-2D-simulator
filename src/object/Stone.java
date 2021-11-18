package object;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;

public class Stone implements Removeable{
	private boolean stone;
	private Cell position;
	
	public Stone(Cell position) {
		this.stone = true;
		this.position = position;
	}

	@Override
	public void beRemoved() {
		// TODO Auto-generated method stub
		if (Player.getCurrentPosition().isNextTo(position)) {
			Player.setStone(Player.getStone()+1);
			position.setStatus(true);
			Player.decreaseHP();
		}
		
		for (Stone x : Map.getAvailableStone()) {
			if (x.isStone())
				return;
			// time = ;
			// TODO Auto-generated method stub

		}
	}
//		public void refresh() {

	public boolean isStone() {
		return stone;
	}

	public Cell getPosition() {
		return position;
	}
	
	

}
