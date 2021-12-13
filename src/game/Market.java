package game;

public class Market {
	private String tradeObject;

	public Market(String tradeObject) {
		this.tradeObject = tradeObject;
	}

	public boolean trade(Player player) {
		switch (tradeObject) {
		case "Canvas":
			if (!player.hasCanvas() && player.getMetal() >= 10 && player.getScrape() >= 20
					&& player.getPlastic() >= 20) {
				player.setCanvas(true);
				player.setMetal(player.getMetal() - 10);
				player.setScrape(player.getScrape() - 20);
				player.setPlastic(player.getPlastic() - 20);
				break;
			}
			return false;
		case "Steering":
			if (!player.hasSteering() && player.getMetal() >= 15 && player.getScrape() >= 30
					&& player.getPlastic() > 30) {
				player.setSteering(true);
				player.setMetal(player.getMetal() - 15);
				player.setScrape(player.getScrape() - 30);
				player.setPlastic(player.getPlastic() - 30);
				break;
			}
			return false;
		case "Petrol":
			if (!player.hasPetrol() && player.getBird() >= 40 && player.getFish() >= 20) {
				player.setPetrol(true);
				player.setBird(player.getBird() - 40);
				player.setFish(player.getFish() - 20);
				break;
			}
			return false;
		case "Engine":
			if (!player.hasEngine() && player.getEagleHead() >= 5) {
				player.setEngine(true);
				player.setEagleHead(player.getEagleHead() - 5);
				break;
			}
			return false;
		}
		return true;
	}

}
