package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Cell;
import game.Player;
import game.base.Coordinate;
import object.Metal;
import object.Weapon;
import object.base.ApplicationType;
import object.base.MaterialType;

public class MetalTest {
	private Metal metal;
	private Player player;
	private Cell cell;
	
	@BeforeEach
	public void setUp() throws Exception {
		player = new Player("player");
		cell = new Cell(new Coordinate(2, 0), false, false, true);
		metal = new Metal(cell);
	}
	
	@Test
	public void testConstructor() {
		assertFalse(metal.getPosition().getStatus());
		assertTrue(metal.isPresent());
	}
	
	@Test
	public void testBeRemoved() {
		metal.beRemoved(player);
		assertTrue(metal.isPresent());
		assertEquals(0, player.getMetal());
		assertEquals(10, player.getHP());
		assertFalse(cell.getStatus());
		
		player.setCurrentShovel(new Weapon(MaterialType.WOOD, ApplicationType.SHOVEL));
		metal.beRemoved(player);
		assertTrue(metal.isPresent());
		assertEquals(0, player.getMetal());
		assertEquals(10, player.getHP());
		assertFalse(cell.getStatus());
		
		player.setCurrentShovel(new Weapon(MaterialType.STONE, ApplicationType.SHOVEL));
		metal.beRemoved(player);
		assertTrue(metal.isPresent());
		assertEquals(0, player.getMetal());
		assertEquals(10, player.getHP());
		assertFalse(cell.getStatus());
		
		player.setCurrentShovel(new Weapon(MaterialType.METAL, ApplicationType.SHOVEL));
		metal.beRemoved(player);
		assertTrue(metal.isPresent());
		assertEquals(0, player.getMetal());
		assertEquals(10, player.getHP());
		assertFalse(cell.getStatus());
		
		player.setCurrentPosition(2, 1);
		metal.beRemoved(player);
		assertFalse(metal.isPresent());
		assertEquals(1, player.getMetal());
		assertEquals(9, player.getHP());
		assertTrue(cell.getStatus());
		assertEquals(19, player.getCurrentShovel().getLifetime());
	}
	
	@Test
	public void testRefresh() {
		player.setCurrentShovel(new Weapon(MaterialType.METAL, ApplicationType.SHOVEL));
		player.setCurrentPosition(2, 1);
		metal.beRemoved(player);
		metal.refresh();
		assertTrue(metal.isPresent());
		assertFalse(metal.getPosition().getStatus());
	}
	
}
