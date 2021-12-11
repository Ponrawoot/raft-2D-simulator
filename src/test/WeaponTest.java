package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import object.Weapon;
import object.base.ApplicationType;
import object.base.MaterialType;

public class WeaponTest {
	private ArrayList<Weapon> weapons;

	@BeforeEach
	public void setUp() throws Exception {
		weapons = new ArrayList<Weapon>();

		ArrayList<MaterialType> m = new ArrayList<MaterialType>();
		m.add(MaterialType.WOOD);
		m.add(MaterialType.STONE);
		m.add(MaterialType.METAL);
		ArrayList<ApplicationType> a = new ArrayList<ApplicationType>();
		a.add(ApplicationType.AXE);
		a.add(ApplicationType.SHOVEL);
		a.add(ApplicationType.SPEAR);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				weapons.add(new Weapon(m.get(i), a.get(j)));
			}
		}
	}

	@Test
	public void testConstructor() {
		for (Weapon w : weapons) {
			if (w.getMaterial() == MaterialType.WOOD)
				assertEquals(5, w.getLifetime());
			else if (w.getMaterial() == MaterialType.STONE)
				assertEquals(10, w.getLifetime());
			else
				assertEquals(20, w.getLifetime());
		}
	}
}
