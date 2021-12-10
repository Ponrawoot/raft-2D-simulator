package object;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;
import object.base.ApplicationType;
import object.base.MaterialType;

public class PineconeTree extends Tree implements Removeable {

	private int pineconeSeed;

	public PineconeTree(Cell position) {
		super(position);
		// TODO Auto-generated constructor stub
		super.setWood(2);
		super.setLeaf(2);
		setPineconeSeed(1);
	}

	@Override
	public void beRemoved(Player player) {
		// TODO Auto-generated method stub
		if (readyToCut && player.getCurrentPosition().isNextTo(position)) {
			if (player.getCurrentAxe().getMaterial() == MaterialType.METAL) {
				player.decreaseLifetime(ApplicationType.AXE);
				player.setWood(player.getWood() + wood);
				player.setLeaf(player.getLeaf() + leaf);
				player.setPineconeSeed(player.getPineconeSeed() + pineconeSeed);
				setWood(0);
				setLeaf(0);
				setPineconeSeed(0);
				setReadyToCut(false);
				Map.removeTree(this);
				this.position.setStatus(true);
				player.decreaseHP();
			}
		}
	}

	@Override
	public void grow(Player player) {
		// TODO Auto-generated method stub
		if (player.getPineconeSeed() > 0 && !readyToCut) {
			super.setWood(2);
			super.setLeaf(2);
			setPineconeSeed(1);
			this.position.setStatus(false);
			player.setPineconeSeed(player.getPineconeSeed() - 1);

			try {
				Thread.sleep(15000); // (millisecond) can change
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			setReadyToCut(true);
		}
	}

	public void setPineconeSeed(int pineconeSeed) {
		this.pineconeSeed = pineconeSeed;
	}

	public int getPineconeSeed() {
		return pineconeSeed;
	}

}
