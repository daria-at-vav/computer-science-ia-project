package application.controllers;

import java.io.IOException;

import application.Main;
import application.models.Constants;
import application.models.Game;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

public class VictoryScreen {
	
	@FXML
	private Button quitGameButton;
	
	@FXML
	private Button nextLevelButton;
	
	@FXML
	private Button mainMenuButton;
	
	@FXML
	private Label resultsLabel;
	
	@FXML
	protected void onQuitGameButtonClicked() {
		Platform.exit();
	}
	
	@FXML
	protected void onNextLevelButtonClicked() throws IOException {
		
		if (Main.game.getDifficulty() == Constants.DIFFICULTY_HARD) {
			resultsLabel.setText("There are no other levels. Try going back to the Main Menu!");
		
		} else {
			
			// Reset player health
			Main.player.setHealth(Main.player.MAX_HEALTH);
			
			// Choose next level difficulty
			if (Main.game.getDifficulty() == Constants.DIFFICULTY_EASY) {
				Main.game = new Game(Main.player, Constants.DIFFICULTY_MODERATE);
				
			} else if (Main.game.getDifficulty() == Constants.DIFFICULTY_MODERATE) {
				Main.game = new Game(Main.player, Constants.DIFFICULTY_HARD);
			}
			
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
	}

	
	@FXML
	protected void onMainMenuButtonClicked() {
		Scene menuScreen = Main.menuScreen;
		Main.mainStage.setScene(menuScreen);
		Main.menuScreenController.updateButtons();
		Main.mainStage.show();
	}

	public void initVictoryScreen(Game game) {
		resultsLabel.setText("Hooray! You got " + Main.game.getCorrect() + " out of " + Main.game.getTotal() + " questions right!");
	}
	
}
