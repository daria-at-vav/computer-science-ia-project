package application.models;

public class EnemySettings {
	private String name;
	private int maxHealth;
	private int attackPoints;
	private String image;
	private String deadImage;

	public EnemySettings(String name, int maxHealth, int attackPoints, String image, String deadImage) {
		this.setName(name);
		this.setMaxHealth(maxHealth);
		this.setAttackPoints(attackPoints);
		this.setImage(image);	
		this.setDeadImage(deadImage);	
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public String getDeadImage() {
		return deadImage;
	}

	public void setDeadImage(String deadImage) {
		this.deadImage = deadImage;
	}
}