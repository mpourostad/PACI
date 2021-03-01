public class Converter {
	private String command;
	private List<String> parsed;
	private ArrayStack<String> operator = new ArrayStack<>();
	public Converter(String command) {
		this.command = command;
		this.parsed = parse(commandInChar());
	}
	public boolean isOperator(int i) {
		if (parsed.get(i).equals("+") || parsed.get(i).equals("-")
			||parsed.get(i).equals("*") || parsed.get(i).equals("/")
			|| parsed.get(i).equals("^") || parsed.get(i).equals("(")
			|| parsed.get(i).equals(")")) {
			return true;
		}
		else {
			return false;
		}
	}
	public static List<String> parse(char[] input) {
	    List<String> parsed = new ArrayList<String>();
	    for (int i = 0; i < input.length; i++) {
	        char c = input[i];
	        if (Character.isDigit(c)) {
	            String number = input[i] + "";
	            for (int j = i + 1; j < input.length; ++j) {
	                if (Character.isDigit(input[j])) {
	                    number += input[j];
	                    i = j;
	                } 
	                else {
	                    break;
	                }
	            }
	            parsed.add(number);
	        } else if (c == '*' || c == '/' || 
	                   c == '+' || c == '^' || 
	                   c == '-' || c == '(' || c == ')') {
	            parsed.add(c + "");
	        }
	    }
	    return parsed;
	}

	public char[] commandInChar() {
		char [] answer = new char[command.length()];
		for (int i = 0; i < command.length(); i++) {
			answer[i] = command.charAt(i);
		}
		return answer;
	}
	public String toPostFix() {
		String number = "";
		String garbage = "";
		for (int i = 0; i < parsed.size(); i++) {
			if (isOperator(i) == false){ 			
				number += parsed.get(i) + " ";
			}
			else {
				if (operator.isEmpty()) {
					operator.push(parsed.get(i));
				}
				else if (parsed.get(i).equals("(")) {
					operator.push(parsed.get(i));
				}
				else if (parsed.get(i).equals(")")) {
					while(!operator.top().equals("(")) {
						number += operator.pop() + " ";
					}
					garbage = operator.pop();
				}
				else if (!parsed.get(i).equals("(") && !parsed.get(i).equals(")") && prec(parsed.get(i)) > prec(operator.top())) {
					operator.push(parsed.get(i));
				}
				else {
					while(operator.isEmpty() == false && prec(operator.top()) >= prec(parsed.get(i))) {
						number += operator.pop() + " ";
					}
					operator.push(parsed.get(i));
				}
			}			
		}
		while(operator.isEmpty() == false) {
			number += operator.pop() + " ";
		}
		return number;
	}
	public static int prec(String opr){
        switch (opr){ 
        case "+": 
        case "-": 
            return 1; 
       
        case "*": 
        case "/": 
            return 2; 
       
        case "^": 
            return 3; 
        }
        return -1; 
    } 
	public String toString() {
		return "Converted to postFix: " + toPostFix(); 
	}
	public List<String> getInChar() {
		return parsed;
	}
	
}	