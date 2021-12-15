package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Player;
import object.Eagle;
import object.Weapon;
import object.base.ApplicationType;
import object.base.MaterialType;

public class EagleTest {

	private Player player1, player2;
	private Eagle eagle;

	@BeforeEach
	public void setUp() throws Exception {
		player1 = new Player("player1");
		Weapon weapon = new Weapon(MaterialType.WOOD, ApplicationType.SPEAR);
		player1.setCurrentSpear(weapon);
		player1.setCurrentPosition(4, 2);

		player2 = new Player("player2");
		Weapon weapon2 = new Weapon(MaterialType.METAL, ApplicationType.SPEAR);
		player2.setCurrentSpear(weapon2);
		player2.setCurrentPosition(0, 0);

		eagle = new Eagle();
	}

	@Test
	public void testConstructor() {
		assertEquals(4, eagle.getPosition().getCoCell().getX());
		assertEquals(1, eagle.getPosition().getCoCell().getY());
//		assertTrue(eagle.isMove());
		assertTrue(eagle.isAlive());
		assertTrue(eagle.getPosition().getStatus());
	}

	@Test
	public void testMoveToPlayer() {
		// TODO
	}

	@Test
	public void testHitPlayer() {
		eagle.hitPlayer(player1);
		assertEquals(10, player1.getHP());
		assertEquals(4, player1.getCurrentPosition().getCoCell().getX());
		assertEquals(2, player1.getCurrentPosition().getCoCell().getY());

		player1.setCurrentPosition(4, 1);
		eagle.hitPlayer(player1);
		assertEquals(1, player1.getHP());
		assertEquals(9, player1.getCurrentPosition().getCoCell().getX());
		assertEquals(12, player1.getCurrentPosition().getCoCell().getY());
	}

	@Test
	public void testKill() {
		eagle.killed(player1);
		assertTrue(eagle.isAlive());
		assertEquals(0, player1.getBird());
		assertEquals(0, player1.getFeather());
		assertEquals(0, player1.getEagleHead());
		assertEquals(10, player1.getHP());
		assertEquals(5, player1.getCurrentSpear().getLifetime());

		Weapon stoneSpear = new Weapon(MaterialType.STONE, ApplicationType.SPEAR);
		eagle.killed(player1);
		player1.setCurrentSpear(stoneSpear);
		assertTrue(eagle.isAlive());
		assertEquals(0, player1.getBird());
		assertEquals(0, player1.getFeather());
		assertEquals(0, player1.getEagleHead());
		assertEquals(10, player1.getHP());
		assertEquals(10, player1.getCurrentSpear().getLifetime());

		eagle.killed(player2);
		assertTrue(eagle.isAlive());
		assertEquals(0, player2.getBird());
		assertEquals(0, player2.getFeather());
		assertEquals(0, player2.getEagleHead());
		assertEquals(10, player2.getHP());
		assertEquals(20, player2.getCurrentSpear().getLifetime());

		eagle.refresh();
		player2.setCurrentPosition(3, 1);
		eagle.killed(player2);
//		assertFalse(eagle.isAlive());
		assertEquals(2, player2.getBird());
		assertEquals(3, player2.getFeather());
		assertEquals(1, player2.getEagleHead());
		assertEquals(9, player2.getHP());
		assertEquals(19, player2.getCurrentSpear().getLifetime());
	}

	@Test
	public void testRefresh() {
		player2.setCurrentPosition(3, 1);
		eagle.killed(player2);
		eagle.refresh();
		assertEquals(4, eagle.getPosition().getCoCell().getX());
		assertEquals(1, eagle.getPosition().getCoCell().getY());
//		assertTrue(eagle.isMove());
		assertTrue(eagle.isAlive());
		assertTrue(eagle.getPosition().getStatus());
	}

	public void testFeed() {
//		player1.feed(eagle);
//		player1.setFish(5);
//		assertFalse(eagle.isMove());
//		assertTrue(eagle.isAlive());
//		assertEquals(2, player1.getFish());
//		
//		eagle.setMove(true);
//		player1.feed(eagle);
//		assertTrue(eagle.isMove());
//		assertTrue(eagle.isAlive());
//		assertEquals(2, player1.getFish());
	}
}
