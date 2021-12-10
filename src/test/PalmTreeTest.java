package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Cell;
import game.Player;
import game.base.Coordinate;
import object.PalmTree;
import object.Weapon;
import object.base.ApplicationType;
import object.base.MaterialType;

public class PalmTreeTest {
	private Player player;
	private PalmTree palmTree;
	private Cell cell;

	@BeforeEach
	public void setUp() throws Exception {
		player = new Player("player");
		cell = new Cell(new Coordinate(7, 5), false, false, false);
		palmTree = new PalmTree(cell);
	}

	@Test
	public void testConstructor() {
		assertFalse(palmTree.isReadyToCut());
		assertFalse(palmTree.getPosition().getStatus());
		assertEquals(7, palmTree.getPosition().getCoCell().getX());
		assertEquals(5, palmTree.getPosition().getCoCell().getY());
		assertEquals(3, palmTree.getLeaf());
		assertEquals(3, palmTree.getWood());
	}

	@Test
	public void testCollect() {
		palmTree.grow(player);

		palmTree.collect(player);
		assertTrue(palmTree.isReadyToCut());
		assertEquals(0, player.getWood());
		assertEquals(0, player.getLeaf());
		assertFalse(cell.getStatus());
		assertEquals(10, player.getHP());
		assertEquals(null, player.getCurrentAxe());

		Weapon weapon = new Weapon(MaterialType.WOOD, ApplicationType.AXE);
		player.setCurrentAxe(weapon);
		palmTree.collect(player);
		assertTrue(palmTree.isReadyToCut());
		assertEquals(0, player.getWood());
		assertEquals(0, player.getLeaf());
		assertFalse(cell.getStatus());
		assertEquals(10, player.getHP());
		assertEquals(5, player.getCurrentAxe().getLifetime());
		
		player.setCurrentPosition(7, 4);
		palmTree.collect(player);
		assertFalse(palmTree.isReadyToCut());
		assertEquals(3, player.getWood());
		assertEquals(3, player.getLeaf());
		assertFalse(cell.getStatus());
		assertEquals(9, player.getHP());
		assertEquals(4, player.getCurrentAxe().getLifetime());
	}

	@Test
	public void testGrow() {
		assertFalse(palmTree.isReadyToCut());
		palmTree.grow(player);
		assertTrue(palmTree.isReadyToCut());
		assertEquals(3, palmTree.getLeaf());
		assertEquals(3, palmTree.getWood());

	}

}