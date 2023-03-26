package application.models;

//Class for storing the multiplication factors Min & Max limits
public class QuestionFactors {
	private int minMultiplicand;
	private int maxMultiplicand;
	private int minMultiplier;
	private int maxMultiplier;
	
	public QuestionFactors(int minMultiplicand, int maxMultiplicand, int minMultiplier, int maxMultiplier) {
		super();
		this.minMultiplicand = minMultiplicand;
		this.maxMultiplicand = maxMultiplicand;
		this.minMultiplier = minMultiplier;
		this.maxMultiplier = maxMultiplier;
	}

	public int getMinMultiplicand() {
		return minMultiplicand;
	}

	public void setMinMultiplicand(int minMultiplicand) {
		this.minMultiplicand = minMultiplicand;
	}

	public int getMaxMultiplicand() {
		return maxMultiplicand;
	}

	public void setMaxMultiplicand(int maxMultiplicand) {
		this.maxMultiplicand = maxMultiplicand;
	}

	public int getMinMultiplier() {
		return minMultiplier;
	}

	public void setMinMultiplier(int minMultiplier) {
		this.minMultiplier = minMultiplier;
	}

	public int getMaxMultiplier() {
		return maxMultiplier;
	}

	public void setMaxMultiplier(int maxMultiplier) {
		this.maxMultiplier = maxMultiplier;
	}
}