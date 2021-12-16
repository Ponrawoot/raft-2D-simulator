package object;

import game.Cell;
import game.Player;
import game.base.Removable;
import object.base.ApplicationType;
import object.base.MaterialType;

public class Bird extends Animal implements Removable {

	public Bird(Cell position) {
		super(position);
	}

	@Override
	public void beRemoved(Player player) {
		// TODO Auto-generated method stub
		if (checkWeaponCondition(player) && player.getCurrentPosition().isNextTo(position) && alive) {
			player.setBird(player.getBird() + 1);
			player.setFeather(player.getFeather() + 2);
			position.setStatus(true);
			setAlive(false);
			player.decreaseHP();
			player.decreaseLifetime(ApplicationType.SPEAR);
		}
	}

	public void refresh(Cell position) {
		if (!alive) {
			setPosition(position);
			setAlive(true);
			this.position.setStatus(false);
		}
	}

	@Override
	public boolean checkWeaponCondition(Player player) {
		return player.getCurrentSpear() != null ;
	}

	@Override
	public String toString() {
		return "bird, 2 feathers,";
	}
}
