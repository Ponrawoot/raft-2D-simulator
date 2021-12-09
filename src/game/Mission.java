package game;

import java.util.ArrayList;
import java.util.Arrays;

import object.Weapon;
import object.base.ApplicationType;
import object.base.MaterialType;

public class Mission {

	private ArrayList<ArrayList<Integer>> allMission;

	public Mission() {
		allMission = new ArrayList<ArrayList<Integer>>(9);
		allMission.get(0).addAll(Arrays.asList(20)); // wood -> stone, rope
		allMission.get(1).addAll(Arrays.asList(20, 10)); // scrape, rope -> metal
		allMission.get(2).addAll(Arrays.asList(10)); // fish -> stone spear
		allMission.get(3).addAll(Arrays.asList(20)); // bird -> metal spear
		allMission.get(4).addAll(Arrays.asList(8)); // fruit -> stone axe, +1 max HP
		allMission.get(5).addAll(Arrays.asList(10, 40, 40, 2)); // fruit, wood, leaf, metal -> metal axe
		allMission.get(6).addAll(Arrays.asList(15, 15)); // feather, bird -> stone shovel, +1 max HP
		allMission.get(7).addAll(Arrays.asList(25)); // metal -> titanium
		allMission.get(8).addAll(Arrays.asList(10, 10)); // plastic, stone -> copper
	}

	public boolean getReward(int i) {
		ArrayList<Integer> selectedMission = allMission.get(i);
		switch (i) {
		case 0:
			if (Player.getWood() >= selectedMission.get(0)) {
				Player.setWood(Player.getWood() - selectedMission.get(0));
				Player.setStone(Player.getStone() + 10);
				Player.setRope(Player.getRope() + 5);
				this.addRequirement(0, 10);
			} else
				return false;
		case 1:
			if (Player.getScrape() >= selectedMission.get(0) && Player.getRope() >= selectedMission.get(1)) {
				Player.setScrape(Player.getScrape() - selectedMission.get(0));
				Player.setRope(Player.getRope() - selectedMission.get(1));
				Player.setMetal(Player.getMetal() + 1);
				this.addRequirement(1, 10);
			} else
				return false;
		case 2:
			if (Player.getFish() >= selectedMission.get(0)) {
				Player.setFish(Player.getFish() - selectedMission.get(0));
				Player.addWeapon(new Weapon(MaterialType.STONE, ApplicationType.SPEAR));
				this.addRequirement(2, 12);
			} else
				return false;
		case 3:
			if (Player.getBird() >= selectedMission.get(0)) {
				Player.setBird(Player.getBird() - selectedMission.get(0));
				Player.addWeapon(new Weapon(MaterialType.METAL, ApplicationType.SPEAR));
				this.addRequirement(3, 16);
			} else
				return false;
		case 4:
			if (Player.getFruit() >= selectedMission.get(0)) {
				Player.setFruit(Player.getFruit() - selectedMission.get(0));
				Player.addWeapon(new Weapon(MaterialType.STONE, ApplicationType.AXE));
				Player.setMaxHP(Player.getMaxHP() + 1);
				this.addRequirement(4, 2);
			} else
				return false;
		case 5:
			if (Player.getFruit() >= selectedMission.get(0) && Player.getWood() >= selectedMission.get(1)
					&& Player.getLeaf() >= selectedMission.get(2) && Player.getMetal() >= selectedMission.get(3)) {
				Player.setFruit(Player.getFruit() - selectedMission.get(0));
				Player.setWood(Player.getWood() - selectedMission.get(1));
				Player.setLeaf(Player.getLeaf() - selectedMission.get(2));
				Player.setMetal(Player.getMetal() - selectedMission.get(3));
				Player.addWeapon(new Weapon(MaterialType.METAL, ApplicationType.AXE));

			} else
				return false;
		case 6:
			if (Player.getFeather() >= selectedMission.get(0) && Player.getBird() >= selectedMission.get(1)) {
				Player.setFeather(Player.getFeather() - selectedMission.get(0));
				Player.setBird(Player.getBird() - selectedMission.get(1));
				Player.addWeapon(new Weapon(MaterialType.STONE, ApplicationType.SHOVEL));
				Player.setMaxHP(Player.getMaxHP() + 1);
				this.addRequirement(6, 2);
			} else
				return false;
		case 7:
			if (Player.getMetal() >= selectedMission.get(0)) {
				Player.setMetal(Player.getMetal() - selectedMission.get(0));
				Player.setTitanium(Player.getTitanium() + 1);
				this.addRequirement(7, 25);
			} else
				return false;
		default:
			if (Player.getPlastic() >= selectedMission.get(0) && Player.getStone() >= selectedMission.get(1)) {
				Player.setPlastic(Player.getPlastic() - selectedMission.get(0));
				Player.setStone(Player.getStone() - selectedMission.get(1));
				Player.setCopper(Player.getCopper() + 2);
				this.addRequirement(8, 5);
			} else
				return false;
		}
		
		return true;
	}

	private void addRequirement(int missionNumber, int amount) {
		for (int i = 0; i < allMission.get(missionNumber).size(); i++) {
			int x = allMission.get(missionNumber).get(i);
			allMission.get(missionNumber).set(i, x + amount);
		}
	}

}
