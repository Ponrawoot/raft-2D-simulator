package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Player;
import object.Shipwreck;

public class ShipwreckTest {
	private Shipwreck shipwreck;
	private Player player;

	@BeforeEach
	public void setUp() throws Exception {
		shipwreck = new Shipwreck();
		player = new Player("player");
		player.setWood(50);
		player.setHinge(10);
		player.setNail(15);
		player.setRope(20);
		player.setCanvas(true);
		player.setSteering(true);
		player.setEngine(true);
		player.setPetrol(true);
		player.setTitanium(1);
		player.setReceiver(true);
		player.setAnthena(true);
	}

	public void preparePlayer(String object) {
		switch (object) {
		case "Wood":
			player.setWood(0);
			break;
		case "Hinge":
			player.setHinge(0);
			break;
		case "Nail":
			player.setNail(0);
			break;
		case "Rope":
			player.setRope(0);
			break;
		case "Canvas":
			player.setCanvas(false);
			break;
		case "Steering":
			player.setSteering(false);
			break;
		case "Engine":
			player.setEngine(false);
			break;
		case "Petrol":
			player.setPetrol(false);
			break;
		case "Titanium":
			player.setTitanium(0);
			break;
		case "Receiver":
			player.setReceiver(false);
			break;
		default:
			player.setAnthena(false);
			break;
		}

		String[] s = { "Wood", "Hinge", "Nail", "Rope", "Canvas", "Steering", "Engine", "Petrol", "Titanium",
				"Receiver", "Anthena" };
		for (String obj : s) {
			if (obj.equals(object))
				continue;
			shipwreck.repair(obj, player);
		}
	}

	@Test
	public void testRepairWood() {
		preparePlayer("Wood");
		assertFalse(shipwreck.repair("Wood", player));

		player.setWood(120);
		assertTrue(shipwreck.repair("Wood", player));
		assertEquals(70, player.getWood());
		assertTrue(shipwreck.haswood());

		shipwreck.repair("Wood", player);
		assertEquals(70, player.getWood());
		assertTrue(shipwreck.haswood());
	}

	@Test
	public void testRepairHinge() {
		preparePlayer("Hinge");
		assertFalse(shipwreck.repair("Hinge", player));

		player.setHinge(60);
		assertTrue(shipwreck.repair("Hinge", player));
		assertEquals(50, player.getHinge());
		assertTrue(shipwreck.hasHinge());

		shipwreck.repair("Hinge", player);
		assertEquals(50, player.getHinge());
		assertTrue(shipwreck.hasHinge());
	}

	@Test
	public void testRepairNail() {
		preparePlayer("Nail");
		assertFalse(shipwreck.repair("Nail", player));

		player.setNail(60);
		assertTrue(shipwreck.repair("Nail", player));
		assertEquals(45, player.getNail());
		assertTrue(shipwreck.hasNail());

		shipwreck.repair("Nail", player);
		assertEquals(45, player.getNail());
		assertTrue(shipwreck.hasNail());
	}

	@Test
	public void testRepairRope() {
		preparePlayer("Rope");
		assertFalse(shipwreck.repair("Rope", player));

		player.setRope(60);
		assertTrue(shipwreck.repair("Rope", player));
		assertEquals(40, player.getRope());
		assertTrue(shipwreck.hasRope());

		shipwreck.repair("Rope", player);
		assertEquals(40, player.getRope());
		assertTrue(shipwreck.hasRope());
	}

	@Test
	public void testRepairCanvas() {
		preparePlayer("Canvas");
		assertFalse(shipwreck.repair("Canvas", player));

		player.setCanvas(true);
		assertTrue(shipwreck.repair("Canvas", player));
		assertFalse(player.hasCanvas());
		assertTrue(shipwreck.hasCanvas());

		shipwreck.repair("Canvas", player);
		assertFalse(player.hasCanvas());
		assertTrue(shipwreck.hasCanvas());
	}

	@Test
	public void testRepairSteering() {
		preparePlayer("Steering");
		assertFalse(shipwreck.repair("Steering", player));

		player.setSteering(true);
		assertTrue(shipwreck.repair("Steering", player));
		assertFalse(player.hasSteering());
		assertTrue(shipwreck.hasSteering());

		shipwreck.repair("Steering", player);
		assertFalse(player.hasSteering());
		assertTrue(shipwreck.hasSteering());
	}

	@Test
	public void testRepairEngine() {
		preparePlayer("Engine");
		assertFalse(shipwreck.repair("Engine", player));

		player.setEngine(true);
		assertTrue(shipwreck.repair("Engine", player));
		assertFalse(player.hasEngine());
		assertTrue(shipwreck.hasEngine());

		shipwreck.repair("Engine", player);
		assertFalse(player.hasEngine());
		assertTrue(shipwreck.hasEngine());
	}

	@Test
	public void testRepairPetrol() {
		preparePlayer("Petrol");
		assertFalse(shipwreck.repair("Petrol", player));

		player.setPetrol(true);
		assertTrue(shipwreck.repair("Petrol", player));
		assertFalse(player.hasPetrol());
		assertTrue(shipwreck.hasPetrol());

		shipwreck.repair("Petrol", player);
		assertFalse(player.hasPetrol());
		assertTrue(shipwreck.hasPetrol());
	}

	@Test
	public void testRepairTitanium() {
		preparePlayer("Titanium");
		assertFalse(shipwreck.repair("Nail", player));

		player.setTitanium(5);
		assertTrue(shipwreck.repair("Titanium", player));
		assertEquals(4, player.getTitanium());
		assertTrue(shipwreck.hasTitanium());

		shipwreck.repair("Titanium", player);
		assertEquals(4, player.getTitanium());
		assertTrue(shipwreck.hasTitanium());
	}

	@Test
	public void testRepairReceiver() {
		preparePlayer("Receiver");
		assertFalse(shipwreck.repair("Receiver", player));

		player.setReceiver(true);
		assertTrue(shipwreck.repair("Receiver", player));
		assertFalse(player.hasReceiver());
		assertTrue(shipwreck.hasReceiver());

		shipwreck.repair("Receiver", player);
		assertFalse(player.hasReceiver());
		assertTrue(shipwreck.hasReceiver());
	}

	@Test
	public void testRepairAnthena() {
		preparePlayer("Anthena");
		assertFalse(shipwreck.repair("Anthena", player));

		player.setAnthena(true);
		assertTrue(shipwreck.repair("Anthena", player));
		assertFalse(player.hasAnthena());
		assertTrue(shipwreck.hasAntenna());

		shipwreck.repair("Anthena", player);
		assertFalse(player.hasAnthena());
		assertTrue(shipwreck.hasAntenna());
	}
}
