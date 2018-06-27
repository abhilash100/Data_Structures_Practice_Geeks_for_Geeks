package binary_search_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import binary_tree.Node;

public class BST {

	public Node root = null;
	public static int sum = 0;
	
	public Node getRoot() {
		return root;
	}

	private void printNode(Node curr) {
		if(curr != null)
			System.out.print(curr.data + " ");
	}

	public boolean isLeaf(Node curr){	
		if(curr.left == null && curr.right == null)
			return true;
		else 
			return false;
	}
	
	public void insert(int val){
		root = insertRec(root,val);
	}
	
	public Node insertRec(Node curr,int val){
		
		if(curr == null){
			return new Node(val);
			}
		
		if(curr.data > val){
			curr.left = insertRec(curr.left,val);
		}
		else{
			curr.right = insertRec(curr.right,val);
		}
		
		return curr;
	}
	
	public void delete(int val){
		
		if(!binarySearch(root,val)){
			System.out.println("Record not present in the BST");
			return;
		}
		
		deleteRec(root,val);
			
	}
	
	private Node deleteRec(Node curr, int val) {
		
		if(getRec(curr,val) != null){
			
			if(curr.data > val)
				curr.left = deleteRec(curr.left,val);
			else if(curr.data < val)
				curr.right = deleteRec(curr.right,val);
			else{
				if(isLeaf(curr))
					return null;
				else if(curr.left != null)
					return curr.left;
				else if(curr.right != null)
					return curr.right;
				else{
					int newVal= getSmallest(curr.right).data;
					deleteRec(curr.right,newVal);
					curr.data = newVal;
					return curr;
				}
			}
		}
		
		return curr;
	}

	public void inOrder(Node curr){
		
		if(curr == null)
			return;
		
		inOrder(curr.left);
		printNode(curr);
		inOrder(curr.right);
	}
	
	public void preOrder(Node curr){
		
		if(curr == null)
			return;
		
		printNode(curr);
		inOrder(curr.left);
		inOrder(curr.right);
	}
	
	public void postOrder(Node curr){
		
		if(curr == null)
			return;
		
		inOrder(curr.left);
		inOrder(curr.right);
		printNode(curr);
	}

	public ArrayList<Integer> getNodesUtil(Node curr,ArrayList<Integer> al){
		
		if(curr == null)
			return al;
		
		getNodesUtil(curr.left,al);
		al.add(curr.data);
		getNodesUtil(curr.right,al);
		
		return al;
	}
	
	public ArrayList<Integer> getNodes(Node curr){
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		getNodesUtil(curr,al);
		
		return al;
	}
	
	public Node getSmallest(Node curr){
		
		if(curr == null)
			return null;
		
		while(curr.left != null){
			curr = curr.left;
		}
		
		return curr;	
	}
	
	public boolean binarySearch(Node curr,int val){
		
		boolean flag = false;
		
		if(curr == null)
			return flag;
		
		if(curr.data > val)
			flag = binarySearch(curr.left,val);
		else if(curr.data < val)
			flag = binarySearch(curr.right,val);
		else
			flag = true;
		
		return flag;
	}

	public Node getRec(Node curr,int val){
		
		Node node = null;
		
		if(curr == null)
			return node;
		
		if(curr.data > val)
			node = getRec(curr.left,val);
		else if(curr.data < val)
			node = getRec(curr.right,val);
		else
			node = curr;
		
		return node;
	}
		
	public Node bstPreOrder(int[] preOrder){
		Node node = bstPreOrderUtil(preOrder,0,preOrder.length);
		return node;
	}
	
	public Node bstPreOrderUtil(int[] preOrder,int start,int end){
		
		if(start >= preOrder.length)
			return null;

		Node node = new Node(preOrder[start]);
		if(start == end-1)
			return node;
		int rstIndex = -1;
		for(int i = start;i < end;i++){
			if(node.data < preOrder[i]){
				rstIndex = i;
				break;
			}
		}
		
		if(start+1 == rstIndex){
			node.right = bstPreOrderUtil(preOrder,start+1,end);
		}
		else{
			node.left = bstPreOrderUtil(preOrder,start+1,rstIndex);
			node.right = bstPreOrderUtil(preOrder,rstIndex,end);
		}
		
		return node;
	}

	public Node btToBst(Node curr){
		
		if(curr == null)
			return null;
		
		ArrayList<Integer> al = getNodes(curr);;
		
		BST bst = new BST();
		
		for(Integer i : al){
			bst.insert(i);
		}
		
		return bst.getRoot();
	}

	public Node bstToSumBt(Node curr){
		
		sum = 0;
		bstToSumBtUtil(curr,sum);
		return curr;
	}

	private void bstToSumBtUtil(Node curr, int sum2) {

		if(curr == null)
			return;
		
		bstToSumBtUtil(curr.right,sum2);
		sum = sum + curr.data;
		curr.data = sum;
		bstToSumBtUtil(curr.left,sum);
	}

	public Node bstToGreaterSumBt(Node curr){
		
		sum = 0;
		bstToGreaterSumBtUtil(curr);
		return curr;
	}

	private void bstToGreaterSumBtUtil(Node curr) {

		if(curr == null)
			return;
		
		bstToGreaterSumBtUtil(curr.right);
		sum = sum + curr.data;
		curr.data = sum - curr.data;
		bstToGreaterSumBtUtil(curr.left);
	}

	public Node levelOrderBst(int[] levelOrder){ // Complete later
		
		
		Node curr = null;
		int level = 0;
		HashMap<Integer,ArrayList<Integer>> levels = 
				new HashMap<Integer,ArrayList<Integer>>();
		
		for(int i = 0;i < levelOrder.length - 1;i++){
			
			ArrayList<Integer> al;
			if(levels.get(level) == null)
				al = new ArrayList<Integer>();
			else
				al = levels.get(level);
			al.add(levelOrder[i]);
			levels.put(level, al);
			
			if(levelOrder[i] > levelOrder[i+1])
				level++;					
			}
		
		int upper = 0;
		int lower = 1;
		
		while(upper < level){
		ArrayList<Integer> al_upper = levels.get(upper);
		ArrayList<Integer> al_lower = levels.get(lower);
		
		for(int i : al_upper){
			
			Node n = new Node(levelOrder[i]);
			if(i == 0)
				curr = n;
			
			for(int j : al_lower){
				
				if(j < i && n.left == null){
					
				}
				
			}
		}
		
		upper++;
		lower++;
		}
		
		return curr;
		}
		
}

