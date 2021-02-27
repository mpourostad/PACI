import java.util.Scanner;

public class Calculator 
{

	public static void main(String[] args) 
	{
		//declaring the variables
		int count = 0;
		String in = "";
		double result = 0;
		String operator = "";
		double number = 0;

		while(true){
			
			count++;
			if(count%2 != 0)//ask the user to enter a number when the count number is odd
			{
				boolean correctValue1 = false;
				//keep asking for a numeric value until the input matches the criteria
				while(correctValue1 == false){
					Scanner input = new Scanner(System.in);
					System.out.println("Enter a number");
					
					in = input.nextLine();
					
					//check if the input is "x"
					if(in.equals("x")){
						System.out.println("You exit the program");
						System.exit(0);					
					}
					//when the input is "c", start the loop from count 1;
					else if(in.equals("c")){
						System.out.println("The buffer is cleared");
						result=0;
						count = 1;
						continue;
					}
					//what happens in case the input is 0
					else if (in.equals("0")){
						if(operator.equals("/")){
							System.out.println("division by zero, please enter another number");							
						}
						else{
							number = Double.parseDouble(in);
							correctValue1 = true;
						}
					}	

					else{
						if(in.matches("[0.0-9.0]+")){
							number = Double.parseDouble(in);
							correctValue1 = true;
						}
						else{
							System.out.println("Please enter a numeric value");
						}

					}
				}	
				// Case of correct numeric value						
				if (count==1){

						
					result = number;

				}

				else{					
					switch(operator) {
					
						case "+":
							result = result + number;
							break;
								
						case "-":
							result = result - number;
							break;
								
						case "*":
							result = result * number;
							break;
									
						case "/":
							result = result / number;
							break;
								
						default: 
							System.out.println("Error! Unknown Operator");
							break;
							
					}
						
					System.out.println("The answer is: " + result);	
				}	

			}
		
					
			else //ask the user for the operator when the count number is even
			{	boolean correctValue = false;
				//keep asking for an operator until the input matches the criteria
				while(correctValue == false){
					Scanner input = new Scanner(System.in);
					System.out.println("Enter an operator:");
					in  = input.nextLine();
					//check if the input is "x"
					if(in.equals("x")){
						System.out.println("You exit the program");
						System.exit(0);
					}
					//check if the input is "c"
					else if(in.equals("c")){
						System.out.println("The buffer is cleared");
						result = 0;
						count = 0;
						correctValue = true;
					}
					//limiting the input to be only a certain type.
					else if(in.equals("+")||in.equals("-")||in.equals("/")||in.equals("*") ){
							operator = in;
							correctValue = true;
					}
					
					else{
						System.out.println("Operator should be +, -, *, /. Please try again");
					}
				}
								

			}
					
		}
	}
}
	
	