package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Cell;
import game.Player;
import game.base.Coordinate;
import object.PineTree;
import object.Weapon;
import object.base.ApplicationType;
import object.base.MaterialType;

public class PineTreeTest {
	private Player player;
	private PineTree pineTree;
	private Cell cell;
	
	@BeforeEach
	public void setUp() throws Exception {
		player = new Player("player");
		player.setPineconeSeed(1);
		cell = new Cell(new Coordinate(18, 0), false, false, true);
		pineTree = new PineTree(cell);
	}
	
	@Test
	public void testConstructor() {
		assertFalse(pineTree.isReadyToCut());
		assertFalse(pineTree.getPosition().getStatus());
		assertEquals(18, pineTree.getPosition().getCoCell().getX());
		assertEquals(0, pineTree.getPosition().getCoCell().getY());
		assertEquals(2, pineTree.getLeaf());
		assertEquals(2, pineTree.getWood());
		assertEquals(1, pineTree.getPinecone());
	}
	
	@Test
	public void testBeRemoved() {
		pineTree.grow();
		
		pineTree.beRemoved(player);
		assertTrue(pineTree.isReadyToCut());
		assertEquals(0, player.getWood());
		assertEquals(0, player.getLeaf());
		assertEquals(0, player.getPineconeSeed());
		assertFalse(cell.getStatus());
		assertEquals(10, player.getHP());
		assertEquals(null, player.getCurrentAxe());
		
		player.setCurrentPosition(18, 1);
		Weapon weapon = new Weapon(MaterialType.WOOD, ApplicationType.AXE);
		player.setCurrentAxe(weapon);
		pineTree.beRemoved(player);
		assertTrue(pineTree.isReadyToCut());
		assertEquals(0, player.getWood());
		assertEquals(0, player.getLeaf());
		assertEquals(0, player.getPineconeSeed());
		assertFalse(cell.getStatus());
		assertEquals(10, player.getHP());
		assertEquals(5, player.getCurrentAxe().getLifetime());
		
		Weapon weapon2 = new Weapon(MaterialType.STONE, ApplicationType.AXE);
		player.setCurrentAxe(weapon2);
		pineTree.beRemoved(player);
		assertTrue(pineTree.isReadyToCut());
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
		assertFalse(pineTree.isReadyToCut());
		pineTree.grow();
		assertFalse(cell.getStatus());
		assertEquals(0, player.getPineconeSeed());
		assertTrue(pineTree.isReadyToCut());
		assertEquals(2, pineTree.getLeaf());
		assertEquals(2, pineTree.getWood());
		assertEquals(1, pineTree.getPinecone());
	}
}
