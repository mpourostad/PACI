
public class CarOop {

	private char color;
	private int xCoordinate;
	private int yCoordinate;
	private boolean ignition;
	private int number; // car number as an instance variable.
	
	public CarOop(int carNumber) {
		color = assignColor();
		number = carNumber;
		xCoordinate = getRandomPosition();
		yCoordinate = getRandomPosition();
		ignition = getIgnition();

	}
	public int assignNumber() {
		number = (int)(Math.random() * 10);
		return number;		
	}
	public int getNumber() {
		return number;
	}
	public char assignColor(){
	
		int number = (int)(Math.random() * 10);
		if (number<2){
			color = 'R';
		}
		else if (number >= 2 && number<4){
			color = 'G';
		}
		else if (number >= 4 && number<6){
			color = 'B';
		}
		else if (number >= 6 && number<8){
			color = 'W';
		}
		else{
			color = 'S';
		}
		return color;
	}
	
	public char getColor() {
		return color;
	}
	
	public boolean ignitionSwitch(boolean ignition){
		if(ignition) {
			this.ignition = false;
			return this.ignition;
		}
		else {
			this.ignition = true;
			return this.ignition;
		}
		
	}
	
	public int getRandomPosition(){
		int coordinate = (int)((Math.random() * 19) + 1);
		return coordinate; 
	}
	
	public int getX() {
		return xCoordinate; 
	}
	
	
	public int getY() {
		return yCoordinate; 
	}
	
	public boolean getIgnition(){
		return ignition;
	}
	
	public int moveX(int move){
		boolean correctValue = false;
		int coordinate = 0;
		while(correctValue==false){
			coordinate = xCoordinate + move;
			if(coordinate > 20 || coordinate < 1){
				System.out.println("Error! The car moves out of the bound.");
				move = CarOopExc.userInputInt();
			}
			else{
				correctValue = true;
			}
		}
		this.xCoordinate = coordinate;
		return xCoordinate;
	}
	
	public int moveY(int move){
		int coordinate = 0;
		boolean correctValue = false;
		while(correctValue==false){
			coordinate = yCoordinate + move;
			if(coordinate > 20 || coordinate < 1){
				System.out.println("Error! The car moves out of the bound.");
				move = CarOopExc.userInputInt();
			}
			else{
				correctValue = true;
			}
		}
		this.yCoordinate = coordinate;
		return yCoordinate;
	}
	public void statusReport(){
		String color = "red";
		switch(this.color){
			case 'R':
				color = "red";
				break;
			case'G':
				color = "green";
				break;
			case 'W':
				color = "white";
				break;
			case 'S':
				color = "silver";
				break;
			case 'B':
				color = "blue";
				break;
			default:
				System.out.print("Error");
				break;
		}
		String ignition1 = "off";
		if(ignition == false){
			ignition1 = "off";
		}
		else{
			ignition1 = "on";
			}
		System.out.println();
		System.out.println("Car #" + getNumber() + " information: ");
		System.out.println("color: " + (color));
		System.out.println("ignition: " + (ignition1));
		System.out.println("car location: (" + (xCoordinate) + "," + (yCoordinate) + ")");
	}

}
	
