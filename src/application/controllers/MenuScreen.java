package application.controllers;

import java.io.IOException;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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
import application.models.Constants;
import application.models.Game;
import application.models.Player;

public class MenuScreen {
	
	@FXML
	private Button quitGameButton;
	
	@FXML
	private Button rulesButton;
	
	@FXML
	private Button lvlOneButton;
	
	@FXML
	private Button lvlTwoButton;
	
	@FXML
	private Button lvlThreeButton;
	
	@FXML
	protected void onQuitGameButtonClicked(ActionEvent event) {
        Platform.exit();
	}
	
	@FXML
	protected void onRulesButtonClicked(ActionEvent event) {
		Scene rulesScreen = Main.rulesScreen;
		Main.mainStage.setScene(rulesScreen);
		Main.mainStage.show();
	}
	
	@FXML
	protected void onLvlOneButtonClicked(ActionEvent event) throws IOException {
		launchBattleByDifficulty(Constants.DIFFICULTY_EASY);
	}
	
	@FXML
	protected void onLvlTwoButtonClicked(ActionEvent event) throws IOException {
		launchBattleByDifficulty(Constants.DIFFICULTY_MODERATE);
	}
	
	@FXML
	protected void onLvlThreeButtonClicked(ActionEvent event) throws IOException {
		launchBattleByDifficulty(Constants.DIFFICULTY_HARD);
	}
	
	// Initialize Battle Screen
	private void initBattleScreen(BorderPane root) {
		
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
	
	}
	
	private void launchBattleByDifficulty(String difficulty) throws IOException {
		
		Main.player = new Player();
		
		Main.game = new Game(Main.player, difficulty);
		
		// Setup BattleScene
		BattleScreen battleScreenController;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/views/BattleScreen.fxml"));
		BorderPane root = loader.load();
		battleScreenController = loader.getController();
				
		initBattleScreen(root);
		battleScreenController.initBattleScreen(Main.game);
		Main.mainStage.setScene(Main.battleScreen);
		Main.mainStage.show();
		
	}
	
	public void updateButtons() {
		if (Main.player != null) {
			String difficultyUnlocked = Main.player.getDifficultyUnlocked();
			
			if (difficultyUnlocked == Constants.DIFFICULTY_MODERATE) {
				lvlTwoButton.setDisable(false);
			
			} else if (difficultyUnlocked == Constants.DIFFICULTY_HARD) {
				lvlTwoButton.setDisable(false);
				lvlThreeButton.setDisable(false);
				
			} else {
				lvlTwoButton.setDisable(true);
				lvlThreeButton.setDisable(true);
			}
		}
	}
		
}
