package object;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;

public class Plastic extends Material implements Removeable {

	public Plastic(Cell position) {
		super(position);
	}
	
	public void beRemoved() {
		// TODO Auto-generated method stub
		if (Player.getCurrentPosition().isNextTo(position)&&present) {
			Player.setPlastic(Player.getPlastic()+1);
			present = false;
			position.setStatus(true);
			Player.decreaseHP();
		}
		for (Material x : Map.getAvailablePlastic()) {
			if (x.isPresent())
				return;
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