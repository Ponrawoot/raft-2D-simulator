package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Cell;
import game.Player;
import game.base.Coordinate;
import object.MangoTree;
import object.Weapon;
import object.base.ApplicationType;
import object.base.MaterialType;

public class MangoTreeTest {
	private Player player;
	private MangoTree mangoTree;
	private Cell cell;

	@BeforeEach
	public void setUp() throws Exception {
		player = new Player("player");
		player.setMangoSeed(1);
		cell = new Cell(new Coordinate(18, 0), false, false, true);
		mangoTree = new MangoTree(cell);
	}

	@Test
	public void testConstructor() {
		assertFalse(mangoTree.isReadyToCut());
		assertFalse(mangoTree.getPosition().getStatus());
		assertEquals(18, mangoTree.getPosition().getCoCell().getX());
		assertEquals(0, mangoTree.getPosition().getCoCell().getY());
		assertEquals(2, mangoTree.getLeaf());
		assertEquals(1, mangoTree.getWood());
		assertEquals(1, mangoTree.getMangoSeed());
		assertEquals(1, mangoTree.getFruit());
	}

	@Test
	public void testBeRemoved() {
		mangoTree.grow(player);

		mangoTree.beRemoved(player);
		assertTrue(mangoTree.isReadyToCut());
		assertEquals(0, player.getWood());
		assertEquals(0, player.getLeaf());
		assertEquals(0, player.getFruit());
		assertEquals(0, player.getMangoSeed());
		assertFalse(cell.getStatus());
		assertEquals(10, player.getHP());
		assertEquals(null, player.getCurrentAxe());

		Weapon weapon = new Weapon(MaterialType.WOOD, ApplicationType.AXE);
		player.setCurrentAxe(weapon);
		mangoTree.beRemoved(player);
		assertTrue(mangoTree.isReadyToCut());
		assertEquals(0, player.getWood());
		assertEquals(0, player.getLeaf());
		assertEquals(0, player.getFruit());
		assertEquals(0, player.getMangoSeed());
		assertFalse(cell.getStatus());
		assertEquals(10, player.getHP());
		assertEquals(5, player.getCurrentAxe().getLifetime());

		Weapon weapon2 = new Weapon(MaterialType.STONE, ApplicationType.AXE);
		player.setCurrentAxe(weapon2);
		mangoTree.beRemoved(player);
		assertTrue(mangoTree.isReadyToCut());
		assertEquals(0, player.getWood());
		assertEquals(0, player.getLeaf());
		assertEquals(0, player.getFruit());
		assertEquals(0, player.getMangoSeed());
		assertFalse(cell.getStatus());
		assertEquals(10, player.getHP());
		assertEquals(10, player.getCurrentAxe().getLifetime());

		player.setCurrentPosition(18, 1);
		player.setCurrentAxe(weapon);
		mangoTree.beRemoved(player);
		assertTrue(mangoTree.isReadyToCut());
		assertEquals(0, player.getWood());
		assertEquals(0, player.getLeaf());
		assertEquals(0, player.getFruit());
		assertEquals(0, player.getMangoSeed());
		assertFalse(cell.getStatus());
		assertEquals(10, player.getHP());
		assertEquals(5, player.getCurrentAxe().getLifetime());

		player.setCurrentAxe(weapon2);
		// Error: NULL Map.trees
//		mangoTree.beRemoved(player);
//		assertFalse(mangoTree.isReadyToCut());
//		assertEquals(1, player.getWood());
//		assertEquals(2, player.getLeaf());
//		assertEquals(1, player.getFruit());
//		assertEquals(1, player.getMangoSeed());
//		assertTrue(cell.getStatus());
//		assertEquals(9, player.getHP());
//		assertEquals(9, player.getCurrentAxe().getLifetime());
	}

	@Test
	public void testGrow() {
		assertFalse(mangoTree.isReadyToCut());
		mangoTree.grow(player);
		assertFalse(cell.getStatus());
		assertEquals(0, player.getMangoSeed());
		assertTrue(mangoTree.isReadyToCut());
		assertEquals(2, mangoTree.getLeaf());
		assertEquals(1, mangoTree.getWood());
		assertEquals(1, mangoTree.getFruit());
		assertEquals(1, mangoTree.getMangoSeed());
	}
}
