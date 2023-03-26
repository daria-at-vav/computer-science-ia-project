package application;

import java.io.IOException;

import application.controllers.MenuScreen;
import application.models.Game;
import application.models.Player;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public static Stage mainStage;
	public static Scene welcomeScreen;
	public static Scene menuScreen;
	public static Scene rulesScreen;
	public static Scene battleScreen;
	public static Scene gameOverScreen;
	public static Player player;
	public static Game game;
	public static MenuScreen menuScreenController;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			mainStage = primaryStage;
			
			// Initialize scenes		
			initWelcomeScreen();
			initRulesScreen();
			initMenuScreen();
			initGameOverScreen();
			
			// Launch WelcomeScreen
			mainStage.setScene(welcomeScreen);
			mainStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void initWelcomeScreen() {
		try {
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/views/WelcomeScreen.fxml"));
			
			Image welcomeBackground = new Image((getClass().getResource("/application/resources/mainMenu.png").toExternalForm()));
		    BackgroundSize bSize = new BackgroundSize(800, 600, false, false, true, false);
		    root.setBackground(new Background(new BackgroundImage(welcomeBackground,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundPosition.CENTER,
		            bSize)));
		    
		    welcomeScreen = new Scene(root, 800, 600);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initMenuScreen() {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/views/MenuScreen.fxml"));
			BorderPane root = loader.load();
			
			Image welcomeBackground = new Image((getClass().getResource("/application/resources/levelSelect.png").toExternalForm()));
		    BackgroundSize bSize = new BackgroundSize(800, 600, false, false, true, false);
		    root.setBackground(new Background(new BackgroundImage(welcomeBackground,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundPosition.CENTER,
		            bSize)));		    
		    
			menuScreen = new Scene(root, 800, 600);
			menuScreenController = loader.getController();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	private void initRulesScreen() {
		try {
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/views/RulesScreen.fxml"));
			
			Image welcomeBackground = new Image((getClass().getResource("/application/resources/levelSelect.png").toExternalForm()));
		    BackgroundSize bSize = new BackgroundSize(800, 600, false, false, true, false);
		    root.setBackground(new Background(new BackgroundImage(welcomeBackground,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundPosition.CENTER,
		            bSize)));
			
			rulesScreen = new Scene(root, 800, 600);			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initGameOverScreen() {
		try {
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/views/GameOverScreen.fxml"));
			
			Image welcomeBackground = new Image((getClass().getResource("/application/resources/lost.png").toExternalForm()));
		    BackgroundSize bSize = new BackgroundSize(800, 600, false, false, true, false);
		    root.setBackground(new Background(new BackgroundImage(welcomeBackground,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundPosition.CENTER,
		            bSize)));
			
			gameOverScreen = new Scene(root, 800, 600);			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}