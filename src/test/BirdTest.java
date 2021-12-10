package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Cell;
import game.Player;
import game.base.Coordinate;
import object.Bird;
import object.Weapon;
import object.base.ApplicationType;
import object.base.MaterialType;

public class BirdTest {

	private Player player1, player2;
	private Bird bird, bird2;
	private Cell cell, cell2;

	@BeforeEach
	public void setUp() throws Exception {
		player1 = new Player("player1");
		Weapon weapon = new Weapon(MaterialType.WOOD, ApplicationType.SPEAR);
		player1.setCurrentSpear(weapon);

		player2 = new Player("player2");
		Weapon weapon2 = new Weapon(MaterialType.STONE, ApplicationType.SPEAR);
		player2.setCurrentSpear(weapon2);

		cell = new Cell(new Coordinate(9, 11), false, false, true);
		bird = new Bird(cell);

		cell2 = new Cell(new Coordinate(0, 0), false, false, true);
		bird2 = new Bird(cell2);
	}

	@Test
	public void testConstructor() {
		assertTrue(bird.isAlive());
		assertEquals(9, bird.getPosition().getCoCell().getX());
		assertEquals(11, bird.getPosition().getCoCell().getY());
		assertFalse(bird.getPosition().getStatus());
	}

	@Test
	public void testRemove() {
		bird.beRemoved(player1);
		assertTrue(bird.isAlive());
		assertEquals(0, player1.getBird());
		assertEquals(0, player1.getFeather());
		assertFalse(cell.getStatus());
		assertEquals(10, player1.getHP());
		assertEquals(5, player1.getCurrentSpear().getLifetime());

		bird.beRemoved(player2);
		assertFalse(bird.isAlive());
		assertEquals(1, player2.getBird());
		assertEquals(2, player2.getFeather());
		assertTrue(cell.getStatus());
		assertEquals(9, player2.getHP());
		assertEquals(9, player2.getCurrentSpear().getLifetime());

		Weapon weapon3 = new Weapon(MaterialType.METAL, ApplicationType.SPEAR);
		player2.setCurrentSpear(weapon3);
		bird.refresh(cell);
		bird.beRemoved(player2);
		assertFalse(bird.isAlive());
		assertEquals(2, player2.getBird());
		assertEquals(4, player2.getFeather());
		assertTrue(cell.getStatus());
		assertEquals(8, player2.getHP());
		assertEquals(19, player2.getCurrentSpear().getLifetime());

		bird2.beRemoved(player2);
		assertTrue(bird2.isAlive());
		assertEquals(2, player2.getBird());
		assertEquals(4, player2.getFeather());
		assertFalse(cell2.getStatus());
		assertEquals(8, player2.getHP());
		assertEquals(19, player2.getCurrentSpear().getLifetime());

	}

	@Test
	public void testRefresh() {
		bird.beRemoved(player2);
		bird.refresh(cell);
		assertTrue(bird.isAlive());
		assertFalse(cell.getStatus());
		assertEquals(9, bird.getPosition().getCoCell().getX());
		assertEquals(11, bird.getPosition().getCoCell().getY());
	}

}
