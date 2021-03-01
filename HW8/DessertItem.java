
public abstract class DessertItem {
	/**
	 * Abstract superclass for Dessert Item hierarchy
	 */
	protected String name;
	  
	public DessertItem() {
	    this("");
	  }

	  public DessertItem(String name) {
	    if (name.length() <= DessertShoppe.MAX_ITEM_NAME_SIZE)
	      this.name = name;
	    else 
	      this.name = name.substring(0,DessertShoppe.MAX_ITEM_NAME_SIZE);
	  }

	  public final String getName() {
	    return name;
	  }

	  public abstract int getCost();
	  	  	   

}
