package game;

public class Market {

	public Market() {
	}

	public void trade(String object) {
		switch(object) {
		case "Canvas" :	
			if (!Player.hasCanvas()&&Player.getMetal()>10 &&Player.getScrape()>20 &&Player.getPlastic()>20 ) {
				Player.setCanvas(true);
				Player.setMetal(Player.getMetal()-10);
				Player.setScrape(Player.getScrape()-20);
				Player.setPlastic(Player.getPlastic()-20);
				break;
			}
		case "Steering" :	
			if (!Player.hasSteering()&&Player.getMetal()>15 &&Player.getScrape()>30 &&Player.getPlastic()>30 ) { 
				Player.setSteering(true);
				Player.setMetal(Player.getMetal()-15);
				Player.setScrape(Player.getScrape()-30);
				Player.setPlastic(Player.getPlastic()-30);
				break;
			}
		case "Petrol" :	if (!Player.hasPetrol()&&Player.getBird()>40 &&Player.getFish()>20 ) {
			Player.setPetrol(true);
			Player.setBird(Player.getBird()-40);
			Player.setFish(Player.getFish()-20);
			break;
		}
		case "Engine" :	if (!Player.hasEngine()&&Player.getEagleHead()>5) {
			Player.setEngine(true);
			Player.setEagleHead(Player.getEagleHead()-5);
			break;
		}
		}
	}

}
