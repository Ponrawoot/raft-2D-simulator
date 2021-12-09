package object;

import java.util.Timer;
import java.util.TimerTask;

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
	public void beRemoved() {
		// TODO Auto-generated method stub
		if (readyToCut && Player.getCurrentPosition().isNextTo(position)) {
			if (Player.getCurrentAxe().getMaterial() == MaterialType.METAL) {
				Player.decreaseLifetime(ApplicationType.AXE);
				Player.setWood(Player.getWood() + wood);
				Player.setLeaf(Player.getLeaf() + leaf);
				Player.setPineconeSeed(Player.getPineconeSeed() + pineconeSeed);
				setWood(0);
				setLeaf(0);
				setPineconeSeed(0);
				setReadyToCut(false);
				Map.removeTree(this);
				this.position.setStatus(true);
				Player.decreaseHP();
			}
		}
	}

	@Override
	public void grow() {
		// TODO Auto-generated method stub
		if (Player.getPineconeSeed() > 0 && !readyToCut) {
			super.setWood(2);
			super.setLeaf(2);
			setPineconeSeed(1);
			this.position.setStatus(false);
			Player.setPineconeSeed(Player.getPineconeSeed() - 1);

			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				int i = 15; // (second) can change

				@Override
				public void run() {
					// TODO Auto-generated method stub
					i--;
					if (i < 0) {
						timer.cancel();
						setReadyToCut(true);
					}
				}
			}, 0, 1000);
		}
	}

	public void setPineconeSeed(int pineconeSeed) {
		this.pineconeSeed = pineconeSeed;
	}

}
