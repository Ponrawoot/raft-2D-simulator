package object;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;

public class Stone extends Material implements Removeable {

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

//		try {
//			Thread.sleep(15000); // (millisecond) can change
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Map.refreshStone(Map.getRandomInteger(1, 10));
//	}

	public void refresh(Cell position) {
		if (!present) {
			this.setPresent(true);
			this.setPosition(position);
			this.position.setStatus(false);
		}
	}

}
