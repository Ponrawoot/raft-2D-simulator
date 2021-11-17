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
		// this.time =;
	}

	@Override
	public void beRemoved() {
		if (Player.getCurrentShovel() == null)
			return;
		if (Player.getCurrentPosition().isNextTo(position) && metal
				&& (Player.getCurrentShovel().getMaterial() == MaterialType.METAL)) {
			Player.setMetal(Player.getMetal() + 1);
			// time =;
			metal = false;
			Player.decreaseLifetime(ApplicationType.SHOVEL);
			Player.decreaseHP();
			position.setStatus(true);
		}
		// TODO Auto-generated method stub
	}

	public void refresh() {
		if (!metal) { // CheckTime
			metal = true;
			position.setStatus(false);
		}
	}

	public boolean isMetal() {
		return metal;
	}

	public Cell getPosition() {
		return position;
	}

	public int getTime() {
		return time;
	}

}
