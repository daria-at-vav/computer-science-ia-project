package application.models;

public class Player {
	
	public final int MAX_HEALTH = 100;
	private int health = 100;
	private int attack = 20;
	private String difficultyUnlocked = Constants.DIFFICULTY_EASY;
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int newHealth) {
		health = newHealth;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int newAttack) {
		attack = newAttack;
	}

	public String getDifficultyUnlocked() {
		return difficultyUnlocked;
	}

	public void setDifficultyUnlocked(String difficultyUnlocked) {
		this.difficultyUnlocked = difficultyUnlocked;
	}

}
