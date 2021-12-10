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
		assertEquals(player.getStone(), 20);
		assertEquals(player.getRope(), 10);
		
	}
	
	@Test
	public void testMission2() {
		assertEquals(player.getMetal(), 0);
		assertEquals(player.getScrape(), 0);
		assertEquals(player.getRope(), 0);
		player.setScrape(50); player.setRope(50);
		mission.getReward(1);
		assertEquals(player.getMetal(),1);
		assertEquals(player.getScrape(), 30);
		assertEquals(player.getRope(), 40);
		
	}

}
