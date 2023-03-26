package application.controllers;

import application.Main;
import application.models.Question;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class QuestionScreen {
	
	@FXML
	private Label questionLabel;
	
	@FXML
	private TextField numberTextField;
	
	@FXML
	private Button answerButton;

	@FXML
	private Label answerLabel;
	
	@FXML 
	protected void onAnswerButtonClicked() {

		try {
			if (answerButton.getText() == "Check") {
				
				if (numberTextField.getText() == null) {
					// Show message that there is a invalid input
					answerLabel.setVisible(true);
					answerLabel.setText("Invalid Input");
					
				} else if(Integer.parseInt(numberTextField.getText().trim()) == question.correctAnswer()) {
					updateQuestionScreen("Correct!");
					Main.game.addCorrect();
						
				} else {
					updateQuestionScreen("Incorrect! The right answer is " + question.correctAnswer() + ".");
				}
				
			} else {
				// Get a handle to the stage using the button and close it
			    Stage questionStage = (Stage) answerButton.getScene().getWindow();
			    parent.updateGameByPlayer(Integer.parseInt(numberTextField.getText().trim()) == question.correctAnswer());
			    questionStage.close();	
			}
			
		} catch (NumberFormatException ex){
			// Show message that there is a invalid input
			answerLabel.setVisible(true);
			answerLabel.setText("Invalid Input");
        }	
		
	}
	
	private Question question;
	private BattleScreen parent;
	
	public void initScreen(Question q, BattleScreen parentController) {
		this.question = q;
		this.parent = parentController;
		
		questionLabel.setText(question.getQuestionText());
		numberTextField.setText(null);
		answerLabel.setVisible(false);
		answerLabel.setText(null);
		answerButton.setVisible(true);
		answerButton.setText("Check");
	}
	
	public void updateQuestionScreen(String message) {
		numberTextField.setDisable(true);
		answerLabel.setVisible(true);
		answerLabel.setText(message);
		answerButton.setText("Continue");
	}
	
}
