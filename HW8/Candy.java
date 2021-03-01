
public class Candy extends DessertItem {

	private double weight;
	private int cost;
	private int price;
	
	public Candy (String name, double weight, int price) {
		super(name);
		this.weight = weight;
		this.price = price;
		this.cost = setCost(price, weight);
	}
	@Override
	public int getCost() {
		return cost;
	}
	public int setCost(int price, double weight) {
		cost = (int) Math.round (price * weight);
		return cost;
	}
	public double getWeight() {
		return weight;
	}

	public int getPrice() {
		return price;
	}
}
