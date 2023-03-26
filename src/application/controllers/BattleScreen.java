package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import application.Main;
import application.models.Constants;
import application.models.Game;
import application.models.Question;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BattleScreen {
	
	@FXML
	private ImageView playerImage;
	
	@FXML
	private ImageView enemyImage;
	
	@FXML
	private ProgressBar playerHealthBar;
	
	@FXML
	private ProgressBar enemyHealthBar;
	
	@FXML
	private Label labelPlayerHealth;
	
	@FXML
	private Label labelEnemyHealth;
	
	@FXML
	private Label labelEnemyName;
	
	@FXML
	private Label textBox;
	
	@FXML
	private Button mainButton;
	
	// modal window
	private Stage questionStage;
		
	// question screen that will run in the modal window
	private Scene questionScreen;
	
	private boolean gameWon;
	private boolean gameLost ;
	
	// victory screen 
	private Scene victoryScreen;
		
	@FXML
	protected void onMainButtonClicked() throws IOException {
		
		if (mainButton.getText() == "Attack") {
			
			// Change button to "Continue" 
			mainButton.setText("Continue");

			// Get ChallengeScreen controller from FXML
			QuestionScreen challengeScreenController;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/views/QuestionScreen.fxml"));
			BorderPane root = loader.load();
			challengeScreenController = loader.getController();
			
			// Create a new stage that will run inside the main stage
			setQuestionStage();
			
			// Create or set the challenge scene that will run inside the new stage
			setQuestionScene(root);
			
			// generate a new question
			Question question = new Question(Main.game.getDifficulty());
			
			// Update the challenge scene with updated question
			challengeScreenController.initScreen(question, this);
			
			// Finally, set the scene to the new stage and show it
			questionStage.setScene(questionScreen);
			questionStage.show();
			
		} else if (mainButton.getText() == "Continue"){
			
			// Only updateGameByEnemy if gameWon is false		
			if (gameWon) {				
				mainButton.setText("Results");
				enemyImage.setImage(new Image((getClass().getResource("/application/resources/" + Main.game.getEnemy().getDeadImage()).toExternalForm())));
				textBox.setText("You defeated the enemy! :D");
				
			} else { 
				
				updateGameByEnemy();

				if (gameLost) {
					playerImage.setImage(new Image((getClass().getResource("/application/resources/deadHand.png").toExternalForm())));
					mainButton.setText("Oh no!");
					
				} else {
					mainButton.setText("Attack");
				}
			}
			
		} else if (mainButton.getText() == "Results"){
			
			if (Main.game.getDifficulty() == Constants.DIFFICULTY_EASY) {
				Main.game.getPlayer().setDifficultyUnlocked(Constants.DIFFICULTY_MODERATE);
			} else if (Main.game.getDifficulty() == Constants.DIFFICULTY_MODERATE){
				Main.game.getPlayer().setDifficultyUnlocked(Constants.DIFFICULTY_HARD);
			}
			
			// Setup VictoryScreen
			VictoryScreen victoryScreenController;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/views/VictoryScreen.fxml"));
			BorderPane root = loader.load();
			victoryScreenController = loader.getController();					
			initVictoryScreen(root);
			victoryScreenController.initVictoryScreen(Main.game);
			Main.mainStage.setScene(victoryScreen);
			Main.mainStage.show();
			
		} else if (mainButton.getText() == "Oh no!") {
			
			Scene gameOverScreen = Main.gameOverScreen;
			Main.mainStage.setScene(gameOverScreen);
			Main.mainStage.show();
		}
	}
	
	public void updateGameByPlayer(boolean isCorrectAnswer) {
		
		Main.game.addTotal();
		int newEnemyHealth = Main.game.getEnemy().getHealth();
		
		// Update images and text box
		if (isCorrectAnswer) {
			newEnemyHealth = Main.game.getEnemy().getHealth() - Main.game.getPlayer().getAttack(); 
			textBox.setText("You got the question right! You dealt " + Main.game.getPlayer().getAttack() + " damage to the enemy! :D");

		} else {
			textBox.setText("You got the question wrong! You delt no damagae this round. :(");
		}
		
		Main.game.getEnemy().setHealth(newEnemyHealth);
		
		// Update progress bar
		int enemyMaxHealth = Main.game.getEnemy().getMaxHealth();
		int enemyHealth = Main.game.getEnemy().getHealth();
		if (enemyHealth <= 0) {
			enemyHealth = 0;
			gameWon = true;
		}
		enemyHealthBar.setProgress((double) enemyHealth / (double) enemyMaxHealth);
		labelEnemyHealth.setText(enemyHealth + "/" + enemyMaxHealth);			
	}

	public void updateGameByEnemy() {
		
		int newPlayerHealth = Main.game.getPlayer().getHealth();
		
		// Update Image and text box
		newPlayerHealth = Main.game.getPlayer().getHealth() - Main.game.getEnemy().getAttackPoints();
		textBox.setText("It's the enemy's turn. " + Main.game.getEnemy().getName() + " did " + Main.game.getEnemy().getAttackPoints() + " damage to you. Ouch!");
		
		Main.game.getPlayer().setHealth(newPlayerHealth);
		
		// Update progress bar
		int playerMaxHealth = Main.game.getPlayer().MAX_HEALTH;
		int currentPlayerHealth = Main.game.getPlayer().getHealth();
		if (currentPlayerHealth <= 0) {
			currentPlayerHealth = 0;
			gameLost = true;
		}
		playerHealthBar.setProgress((double) currentPlayerHealth / (double) playerMaxHealth);
		labelPlayerHealth.setText(currentPlayerHealth + "/" + playerMaxHealth);	
	}
		
	public void initBattleScreen(Game game) {
		
		// Player image and progress bar
		playerImage.setImage(new Image((getClass().getResource("/application/resources/hand.png").toExternalForm())));
		int playerMaxHealth = game.getPlayer().MAX_HEALTH;
		int currentPlayerHealth = game.getPlayer().getHealth();
		// cast integers to double otherwise the division will be 0
		playerHealthBar.setProgress((double) currentPlayerHealth / (double) playerMaxHealth);
		labelPlayerHealth.setText(currentPlayerHealth + "/" + playerMaxHealth);
				
		// Enemy name, image and progress bar
		labelEnemyName.setText(game.getEnemy().getName());
		enemyImage.setImage(new Image((getClass().getResource("/application/resources/" + game.getEnemy().getImage()).toExternalForm())));
		int enemyMaxHealth = game.getEnemy().getMaxHealth();
		int enemyHealth = game.getEnemy().getHealth();
		// cast integers to double otherwise the division will be 0
		enemyHealthBar.setProgress((double) enemyHealth / (double) enemyMaxHealth);
		labelEnemyHealth.setText(enemyHealth + "/" + enemyMaxHealth);
				
		// Text box
		textBox.setText("The battle begins! " + game.getEnemy().getName() + " approaches... You have to attack!");
		mainButton.setText("Attack");
	}
	
	private void setQuestionStage() {		
		// create a new stage and remove minimize and maximize buttons - UTILITY
		this.questionStage = new Stage(StageStyle.UTILITY);
		
		// disable close button
		this.questionStage.setOnCloseRequest((event) -> event.consume());
		
		// position the new stage (in center of the main stage)
		this.questionStage.setX(Main.mainStage.getX() + 80); // mainStage position X + ((800 - 640) / 2)
		this.questionStage.setY(Main.mainStage.getY() + 60); // mainStage position X + ((600 - 480) / 2)
		
		// set the new stage as WINDOW_MODAL (when opened the users cannot interact with other stages in the application)
		this.questionStage.initModality(Modality.WINDOW_MODAL);
		
		// set the owner of the new stage - the primary stage
		this.questionStage.initOwner(Main.mainStage); 
	}
	
	private void setQuestionScene(BorderPane root) {
		
		this.questionScreen = null;
		
		// Set the background to root first
		Image battleBackground = new Image((getClass().getResource("/application/resources/question.png").toExternalForm()));
		BackgroundSize bSize = new BackgroundSize(640, 480, false, false, true, false);
		root.setBackground(new Background(new BackgroundImage(battleBackground,
			BackgroundRepeat.NO_REPEAT,
		    BackgroundRepeat.NO_REPEAT,
		    BackgroundPosition.CENTER,
		    bSize
	    )));
		    
		// Create the scene
		questionScreen = new Scene(root, 640, 480);
	}
	
	private void initVictoryScreen(BorderPane root) {
		
		if (victoryScreen == null) {
			
			Image victoryBackground = new Image((getClass().getResource("/application/resources/won.png").toExternalForm()));
		    BackgroundSize bSize = new BackgroundSize(800, 600, false, false, true, false);
		    root.setBackground(new Background(new BackgroundImage(victoryBackground,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundPosition.CENTER,
		            bSize)));
		    
		    // Create the scene
			victoryScreen = new Scene(root, 800, 600);
		}
	
	}
}