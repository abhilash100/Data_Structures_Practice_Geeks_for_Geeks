package main_package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import binary_search_tree.BST;
import binary_tree.Binary_Tree;
import binary_tree.Node;
import hashTables.hashFunctions;
import javafx.util.Pair;
import linkedlist.LinkedList;
import sorting_algos.sortingAlgos;
import stack_algo.Stack_Algo;
import string_algos.stringAlgos;

/*
 * Project developed by Abhilash Chivukula
 * Has the implementation of the most common data structures and the algorithms 
 * pertaining to them*/
public class MainClass {
public static void main(String args[]){

	string_algos();
	stack_test();
	sorting_algos();
	hash_test();
	linkedList_test();
}

public static void bst_test(){
	
//	BST bst = new BST();
//	
//	bst.insert(30);
//	bst.insert(40);
//	bst.insert(8);
//	bst.insert(6);
//	bst.insert(45);
//	bst.insert(15);
	
//	bst.delete(6);
//	bst.delete(40);
//	bst.inOrder(bst.getRoot());
//	System.out.println(bst.binarySearch(bst.getRoot(), 5));
	
//	int[] preOrder = {10,5,1,7,40,50};
//	bst.inOrder(bst.bstPreOrder(preOrder));
	
//	bst.inOrder(bst.bstToSumBt(bst.getRoot()));
	
//	bst.inOrder(bst.bstToGreaterSumBt(bst.getRoot()));
	
//	int[] levelOrder = {7, 4, 12, 3, 6, 8, 1, 5, 10}; 
//	bst.levelOrderBst(levelOrder);
	
//	Binary_Tree bt = new Binary_Tree(1);
//	bt.getRoot().setLeft(new Node(2));
//	bt.getRoot().setRight(new Node(3));
//	bt.getRoot().getLeft().setLeft(new Node(4));
//	bt.getRoot().getLeft().setRight(new Node(5));
//	bt.getRoot().getLeft().getLeft().setLeft(new Node(6));
//	bt.getRoot().getLeft().getRight().setRight(new Node(7));
//	bt.getRoot().getRight().setLeft(new Node(8));
//	bt.getRoot().getRight().setRight(new Node(9));
//	
//	bst.preOrder(bst.btToBst(bt.getRoot()));
	
}

public static void binaryTree_test(){
	
	Binary_Tree bt = new Binary_Tree(1);
	bt.getRoot().setLeft(new Node(2));
	bt.getRoot().setRight(new Node(3));
	bt.getRoot().getLeft().setLeft(new Node(4));
	bt.getRoot().getLeft().setRight(new Node(5));
	bt.getRoot().getLeft().getLeft().setLeft(new Node(6));
	bt.getRoot().getLeft().getRight().setRight(new Node(7));
	bt.getRoot().getRight().setLeft(new Node(8));
	bt.getRoot().getRight().setRight(new Node(9));
	
//	System.out.print("InOrder : ");
//	bt.inOrderRecursion(bt.getRoot());
//	System.out.print("\nPreOrder : ");
//	bt.preOrderRecursion(bt.getRoot());
//	System.out.print("\nPostOrder : ");
//	bt.postOrderRecursion(bt.getRoot());
	
//	System.out.print("InOrderMorris : ");
//	bt.inOrderMorris(bt.getRoot());
//	
//	System.out.print("PreOrderMorris : ");
//	bt.preOrderMorris(bt.getRoot());
	
//	System.out.println("Post Order Two Stack");
//	bt.postOrderTwoStack(bt.getRoot());
	
//	System.out.println("Post Order One Stack");
//	bt.postOrderOneStack(bt.getRoot());
	
//	System.out.println("Level Order Traversal : ");
//	bt.levelOrder(bt.getRoot());
	
//	System.out.println("Reverse Level Order Traversal : ");
//	bt.reverseLevelOrder(bt.getRoot());
	
//	int inOrder[] = {6,4,2,5,7,1,8,3,9};
//	int preOrder[] = {1,2,4,6,5,7,3,8,9};
	
//	Binary_Tree.preInPost(preOrder, inOrder, 0, inOrder.length - 1);
//	for(int i = 0;i < Binary_Tree.postOrderPrint.length;i++)
//		System.out.print(Binary_Tree.postOrderPrint[i] + " ");
	
//	Node node = Binary_Tree.preInTree(preOrder, inOrder, 0, inOrder.length - 1);
//	bt.preOrderStack(node);
	
//	System.out.println("PreInPost : ");
//	Binary_Tree.preInPost(preOrder, inOrder, 0, inOrder.length - 1);
	
//	System.out.println("Diagonal Traversal : ");
//	bt.printDiagonal(bt.getRoot());
	
//	System.out.println("Leaf Traversal : ");
//	bt.leafTraversal(bt.getRoot());
	
//	System.out.println("Vertical Order Traversal : ");
//	bt.verticalOrder(bt.getRoot());
	
//	System.out.println("Boundary Traversal : ");
//	bt.printBoundary(bt.getRoot());
	
//	  int in[] = {4, 8, 10, 12, 14, 20, 22};
//    int level[] = {20, 8, 22, 4, 12, 10, 14};
//	
//      bt.inOrderRecursion(bt.inLevelConstructTree(in, level));
	
//	int pre[] = {1,2,4,6,5,7,3,8,9};
//	int post[] = {6,4,7,5,2,8,9,3,1};
//	
//	bt.preOrderRecursion(bt.prePostConstructFullTree(pre,post));
	
//	int pre[] = {1,2,4,6,7,5,8,9,3};
//	char preLN[] = {'N','N','N','L','L','N','L','L','L'};
//	
//	bt.preSpecialIndex = 0;
//	bt.preOrderRecursion(bt.preOrderSpecialTree(pre,preLN));
	
//	System.out.println(bt.countNodes(bt.getRoot()));
	
//	bt.ancestorMatrixFromTree(bt.getRoot());
//	bt.printAncestorMatrix();
	
//	int[][] ancestorMatrix = {{0, 1, 1, 1, 1, 1, 1, 1, 1}, 
//	{0,0,0,1,1,1,1,0,0}, 
//	{0,0,0,0,0,0,0,1,1},
//	{0,0,0,0,0,1,0,0,0}, 
//	{0,0,0,0,0,0,1,0,0}, 
//	{0,0,0,0,0,0,0,0,0}, 
//	{0,0,0,0,0,0,0,0,0},  
//	{0,0,0,0,0,0,0,0,0},  
//	{0,0,0,0,0,0,0,0,0} };
//	
//	bt.preOrderRecursion(bt.ancestorToTree(ancestorMatrix));
	
//	int[] inOrder1 = {1,5,10,40,30,15,28,20};
//	bt.inOrderRecursion((bt.inOrderSpecialInitialize(inOrder1)));
	
//	int[] parentArray = {1,5,5,2,2,-1,3};
//	bt.inOrderRecursion(bt.parentArrayToTreeInitialize(parentArray));
	
//	bt.inOrderRecursion(bt.toThreaded(bt.getRoot()));
	
//	System.out.println(bt.nodePresent(bt.getRoot(), 6));
	
//	ArrayList<Integer> al = new ArrayList<Integer>();
//	al = bt.findPathFromRoot(bt.getRoot(), 6);
	
//	for(Integer i : al){
//		System.out.print(i + " ");
//	}
	
//	System.out.println(bt.findLCA(bt.getRoot(), 9, 6));
	
//	System.out.println(bt.distTwoNodes(bt.getRoot(), 1, 6));
	
}

public static void linkedList_test(){
	
	LinkedList ll = new LinkedList();
	LinkedList l = new LinkedList();
	l.pushAtStart(62);
	l.pushAtStart(452);
	l.pushAtStart(879);
	ll.pushAtStart(9);
	ll.pushAtStart(56);
	ll.pushAtStart(5686);
	ll.pushAtEnd(5);
	ll.pushAtEnd(6);
	ll.pushAtEnd(949494);
	try {
		ll.pushAtN(2,2);
		ll.deleteAtN(3);
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		ll.swap(2,3);
		ll.mergeList(l);
		//System.out.println(ll.getMiddle(ll.head).data);
		System.out.println("Search value : " + ll.search(949494));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//System.out.println("Size : " + ll.getSize());
	//ll.deleteFirst();
	//ll.deleteLast();
	//System.out.println("Size : " + ll.getSize());
	//ll.printList();	
}

public static void stack_test(){
	Stack_Algo stack_algo = new Stack_Algo();
	
//	System.out.println(("(a+b)*(c+d)-f+g*k"));
//	System.out.println(stack_algo.infixToPostfix("(a+b)*(c+d)-f+g*k"));
//	System.out.println(stack_algo.balancedExpr("(a+b)*(c+d)-f+g*[{]}k"));
	
//	int price[] = {100,80,60,70,60,75,85};
//	int[] span = (stack_algo.stockSpan(price));
//	for(int i = 1;i < span.length;i++)
//		System.out.print(span[i] + " ");
	
//	int nge[] = stack_algo.nextGreaterInteger(price);
//	for(int i = 0;i < nge.length;i++)
//		System.out.print(nge[i] + " ");

//	System.out.println(stack_algo.evaluatePostfix("1 2 * 6 +"));
	
	stack_algo.initializeTowersOfHanoi(8, 1, 2);
	////////
	
}

public static void sorting_algos(){
	
	sortingAlgos algo = new sortingAlgos();
	int[] arr = algo.generateRandomArray(10000);
	algo.printArray(arr);
	
	//long currTime = System.currentTimeMillis();
	//algo.printArray(algo.bubbleSort(arr));
	//long nowTime = System.currentTimeMillis();
	//System.out.println("Time taken : " + (nowTime-currTime));
	//algo.printArray(algo.selectionSort(arr));
	//algo.printArray(algo.bubbleSort(arr));
	//algo.printArray(algo.insertionSort(arr));
	//algo.printArray(algo.mergeSort(arr,0,arr.length-1));
	//algo.printArray(algo.quickSort(arr, 0, arr.length-1));
	
}

public static void hash_test(){

	hashFunctions hf = new hashFunctions();
	
	int[] arr1 = {6,8,5,1};
	int[] arr2 = {8};
	//int[] arr = {1,2,3,1,2,3,4};
	//int arr3[][] = {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}};
	//System.out.println(hf.subsetArray(arr1, arr2));
	//System.out.println(hf.pairSum(arr1, 11));
	//System.out.println(hf.duplicateAtK(arr, 3));
	
//	ArrayList<Pair<Integer,Integer>> sym = new ArrayList<Pair<Integer,Integer>>();
//	
//	sym = hf.returnSymmetricPairs(arr3);
//	for(Pair<Integer,Integer>p : sym)
//		System.out.println(p.getKey() + " " + p.getValue());
	
//	int[] arr4 = {4, 6, 9, 2, 3, 4, 9, 6, 10, 4};
//	int[] occ = hf.multipleOccurences(arr4);
//	for(int i = 0;i < arr4.length;i++)
//		System.out.print(occ[i] + " ");
	
//	System.out.println(hf.disjointSets(arr1, arr2));
//	System.out.println(hf.pairProduct(arr1, 18));
//	ArrayList<Integer> missing = hf.missingElements(arr1);
//	for(Integer i : missing)
//		System.out.print(i + " ");
	
//	int[] reduced = hf.reducedForm(arr1);
//	for(int i = 0;i < arr1.length;i++)
//		System.out.print(reduced[i] + " ");
	
//	HashMap<String, String> dataSet = new HashMap<String, String>();
//    dataSet.put("Chennai", "Banglore");
//    dataSet.put("Bombay", "Delhi");
//    dataSet.put("Goa", "Chennai");
//    dataSet.put("Delhi", "Goa");
//    
//    hf.printItinerary(dataSet);
	
//	HashMap<String, String> dataSet = new HashMap<String, String>();
//    dataSet.put("A", "C");
//    dataSet.put("B", "C");
//    dataSet.put("C", "F");
//    dataSet.put("D", "E");
//    dataSet.put("E", "F");
//    dataSet.put("F", "F");
//
//    HashMap<String,Integer> noOfEmployees = hf.managerEmployee(dataSet);
//    for(String i : noOfEmployees.keySet())
//    	System.out.println(i + " " + noOfEmployees.get(i));
    
//	int[] arr5 = {65, 30, 7, 90, 1, 9, 8};
//	hf.elementSum(arr5);

//	int[] arr6 = {92, 75, 65, 48, 45, 35};
//	System.out.println(hf.pairSumK(arr6, 6));

//	int[] arr7 = {0, -2, 2, -8, 1, 9, 10, 23};
//	System.out.println(hf.largestSubArray(arr7));
	
//	int[] arr8 = {1, 9, 3, 10, 4, 20,11};
//	System.out.println(hf.longestConsecutive(arr8));
}

public static void string_algos(){
	
	stringAlgos algos = new stringAlgos();
	String str = "AABAACAADAABAAABAA";
    String pattern = "AABA";
    //algos.naivePatternSearch(pattern, str);
	algos.kmpSearch(pattern, str);
    //algos.rubinKarpSearch(pattern, str);
    //algos.zSearch(pattern, str);
	
//	int[] lps = algos.getLps("ABABCABAB");
//	for(int i = 0;i < lps.length;i++)
//		System.out.print(lps[i] + " ");
}
}
