package binary_tree;

/*	Node class defines a small element of a binary tree.
 * 	It has a integer data value and left and right nodes.*/
public class Node{
	
	public int data;
	public Node left;
	public Node right;
	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node(int data){
		this.data = data;
		left = right = null;
	}
}
