package application.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import application.Main;
import javafx.event.ActionEvent;
import javafx.scene.Scene;

public class WelcomeScreen {
	
	@FXML
	private Button startButton;
			
	@FXML
	protected void onStartButtonClicked(ActionEvent event) {
		Scene menuScreen = Main.menuScreen;
		Main.mainStage.setScene(menuScreen);
		Main.mainStage.show();
	}
	
}
