package application.models;

import java.util.Hashtable;

public class Enemy {
	
	private String name;
	private int health;
	private int maxHealth;
	private int attackPoints;
	private String image;
	private String deadImage;
	private Hashtable<String, EnemySettings> defaultValues = new Hashtable<String, EnemySettings>();
	
	public Enemy(String difficulty) {
		
		populateDefaultSettings();
		
		this.name = defaultValues.get(difficulty).getName();
		this.attackPoints = defaultValues.get(difficulty).getAttackPoints();
		this.maxHealth = defaultValues.get(difficulty).getMaxHealth();
		this.image = defaultValues.get(difficulty).getImage();
		this.deadImage = defaultValues.get(difficulty).getDeadImage();
		this.health = this.maxHealth;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int newHealth) {
		health = newHealth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	private void populateDefaultSettings() {
	
		defaultValues.put(Constants.DIFFICULTY_EASY, new EnemySettings("Beanie Meanie", 100, 5, "beanieMeanie.png", "deadBeanie.png"));
		defaultValues.put(Constants.DIFFICULTY_MODERATE, new EnemySettings("Top Hat Rat", 140, 7, "topHatRat.png", "deadTopHat.png"));
		defaultValues.put(Constants.DIFFICULTY_HARD, new EnemySettings("Blizzard Wizard", 200, 10, "blizzardWizard.png", "deadWizard.png"));
	
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDeadImage() {
		return deadImage;
	}

	public void setDeadImage(String deadImage) {
		this.deadImage = deadImage;
	}
}
