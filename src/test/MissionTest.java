package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

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
		ArrayList<Integer> requirement = new ArrayList<Integer>(Arrays.asList(30));
		assertEquals(requirement, mission.getMissionRequirement(0));

		player.setWood(20);
		assertFalse(mission.getReward(0, player));

		player.setWood(100);
		assertTrue(mission.getReward(0, player));
		assertEquals(70, player.getWood());
		assertEquals(20, player.getStone());
		assertEquals(10, player.getRope());
		ArrayList<Integer> requirement2 = new ArrayList<Integer>(Arrays.asList(40));
		assertEquals(requirement2, mission.getMissionRequirement(0));

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
		ArrayList<Integer> requirement = new ArrayList<Integer>(Arrays.asList(30, 20));
		assertEquals(requirement, mission.getMissionRequirement(1));

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
		ArrayList<Integer> requirement = new ArrayList<Integer>(Arrays.asList(22));
		assertEquals(requirement, mission.getMissionRequirement(2));

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
		ArrayList<Integer> requirement = new ArrayList<Integer>(Arrays.asList(36));
		assertEquals(requirement, mission.getMissionRequirement(3));

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
		ArrayList<Integer> requirement = new ArrayList<Integer>(Arrays.asList(10));
		assertEquals(requirement, mission.getMissionRequirement(4));

		assertFalse(mission.getReward(4, player));
	}

	@Test
	public void testMission5() {
		assertFalse(mission.getReward(5, player));

		player.setFruit(50);
		assertFalse(mission.getReward(5, player));

		player.setWood(50);
		assertFalse(mission.getReward(5, player));

		player.setLeaf(40);
		assertFalse(mission.getReward(5, player));

		player.setMetal(10);
		assertTrue(mission.getReward(5, player));
		assertEquals(40, player.getFruit());
		assertEquals(10, player.getWood());
		assertEquals(0, player.getLeaf());
		assertEquals(8, player.getMetal());
		assertEquals(2, player.getPlayerWeapon().size());
		assertEquals(MaterialType.METAL, player.getPlayerWeapon().get(1).getMaterial());
		assertEquals(ApplicationType.AXE, player.getPlayerWeapon().get(1).getApplication());
		ArrayList<Integer> requirement = new ArrayList<Integer>(Arrays.asList(10, 40, 40, 2));
		assertEquals(requirement, mission.getMissionRequirement(5));

		assertFalse(mission.getReward(5, player));
	}

	@Test
	public void testMission6() {
		assertFalse(mission.getReward(6, player));

		player.setFeather(20);
		assertFalse(mission.getReward(6, player));

		player.setBird(20);
		assertTrue(mission.getReward(6, player));
		assertEquals(5, player.getFeather());
		assertEquals(5, player.getBird());
		assertEquals(2, player.getPlayerWeapon().size());
		assertEquals(MaterialType.STONE, player.getPlayerWeapon().get(1).getMaterial());
		assertEquals(ApplicationType.SHOVEL, player.getPlayerWeapon().get(1).getApplication());
		assertEquals(11, player.getMaxHP());
		ArrayList<Integer> requirement = new ArrayList<Integer>(Arrays.asList(17, 17));
		assertEquals(requirement, mission.getMissionRequirement(6));

		assertFalse(mission.getReward(6, player));
	}

	@Test
	public void testMission7() {
		assertFalse(mission.getReward(7, player));

		player.setMetal(30);
		assertTrue(mission.getReward(7, player));
		assertEquals(5, player.getMetal());
		assertEquals(1, player.getTitanium());
		ArrayList<Integer> requirement = new ArrayList<Integer>(Arrays.asList(50));
		assertEquals(requirement, mission.getMissionRequirement(7));

		assertFalse(mission.getReward(7, player));
	}

	@Test
	public void testMission8() {
		assertFalse(mission.getReward(8, player));

		player.setPlastic(20);
		assertFalse(mission.getReward(8, player));

		player.setStone(35);
		assertTrue(mission.getReward(8, player));
		assertEquals(10, player.getPlastic());
		assertEquals(25, player.getStone());
		assertEquals(2, player.getCopper());
		ArrayList<Integer> requirement = new ArrayList<Integer>(Arrays.asList(15, 15));
		assertEquals(requirement, mission.getMissionRequirement(8));

		assertFalse(mission.getReward(8, player));
	}
}
