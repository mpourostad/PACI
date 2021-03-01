
public class Cookie extends DessertItem {
	
	private int cost;
	private int price;
	private int number;
	
	public Cookie(String name, int number,  int price) {
		
		super(name);
		this.price = price;
		this.number = number;
		setCost(price, number);
	}
	public int setCost(int price, int number) {
		
		cost = Math.round (number * price / 12);
		return cost;
	}
	@Override
	public int getCost() {
		
		return cost;
	}
	public int getPrice() {
		
		return price;
	}
	public int getNumber() {
		
		return number;
	}
}
