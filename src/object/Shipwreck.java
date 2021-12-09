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

	public void repair(String object) {
		int n;
		boolean c;
		switch (object) {
		case "Wood":
			n = Player.getWood();
			if (n >= 50)
				wood = true;
			Player.setWood(n - 50);
			break;
		case "Hinge":
			n = Player.getHinge();
			if (n >= 10)
				hinge = true;
			Player.setHinge(n - 10);
			break;
		case "Nail":
			n = Player.getNail();
			if (n >= 15)
				nail = true;
			Player.setNail(n - 15);
			break;
		case "Rope":
			n = Player.getRope();
			if (n >= 20)
				rope = true;
			Player.setRope(n - 20);
			break;
		case "Canvas":
			c = Player.hasCanvas();
			if (c)
				canvas = true;
			Player.setCanvas(false);
			break;
		case "Steering":
			c = Player.hasSteering();
			if (c)
				steering = true;
			Player.setSteering(false);
			break;
		case "Engine":
			c = Player.hasEngine();
			if (c)
				engine = true;
			Player.setEngine(false);
			break;
		case "Petrol":
			c = Player.hasPetrol();
			if (c)
				petrol = true;
			Player.setPetrol(false);
			break;
		case "Titanium":
			n = Player.getTitanium();
			if (n >= 1)
				titanium = true;
			Player.setTitanium(n - 1);
			break;
		case "Receiver":
			c = Player.hasReceiver();
			if (c)
				receiver = true;
			Player.setReceiver(false);
			break;
		case "Anthena":
			c = Player.hasAnthena();
			if (c)
				anthena = true;
			Player.setAnthena(false);
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
