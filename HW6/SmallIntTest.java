package assignment6;
import java.util.Scanner;

public class SmallIntTest {

	public static void main(String[] args) {
		
			int number = userInputDecimal();
			SmallInt myNumber = new SmallInt (number);
			System.out.println("The binary of "
					+ myNumber.getDee() + " is " + myNumber.getBin());
			myNumber.setDee(number);		
			System.out.println("the hexadecimal of "
					+ myNumber.getDee() + " is " + myNumber.getHex());
			
			String number1 = userInputBinary();
			String number2 = userInputHex();
			boolean value = SmallInt.sameValue(number1, number2);
			if(value) {
				System.out.println(value + "\nThe provided numbers have the same value");		
			}
			else {
				System.out.println(value + "\nThe provided numbers don't have the same value");
			}
		
	}

	public static int userInputDecimal() {
		boolean correct = false;
		int entry = 0;
		int count = 0;
		String number = " ";
		while(correct == false) {
			count++;
			if (count == 1) {
				Scanner input = new Scanner ( System.in );
				System.out.println("Please enter a positive number smaller or equal to 1000.");
				number = input.nextLine();
			}
			if(count > 1) {
				Scanner input = new Scanner ( System.in );
				System.out.println("Error! The input must be a positive number smaller or equal to 1000. \nPlease try again: ");
				number = input.nextLine();
			}
			if(number.matches("[0-9]+")) {
				entry = Integer.parseInt(number);
			}
			if (entry <= SmallInt.MAXVALUE) {
				correct = true;
			}
		}
		return entry;
			
	}
	public static String userInputBinary() {
		boolean correct = false;
		String number = " ";
		int count = 0;
		while(correct == false) {
			count++;
			if (count == 1) {
				Scanner input = new Scanner ( System.in );
				System.out.println("Please enter a number in binary format:");
				number = input.nextLine();
			}
			if (count > 1) {
				Scanner input = new Scanner (System.in);
				System.out.println("Error! Please enter a number in binary format:");
				number = input.nextLine();
			}
			if(number.matches("[0-1]+")) {
				correct = true;
			}
			
		}
		return number;
	}
	public static String userInputHex() {
		boolean correct = false;
		String number = " ";
		int count = 0;
		while(correct == false) {
			count++;
			if (count == 1) {
				Scanner input = new Scanner ( System.in );
				System.out.println("Please enter a number in hexadecimal format");
				number = input.nextLine();
			}
			if (count > 1) {
				Scanner input = new Scanner (System.in);
				System.out.println("Error! Please enter a number in hexadecimal format:");
				number = input.nextLine();
			}
			if(number.matches("[0-9]+") || number.matches("[A-F]+")) {
				correct = true;
			}			
		}
		return number;
	}  

}
