package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.Mission;
import game.Player;

public class MissionTest {
	private Player player;
	
	private Mission mission; 
	
	@BeforeEach
	public void setUpBeforeEachTest()  {
		player = new Player("Survival boy");
		mission = new Mission();
	}
	
	@Test
	public void testMission1() {
		player.setWood(20);
		assertEquals(player.getWood(), 20);
		assertEquals(player.getStone(), 0);
		assertEquals(player.getRope(), 0);
		mission.getReward(0, player);
		assertEquals(player.getWood(), 0);
		assertEquals(player.getStone(), 10);
		assertEquals(player.getRope(), 5);
		player.setWood(20);
		mission.getReward(0, player);
		assertTrue(player.getWood()==20);
		player.setWood(100);
		mission.getReward(0, player);
		assertEquals(player.getWood(), 70);
		
	}

}
