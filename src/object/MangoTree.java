package object;

import java.util.Timer;
import java.util.TimerTask;

import game.Cell;
import game.Map;
import game.Player;
import game.base.Removeable;
import object.base.ApplicationType;
import object.base.MaterialType;

public class MangoTree extends Tree implements Removeable {

	private int fruit;
	private int mangoSeed;

	public MangoTree(Cell position) {
		super(position);
		// TODO Auto-generated constructor stub
		super.setWood(1);
		super.setLeaf(2);
		setFruit(1);
		setMangoSeed(1);
	}

	@Override
	public void beRemoved() {
		// TODO Auto-generated method stub
		if (readyToCut && Player.getCurrentPosition().isNextTo(position)) {
			if (Player.getCurrentAxe().getMaterial() == MaterialType.STONE
					|| Player.getCurrentAxe().getMaterial() == MaterialType.METAL) {
				Player.decreaseLifetime(ApplicationType.AXE);
				Player.setWood(Player.getWood() + wood);
				Player.setLeaf(Player.getLeaf() + leaf);
				Player.setFruit(Player.getFruit() + fruit);
				Player.setMangoSeed(Player.getMangoSeed() + mangoSeed);
				setWood(0);
				setLeaf(0);
				setFruit(0);
				setMangoSeed(0);
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
		if (Player.getMangoSeed() > 0) {
			super.setWood(1);
			super.setLeaf(2);
			setFruit(1);
			setMangoSeed(1);
			this.position.setStatus(false);
			Player.setMangoSeed(Player.getMangoSeed() - 1);

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

	public void setFruit(int fruit) {
		this.fruit = fruit;
	}

	public void setMangoSeed(int mangoSeed) {
		this.mangoSeed = mangoSeed;
	}

}
