package stack_algo;

import java.util.ArrayList;
import java.util.Stack;

public class Stack_Algo {

	/*	Used to get precedence levelof operator. 
	 *	Used in infix to postfix conversion and evaluating postfix expressions*/
	private class Precedence{
		/*	Returns precedence of the operator	*/
		public int getPrecedence(char c){
			if(c == '+' || c == '-')
				return 0;
			else if(c == '*' || c == '/')
				return 1;
			else if(c == '(' || c == ')')
				return 2;
			else
				return -1;
		}
		/*	Returns whether the character is an operator or not	*/
		public boolean isOperator(char c){
			if(c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')')
				return true;
			else
				return false;
		}
		/*	Compares the precedence of the two operaros passed	*/
		public int comparePrecedence(char a,char b){
			if(getPrecedence(a) == getPrecedence(b))
				return 0;
			else if(getPrecedence(a) > getPrecedence(b))
				return 1;
			else
				return -1;
		}
	}

	/*	Converts infix expression to postfix	*/
	public String infixToPostfix(String expr){
		
		StringBuffer post_expr = new StringBuffer();
		Stack<Character> op_stack = new Stack<Character>();
		Precedence obj = new Precedence();
		
		for(int i = 0;i < expr.length();i++){
			char c = expr.charAt(i);
		//	Operand	
		if(!obj.isOperator(c))
			post_expr.append(c);
		//	Operator
		else{
			System.out.println("Present Character : " + c);
			System.out.println(op_stack.toString());
				if(c == '('){
					op_stack.push(c);
				}
				else if(c == ')'){
					while(!op_stack.isEmpty() && op_stack.peek() != '(')
						//System.out.println(op_stack.pop());
						post_expr.append(op_stack.pop());
					if(!op_stack.isEmpty() && op_stack.peek() == '(')
						op_stack.pop();
					}	
				
				else{
					if(op_stack.isEmpty())
						op_stack.push(c);
					else{
//						if(op_stack.peek() == '(')
//							op_stack.pop();
						while(!op_stack.isEmpty() 
								&& obj.getPrecedence(c) <= obj.getPrecedence(op_stack.peek())
								&& op_stack.peek() != '('){
							post_expr.append(op_stack.pop());
						}
						op_stack.push(c);
					}
				}
			
		}
	}
		while(!op_stack.isEmpty()){
			char x = op_stack.pop();
			post_expr.append(x);
		}
		return post_expr.toString();
   }
	/*	Checks if the expression in a balanced expression or not	*/
	public boolean balancedExpr(String expr){
		boolean flag;
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0;i< expr.length();i++){
			char c = expr.charAt(i);
			if(c == '[' || c == '{' || c == '(')
				stack.push(c);
			
			else if(c == ')'){
				if(!stack.isEmpty() && stack.peek() == '(')
					stack.pop();
				else 
					return false;
			}
			else if(c == '}'){
				if(!stack.isEmpty() && stack.peek() == '{')
					stack.pop();
				else 
					return false;
			}
			else if(c == ']'){
				if(!stack.isEmpty() && stack.peek() == '[')
					stack.pop();
				else 
					return false;
			}
			
		}
		return true;
	}
	
	/*	Sloution to the stock span problem	*/
	public int[] stockSpan(int[] price){
		
		int size = price.length;
		int[] span = new int[size];
		Stack<Integer> stack = new Stack<Integer>();
		span[0] = 1;
		stack.push(0);
		
		for(int i = 1;i < size;i++){
			while(!stack.isEmpty() && price[i] >= price[stack.peek()]){
				stack.pop();
			}
			span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
			stack.push(i);
		}
		
		return span;
	}
	
	/*	Solution to the next greatest integer problem	*/
	public int[] nextGreaterInteger(int[] arr){
		
		int size = arr.length;
		int[] nge = new int[size];
		Stack<Integer> st = new Stack<Integer>();
		
		for(int i = size - 1;i >= 0;i--){
			while(!st.isEmpty() && (arr[i] > arr[st.peek()]))
				st.pop();
			if(st.isEmpty())
				nge[i] = -1;
			else
				nge[i] = arr[st.peek()];
			st.push(i);			
		}
		
		return nge;
	}
	/*	Evaluating a posfix expression	*/
	public int evaluatePostfix(String exp){
		
		Stack<Integer> integerStack = new Stack<Integer>();
		String[] data = exp.split("\\s");
		Precedence p = new Precedence();
		
		for(int i = 0;i < data.length;i++){
			char ch = data[i].toCharArray()[0];

			if(p.isOperator(ch)){
				int a = integerStack.pop();
				int b = integerStack.pop();
				
				if(data[i].equals("*")){
						integerStack.push(a*b);
					}
				else if(data[i].equals("+")){
					integerStack.push(a+b);
					}
				else if(data[i].equals("-")){
					integerStack.push(a-b);
					}	
				else if(data[i].equals("-")){
					integerStack.push(a/b);
					}
				}
			else{
				integerStack.push(Integer.parseInt(data[i]));
			}
		}
		return integerStack.peek();
	}
	
	/*	Utility method for Towers of Hanoi implementation	*/
	public int makeMove(ArrayList<Stack<Integer>> st,int src,int dest){
		
		if(st.get(src).isEmpty())
			return -1;
		
		int popValue = st.get(src).pop();
		st.get(dest).push(popValue);
		System.out.println("Moving " + popValue + " from "+ src + " to " + dest);
		
		return 1;

	}
	
	/*	Towers of Hanoi implementation	*/
	public void solveTowersOfHanoi(ArrayList<Stack<Integer>> st,int n,int src,int dest){
		
		if(n == 1){
			makeMove(st,src,dest);
			return;
		}
		int other = 3 - src - dest;
		
		solveTowersOfHanoi(st,n-1,src,other);
		solveTowersOfHanoi(st,1,src,dest);
		solveTowersOfHanoi(st,n-1,other,dest);
			
	}
	
	/*	Utility method for Towers of Hanoi implementation	*/
	public void initializeTowersOfHanoi(int n,int src,int dest){
		
		ArrayList<Stack<Integer>> st = new ArrayList<Stack<Integer>>();
		
		Stack<Integer> st0 = new Stack<Integer>();
		Stack<Integer> st1 = new Stack<Integer>();
		Stack<Integer> st2 = new Stack<Integer>();
		
		st.add(st0);
		st.add(st1);
		st.add(st2);
		
		for(int i = n;i > 0;i--){
			st.get(src).push(i);
		}
		
		solveTowersOfHanoi(st,n,src,dest);
		
	}
}
