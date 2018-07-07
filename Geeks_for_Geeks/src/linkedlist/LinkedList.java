package linkedlist;

public class LinkedList {

public Node head = null;
int size;
int count = 0; 			//	Delete later
public int getSize() {
	return size;
}
/*	Linked list node definition	*/
public class Node{
	public int data;
	Node next;
	
	public Node(int x){
		this.data = x;
		this.next = null;
	}
}
/*	Adding a node at the start of the list	*/
public void pushAtStart(int val){
	Node n = new Node(val);
	n.next = head;
	head = n;
	size++;
}
/*	Adding a node at the end of the list	*/
public void pushAtEnd(int val){
	Node n = new Node(val);
	Node x = head;
	while(x.next != null){
		x = x.next;
	}
	x.next = n;
	size++;
}
/*	Pushing a node at position N	*/
public void pushAtN(int val,int idx)throws Exception{
	Node n = new Node(val);
	if(idx == 0)
		pushAtStart(val);
	else if(idx == (size - 1))
		pushAtEnd(val);
	else if(idx >= size)
		throw new LinkedListException("Index greater than LinkedList size");
	else{
		Node itr = head;
		for(int i = 0;i < idx - 1;i++){
			itr = itr.next;
		}
		n.next = itr.next;
		itr.next = n;
	}
}
/*	Deleting the first node*/
public void deleteFirst(){
	if(head == null)
		throw new LinkedListException("Cannot delete first element as Linked List is empty");
	else
		head = head.next;
	size --;
}
/*	Deleting the last node	*/
public void deleteLast(){
	Node x = head;
	while(x.next.next != null){
		x = x.next;
	}
	x.next = null;
	size --;
}
/*	Deleting the Nth node*/
public void deleteAtN(int idx){
	if(idx == 0)
		deleteFirst();
	else if(idx == (size - 1))
		deleteLast();
	else if(idx >= size)
		throw new LinkedListException("Index greater than LinkedList size");
	else{
		Node itr = head;
		for(int i = 0;i < idx - 1;i++){
			itr = itr.next;
		}
		itr.next = itr.next.next;
	}
}
/*	Swapping the elements at idx2 and idx2	*/
public void swap(int idx1,int idx2) throws Exception{
	
	Node itr1 = head;
	Node itr2 = head;
	Node prev1,prev2,curr1,curr2;
	
	if(idx1 == idx2)
		return;
	
	for(int i = 0;i < idx1 - 1;i++)
		itr1 = itr1.next;
	
	for(int i = 0;i < idx2 - 1;i++)
		itr2 = itr2.next;
	
	if(itr1 == head){
		curr1 = head;
		prev1 = null;
	}
	else{
		prev1 = itr1;
		curr1 = itr1.next;	
	}
	
	if(itr2 == head){
		curr2 = head;
		prev2 = null;
	}
	else{
		prev2 = itr2;
		curr2 = itr2.next;
	}

	if(prev1 != null && prev2 != null){
		if(prev1 != curr2 && prev2 != curr1){
		Node tmp1 = null,tmp2 = null;
		if(curr1.next != null)
			tmp1 = curr1.next;
		if(curr2.next != null)
			tmp2 = curr2.next;
		prev2.next = curr1;
		prev1.next = curr2;
		curr2.next = tmp1;
		curr1.next = tmp2;
		}
		else if(prev1 == curr2){
			Node tmp = curr1.next;
			prev2.next = curr1;
			curr1.next = curr2;
			curr2.next = tmp;
		}
		else if(prev2 == curr1){
			Node tmp = curr2.next;
			prev1.next = curr2;
			curr2.next = curr1;
			curr1.next = tmp;
		}
	}
	if(prev1 == null){
		Node tmp1 = curr1.next;
		Node tmp2 = curr2.next;
		prev2.next = curr1;
		curr2.next = tmp1;
		curr1.next = tmp2;
		head = curr2;

	}
	if(prev2 == null){
		Node tmp1 = curr1.next;
		Node tmp2 = curr2.next;
		prev1.next = curr2;
		curr1.next = tmp2;
		curr2.next = tmp1;
		head = curr1;
	}
	
}
/*	Searcing for a particular number in the linked list	*/
public int search(int num){

	int idx = 0;
	boolean flag = false;
	Node x = head;
	while(x.next != null){
		x = x.next;
		idx++;
		if(x.data == num){
			flag = true;
			break;
			}
	}
	if(flag)
		return idx;
	else 
		return -1;

}
/*	Merging the linked list with the one passed as an argument	*/
public void mergeList(LinkedList l){
	Node x = head;
	while(x.next != null){
		x = x.next;
	}
	x.next = l.head;
}
/*	Getting the middle element of a linked list	*/
public static Node getMiddle(Node head1){
	
	if(head1 == null)
		return head1;
		
	Node fast_ptr = head1.next;
	Node slow_ptr = head1;
	
	while(fast_ptr != null){
		fast_ptr = fast_ptr.next;
		if(fast_ptr != null){
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next;
		}
		
	}
	return slow_ptr;
} 
/*	Breaking the linked list based on the values of l and r	*/
public LinkedList breakList(LinkedList list, int l,int r){
	Node itr = list.head;
	
	for(int i = 0;i < l;i++){
		itr = itr.next;
	}
	list.head = itr;
	
	for(int i = 0;i < r - l ;i++){
		itr = itr.next;
	}
	itr.next = null;
	
	list.size = r - l + 1;
	
	return list;
}

@SuppressWarnings("unused")
public static Node sortMerge(Node node1,Node node2){
	
	Node list_ptr = null;
	
	if(node1 == null)
		return node2;
	if(node2 == null)
		return node1;
	
	if(node1.data < node2.data){
			list_ptr = node1;
			list_ptr.next = sortMerge(node1.next,node2);
	}
	else if(node1.data >= node2.data){
			list_ptr = node2;
			list_ptr.next = sortMerge(node1,node2.next);
		}	
	
	return list_ptr;
}

public static Node mergeSort(Node list_head) {
	if(list_head == null || list_head.next == null)
		return list_head;
	
	Node middle = getMiddle(list_head);
	Node next_middle = middle.next;
	middle.next = null;

	Node left = mergeSort(list_head);
	Node right = mergeSort(next_middle);
	
	Node sorted_list = sortMerge(left,right);
	return sorted_list;
}
/*	Prints out the entire Linked List*/
public void printList(){
	Node itr = head;
	while(itr.next != null){
		System.out.println(itr.data);
		itr = itr.next;
	}
	System.out.println(itr.data);
}
/*	Prints out the element of index N of the linked list	*/
public static void printList(Node n){
	Node itr = n;
	while(itr.next != null){
		System.out.println(itr.data);
		itr = itr.next;
	}
	System.out.println(itr.data);
}
}
