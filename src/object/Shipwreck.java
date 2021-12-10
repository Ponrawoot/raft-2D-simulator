package object;

import game.Player;

public class Shipwreck {
	private boolean wood;
	private boolean hinge;
	private boolean nail;
	private boolean rope;
	private boolean canvas;
	private boolean steering;
	private boolean engine;
	private boolean petrol;
	private boolean titanium;
	private boolean receiver;
	private boolean anthena;

	public Shipwreck() {
		wood = false;
		hinge = false;
		nail = false;
		rope = false;
		canvas = false;
		steering = false;
		engine = false;
		petrol = false;
		titanium = false;
		receiver = false;
		anthena = false;
	}

	public void repair(String object, Player player) {
		int n;
		boolean c;
		switch (object) {
		case "Wood":
			n = player.getWood();
			if (n >= 50)
				wood = true;
			player.setWood(n - 50);
			break;
		case "Hinge":
			n = player.getHinge();
			if (n >= 10)
				hinge = true;
			player.setHinge(n - 10);
			break;
		case "Nail":
			n = player.getNail();
			if (n >= 15)
				nail = true;
			player.setNail(n - 15);
			break;
		case "Rope":
			n = player.getRope();
			if (n >= 20)
				rope = true;
			player.setRope(n - 20);
			break;
		case "Canvas":
			c = player.hasCanvas();
			if (c)
				canvas = true;
			player.setCanvas(false);
			break;
		case "Steering":
			c = player.hasSteering();
			if (c)
				steering = true;
			player.setSteering(false);
			break;
		case "Engine":
			c = player.hasEngine();
			if (c)
				engine = true;
			player.setEngine(false);
			break;
		case "Petrol":
			c = player.hasPetrol();
			if (c)
				petrol = true;
			player.setPetrol(false);
			break;
		case "Titanium":
			n = player.getTitanium();
			if (n >= 1)
				titanium = true;
			player.setTitanium(n - 1);
			break;
		case "Receiver":
			c = player.hasReceiver();
			if (c)
				receiver = true;
			player.setReceiver(false);
			break;
		case "Anthena":
			c = player.hasAnthena();
			if (c)
				anthena = true;
			player.setAnthena(false);
			break;
		}
		checkWinCondition();
	}

	public boolean checkWinCondition() {
		if (wood && hinge && nail && rope && canvas && steering && engine && petrol && titanium && receiver
				&& anthena) {
			return true;
		}
		return false;
	}

}
