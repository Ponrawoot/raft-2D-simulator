package object;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;
import object.base.ApplicationType;
import object.base.MaterialType;

public class Bird extends Animal implements Removeable {

	public Bird(Cell position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void beRemoved() {
		// TODO Auto-generated method stub
		if ((Player.getCurrentSpear().getMaterial() == MaterialType.STONE
				|| Player.getCurrentSpear().getMaterial() == MaterialType.METAL)
				&& Player.getCurrentPosition().isNextTo(position) && alive) {
			Player.setBird(Player.getBird() + 1);
			Player.setFeather(Player.getFeather() + 1);
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
