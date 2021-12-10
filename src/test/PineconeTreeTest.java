package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Cell;
import game.Player;
import game.base.Coordinate;
import object.PineconeTree;
import object.Weapon;
import object.base.ApplicationType;
import object.base.MaterialType;

public class PineconeTreeTest {
	private Player player;
	private PineconeTree pineconeTree;
	private Cell cell;
	
	@BeforeEach
	public void setUp() throws Exception {
		player = new Player("player");
		player.setPineconeSeed(1);
		cell = new Cell(new Coordinate(18, 0), false, false, true);
		pineconeTree = new PineconeTree(cell);
	}
	
	@Test
	public void testConstructor() {
		assertFalse(pineconeTree.isReadyToCut());
		assertFalse(pineconeTree.getPosition().getStatus());
		assertEquals(18, pineconeTree.getPosition().getCoCell().getX());
		assertEquals(0, pineconeTree.getPosition().getCoCell().getY());
		assertEquals(2, pineconeTree.getLeaf());
		assertEquals(2, pineconeTree.getWood());
		assertEquals(1, pineconeTree.getPineconeSeed());
	}
	
	@Test
	public void testBeRemoved() {
		pineconeTree.grow(player);
		
		pineconeTree.beRemoved(player);
		assertTrue(pineconeTree.isReadyToCut());
		assertEquals(0, player.getWood());
		assertEquals(0, player.getLeaf());
		assertEquals(0, player.getPineconeSeed());
		assertFalse(cell.getStatus());
		assertEquals(10, player.getHP());
		assertEquals(null, player.getCurrentAxe());
		
		player.setCurrentPosition(18, 1);
		Weapon weapon = new Weapon(MaterialType.WOOD, ApplicationType.AXE);
		player.setCurrentAxe(weapon);
		pineconeTree.beRemoved(player);
		assertTrue(pineconeTree.isReadyToCut());
		assertEquals(0, player.getWood());
		assertEquals(0, player.getLeaf());
		assertEquals(0, player.getPineconeSeed());
		assertFalse(cell.getStatus());
		assertEquals(10, player.getHP());
		assertEquals(5, player.getCurrentAxe().getLifetime());
		
		Weapon weapon2 = new Weapon(MaterialType.STONE, ApplicationType.AXE);
		player.setCurrentAxe(weapon2);
		pineconeTree.beRemoved(player);
		assertTrue(pineconeTree.isReadyToCut());
		assertEquals(0, player.getWood());
		assertEquals(0, player.getLeaf());
		assertEquals(0, player.getPineconeSeed());
		assertFalse(cell.getStatus());
		assertEquals(10, player.getHP());
		assertEquals(10, player.getCurrentAxe().getLifetime());
		
		Weapon weapon3 = new Weapon(MaterialType.METAL, ApplicationType.AXE);
		player.setCurrentAxe(weapon3);
		// Error: NULL Map.trees
//		pineconeTree.beRemoved(player);
//		assertFalse(pineconeTree.isReadyToCut());
//		assertEquals(2, player.getWood());
//		assertEquals(2, player.getLeaf());
//		assertEquals(1, player.getPineconeSeed());
//		assertTrue(cell.getStatus());
//		assertEquals(9, player.getHP());
//		assertEquals(19, player.getCurrentAxe().getLifetime());
		
//		pineconeTree.grow(player);
//		player.setCurrentPosition(0, 0);
//		pineconeTree.beRemoved(player);
//		assertTrue(pineconeTree.isReadyToCut());
//		assertEquals(2, player.getWood());
//		assertEquals(2, player.getLeaf());
//		assertEquals(1, player.getPineconeSeed());
//		assertFalse(cell.getStatus());
//		assertEquals(9, player.getHP());
//		assertEquals(9, player.getCurrentAxe().getLifetime());
	}
	
	@Test
	public void testGrow() {
		assertFalse(pineconeTree.isReadyToCut());
		pineconeTree.grow(player);
		assertFalse(cell.getStatus());
		assertEquals(0, player.getPineconeSeed());
		assertTrue(pineconeTree.isReadyToCut());
		assertEquals(2, pineconeTree.getLeaf());
		assertEquals(2, pineconeTree.getWood());
		assertEquals(1, pineconeTree.getPineconeSeed());
	}
}
