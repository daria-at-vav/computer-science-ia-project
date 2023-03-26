package application.controllers;

import java.io.IOException;

import application.Main;
import application.models.Game;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

public class GameOverScreen {
	
	@FXML
	private Button quitGameButton;
	
	@FXML
	private Button tryAgainButton;
	
	@FXML
	private Button mainMenuButton;
	
	@FXML
	protected void onQuitGameButtonClicked() {
		Platform.exit();
	}
	
	@FXML
	protected void onTryAgainButtonClicked() throws IOException {
		
		// Reset player health
		Main.player.setHealth(Main.player.MAX_HEALTH);
		
		Main.game = new Game(Main.player, Main.game.getDifficulty());
		
		// Setup BattleScene
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/views/BattleScreen.fxml"));
		BorderPane root = loader.load();
		BattleScreen battleScreenController = loader.getController();
				
		Image battleBackground = new Image((getClass().getResource("/application/resources/battle.png").toExternalForm()));
	    BackgroundSize bSize = new BackgroundSize(800, 600, false, false, true, false);
	    root.setBackground(new Background(new BackgroundImage(battleBackground,
	            BackgroundRepeat.NO_REPEAT,
	            BackgroundRepeat.NO_REPEAT,
	            BackgroundPosition.CENTER,
	            bSize)));
	    
	    // Create the scene
	 	Scene battleScreen = new Scene(root, 800, 600);
	 	Main.battleScreen = battleScreen;
	    
	    battleScreenController.initBattleScreen(Main.game);
		Main.mainStage.setScene(Main.battleScreen);
		Main.mainStage.show();
	}

	
	@FXML
	protected void onMainMenuButtonClicked() {
		Scene menuScreen = Main.menuScreen;
		Main.mainStage.setScene(menuScreen);
		Main.menuScreenController.updateButtons();
		Main.mainStage.show();
	}


}
