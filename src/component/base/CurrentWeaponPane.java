package component.base;

import game.Player;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import object.Weapon;
import object.base.ApplicationType;

public class CurrentWeaponPane extends GridPane {
	private Pane currentAxe;
	private Pane currentShovel;
	private Pane currentSpear;

	public CurrentWeaponPane(Player player) {
		super();
		initCurrentAxe(player);
		initCurrentShovel(player);
		initCurrentSpear(player);

		setHgap(5);
		setPadding(new Insets(10));

		add(new Text("axe"), 0, 0);
		add(new Text("shovel"), 1, 0);
		add(new Text("spear"), 2, 0);
		add(currentAxe, 0, 1);
		add(currentShovel, 1, 1);
		add(currentSpear, 2, 1);
	}

	private void setImage(Weapon weapon) {
		if (weapon == null) {
			return;
		}
		String image_path = ClassLoader.getSystemResource("inventory/" + weapon.toString() + ".png").toString();
		Image image = new Image(image_path);
		BackgroundFill bgFill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = { bgFill };
		BackgroundSize bgSize = new BackgroundSize(40, 40, false, false, false, false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = { bgImg };

		if (weapon.getApplication() == ApplicationType.AXE) {
			currentAxe.setBackground(new Background(bgFillA, bgImgA));
		} else if (weapon.getApplication() == ApplicationType.SHOVEL) {
			currentShovel.setBackground(new Background(bgFillA, bgImgA));
		} else {
			currentSpear.setBackground(new Background(bgFillA, bgImgA));
		}
	}

	private void initCurrentAxe(Player player) {
		Weapon axe = player.getCurrentAxe();
		currentAxe = new Pane();
		currentAxe.setPrefHeight(40);
		currentAxe.setPrefWidth(40);
		currentAxe.setPadding(new Insets(8));
		currentAxe.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setImage(axe);
	}

	private void initCurrentShovel(Player player) {
		Weapon shovel = player.getCurrentShovel();
		currentShovel = new Pane();
		currentShovel.setPrefHeight(40);
		currentShovel.setPrefWidth(40);
		currentShovel.setPadding(new Insets(8));
		currentShovel.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setImage(shovel);
	}

	private void initCurrentSpear(Player player) {
		Weapon spear = player.getCurrentSpear();
		currentSpear = new Pane();
		currentSpear.setPrefHeight(40);
		currentSpear.setPrefWidth(40);
		currentSpear.setPadding(new Insets(8));
		currentSpear.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setImage(spear);
	}

	public void update(Player player) {
		currentAxe = null;
		initCurrentAxe(player);

		currentShovel = null;
		initCurrentShovel(player);

		currentSpear = null;
		initCurrentSpear(player);

		getChildren().clear();
		add(new Text("axe"), 0, 0);
		add(new Text("shovel"), 1, 0);
		add(new Text("spear"), 2, 0);
		add(currentAxe, 0, 1);
		add(currentShovel, 1, 1);
		add(currentSpear, 2, 1);
	}
}
