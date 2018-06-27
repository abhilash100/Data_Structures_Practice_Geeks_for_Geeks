package stack_algo;

import java.util.ArrayList;
import java.util.Stack;

public class Stack_Algo {

	private class Precedence{
		
		public int getPrecedence(char c){
			if(c == '+' || c == '-')
				return 0;
			else if(c == '*' || c == '/')
				return 1;
			//else if(c == '(' || c == ')')
			//	return 2;
			else
				return -1;
		}
		
		public boolean isOperator(char c){
			if(c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')')
				return true;
			else
				return false;
		}
		
		public int comparePrecedence(char a,char b){
			if(getPrecedence(a) == getPrecedence(b))
				return 0;
			else if(getPrecedence(a) > getPrecedence(b))
				return 1;
			else
				return -1;
		}
	}
	
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
				if(c == '('){
					op_stack.push(c);
				}
				else if(c == ')'){
					while(!op_stack.isEmpty() && op_stack.peek() != '(')
						post_expr.append(op_stack.pop());
					//System.out.println(op_stack.isEmpty());
					}	
				else{
					if(op_stack.isEmpty())
						op_stack.push(c);
					else{
						if(op_stack.peek() == '(')
							op_stack.pop();
						while(!op_stack.isEmpty() && obj.getPrecedence(c) <= obj.getPrecedence(op_stack.peek())){
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
	
	public int evaluatePostfix(String exp){
		
		Stack<Integer> integerStack = new Stack<Integer>();
		String[] data = exp.split("\\s");
		Precedence p = new Precedence();
		
		for(int i = 0;i < data.length;i++){
			char ch = data[i].toCharArray()[0];

				if(p.isOperator(ch)){
				int a = integerStack.pop();
				System.out.println(ch + " " + a);
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

	public int makeMove(ArrayList<Stack<Integer>> st,int src,int dest){
		
		if(st.get(src).isEmpty())
			return -1;
		
		int popValue = st.get(src).pop();
		st.get(dest).push(popValue);
		System.out.println("Moving " + popValue + " from "+ src + " to " + dest);
		
		return 1;

	}
	
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
		
		int other = 3 - src - dest;
		
		int count = 0;
		solveTowersOfHanoi(st,n,src,dest);
		
	}
}
