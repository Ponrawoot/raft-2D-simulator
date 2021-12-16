package component.base;

import game.Mission;
import game.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

public class MissionPane extends BorderPane{
	private Mission mission;
	private Label label;

	public MissionPane(Mission mission, int missionNumber, Player player) {
		super();
		setPrefHeight(110);
		this.mission = mission;
		setLabel(missionNumber);
		Button getRewardButton = new Button("Get");
		getRewardButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				boolean getReward = mission.getReward(missionNumber, player);
				setLabel(missionNumber);
				setLeft(label);
				if (!getReward) {
					showWarning();
				}
			}
		});
		setLeft(label);
		setRight(getRewardButton);
	}
	
	private void setLabel(int missionNumber) {
		label = new Label();
		String requirement = "";
		switch (missionNumber) {
		case 0:
			requirement += "Reward: stone, rope\n" + 
							"Requirement:\n" + 
							" - wood " + mission.getMissionRequirement(missionNumber).get(0);
			break;
		case 1:
			requirement += "Reward: metal\n" + 
							"Requirement:\n" + 
							" - scrap " + mission.getMissionRequirement(missionNumber).get(0) + "\n" +
							" - rope " + mission.getMissionRequirement(missionNumber).get(1);
			break;
		case 2:
			requirement += "Reward: stone spear\n" + 
							"Requirement:\n" + 
							" - fish " + mission.getMissionRequirement(missionNumber).get(0);
			break;
		case 3:
			requirement += "Reward: metal spear\n" + 
							"Requirement:\n" + 
							" - bird " + mission.getMissionRequirement(missionNumber).get(0);
			break;
		case 4:
			requirement += "Reward: stone axe, increase max HP\n" + 
							"Requirement:\n" + 
							" - fruit " + mission.getMissionRequirement(missionNumber).get(0);
			break;
		case 5:
			requirement += "Reward: metal axe\n" + 
							"Requirement:\n" + 
							" - fruit " + mission.getMissionRequirement(missionNumber).get(0) + "\n" +
							" - wood " + mission.getMissionRequirement(missionNumber).get(1) + "\n" +
							" - leaf " + mission.getMissionRequirement(missionNumber).get(2) + "\n" +
							" - metal " + mission.getMissionRequirement(missionNumber).get(3);
			break;
		case 6:
			requirement += "Reward: stone shovel, increase max HP\n" + 
							"Requirement:\n" + 
							" - feather " + mission.getMissionRequirement(missionNumber).get(0) + "\n" +
							" - bird " + mission.getMissionRequirement(missionNumber).get(1);
			break;
		case 7:
			requirement += "Reward: titanium\n" + 
							"Requirement:\n" + 
							" - metal " + mission.getMissionRequirement(missionNumber).get(0);
			break;
		case 8:
			requirement += "Reward: copper\n" + 
							"Requirement:\n" + 
							" - plastic " + mission.getMissionRequirement(missionNumber).get(0) + "\n" +
							" - stone " + mission.getMissionRequirement(missionNumber).get(1);
			break;
		}
		label.setText(requirement);
	}
	
	public void showWarning() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Fail to get reward");
		alert.setHeaderText(null);
		alert.setContentText("Please check your object amount." );
		alert.showAndWait();
	}
}
