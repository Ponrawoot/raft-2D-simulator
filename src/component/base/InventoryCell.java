package component.base;

import javafx.geometry.Insets;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import object.Weapon;

public class InventoryCell extends Pane {
	private String name;
	private Object object;
	private int amount;

	public InventoryCell(String name, Object object, int amount) {
		super();
		this.name = name;
		this.object = object;
		setAmount(amount);

		this.setPrefHeight(40);
		this.setPrefWidth(40);
		this.setMinHeight(40);
		this.setMinWidth(40);
		this.setPadding(new Insets(8));
		this.setTooltip();
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		String url;
		switch (name) {
		case "Wood":
			url = "inventory/Wood.png";
			this.setImage(url);
			break;
		case "Leaf":
			url = "inventory/Leaf.png";
			this.setImage(url);
			break;
		case "Mango seed":
			url = "inventory/MangoSeed.png";
			this.setImage(url);
			break;
		case "Pinecone seed":
			url = "inventory/PineconeSeed.png";
			this.setImage(url);
			break;
		case "Fruit":
			url = "inventory/Fruit.png";
			this.setImage(url);
			break;
		case "Plastic":
			url = "inventory/Plastic.png";
			this.setImage(url);
			break;
		case "Feather":
			url = "inventory/Feather.png";
			this.setImage(url);
			break;
		case "Titanium":
			url = "inventory/Titanium.png";
			this.setImage(url);
			break;
		case "Copper":
			url = "inventory/Copper.png";
			this.setImage(url);
			break;
		case "Metal":
			url = "inventory/Metal.png";
			this.setImage(url);
			break;
		case "Stone":
			url = "inventory/Stone.png";
			this.setImage(url);
			break;
		case "Scrap":
			url = "inventory/Scrap.png";
			this.setImage(url);
			break;
		case "Hinge":
			url = "inventory/Hinge.png";
			this.setImage(url);
			break;
		case "Nail":
			url = "inventory/Nail.png";
			this.setImage(url);
			break;
		case "Rope":
			url = "inventory/Rope.png";
			this.setImage(url);
			break;
		case "Circuit":
			url = "inventory/Circuit.png";
			this.setImage(url);
			break;
		case "Fish":
			url = "inventory/Fish.png";
			this.setImage(url);
			break;
		case "Bird":
			url = "inventory/Bird.png";
			this.setImage(url);
			break;
		case "Eagle head":
			url = "inventory/EagleHead.png";
			this.setImage(url);
			break;
		case "Weapon":
			url = "inventory/Wood-Axe.png";
			this.setImage(url);
			break;
		default:
			break;
		}
		setImage();



	private void setImage() {
		String image_path = ClassLoader.getSystemResource("inventory/" + name + ".png").toString();
		Image image = new Image(image_path);
		BackgroundFill bgFill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = { bgFill };
		BackgroundSize bgSize = new BackgroundSize(40, 40, false, false, false, false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = { bgImg };
		this.setBackground(new Background(bgFillA, bgImgA));
	}

	private void setAmount(int amount) {
		if (amount < 0)
			amount = 0;
		this.amount = amount;
	}

	public void setTooltip() {
		Tooltip tooltip = new Tooltip();
		tooltip.setFont(new Font(12));
		tooltip.setText(toString());
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}

	public String toString() {
		if (object instanceof Weapon) {
			return ((Weapon) object).toString() + "\nLife time: " + ((Weapon) object).getLifetime();
		}
		if (amount == 0) {
			return name;
		}
		return name + "\nAmount: " + amount;
	}

}
