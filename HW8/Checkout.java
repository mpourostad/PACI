
public class Checkout {
	
	DessertItem [] desserts ;
	
	public Checkout(){
		
		desserts = new DessertItem [100];
	}
	public void clear() {
		
		for (int i = 0; i< desserts.length; i++) {
			while (desserts[i] != null) {
				desserts[i] = null;
			}
		}
	}

	public void enterItem(DessertItem item) {
		
		for (int i = 0; i < desserts.length; i++) {
			if (desserts[i] == null) {
				desserts[i] = item;
				break;
			}
		}
		
	}

	public int totalTax() {

		int total = (int) Math.round((totalCost() * ( DessertShoppe.TAX_RATE / 100 )));
		return total;
	}

	public int totalCost() {
		
		int total = 0;
		for (int i = 0; i < desserts.length; i++) {
			if(desserts[i] != null)
			total += desserts[i].getCost();
		}
		return total;
	}

	public int numberOfItems() {
		
		int numberOfItems = 0;
		for(int i = 0; i < 100; i++ ) {
			if (desserts[i] != null) {
				numberOfItems++;
			}
		}
		return numberOfItems;
	}
	public java.lang.String toString() {
		
		int max = desserts[0].getName().length();		
		String total =  "\n    " + DessertShoppe.STORE_NAME + "\n   - - - - - - - - - - - -";
/* line 62 to 74: finding the element with the longest name and adding space to the other elements' names to ensure the corresponding prices 
 * would be arranged neatly in the receipt. */		
		for (int i = 0; i < desserts.length; i++) {
			if(desserts[i] != null && desserts[i].getName().length() > max) {
				max = desserts[i].getName().length();
			}
		}
		for (int i = 0; i < desserts.length; i++) {
			if (desserts[i] != null) {
				int count = 0;
				String space = "";
				while(count < max - desserts[i].getName().length()) {
					space += " ";
					count++;
				}	

				if (desserts[i] instanceof IceCream) {
					if (desserts[i] instanceof Sundae ) {
						Sundae sundae = (Sundae) desserts[i];
						total += "\n" + sundae.getTopping() + " sundae with\n" + sundae.getName()+ space
								+ "\t" + DessertShoppe.cents2dollarsAndCents(sundae.getCost());
					}
					else {
						total += "\n" + desserts[i].getName() + space + "\t" + DessertShoppe.cents2dollarsAndCents(desserts[i].getCost());
					}
				}	
				else if (desserts[i] instanceof Candy) {
					Candy candy = (Candy) desserts[i];
					total += "\n" + candy.getWeight() + " lbs. @ " + DessertShoppe.cents2dollarsAndCents(candy.getPrice()) + "/lb.\n" + 
							candy.getName() + space + "\t" + DessertShoppe.cents2dollarsAndCents(candy.getCost());
				}
				else {
					Cookie cookie = (Cookie) desserts[i];
					total += "\n" + cookie.getNumber() + " @ " + DessertShoppe.cents2dollarsAndCents(cookie.getPrice()) + "/dz.\n" + 
							cookie.getName() + space + "\t" + DessertShoppe.cents2dollarsAndCents(cookie.getCost());
				}
			}
			
		}
		String taxInDollar = DessertShoppe.cents2dollarsAndCents(totalTax());
		String costInDollar = DessertShoppe.cents2dollarsAndCents(totalCost() + totalTax());
		// Aligning the tax and total cost with the other prices.
		String [] name = {"Tax" , "Total Cost"};
		for (int i = 0; i < name.length; i++) {
			int count = 0; 
			String space = "";
			while (count < max - name[i].length()) {
				space += " ";
				count ++;
			}
			if(i == 0) {
				total += "\n\nTax" + space + "\t" + taxInDollar;
			}
			else {
				total += "\nTotal Cost" + space + "\t"+ costInDollar;
			}
		}
		return total;
				
	}
}
