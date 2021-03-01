import java.util.Scanner;
public class ExpressionTreeExe {
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			System.out.println("type your infix expression: ");
			String input = in.nextLine();
			Converter convert = new Converter(input);
			System.out.println(convert);
			System.out.println();
			
			DoublyLinkedList<String> list1 = convert.toPostFix();
			DoublyLinkedList<String> list2 = convert.toPostFix();
			DoublyLinkedList<String> list3 = convert.toPostFix();
			ArrayStack<String> operation1 = stackBuilder(list1);
			ArrayStack<String> operation2 = stackBuilder(list2);
			ArrayStack<String> operation3 = stackBuilder(list3);
			
			ArrayStack<Node> tree1 = convert(operation1);
			System.out.print("Prefix: ");
			prefix(tree1.pop());
			System.out.println();
			ArrayStack<Node> tree2 = convert(operation2);
			System.out.println();
			System.out.print("infix: ");
			infix(tree2.pop());
			System.out.println();
			ArrayStack<Node> tree3 = convert(operation3);
			System.out.println();
			System.out.print("postfix: ");
			postfix(tree3.pop());
 			
		}
		public static ArrayStack<String> stackBuilder(DoublyLinkedList<String> list){
			ArrayStack<String> operation = new ArrayStack<>();
			while(list.isEmpty() == false) {
				for (int i = 0; i < list.size(); i++) {
					operation.push(list.removeLast());
				}
			}
			return operation;
		}
		public static void prefix(Node t) {
			if(t != null) {
				
				System.out.print(t);
				prefix(t.leftChild);
				prefix(t.rightChild);
			}	
		}
		public static void infix(Node t)
		{	
			if(t != null)
			{
				if(isDouble(t.element)) {
					infix(t.leftChild);
					System.out.print(t);
					infix(t.rightChild);
				}
				else {
					System.out.print("(");
					infix(t.leftChild);
					System.out.print(t);
					infix(t.rightChild);
					System.out.print(")");
				}
			}
		}		
		public static void postfix(Node t)
		{
			if(t != null)
			{
				postfix(t.leftChild);
				postfix(t.rightChild);
				System.out.print(t);
			}
		}
		public static boolean isDouble( String input ) {
		    try {
		        Double.parseDouble( input );
		        return true;
		    }
		    catch( Exception e ) {
		        return false;
		    }
		}
		public static ArrayStack<Node> convert(ArrayStack<String> stack) {
			ArrayStack<Node> tree = new ArrayStack<>();
			while(stack.isEmpty() == false) {
				if(isDouble(stack.top())) {
					Node number1 = new Node(stack.pop());
					tree.push(number1);
				}
				else {
					Node right = tree.pop();
					Node left = tree.pop();
					Node operator = new Node(stack.pop(), left, right);
					tree.push(operator);
					if (stack.isEmpty()) {
						break;
					}	
				}
			}
			return tree;			
		}
		public static ArrayStack<Node> convertInfix(ArrayStack<String> stack) {
			ArrayStack<Node> tree = new ArrayStack<>();
			while(stack.isEmpty() == false) {
				if(isDouble(stack.top())) {
					Node number1 = new Node(stack.pop());
					tree.push(number1);
				}
				else {
					Node right = tree.pop();
					Node left = tree.pop();
					Node operator = new Node( stack.pop(), left, right);
					tree.push(operator);
					if (stack.isEmpty()) {
						break;
					}	
				}
			}
			return tree;			
		}
}
