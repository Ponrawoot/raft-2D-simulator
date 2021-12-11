package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Market;
import game.Player;

public class MarketTest {
	private Market market;
	private Player player;

	@BeforeEach
	public void setUp() throws Exception {
		market = new Market();
		player = new Player("player");
	}

	@Test
	public void testTradeCanvas() {
		market.trade("Canvas", player);
		assertFalse(player.hasCanvas());

		player.setMetal(50);
		market.trade("Canvas", player);
		assertFalse(player.hasCanvas());

		player.setScrape(50);
		market.trade("Canvas", player);
		assertFalse(player.hasCanvas());

		player.setPlastic(50);
		market.trade("Canvas", player);
		assertTrue(player.hasCanvas());
		assertEquals(40, player.getMetal());
		assertEquals(30, player.getScrape());
		assertEquals(30, player.getPlastic());

		market.trade("Canvas", player);
		assertTrue(player.hasCanvas());
		assertEquals(40, player.getMetal());
		assertEquals(30, player.getScrape());
		assertEquals(30, player.getPlastic());
	}

	@Test
	public void testTradeSteering() {
		market.trade("Steering", player);
		assertFalse(player.hasSteering());

		player.setMetal(50);
		market.trade("Steering", player);
		assertFalse(player.hasSteering());

		player.setScrape(60);
		market.trade("Steering", player);
		assertFalse(player.hasSteering());

		player.setPlastic(60);
		market.trade("Steering", player);
		assertTrue(player.hasSteering());
		assertEquals(35, player.getMetal());
		assertEquals(30, player.getScrape());
		assertEquals(30, player.getPlastic());

		market.trade("Steering", player);
		assertTrue(player.hasSteering());
		assertEquals(35, player.getMetal());
		assertEquals(30, player.getScrape());
		assertEquals(30, player.getPlastic());
	}

	@Test
	public void testTradePetrol() {
		market.trade("Petrol", player);
		assertFalse(player.hasPetrol());

		player.setBird(100);
		market.trade("Petrol", player);
		assertFalse(player.hasPetrol());

		player.setFish(50);
		market.trade("Petrol", player);
		assertTrue(player.hasPetrol());
		assertEquals(60, player.getBird());
		assertEquals(30, player.getFish());

		market.trade("Petrol", player);
		assertTrue(player.hasPetrol());
		assertEquals(60, player.getBird());
		assertEquals(30, player.getFish());
	}

	@Test
	public void testTradeEngine() {
		market.trade("Engine", player);
		assertFalse(player.hasEngine());

		player.setEagleHead(10);
		market.trade("Engine", player);
		assertTrue(player.hasEngine());
		assertEquals(5, player.getEagleHead());

		market.trade("Engine", player);
		assertTrue(player.hasEngine());
		assertEquals(5, player.getEagleHead());
	}

}
