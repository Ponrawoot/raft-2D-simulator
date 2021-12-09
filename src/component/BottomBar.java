package component;

import component.base.GuideButton;
import component.base.InventoryButton;
import component.base.MarketButton;
import component.base.MissionButton;
import javafx.scene.layout.FlowPane;

public class BottomBar extends FlowPane {
	private static InventoryButton inventoryButton;
	private static MissionButton missionButton;
	private static MarketButton marketButton;
	private static GuideButton guideButton;
	
	public BottomBar() {
		inventoryButton = new InventoryButton();
		missionButton = new MissionButton();
		marketButton = new MarketButton();
		guideButton = new GuideButton();
		this.getChildren().addAll(inventoryButton,missionButton,marketButton,guideButton);
	}
}
