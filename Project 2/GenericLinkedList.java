package hw02;
//written by Diem Dao
//Sep 20, 2018
//Section 3

//T is the generic type, so it's every type
public class GenericLinkedList <T> {
	/*
	 * Linked list with an iteratro.One node is the "curren node."
	 * Initailly, the curren node is the first node. It can be changed to the 
	 * next node until the iteration has moeved beyoud the end of the list.
	 */
	private class ListNode{
		private T data;
		private ListNode link;
		public ListNode()//default constructor
		{
			data = null;
			link = null;
		}
		public ListNode(T aData, ListNode aLink) {  //parameterized
			data = aData;
			link = aLink;
		}
	}
	
	//Pointer nodes
	private ListNode head, curr, prev;
	
	//constructors of GenericLinkedList class
	public GenericLinkedList() {
		head = curr = prev = null;
	}
	
	//access for current Node
	public T getCurrent() {
		if(curr != null) 
			return curr.data;
		else
			return null;
	}
	
	//modify the current Node
	public void setCurrent(T aData)
	{
		if(curr != null)
			curr.data = aData; 
	}
	
	//insert new element to the end of the list
	public void insert(T aData) {
		ListNode newNode = new ListNode(aData, null);   //go from head to null, but if you want to be in circle then (aData, head)
		if(head == null) { //list is empty
			//head = curr = newNode;
			head =  newNode; //Points head to the new node
			curr = head; //Point current to the first element
			return;
		}
		ListNode temp = head;//Temp node to point to the head
		while(temp.link != null)//as long as the node is pointing to something
		{
			//move the temp node forward
			temp = temp.link;
		}
		temp.link = newNode;//Point to the new node
	}
	
	//insertAfterCurrent
	public void insertAfterCurrent(T aData) {
		//create a new node
		ListNode newNode = new ListNode(aData, null);
		if(curr != null)
		{
			newNode.link = curr.link;
			curr.link = newNode;
		}
		else if(head != null) {
			System.out.println("current is outside of the linked list");
		}
		else
		{
			System.out.println("List is empty");
		}
	}
	
	//Move current forward
	public void gotoNext()
	{
		if(curr != null)
		{
			prev = curr;
			curr = curr.link;
		}
	}
	
	//resetCurrent method
	public void resetCurrent() {
		curr = head;
		prev = null;
	}
	
	//hasMore method
	public boolean hasMore() {
		return curr != null;
	}
	
	
	//print
	public void print()
	{
		ListNode temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	public void deleteCurrent() {
		if(curr != null && prev != null)//Current is in the middle
		{
			prev.link = curr.link;
			curr = curr.link;
		}
		else if(curr != null && prev == null)
		{
			head = head.link; //Or head = current.link
			curr = head;
		}
	}

	
}
