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
			; // this.lifetime = ;
		else if (material == MaterialType.STONE)
			; // this.lifetime = ;
		else
			; // this.lifetime = ;
	}

}
