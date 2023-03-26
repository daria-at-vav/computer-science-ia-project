package application.models;

public class Question {
	
	private String difficulty;
	private int multiplicand;
	private int multiplier;
	private QuestionFactors factors;

	public Question(String difficulty) {
		
		this.setDifficulty(difficulty);
		
		// get the list of possible options to be chose from for factors (multiplicand and multiplier)
		if (difficulty == Constants.DIFFICULTY_MODERATE) {
			factors = Constants.MODERATE_FACTORS;
		} else if (difficulty == Constants.DIFFICULTY_HARD) {
			factors = Constants.HARD_FACTORS;
		} else { // default difficulty
			factors = Constants.EASY_FACTORS;
		}
			
		// set the multiplicand - pick randomly between multiplicandMin and multiplicandMax of factors
		this.multiplicand = getRandomBetween(factors.getMinMultiplicand(), factors.getMaxMultiplicand());
		
		// set the multiplier - pick randomly between multiplierMin and multiplierMax of factors
		this.multiplier = getRandomBetween(factors.getMinMultiplier(), factors.getMaxMultiplier());		
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	public int correctAnswer() {
		return multiplicand * multiplier;
	}
	
	public boolean isCorrectAnswer(int answer) {
		return answer == this.correctAnswer();
	}	
	
	public String getQuestionText() {
		return(this.multiplicand + " x " + this.multiplier + " = ?");
	}
	
	private int getRandomBetween(int min, int max) {
		return ((int)Math.floor(Math.floor(Math.random()*(max+1 - min) + min)));
	}
}