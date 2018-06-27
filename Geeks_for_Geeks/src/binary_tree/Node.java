package binary_tree;

public class Node{
	public int data;
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

	public Node left;
	public Node right;
	
	public Node(int data){
		this.data = data;
		left = right = null;
	}
}
