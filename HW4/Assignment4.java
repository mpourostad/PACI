import java.util.Scanner;
public class Assignment4{
	public static void main(String[] args) {
		int xCoordinate = randomPosition();
		int yCoordinate = randomPosition();
		char color = assignColor();
		boolean ignition1 = false;
		clearScreen();
		statusReport(xCoordinate, yCoordinate, color, ignition1);
		System.out.println();
		drawTheBoard(xCoordinate, yCoordinate, color);

		while(true){
			System.out.println();
			char in = userInput();

			//what happens when the user choose "1", in case the ignition is on or off.
			if(in == '1'){
				if(ignition1 == false){
					ignition1 = ignitionSwitch(ignition1);
					System.out.println();
					statusReport(xCoordinate, yCoordinate, color, ignition1);
					System.out.println();
				}
				else{
					ignition1 = ignitionSwitch(ignition1);
					statusReport(xCoordinate, yCoordinate, color, ignition1);
					System.out.println();
					drawTheBoard(xCoordinate, yCoordinate, color);
				}
			}
			//what happens when the user choose "2".
			if(in == '2'){
				if(ignition1 == false){
					System.out.println("please turn on the ignition first");
					continue;
				}
				else{
					char input2 = userInputHV();
					if(input2 == 'H'){
						int inputx = userInputInt();
						xCoordinate = move(xCoordinate, inputx);
						statusReport(xCoordinate, yCoordinate, color, ignition1);
						System.out.println();
						drawTheBoard(xCoordinate, yCoordinate, color);
					}
					else{
						int inputy = userInputInt();
						yCoordinate = move(yCoordinate, inputy);
						statusReport(xCoordinate, yCoordinate, color, ignition1);
						System.out.println();
						drawTheBoard(xCoordinate, yCoordinate, color);
					}
				}
			}
		}		
	}

	public static boolean ignitionSwitch(boolean ignition){
		if(ignition == true){
			return false; 
		}
		else{
			return true;
		}
	}	
	//method to promote the user to turn the ignition on/off, move the car, or quit the program.
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
				System.out.print("input: ");
				entry = input.next().charAt(0);
				if(entry == 2){
					input = new Scanner(System.in);
					System.out.println("Please turn on the ignition first. ");
					System.out.print("input: ");
					entry = input.next().charAt(0);
				}
			}	
			else{
				Scanner input = new Scanner(System.in);
				System.out.println("Error, Please choose 1, or 2, Q");
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
				System.out.print("direction: ");
				entry = input.next().charAt(0);
			}
			else{
				Scanner input = new Scanner(System.in);
				System.out.println("Please enter " + "\"" + "H" + "\"" + " for horizontal move and " + " \"" + "V" + "\"" + " for vertical move");
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
			//checking the inpu tto see if it contains an integer.
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

	public static void statusReport(int xCoordinate, int yCoordinate, char color, boolean ignition1){
		String color2 = "red";
		switch(color){
			case 'R':
				color2 = "red";
				break;
			case'G':
				color2 = "green";
				break;
			case 'W':
				color2 = "white";
				break;
			case 'S':
				color2 = "sage";
				break;
			case 'B':
				color2 = "blue";
				break;
			default:
				System.out.print("Error");
				break;
		}
		String ignition = "off";
		if(ignition1 == false){
			ignition = "off";
		}
		else{
			ignition = "on";
			}
		System.out.println();
		System.out.println("Car information: ");
		System.out.println("color:" + (color2));
		System.out.println("ignition: " + (ignition));
		System.out.println("car location: (" + (xCoordinate) + "," + (yCoordinate) + ")");
	}

	/*realized the move horizontally method and move vertically method which were asked in the assignement description,
	were doing the same job in my code, so I decided to create the below method and call it to move a coordinate. */
	public static int move(int coordinate, int move){
		int coordinate_new = 0;
		boolean correctValue = false;
		while(correctValue==false){
			coordinate_new = coordinate + move;
			if(coordinate_new>21 || coordinate_new < 1){
				System.out.println("Error! The car moves out of the bound.");
				move = userInputInt();
			}
			else{
				correctValue = true;
			}
		}
		return coordinate_new;
	}


	public static int randomPosition(){
		int location = (int)((Math.random() * 19) + 1);
		return location; 
	}

	public static char assignColor(){
		char color;

		int number = (int)(Math.random() * 10);
		if (number<2){
			color = 'R';
		}
		else if (number>=2 && number<4){
			color = 'G';
		}
		else if (number>=4 && number<6){
			color = 'B';
		}
		else if (number>=6 && number<8){
			color = 'W';
		}
		else{
			color = 'S';
		}
		return color;

	}

	public static void drawTheBoard(int xCoordinate, int yCoordinate, char color){
		char characterToPrint;
		for(int row=1; row<21; row++){
			for( int column=1; column<21; column++){
				if (row == yCoordinate && column == xCoordinate){
					characterToPrint = color;
				}
				else{
					characterToPrint = '-';
				}
				if(column == 20){
					System.out.println(characterToPrint);
				}

				else{
					System.out.print(characterToPrint);
				}
			}
		}			 
	}

	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
}