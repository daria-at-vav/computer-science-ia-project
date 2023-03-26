package application.controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class RulesScreen {
	
	@FXML
	private Button BackButton;
	
	@FXML
	private ImageView PantsRulesImage;
	
	@FXML
	protected void onBackButtonClicked(ActionEvent event) {
		Scene menuScreen = Main.menuScreen;
		Main.mainStage.setScene(menuScreen);
		Main.mainStage.show();
	}

}
