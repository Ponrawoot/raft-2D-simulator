package object;

import game.Cell;
import game.Player;
import game.base.Removeable;
import object.base.ApplicationType;
import object.base.MaterialType;

public class Metal implements Removeable {
	private boolean metal;
	private Cell position;
	private int time;

	
	public Metal(Cell position) {
		this.metal = false;
		this.position = position;
		//this.time =; 
	}
	@Override
	public void beRemoved() {
		if (Player.getCurrentPosition().getCoCell().isNextTo(this.position.getCoCell())&&metal&&(Player.getCurrentShovel().getMaterial()==MaterialType.METAL)) {
			Player.setMetal(Player.getMetal()+1);
			//time =;
			Player.decrease
		}
		// TODO Auto-generated method stub
		
		
	}

}
