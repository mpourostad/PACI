/** Node for a binary tree **/
// this is the code from the class website. I just changed the element type to string so I can add space between the characters. 
public class Node {
	
	public String element;
	
	public Node leftChild;
	public Node rightChild;
	
	public Node (String o) {
		this (o, null, null);
	}
	
	public Node (String o, Node l, Node r) {
		element = o + " ";
		leftChild = l;
		rightChild = r;
	}
	
	public String toString() {
		return element.toString();
	}
}

