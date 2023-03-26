package application.models;

public class Game {
	
	private static Player player;
	private static Enemy enemy;
	private String difficulty;
	private static int total;
	private static int correct;
	
	public Game(Player newPlayer, String difficulty) {
		player = newPlayer;
		this.difficulty = difficulty;
		enemy = new Enemy(difficulty);
		this.setCorrect(0);
		this.setTotal(0);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player newPlayer) {
		player = newPlayer;
	}
	
	public Enemy getEnemy() {
		return enemy;
	}
	
	public void setEnemy(Enemy newEnemy) {
		enemy = newEnemy;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int newCorrect) {
		correct = newCorrect;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int newTotal) {
		total = newTotal;
	}

	public void addCorrect() {
		correct++;
	}
	
	public void addTotal() {
		total++;
	}

}
