package component.base;

import component.TopBar;
import game.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import object.Weapon;
import object.base.ApplicationType;

public class InventoryPane extends VBox {
	private GridPane objectPane;
	private ObservableList<InventoryCell> objects;
	private GridPane weaponPane;
	private ObservableList<InventoryCell> weapons;
	private HBox eatButtons;
	private Button setWeapon;
	private Weapon selectedWeapon;

	public InventoryPane(Player player) {
		initObjects(player);
		initWeapons(player);
		initEatButtons(player);
		initSetWeapon(player);

		setSpacing(10);
		setPadding(new Insets(5));
		getChildren().addAll(new Text("Player objects"), objectPane, eatButtons, new Text("Player weapons"), weaponPane,
				setWeapon);
	}

	private void initObjects(Player player) {
		objectPane = new GridPane();
		objectPane.setHgap(5);
		objectPane.setVgap(5);
		objects = FXCollections.observableArrayList();

		InventoryCell inv0 = new InventoryCell("Wood", null, player.getWood());
		InventoryCell inv1 = new InventoryCell("Leaf", null, player.getLeaf());
		InventoryCell inv2 = new InventoryCell("Mango seed", null, player.getMangoSeed());
		InventoryCell inv3 = new InventoryCell("Pinecone seed", null, player.getPineconeSeed());
		InventoryCell inv4 = new InventoryCell("Fruit", null, player.getFruit());
		InventoryCell inv5 = new InventoryCell("Plastic", null, player.getPlastic());
		InventoryCell inv6 = new InventoryCell("Feather", null, player.getFeather());
		InventoryCell inv7 = new InventoryCell("Titanium", null, player.getTitanium());
		InventoryCell inv8 = new InventoryCell("Copper", null, player.getCopper());
		InventoryCell inv9 = new InventoryCell("Metal", null, player.getMetal());
		InventoryCell inv10 = new InventoryCell("Stone", null, player.getStone());
		InventoryCell inv11 = new InventoryCell("Scrap", null, player.getScrape());
		InventoryCell inv12 = new InventoryCell("Hinge", null, player.getHinge());
		InventoryCell inv13 = new InventoryCell("Nail", null, player.getNail());
		InventoryCell inv14 = new InventoryCell("Rope", null, player.getRope());
		InventoryCell inv15 = new InventoryCell("Circuit", null, player.getCircuit());
		InventoryCell inv16 = new InventoryCell("Fish", null, player.getFish());
		InventoryCell inv17 = new InventoryCell("Bird", null, player.getBird());
		InventoryCell inv18 = new InventoryCell("Eagle head", null, player.getEagleHead());
		objects.addAll(inv0, inv1, inv2, inv3, inv4, inv5, inv6, inv7, inv8, inv9, inv10, inv11, inv12, inv13, inv14,
				inv15, inv16, inv17, inv18);

		if (player.hasRaft())
			objects.add(new InventoryCell("Raft", null, 0));
		if (player.hasReceiver())
			objects.add(new InventoryCell("Reiceiver", null, 0));
		if (player.hasAnthena())
			objects.add(new InventoryCell("Antenna", null, 0));
		if (player.hasCanvas())
			objects.add(new InventoryCell("Canvas", null, 0));
		if (player.hasSteering())
			objects.add(new InventoryCell("Steering", null, 0));
		if (player.hasPetrol())
			objects.add(new InventoryCell("Petrol", null, 0));
		if (player.hasEngine())
			objects.add(new InventoryCell("Engine", null, 0));

		int index = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				if (index >= objects.size())
					break;
				objectPane.add(objects.get(index), j, i);
				index++;
			}
		}
	}

	private void initWeapons(Player player) {
		weaponPane = new GridPane();
		weaponPane.setHgap(5);
		weaponPane.setVgap(5);
		weapons = FXCollections.observableArrayList();

		int i = 0;
		int j = 0;
		for (Weapon w : player.getPlayerWeapon()) {
			InventoryCell invw = new InventoryCell(w.toString(), w, 1);
			invw.setOnMouseClicked(event -> {
				selectedWeapon = (Weapon) invw.getObject();
				resetHighlight();
				invw.highlight();
			});
			weapons.add(invw);
			if (j == 7) {
				j = 0;
				i++;
			}
			weaponPane.add(invw, j, i);
			j++;
		}

	}

	private void resetHighlight() {
		for (InventoryCell inv : weapons) {
			inv.unhighlight();
		}
	}

	private void initEatButtons(Player player) {
		eatButtons = new HBox();
		eatButtons.setSpacing(10);

		Button fruit = new Button("Eat fruit");
		Button fish = new Button("Eat fish");
		Button bird = new Button("Eat bird");
		fruit.setOnAction(event -> {
			player.consume("Fruit");
			update(player);
			if (player.getFruit() == 0)
				fruit.setDisable(true);
		});
		fish.setOnAction(event -> {
			player.consume("Fish");
			update(player);
			if (player.getFish() == 0)
				fish.setDisable(true);
		});
		bird.setOnAction(event -> {
			player.consume("Bird");
			update(player);
			if (player.getBird() == 0)
				bird.setDisable(true);
		});

		if (player.getFruit() == 0)
			fruit.setDisable(true);
		if (player.getFish() == 0)
			fish.setDisable(true);
		if (player.getBird() == 0)
			bird.setDisable(true);

		eatButtons.getChildren().addAll(fruit, fish, bird);
	}

	private void initSetWeapon(Player player) {
		setWeapon = new Button("Set as current weapon");
		setWeapon.setOnAction(event -> {
			if (selectedWeapon.getApplication() == ApplicationType.AXE) {
				player.setCurrentAxe(selectedWeapon);
			} else if (selectedWeapon.getApplication() == ApplicationType.SHOVEL) {
				player.setCurrentShovel(selectedWeapon);
			} else {
				player.setCurrentSpear(selectedWeapon);
			}
			TopBar.getWeaponPane().update(player);
		});
	}

	public void update(Player player) {
		objects = null;
		initObjects(player);
		getChildren().set(1, objectPane);

		weapons = null;
		initWeapons(player);
		getChildren().set(4, weaponPane);
	}

}
