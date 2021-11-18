package object;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;
import object.base.ApplicationType;

public class Fish extends Animal implements Removeable {

	public Fish(Cell position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void beRemoved() {
		// TODO Auto-generated method stub
		if (Player.getCurrentSpear() != null && Player.getCurrentPosition().isNextTo(position) && alive) {
			Player.setFish(Player.getFish() + 1);
			position.setStatus(true);
			setAlive(false);
			Player.decreaseHP();
			Player.decreaseLifetime(ApplicationType.SPEAR);
		}
	}

	public void refresh(Cell position) {
		if (!alive) {
			setPosition(position);
			setAlive(true);
			this.position.setStatus(false);
		}
	}
}
