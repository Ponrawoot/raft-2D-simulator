package object;

import game.Player;

public class Shipwreck {
	private static boolean wood;
	private static boolean hinge;
	private static boolean nail;
	private static boolean rope;
	private static boolean canvas;
	private static boolean steering;
	private static boolean engine;
	private static boolean petrol;
	private static boolean titanium;
	private static boolean receiver;
	private static boolean anthena;

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

	public boolean repair(String object, Player player) {
		int n;
		switch (object) {
		case "Wood":
			n = player.getWood();
			if (n >= 50 && !wood) {
				wood = true;
				player.setWood(n - 50);
				break;
			}
			return false;
		case "Hinge":
			n = player.getHinge();
			if (n >= 10 && !hinge) {
				hinge = true;
				player.setHinge(n - 10);
				break;
			}
			return false;
		case "Nail":
			n = player.getNail();
			if (n >= 15 && !nail) {
				nail = true;
				player.setNail(n - 15);
				break;
			}
			return false;
		case "Rope":
			n = player.getRope();
			if (n >= 20 && !rope) {
				rope = true;
				player.setRope(n - 20);
				break;
			}
			return false;
		case "Canvas":
			if (player.hasCanvas() && !canvas) {
				canvas = true;
				player.setCanvas(false);
				break;
			}
			return false;
		case "Steering":
			if (player.hasSteering() && !steering) {
				steering = true;
				player.setSteering(false);
				break;
			}
			return false;
		case "Engine":
			if (player.hasEngine() && !engine) {
				engine = true;
				player.setEngine(false);
				break;
			}
			return false;
		case "Petrol":
			if (player.hasPetrol() && !petrol) {
				petrol = true;
				player.setPetrol(false);
				break;
			}
			return false;
		case "Titanium":
			n = player.getTitanium();
			if (player.getTitanium() >= 1 && !titanium) {
				titanium = true;
				player.setTitanium(n - 1);
				break;
			}
			return false;
		case "Receiver":
			if (player.hasReceiver() && !receiver) {
				receiver = true;
				player.setReceiver(false);
				break;
			}
			return false;
		case "Antenna":
			if (player.hasAnthena() && !anthena) {
				anthena = true;
				player.setAnthena(false);
				break;
			}
			return false;
		}
		return true;
	}

	public static boolean checkWinCondition() {
		if (wood && hinge && nail && rope && canvas && steering && engine && petrol && titanium && receiver
				&& anthena) {
			return true;
		}
		return false;
	}

	public boolean haswood() {
		return wood;
	}

	public boolean hasHinge() {
		return hinge;
	}

	public boolean hasNail() {
		return nail;
	}

	public boolean hasRope() {
		return rope;
	}

	public boolean hasCanvas() {
		return canvas;
	}

	public boolean hasSteering() {
		return steering;
	}

	public boolean hasEngine() {
		return engine;
	}

	public boolean hasPetrol() {
		return petrol;
	}

	public boolean hasTitanium() {
		return titanium;
	}

	public boolean hasReceiver() {
		return receiver;
	}

	public boolean hasAnthena() {
		return anthena;
	}
}
