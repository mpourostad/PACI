
public class Sundae extends IceCream {
	private int cost;
	private String topping;
	
	public Sundae(String name, int cost, String topping, int toppingCost) {
		super (name, cost);
		this.topping = topping;
		this.cost = toppingCost + cost;		
	}
	public String getTopping() {
		return topping;
	}
	@Override
	public int getCost() {
		return cost;
	}
	public int setCost(int iceCreamCost, int toppingCost) {
		this.cost = iceCreamCost + toppingCost;
		return cost;
	}

}
