package game;

import java.util.ArrayList;
import java.util.Arrays;

import object.Weapon;
import object.base.ApplicationType;
import object.base.MaterialType;

public class Mission {

	private ArrayList<ArrayList<Integer>> allMission;

	public Mission() {
		allMission = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 9; i++) {
			allMission.add(new ArrayList<Integer>());
		}
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

	public boolean getReward(int i, Player player) {
		ArrayList<Integer> selectedMission = allMission.get(i);
		switch (i) {
		case 0:
			if (player.getWood() >= selectedMission.get(0)) {
				player.setWood(player.getWood() - selectedMission.get(0));
				player.setStone(player.getStone() + 10);
				player.setRope(player.getRope() + 5);
				this.addRequirement(0, 10);
				break;
			} else
				return false;
		case 1:
			if (player.getScrape() >= selectedMission.get(0) && player.getRope() >= selectedMission.get(1)) {
				player.setScrape(player.getScrape() - selectedMission.get(0));
				player.setRope(player.getRope() - selectedMission.get(1));
				player.setMetal(player.getMetal() + 1);
				this.addRequirement(1, 10);
				break;
			} else
				return false;
		case 2:
			if (player.getFish() >= selectedMission.get(0)) {
				player.setFish(player.getFish() - selectedMission.get(0));
				player.addWeapon(new Weapon(MaterialType.STONE, ApplicationType.SPEAR));
				this.addRequirement(2, 12);
				break;
			} else
				return false;
		case 3:
			if (player.getBird() >= selectedMission.get(0)) {
				player.setBird(player.getBird() - selectedMission.get(0));
				player.addWeapon(new Weapon(MaterialType.METAL, ApplicationType.SPEAR));
				this.addRequirement(3, 16);
				break;
			} else
				return false;
		case 4:
			if (player.getFruit() >= selectedMission.get(0)) {
				player.setFruit(player.getFruit() - selectedMission.get(0));
				player.addWeapon(new Weapon(MaterialType.STONE, ApplicationType.AXE));
				player.setMaxHP(player.getMaxHP() + 1);
				this.addRequirement(4, 2);
				break;
			} else
				return false;
		case 5:
			if (player.getFruit() >= selectedMission.get(0) && player.getWood() >= selectedMission.get(1)
					&& player.getLeaf() >= selectedMission.get(2) && player.getMetal() >= selectedMission.get(3)) {
				player.setFruit(player.getFruit() - selectedMission.get(0));
				player.setWood(player.getWood() - selectedMission.get(1));
				player.setLeaf(player.getLeaf() - selectedMission.get(2));
				player.setMetal(player.getMetal() - selectedMission.get(3));
				player.addWeapon(new Weapon(MaterialType.METAL, ApplicationType.AXE));
				break;
			} else
				return false;
		case 6:
			if (player.getFeather() >= selectedMission.get(0) && player.getBird() >= selectedMission.get(1)) {
				player.setFeather(player.getFeather() - selectedMission.get(0));
				player.setBird(player.getBird() - selectedMission.get(1));
				player.addWeapon(new Weapon(MaterialType.STONE, ApplicationType.SHOVEL));
				player.setMaxHP(player.getMaxHP() + 1);
				this.addRequirement(6, 2);
				break;
			} else
				return false;
		case 7:
			if (player.getMetal() >= selectedMission.get(0)) {
				player.setMetal(player.getMetal() - selectedMission.get(0));
				player.setTitanium(player.getTitanium() + 1);
				this.addRequirement(7, 25);
				break;
			} else
				return false;
		default:
			if (player.getPlastic() >= selectedMission.get(0) && player.getStone() >= selectedMission.get(1)) {
				player.setPlastic(player.getPlastic() - selectedMission.get(0));
				player.setStone(player.getStone() - selectedMission.get(1));
				player.setCopper(player.getCopper() + 2);
				this.addRequirement(8, 5);
				break;
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

	public ArrayList<Integer> getMissionRequirement(int i) {
		return allMission.get(i);
	}

	public ArrayList<ArrayList<Integer>> getAllMission() {
		return allMission;
	}
}
