package game;

public class Market {
	private boolean index1,index2,index3,index4;
	
	public Market() {
		index1 = false;
		index2 = false;
		index3 = false;
		index4 = false;
	}
	
	public void trade(String object) {
		switch(object) {
		case "Canvas" :	if (!index1) Player.setCanvas(true); index1 = true;	break;
		case "Steering" :	if (!index2) Player.setSteering(true); index2 = true;	break;
		case "Petrol" :	if (!index3) Player.setPetrol(true); index3 = true;	break;
		case "Engine" :	if (!index4) Player.setEngine(true); index4 = true;	break;
		}
	}

}
