package application.models;

public class Constants {
	
	// Prevents instantiation
	private Constants() {}

    public static final String DIFFICULTY_EASY = "easy";
    public static final String DIFFICULTY_MODERATE = "moderate";
    public static final String DIFFICULTY_HARD = "hard";
    
    public static final QuestionFactors EASY_FACTORS = new QuestionFactors(0,5,0,5); // multiplicands: 0-5, multipliers: 0-5
    public static final QuestionFactors MODERATE_FACTORS = new QuestionFactors(5,10,5,10); // multiplicands: 5-10, multipliers: 5-10
    public static final QuestionFactors HARD_FACTORS = new QuestionFactors(10,15,10,15); // multiplicands: 10-15, multipliers: 10-15
}