package binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;

import javafx.util.Pair;


public class Binary_Tree {

	Node root;
	static int preIndex = 0;
	static int preIndexPostPrint = 0; 
	static boolean[] visit;
	public static int[] postOrderPrint;
	static int prePostTree = 0;
	public ArrayList<Integer> visitprePost;
	public static ArrayList<Pair<Integer,Integer>> nodeSlope;
	public static int preSpecialIndex = 0;
	public int ancestorMatrix[][];
	public static int count = 0;
	
	static boolean[] visitedParetArray[];
	
	public Node getRoot() {
		return root;
	}

	public Binary_Tree(int val){
		root = new Node(val);
		root.left = root.right = null;
	}
	
	/*	Checks if a node is a leaf node or not	*/
	public boolean isLeaf(Node currNode){
		
		if(currNode == null)
			return false;
		
		if(currNode.left == null && currNode.right == null)
			return true;
		else
			return false;
	}
	
	/*	Prints the data of the current Node	*/
	public void printNode(Node node){
		System.out.print(node.data + " ");
	}
	/*	Inorder traversal of tree using recursion	*/
	public void inOrderRecursion(Node currNode){
		if(currNode == null)
			return;
		
		inOrderRecursion(currNode.left);
		System.out.print(currNode.data + " ");
		inOrderRecursion(currNode.right);
		
	}
	/*	Preorder traversal of tree using recursion	*/
	public void preOrderRecursion(Node currNode){
		if(currNode == null)
			return;
		
		System.out.print(currNode.data + " ");
		preOrderRecursion(currNode.left);
		preOrderRecursion(currNode.right);
	}
	/*	Postorder traversal of tree using recursion	*/
	public void postOrderRecursion(Node currNode){
		if(currNode == null)
			return;
		
		postOrderRecursion(currNode.left);
		postOrderRecursion(currNode.right);
		System.out.print(currNode.data + " ");
	}
	/*	Pre order traversal using stack	*/
	public void preOrderStack(Node currNode){
			
		if(currNode == null)
			return;
		
		Stack<Node> st = new Stack<Node>(); 
		st.push(currNode);

		while(!st.isEmpty()){
			Node popNode = st.pop();
			printNode(popNode);
			if(popNode.right != null)
				st.push(popNode.right);
			if(popNode.left != null)
				st.push(popNode.left);
		}
	}
	/*	In order traversal using stack	*/
	public void inOrderStack(Node currNode){
			
		if(currNode == null)
			return;
		
		Stack<Node> st = new Stack<Node>();
		Node node = currNode;
		
		while(node != null){
			st.push(node);
			node = node.left;
		}

		while(!st.isEmpty()){
			
			Node popNode = st.pop();
			printNode(popNode);
			
			if(popNode.right != null){	
				node = popNode.right;
				while(node != null){
					st.push(node);
					node = node.left;
				}	
			}
		}
	}
	/*	In order traversal using Morris traversal(treaded binary trees)	*/
	public void inOrderMorris(Node currNode){
		
		if(currNode == null)
			return;
		
		Node curr = currNode;
		Node prev = null;
		
		while(curr != null){
			if(curr.left == null){
				printNode(curr);
				curr = curr.right;
			}
			else{
				prev = curr.left;
				while(prev.right != null && prev.right != curr)
					prev = prev.right;
				
				if(prev.right == null){
					prev.right = curr;
					curr = curr.left;
				}
				else{
					prev.right = null;
					printNode(curr);
					curr = curr.right;
				}	
			}	
		}
	}
	/*	Pre order traversal using Morris traversal(threaded binary trees)	*/
	public void preOrderMorris(Node currNode){
		
		if(currNode == null)
			return;
		
		while(currNode != null){
			if(currNode.left == null){
				printNode(currNode);
				currNode = currNode.right;
			}
			else{	
				Node curr = currNode.left;
				while(curr.right != null && curr.right != currNode)
					curr = curr.right;
				
				if(curr.right == null){
					curr.right = currNode;
					printNode(currNode);
					currNode = currNode.left;
				}
				else{
					curr.right = null;
					currNode = currNode.right;
				}
			}
		}	
	   }
	/*	Post order traversal using two stacks	*/
	public void postOrderTwoStack(Node currNode){ 		
		
		if(currNode == null)
			return;
		
		Stack<Node> st1 = new Stack<Node>();
		Stack<Node> st2 = new Stack<Node>();
		st1.push(currNode);
		
		while(!st1.isEmpty()){
			Node popNode = st1.pop();
			st2.push(popNode);
			if(popNode.left != null)
				st1.push(popNode.left);
			if(popNode.right != null)
				st1.push(popNode.right);
		}
		while(!st2.isEmpty())
			printNode(st2.pop());
	}
	/*	Post order travrsal using single stack*/
	public void postOrderOneStack(Node currNode){	// TODO : To be reviewed later	
		// Copied from Geeks for Geeks. Slightly complex
		
		if(currNode == null)
			return;
		
		Stack<Node> st = new Stack<Node>();
		st.push(currNode);
		Node prev = null;
		
		while(!st.isEmpty()){
			
			Node curr = st.peek();
			if(prev == null || prev.left == curr || prev.right == curr){
				if(curr.left != null)
                    st.push(curr.left);
                else if(curr.right != null)
                    st.push(curr.right);
                else
                {
                    st.pop();
                    printNode(curr);
                }
			}

            else if(curr.left == prev){
                if (curr.right != null)
                    st.push(curr.right);
                else{
                    st.pop();
                    printNode(curr);
                }
            } 
            else if(curr.right == prev){
                st.pop();
                printNode(curr);
            }
            prev = curr;
        }	
	  }
	/*	Level order traversal using queue	*/
	public void levelOrderQueue(Node currNode){
		
		if(currNode == null)
			return;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(currNode);
		
		while(!q.isEmpty()){
			Node removedNode = q.poll();
			printNode(removedNode);
			
			if(removedNode.left != null)
				q.add(removedNode.left);
			if(removedNode.right != null)
				q.add(removedNode.right);
		}
	}
	/*	Reverse Level order traversal using queue	*/
	public void reverseLevelOrder(Node currNode){
		
		if(currNode == null)
			return;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(currNode);
		Stack<Node> st = new Stack<Node>();
		
		while(!q.isEmpty()){
			Node removedNode = q.poll();
			st.push(removedNode);
			
			if(removedNode.left != null)
				q.add(removedNode.left);
			if(removedNode.right != null)
				q.add(removedNode.right);
		}
	
	while(!st.isEmpty()){
		Node popNode = st.pop();
		if(popNode != null)
			printNode(popNode);
		else
			System.out.println();
	}
   }
	/*	Constructing tree when preOrder and irOrder traversals are given	*/
	public static Node preInTree(int[] preOrder,int[] inOrder,int start,int end){
		
		if(start > end)
			return null;
		
		int rootVal = preOrder[preIndex];
		preIndex++;
		int inOrderIdx = 0;
		Node root = new Node(rootVal);		
		
		if(start == end)
			return root;
		
		for(int i = start;i < end;i++){
			if(rootVal == inOrder[i]){
				inOrderIdx = i;
				break;
			}
		}
		
		root.left = preInTree(preOrder,inOrder,start,inOrderIdx - 1);
		root.right = preInTree(preOrder,inOrder,inOrderIdx + 1,end);
				
		return root;
	}
	/*	Prints out post order traversal using preOrder and inOrder	*/
	public static void preInPost(int[] preOrder,int[] inOrder,int start,int end){
		
		if(start > end)
			return;
		
		if(preIndexPostPrint < inOrder.length){
		int rootVal = preOrder[preIndexPostPrint];
		preIndexPostPrint++;
		int inOrderIdx = 0;
		
		for(int i = start;i <= end;i++){
			if(rootVal == inOrder[i]){
				inOrderIdx = i;
				break;
			}
		}
		
		if(start == end){
			System.out.print(rootVal + " ");
			return;	
		}
		
			preInPost(preOrder,inOrder,start,inOrderIdx - 1);
			preInPost(preOrder,inOrder,inOrderIdx + 1,end);

		System.out.print(rootVal + " ");
		}
	}
	/*	Utility method used to print out diagonal traversl of binary tree	*/
	public void diagonalTraversal(Node currNode, int d, HashMap<Integer
			,ArrayList<Integer>> diagonalElements){
		
		if(currNode == null)
			return;
		
		if(diagonalElements.get(d) == null){
			ArrayList<Integer> al = new ArrayList<Integer>();
			al.add(currNode.data);
			diagonalElements.put(d, al);
		}
		else{
			diagonalElements.get(d).add(currNode.data);
		}
		
		//ArrayList<Integer> a = diagonalElements.get(d);
		diagonalTraversal(currNode.right,d,diagonalElements);
		diagonalTraversal(currNode.left,d+1,diagonalElements);
	}
	/*	Prints out diagonal traversal of the binary tree	*/
	public void printDiagonal(Node currNode){
	
		if(currNode== null)
			return;
		
		HashMap<Integer,ArrayList<Integer>> diagonalElements = 
				new HashMap<Integer,ArrayList<Integer>>();
		
		diagonalTraversal(currNode,0,diagonalElements);
		
		for(Integer i : diagonalElements.keySet()){
			for(Integer j : diagonalElements.get(i)){
				System.out.print(j + " ");
			}				
			System.out.println();
		}
		
	}
	/*	TODO : Must review and remove this method	*/
	public void diagonalTraversalBkp(Node currNode){
		
		if(currNode == null)
			return;
		
		Stack<Node> st = new Stack<Node>();
		
		while(currNode != null || !st.isEmpty()){
			
			if(currNode != null){
				printNode(currNode);
				Node leftNode = null;
				if(currNode.left != null)
					leftNode = currNode.left;
				if(leftNode != null){
					st.push(leftNode);
					leftNode = leftNode.left;

			}
			currNode = currNode.right;
			}
			if(currNode == null){
				System.out.println();
				while(!st.isEmpty()){
					Node popNode = st.pop();
					printNode(popNode);
					currNode = popNode.left;
				}
				System.out.println();
			}
		}
	}
	/*	Prints out all the leaf Nodes. 
	 * Traverses all nodes but only prints out the leaf nodes	*/
	public void leafTraversal(Node currNode){
		
		if(currNode == null)
			return;
			
		Stack<Node> st = new Stack<Node>();
		Node node = currNode;
		
		while(node != null){
			st.push(node);
			node = node.left;
		}
		
		while(!st.isEmpty()){
			
			Node popNode = st.pop();
			if(isLeaf(popNode))
				printNode(popNode);
			
			if(popNode.right != null){	
				node = popNode.right;
				while(node != null){
					st.push(node);
					node = node.left;
				}	
			}
		}
		
	}
	/*	Does level order traversal of the binary tree.
	 * Prints each level of nodes in a different line	*/
	public void levelOrder(Node currNode){
		
		if(currNode == null)
			return;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(currNode);
		q.add(null);
		
		while(!q.isEmpty()){
			Node removedNode = q.poll();
				
			if(removedNode != null){
				printNode(removedNode);
				if(removedNode.left != null)
					q.add(removedNode.left);
				if(removedNode.right != null)
					q.add(removedNode.right);
				}
			else{
				System.out.println();
				if(q.isEmpty())
					return;
				q.add(null);
			}	
		}	
	}
	/*	Prints out vertical level traversal of the binary tree.
	 * Prints each vertical level of nodes on a different line	*/
	public void verticalOrder(Node currNode){
		
		if(currNode == null)
			return;
		
		HashMap<Integer,ArrayList<Integer>> horizontalDistance = new HashMap<Integer,ArrayList<Integer>>();	
		int hd = 0;
		
		getVerticalOrder(horizontalDistance,hd,currNode);
		
		for(Entry<Integer, ArrayList<Integer>> entry : horizontalDistance.entrySet()){
			System.out.println(entry.getValue());
		}
	}
	/*	Utility method for vertical level traversal	*/
	public void getVerticalOrder(HashMap<Integer,ArrayList<Integer>> horizontalDistance,int hd,Node currNode){

		if(currNode == null)
			return;
		
		ArrayList<Integer> list = horizontalDistance.get(hd);
		
		if(list == null)
			list = new ArrayList<Integer>();
		
		list.add(currNode.data);
		
		horizontalDistance.put(hd, list);
		
		getVerticalOrder(horizontalDistance,hd - 1,currNode.left);
		getVerticalOrder(horizontalDistance,hd + 1,currNode.right);
	}
	/*	Prints out the leaves of the binary tree	*/
	public void printLeaves(Node currNode){
		
		if(currNode == null)
			return;

		printLeaves(currNode.left);
		if(currNode.left == null && currNode.right == null)
			printNode(currNode);
		printLeaves(currNode.right);
		
	}
	/*	Utility method used for boundar traversal	*/
	public void printLeftBoundary(Node currNode){
		
		if(currNode == null)
			return;
		
		if(currNode.left != null){
			printNode(currNode);
			printLeftBoundary(currNode.left);
		}
		else if(currNode.right != null){
			printNode(currNode);
			printLeftBoundary(currNode.right);
		}
	}
	/*	Utility method used for boundar traversal	*/
	public void printRightBoundary(Node currNode){
		
		if(currNode == null)
			return;
		
		if(currNode.right != null){
			printRightBoundary(currNode.right);
			printNode(currNode);
		}
		else if(currNode.left != null){
			printNode(currNode);
			printRightBoundary(currNode.left);
		}
		
	}
	/*	Prints out the boundary traversal of the binary tree	*/
	public void printBoundary(Node currNode){
		
		if(currNode == null)
			return;
		
		printLeftBoundary(currNode);
		printLeaves(currNode);
		printRightBoundary(currNode);

	}
	/*	Returns the root node of constructed binary tree	
	 * 	Binary tree is constructed using level and in order traversal	*/
	public Node inLevelTree(Node currNode,int[] inOrder,int[] levelOrder,int start,int end){
		
		if(start > end)
			return null;
		
		if(start == end)
			return new Node(inOrder[start]);
		
		int index = 0;
		boolean found = false;
		
		for(int i = 0;i < levelOrder.length - 1;i++){
			int data = levelOrder[i];
			
			for(int j = start;j < end;j++){
				if(data == inOrder[j]){
					currNode = new Node(data);
					found = true;
					index = j;
					break;
				}
			}
			if(found)
				break;
		}
		
		currNode.left = inLevelTree(currNode,inOrder,levelOrder,start,index - 1);
		currNode.right = inLevelTree(currNode,inOrder,levelOrder,index + 1,end);
		
		return currNode;
		
	}
	/*	Method used to initialize the inLevel tree method
	 * 	TODO : Try and remove this	*/
	public Node inLevelConstructTree(int[] inOrder,int[] levelOrder){
		Node currNode = null;
		return inLevelTree(currNode,inOrder,levelOrder,0,inOrder.length - 1);
	}
	/*	Method used to construct binary tree using preOrder 
	 * and postOrder traversals.	
	 * TODO : Resolve bug. Not working correctly	*/
	public Node prePostConstructFullTree(int[] preOrder, int[] postOrder){
		return prePostTree(preOrder,postOrder,preOrder.length - 1,preOrder.length);
	}
	/*	Recursive method used to construct binary tree from 
	 * 	pre and post order traversals	*/
	private Node prePostTree(int[] preOrder, int[] postOrder,int l,int r) {

		if(prePostTree >= preOrder.length || l > r)
			return null;
		
		Node root = new Node(preOrder[prePostTree]);
		prePostTree++;
		
		if(l == r || prePostTree >= preOrder.length)
			return root;
		
		int postIndex = 0;
		for(int i = 0;i < preOrder.length;i++){
			if(postOrder[i] == preOrder[prePostTree]){
				postIndex = i;break;
			}
		}
		if(postIndex < r){
			root.left = prePostTree(preOrder,postOrder,1,postIndex);
			root.right = prePostTree(preOrder,postOrder,postIndex + 1,r);
		}
		
		return root;
	}
	/*	Special tree is a binary tree where each node has 0 or 2 children	
	 * 	This method constructs a binary tree based on the preOrder traversal and 
	 * 	whether the node is a leaf of not*/
	public Node preOrderSpecialTree(int[] preOrder,char[] leafNotLeaf){
		
	Node root =  new Node(preOrder[preSpecialIndex]);
	
	if(leafNotLeaf[preSpecialIndex] == 'L' || preSpecialIndex >= preOrder.length){
		preSpecialIndex++;
		return root;
	}
	preSpecialIndex++;
	
	root.left = preOrderSpecialTree(preOrder,leafNotLeaf);
	root.right = preOrderSpecialTree(preOrder,leafNotLeaf);
	return root;
	}
	/*	Counts the number of nodes in the binary tree	*/
	public int countNodes(Node currNode){

		if(currNode != null){
			countNodes(currNode.left);
			count++;
			countNodes(currNode.right);
		}
		else 
			return 0;
		
		return count;
		
	}
	/*	Method used to create ancestor matrix from binary tree	*/
	public void ancestorMatrixFromTree(Node currNode){
		
		if(currNode == null)
			return;
		
		int size = countNodes(currNode);
		ancestorMatrix = new int[size][size];
		
		for(int i = 0;i < size;i++){
			for(int j = 0;j < size;j++){
				ancestorMatrix[i][j] = 0;
			}
		}
		
		ArrayList<Integer> rootAnces = new ArrayList<Integer>();
		rootAnces.add(currNode.data - 1);
		
		ancestorCreate(currNode,rootAnces);
 	}
	/*	Utility method to used to create ancestor matrix	*/
	public void ancestorCreate(Node currNode,ArrayList<Integer> ances){
		
		if(currNode == null)
			return;
		
		ArrayList<Integer> newances = new ArrayList<Integer>();
		newances.addAll(ances);
		
		newances.add(currNode.data - 1);
		
		for(Integer i : ances){
			ancestorMatrix[i][currNode.data - 1] = 1;
		}
		
		ancestorCreate(currNode.left,newances);
		ancestorCreate(currNode.right,newances);
		
	}
	/*	Prints out the ancestor matrix	*/
	public void printAncestorMatrix(){
		
		for(int i =0;i < ancestorMatrix.length;i++){
			for(int j = 0;j < ancestorMatrix.length;j++){
				System.out.print(ancestorMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	/*	Constructs a tree from the ancestor matrix	
	 * TODO : Review later*/
	public Node ancestorToTree(int[][] ancestor){
		
		int size = ancestor[0].length;
		int[] ancestorCount = new int[size];
		Node[] nodeArray = new Node[size]; 
		int[] noOfAncestors = new int[size];
		int depth = 0;
		HashMap<Integer,ArrayList<Integer>> levelNode = 
				new HashMap<Integer,ArrayList<Integer>>();
		
		Node root = null;
		
		for(int i = 0;i < ancestor.length;i++){
			ancestorCount[i] = 0;
			noOfAncestors[i] = 0;
		}
		
		
		for(int i = 0;i < ancestor.length;i++){
			for(int j = 0;j < ancestor.length;j++){
				noOfAncestors[i] += ancestor[j][i];
			}
		}
		
		for(int i = 0;i < ancestor.length;i++){
			ArrayList<Integer> al;
			
			if(noOfAncestors[i] > depth)
				depth = noOfAncestors[i];
			
			if(levelNode.get(noOfAncestors[i]) == null){
				al = new ArrayList<Integer>();
				al.add(i);
				levelNode.put(noOfAncestors[i], al);
			}
			else{
				levelNode.get(noOfAncestors[i]).add(i);
			}
		}
		
		for(int i = 0;i < size;i++){
			nodeArray[i] = new Node(i);
		}
		
		root = nodeArray[levelNode.get(0).get(0)];
		int upper = 0;
		int lower = 1;
		
		while(upper < depth){
			
			for(Integer i : levelNode.get(upper)){
				
				ArrayList<Integer> al = levelNode.get(lower);
				
				for(Integer k : al){
					if(ancestor[i][k] == 1 && nodeArray[i].left != null){
						nodeArray[i].right = nodeArray[k];
						
					}
					else if(ancestor[i][k] == 1)
						nodeArray[i].left = nodeArray[k];
				}
			}
			upper++;
			lower++;
		}
		
		return root;
	}
	/*	Special tree is a binary tree where each node has 0 or 2 children	
	 * 	Inorder traversal data is used toconstruct a special tree. 
	 * 	The root of the tree is returned	*/
	public Node inOrderSpecialTree(int[] inOrder,int start,int end){
		
		int max = inOrder[start];
		int maxIndex = start;
		
		for(int i = start;i < end;i++){
			if(max < inOrder[i]){
				max = inOrder[i];
				maxIndex = i;
			}
		}
		
		Node node = new Node(max);
		
		if(start == end){
			return node;
			}
		if(start > end)
			return null;
		
		
		node.left = inOrderSpecialTree(inOrder,start,maxIndex-1);
		node.right = inOrderSpecialTree(inOrder,maxIndex+1,end);

		return node;
		
	}
	/*	Initializes special tree creation from inorder traversal	*/
	public Node inOrderSpecialInitialize(int[] inOrder){
		
		int size = inOrder.length;
		Node root = inOrderSpecialTree(inOrder,0,size-1);
		
		return root;
	}
	/*	Utility method used to create binary tree from parent array	*/
	public Node parentArrayToTree(int[] parent, Node root){
		
		int rootVal = root.data;
		int count = 0;
		int left = -1;
		int right = -1;
		
		for(int i = 0;i < parent.length;i++){
			if(rootVal == parent[i] && left == -1){
				count++;
				left = i;
			}
			else if(rootVal == parent[i]){
				count++;
				right = i;
			}
		}
		
		if(left != -1){
			root.left = new Node(left);
			parentArrayToTree(parent,root.left);
		}
		if(right != -1){
			root.right = new Node(right);
			parentArrayToTree(parent,root.right);
		}
		
		return root;
		
	}
	/*	Method used to create a binary tree from parent array representation	*/
	public Node parentArrayToTreeInitialize(int[] parent){
		
		int rootVal = 0;
		
		for(int i = 0;i < parent.length;i++){
			if(parent[i] == -1){
				rootVal = i;
				break;
			}
		}
		
		Node root = new Node(rootVal);
		parentArrayToTree(parent,root);
		
		return root;
	}
	
	public Node toThreaded(Node currNode){	// TODO :	Review and test later
		
		Stack<Node> stack = new Stack<Node>();
		Queue<Node> q = new LinkedList<Node>();
		
		Node root = currNode;
		
		while(currNode != null){
			stack.push(currNode);
			currNode = currNode.left;
		}
		
		while(!stack.isEmpty()){
			Node removedNode = stack.pop();
			q.add(removedNode);
			printNode(removedNode);
			if(removedNode.right != null){
				removedNode = removedNode.right;
				while(removedNode != null){
					stack.push(removedNode);
					removedNode = removedNode.left;
				}
			}
		}
		
		while(root != null){
			stack.push(root);
			q.poll();
			root = root.left;
		}
		
		while(stack.isEmpty()){
			Node removedNode = stack.pop();
			if(removedNode.right != null){
				removedNode = removedNode.right;
				while(removedNode != null){
					stack.push(removedNode);
					q.poll();
					removedNode = removedNode.left;
				}
			}
			if(removedNode.right == null){
				removedNode.right = q.peek(); 
			}

		}
		return currNode;
	}
	/*	Finds path from the root to the given node	*/
	public ArrayList<Integer> findPathFromRoot(Node root,int nodeVal){
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		if(nodePresent(root,nodeVal)){
			path.add(root.data);
			while(root.data != nodeVal){
				if(nodePresent(root.left,nodeVal)){
					path.add(root.left.data);
					root = root.left;
				}
				else if(nodePresent(root.right,nodeVal)){
					path.add(root.right.data);
					root = root.right;
				}
			}
			return path;
		}
		else{
			System.out.println("ERROR : Node not present");
			return path;
		}
	}
	/*	Method is used to check whether the data point(nodeVal) 
	 * 	is present in the binary tree*/
	public boolean nodePresent(Node root,int nodeVal){
		
		boolean present = false;
		boolean leftpresent = false;
		boolean rightpresent = false;
		
		if(root == null)
			return false;
		
		if(root.data != nodeVal){
			if(root.left != null)
				leftpresent = nodePresent(root.left,nodeVal);
			if(root.right != null)
				rightpresent = nodePresent(root.right,nodeVal);
		}
		else{
			present = true;
		}
		
		if(!present){
			present = rightpresent || leftpresent;
		}
		
		return present;
	}
	/*	Finds Least Common Ancestor(LCA) of two Nodes	*/
	public int findLCA(Node root,int a,int b){
		
		int LCA = root.data;
		
		if(nodePresent(root, a) && nodePresent(root, b)){
			
			ArrayList<Integer> ala = new ArrayList<Integer>();
			ala = findPathFromRoot(root, a);
			
			ArrayList<Integer> alb = new ArrayList<Integer>();
			alb = findPathFromRoot(root, b);
			
			for(Integer i : ala){
				if(alb.contains(i))
					LCA = i;
				}
			return LCA;	
		}
		else
			return -1;
	}
	/*	Finds the minimum distance between two nodes in the tree*/
	public int distTwoNodes(Node root,int a, int b){
		
		int dist = 0;
		int LCA = 0;
		
		if(nodePresent(root, a) && nodePresent(root, b)){
			
			ArrayList<Integer> ala = new ArrayList<Integer>();
			ala = findPathFromRoot(root, a);
			ArrayList<Integer> alb = new ArrayList<Integer>();
			alb = findPathFromRoot(root, b);
		
			LCA = findLCA(root,a,b);
			dist = ala.size() + alb.size() - 2;
		
			int count1 = 0;
			for(Integer i : ala){
				if(i == LCA)
					break;
				count1++;
			}
			dist = dist - count1;
		
			count1 = 0;
			for(Integer i : alb){
				if(i == LCA)
					break;
				count1++;
			}
		
		}
		else 
			return -1;
		
		return dist;
	}
}

	
	

