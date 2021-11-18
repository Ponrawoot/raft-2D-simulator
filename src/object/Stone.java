package object;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;

public class Stone extends Material implements Removeable{

	public Stone(Cell position) {
		super(position);
	}

	@Override
	public void beRemoved() {
		// TODO Auto-generated method stub
		if (Player.getCurrentPosition().isNextTo(position)&&present) {
			Player.setStone(Player.getStone()+1);
			present = false;
			position.setStatus(true);
			Player.decreaseHP();
		}
	}
	
	public void refresh(Cell position) {
		if (!present) {
			this.setPresent(true);
			this.setPosition(position);
			this.position.setStatus(false);
		}
	}

}
