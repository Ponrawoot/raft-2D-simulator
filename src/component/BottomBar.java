package component;

import component.base.GuideButton;
import component.base.InventoryButton;
import component.base.MarketButton;
import component.base.MissionButton;
import component.base.ShipwreckButton;
import game.Player;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;

public class BottomBar extends FlowPane {
	private static InventoryButton inventoryButton;
	private static MissionButton missionButton;
	private static MarketButton marketButton;
	private static ShipwreckButton shipwreckButton;
	private static GuideButton guideButton;
	
	public BottomBar(Player player) {
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		inventoryButton = new InventoryButton(player);
		missionButton = new MissionButton(player);
		marketButton = new MarketButton(player);
		shipwreckButton = new ShipwreckButton(player);
		guideButton = new GuideButton();
		this.getChildren().addAll(inventoryButton,missionButton,marketButton,shipwreckButton,guideButton);
	}
}
