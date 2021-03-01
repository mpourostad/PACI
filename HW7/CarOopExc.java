import java.util.Scanner;

public class CarOopExc {
	
	public static void main(String[] args) {
		
		CarOop [] cars = new CarOop [10];
		for(int i = 0; i < cars.length; i++) {
			// the constructor gets the " i + 1 " and assign it to the instance variable "number".
			cars [i] = new CarOop(i + 1);
			System.out.println(cars[i]);
		}	
		int chosenCar = carInput();
		int i = chosenCar - 1;
		cars[i].statusReport();
		System.out.println();
		drawTheBoardAll(cars[i].getX(), cars[i].getY(), cars[i].getColor());	

		while(true){

			char in = userInput();

			//what happens when the user choose "1", in case the ignition is on or off.
			if(in == '1'){
				if(cars[i].getIgnition() == false){
					cars[i].ignitionSwitch(cars[i].getIgnition());
					System.out.println();
					cars[i].statusReport();
					System.out.println();
					drawTheBoardAll(cars[i].getX(), cars[i].getY(), cars[i].getColor());	

				}
				else{
					cars[i].ignitionSwitch(cars[i].getIgnition());
					System.out.println();
					cars[i].statusReport();
					System.out.println();
					drawTheBoardAll(cars[i].getX(), cars[i].getY(), cars[i].getColor());	
					System.out.println();
					chosenCar = carInput();
					i = chosenCar - 1;
					cars[i].statusReport();
					System.out.println();
					drawTheBoardAll(cars[i].getX(), cars[i].getY(), cars[i].getColor());	

				}
			}
			//what happens when the user choose "2".
			if(in == '2'){
				if(cars[i].getIgnition() == false){
					System.out.println("please turn on the ignition first");
					continue;
				}
				else{
					char input2 = userInputHV();
					if(input2 == 'H'){
						int inputx = userInputInt();
						cars[i].moveX(inputx);
						cars[i].statusReport();
						System.out.println();
						drawTheBoardAll(cars[i].getX(), cars[i].getY(), cars[i].getColor());
						chosenCar = carInput();
						i = chosenCar - 1;
						cars[i].statusReport();
						System.out.println();
						drawTheBoardAll(cars[i].getX(), cars[i].getY(), cars[i].getColor());
					}
					else{
						int inputy = userInputInt();
						cars[i].moveY(inputy);
						cars[i].statusReport();
						System.out.println();
						drawTheBoardAll(cars[i].getX(), cars[i].getY(), cars[i].getColor());
						chosenCar = carInput();
						i = chosenCar - 1;
						cars[i].statusReport();
						System.out.println();
						drawTheBoardAll(cars[i].getX(), cars[i].getY(), cars[i].getColor());
					}
				}
			}				
		}

	}
	public static int carInput() {
		String entry = "";
		int count = 0;
		int number = 0;
		boolean correctValue = false;
		while (correctValue == false ) {
			count++;
			if(count == 1) {
				Scanner input = new Scanner(System.in);
				System.out.print("Which car would you like to use? (Choose from 1-10) " + "\n" + "input: ");
				entry = input.nextLine();
			}
			else {
				Scanner input = new Scanner(System.in);
				System.out.println("please enter a valid number: " + "\n" + "input: ");
				entry = input.nextLine();
			}
			if(entry.matches("[0-9]+")) {
				number = Integer.parseInt(entry);
				if(number < 11 && number > 0) {
					correctValue = true;
				}
			}

		}
		return number;
	}
	public static char userInput(){
		boolean correctUserInput = false;
		int count = 0;
		char entry = '0';


		while(correctUserInput == false){
			count ++;
			if(count == 1){
				Scanner input = new Scanner(System.in);
				System.out.println("what would you like to do?");
				System.out.println("1: Turn the ignition on/off" + "\n" + "2: change the position of the car");
				System.out.println("Q: Quit the program");
				System.out.println();
				System.out.print("input: ");
				entry = input.next().charAt(0);
				if(entry == 2){
					input = new Scanner(System.in);
					System.out.println();
					System.out.println("Please turn on the ignition first. ");
					System.out.print("input: ");
					entry = input.next().charAt(0);
				}
			}	
			else{
				Scanner input = new Scanner(System.in);
				System.out.println("Error, Please choose 1, or 2, Q");
				System.out.println();
				System.out.print("input: ");
				entry = input.next().charAt(0);
			}

			if(entry == '1' || entry == '2' || entry == 'Q'){
				correctUserInput = true;
			}
			if(entry == 'Q'){
				System.exit(0);
			}	
		}
		return entry;
	}
	//Method to get the direction from the user
	public static char userInputHV(){
		boolean correctUserInput = false;
		int count = 0;
		char entry = '0';

		while(correctUserInput == false){
			count++;
			if(count == 1){
				Scanner input = new Scanner(System.in);
				System.out.println("In which direction do you want to move the car? ");
				System.out.println();
				System.out.print("direction: ");
				entry = input.next().charAt(0);
			}
			else{
				Scanner input = new Scanner(System.in);
				System.out.println("Please enter \"" + "H" + "\" for horizontal move and \"" + "V" + "\" for vertical move.");
				System.out.println();
				System.out.print("direction: ");
				entry = input.next().charAt(0);
			}

			if(entry == 'H' || entry == 'V'){
				correctUserInput = true;
			}
		}
		return entry;
	}
	//Method to get a number from the user to move the car
	public static int userInputInt(){
		boolean correctUserInput = false;
		int count = 0;
		String entry = "0"; // getting string for the entry to avoid crashing if the user input is not a number
		int number = 0;

		while(correctUserInput == false){
			count++;
			if(count == 1){
				Scanner input = new Scanner(System.in);
				System.out.print("Enter a movement distance: ");
				entry = input.nextLine();
			}
			else{
				Scanner input = new Scanner(System.in);
				System.out.print("Error! Please enter a number: ");
				entry = input.nextLine();
			}
			//checking the input to see if it contains an integer either positive or negative.
			String firstLetter = Character.toString(entry.charAt(0));
			String remainingLetter = entry.substring(1);
			if(firstLetter.equals("-") || firstLetter.matches("[0-9]")){
				if(entry.length() == 1 && !firstLetter.equals("-")){
					number = Integer.parseInt(entry);
					correctUserInput = true;
				}
				else if(remainingLetter.matches("[0-9]+")){
					number = Integer.parseInt(entry);
					correctUserInput = true;
				}

			}
		}
		return number;
	}

	public static void drawTheBoardAll(int xCoordinate1, int yCoordinate1, char color1){
		char characterToPrint = '-';
		for(int row = 1; row < 21; row++){
			for( int column = 1; column < 21; column++){
				if (row == yCoordinate1 && column == xCoordinate1){
						characterToPrint = color1;
				}
				else{
					characterToPrint = '-';
				}
				if(column == 20){
					System.out.println(characterToPrint);
				}
	
				else{
					System.out.print(characterToPrint + " ");
				}
			}
		}
		System.out.println();
	}

}
