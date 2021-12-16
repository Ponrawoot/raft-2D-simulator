package object;

import game.Cell;
import game.Player;
import game.base.Removable;

public class Stone extends Material implements Removable {

	public Stone(Cell position) {
		super(position);
	}

	@Override
	public void beRemoved(Player player) {
		// TODO Auto-generated method stub

		if (player.getCurrentPosition().isNextTo(position) && present) {
			player.setStone(player.getStone() + 1);
			present = false;
			position.setStatus(true);
			player.decreaseHP();
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
