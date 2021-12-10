package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.Mission;
import game.Player;
import object.base.ApplicationType;
import object.base.MaterialType;

public class MissionTest {
	private Player player;
	private Mission mission;

	@BeforeEach
	public void setUpBeforeEachTest() {
		player = new Player("Survival boy");
		mission = new Mission();
	}

	@Test
	public void testMission0() {
		assertFalse(mission.getReward(0, player));
		
		player.setWood(20);
		assertTrue(mission.getReward(0, player));
		assertEquals(0, player.getWood());
		assertEquals(10, player.getStone());
		assertEquals(5, player.getRope());
		assertEquals(30, mission.getMissionRequirement(0).get(0));
		
		player.setWood(20);
		assertFalse(mission.getReward(0, player));
		
		player.setWood(100);
		assertTrue(mission.getReward(0, player));
		assertEquals(70, player.getWood());
		assertEquals(20, player.getStone());
		assertEquals(10, player.getRope());
		assertEquals(40, mission.getMissionRequirement(0).get(0));

	}

	@Test
	public void testMission1() {
		assertFalse(mission.getReward(1, player));
		
		player.setScrape(50);
		player.setRope(10);
		assertTrue(mission.getReward(1, player));
		assertEquals(1, player.getMetal());
		assertEquals(30, player.getScrape());
		assertEquals(0, player.getRope());
		assertEquals(30, mission.getMissionRequirement(1).get(0));
		assertEquals(20, mission.getMissionRequirement(1).get(1));
		
		assertFalse(mission.getReward(1, player));
		
		player.setScrape(0);
		player.setRope(20);
		assertFalse(mission.getReward(1, player));
	}

	@Test
	public void testMission2() {
		assertFalse(mission.getReward(2, player));
		
		player.setFish(20);
		assertTrue(mission.getReward(2, player));
		assertEquals(10, player.getFish());
		assertEquals(2, player.getPlayerWeapon().size());
		assertEquals(MaterialType.STONE, player.getPlayerWeapon().get(1).getMaterial());
		assertEquals(ApplicationType.SPEAR, player.getPlayerWeapon().get(1).getApplication());
		assertEquals(22, mission.getMissionRequirement(2).get(0));
		
		assertFalse(mission.getReward(2, player));
	}
	
	@Test
	public void testMission3() {
		assertFalse(mission.getReward(3, player));
		
		player.setBird(30);
		assertTrue(mission.getReward(3, player));
		assertEquals(10, player.getBird());
		assertEquals(2, player.getPlayerWeapon().size());
		assertEquals(MaterialType.METAL, player.getPlayerWeapon().get(1).getMaterial());
		assertEquals(ApplicationType.SPEAR, player.getPlayerWeapon().get(1).getApplication());
		assertEquals(36, mission.getMissionRequirement(3).get(0));
		
		assertFalse(mission.getReward(3, player));
	}
	
	@Test
	public void testMission4() {
		assertFalse(mission.getReward(4, player));
		
		player.setFruit(10);
		assertTrue(mission.getReward(4, player));
		assertEquals(2, player.getFruit());
		assertEquals(2, player.getPlayerWeapon().size());
		assertEquals(MaterialType.STONE, player.getPlayerWeapon().get(1).getMaterial());
		assertEquals(ApplicationType.AXE, player.getPlayerWeapon().get(1).getApplication());
		assertEquals(11, player.getMaxHP());
		assertEquals(10, mission.getMissionRequirement(4).get(0));
		
		assertFalse(mission.getReward(4, player));
	}
}
