package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Cell;
import game.Player;
import game.base.Coordinate;
import object.Fish;
import object.Weapon;
import object.base.ApplicationType;
import object.base.MaterialType;

public class FishTest {
	private Player player1, player2;
	private Fish fish;
	private Cell cell;

	@BeforeEach
	public void setUp() throws Exception {
		player1 = new Player("player1");
		Weapon weapon = new Weapon(MaterialType.STONE, ApplicationType.SPEAR);
		player1.setCurrentSpear(weapon);

		player2 = new Player("player2");
		player2.setCurrentPosition(0, 10);

		cell = new Cell(new Coordinate(0, 9), false, false, true);
		fish = new Fish(cell);
	}

	@Test
	public void testConstructor() {
		assertTrue(fish.isAlive());
		assertEquals(0, fish.getPosition().getCoCell().getX());
		assertEquals(9, fish.getPosition().getCoCell().getY());
		assertFalse(fish.getPosition().getStatus());
	}

	@Test
	public void testBeRemoved() {
		fish.beRemoved(player2);
		assertTrue(fish.isAlive());
		assertEquals(0, player2.getFish());
		assertFalse(cell.getStatus());
		assertEquals(10, player2.getHP());
		assertEquals(null, player2.getCurrentSpear());

		fish.beRemoved(player1);
		assertTrue(fish.isAlive());
		assertEquals(0, player1.getFish());
		assertFalse(cell.getStatus());
		assertEquals(10, player1.getHP());
		assertEquals(10, player1.getCurrentSpear().getLifetime());

		Weapon weapon = new Weapon(MaterialType.WOOD, ApplicationType.SPEAR);
		player2.setCurrentSpear(weapon);
		fish.beRemoved(player2);
		assertFalse(fish.isAlive());
		assertEquals(1, player2.getFish());
		assertTrue(cell.getStatus());
		assertEquals(9, player2.getHP());
		assertEquals(4, player2.getCurrentSpear().getLifetime());

		fish.refresh(cell);
		player1.setCurrentPosition(1, 9);
		fish.beRemoved(player1);
		assertFalse(fish.isAlive());
		assertEquals(1, player1.getFish());
		assertTrue(cell.getStatus());
		assertEquals(9, player1.getHP());
		assertEquals(9, player1.getCurrentSpear().getLifetime());
	}

	@Test
	public void testRefresh() {
		player1.setCurrentPosition(1, 9);
		fish.beRemoved(player1);
		fish.refresh(cell);
		assertTrue(fish.isAlive());
		assertFalse(fish.getPosition().getStatus());
		assertEquals(0, fish.getPosition().getCoCell().getX());
		assertEquals(9, fish.getPosition().getCoCell().getY());
	}

}
