package object;

import object.base.ApplicationType;
import object.base.MaterialType;

public class Weapon {
	private MaterialType material;
	private ApplicationType application;
	private int lifetime;

	public Weapon(MaterialType material, ApplicationType application) {
		this.material = material;
		this.application = application;
		setLifetime(material);
	}

	public int getLifetime() {
		return lifetime;
	}

	public MaterialType getMaterial() {
		return material;
	}

	public ApplicationType getApplication() {
		return application;
	}

	private void setLifetime(MaterialType material) {
		if (material == MaterialType.WOOD)
			this.lifetime = 5;
		else if (material == MaterialType.STONE)
			this.lifetime = 10;
		else
			this.lifetime = 20;
	}

	public void setLifetime(int lifetime) {
		this.lifetime = lifetime;
	}
	
}
