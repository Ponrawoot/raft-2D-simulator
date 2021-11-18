package object;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;

public class Plastic implements Removeable {
	private boolean plastic;
	private Cell position;
	
	public Plastic(Cell positon) {
		this.plastic = true;
		this.position = positon;
	}
	@Override
	public void beRemoved() {
		// TODO Auto-generated method stub
		if (Player.getCurrentPosition().isNextTo(position)) {
			Player.setPlastic(Player.getPlastic()+1);
			position.setStatus(true);
			Player.decreaseHP();
		}
		for (Plastic x : Map.getAvailablePlastic()) {
			if (x.isPlastic())
				return;
		}
		// time = ;
		
	}
	
//	public void refresh() {
	
	public boolean isPlastic() {
		return plastic;
	}
	public Cell getPosition() {
		return position;
	}
	

}
