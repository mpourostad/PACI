import java.util.Scanner;
public class Calculator {

	public static void main(String[] args) {
		double result = 0;
		String temp = 1+"";
		Scanner in = new Scanner(System.in);
		System.out.println("type your infix expression: ");
		String input = in.nextLine();
		Converter convert = new Converter(input);
		System.out.print("converted to postfix: ");
		System.out.println(convert.toPostFix());
		DoublyLinkedList<String> list = parse(inChar(convert.toPostFix()));
		ArrayStack<String> operation = new ArrayStack<>();
		while(list.isEmpty() == false) {
			for (int i = 0; i < list.size(); i++) {
				operation.push(list.removeLast());
			}
		}
//		list = parse(inChar(convert.toPostFix()));		
		while(operation.isEmpty() == false) {
			if(operation.top().matches("[0.0-9.0]+")) {
				list.addLast(operation.pop());
				continue;
			}
			else {
				list.addLast(operation.pop());
				result = answer(list.removeLast(), list.removeLast(), list.removeLast());
				if (operation.isEmpty() == true) {
					System.out.println(result);
					System.exit(0);
				}
				else {
					temp = result + "";
					operation.push(temp);
				}
			}
		}
		
	}
	public static char[] inChar(String input) {
		char [] answer = new char[input.length()];
		for (int i = 0; i < input.length(); i++) {
			answer[i] = input.charAt(i);
		}
		return answer;
	}
	public static DoublyLinkedList<String> parse(char[] input) {
	    DoublyLinkedList<String> parsed = new DoublyLinkedList<String>();
	    for (int i = 0; i < input.length; ++i) {
	        char c = input[i];
	        if (Character.isDigit(c)) {
	            String number = input[i] + "";
	            for (int j = i + 1; j < input.length; ++j) {
	                if (Character.isDigit(input[j])) {
	                    number += input[j];
	                    i = j;
	                } else {
	                    break;
	                }
	            }
	            parsed.addLast(number);
	        } else if (c == '*' || c == '/' || 
	                   c == '+' || c == '^' || 
	                   c == '-' || c == '(' || c == ')') {
	            parsed.addLast(c + "");
	        }
	    }
	    return parsed;
	} 
	public static double answer(String operator, String numberTwo, String numberOne) {
		double result = 0;
		double number1 = Double.parseDouble(numberOne);
		double number2 = Double.parseDouble(numberTwo);
		switch(operator) {
		
		case "+":
			result = number1 + number2;
			break;
				
		case "-":
			result = number1 - number2;
			break;
				
		case "*":
			result = number1 * number2;
			break;
					
		case "/":
			result = number1 / number2;
			break;
		case "^":
			result = Math.pow(number1, number2);
				
		default: 
			System.out.println("Error! Unknown Operator");
			break;
			
		}
		return result;
	}

	

}
