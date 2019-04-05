package lab04;
//written by Diem Dao
//Sep 13, 2018
//Section 3


public class GroceryList {
	//internal class ListNode
	private class ListNode{
		//instance variables
		private GroceryItem data;
		private ListNode link;
		
		//defualt constructor
		public ListNode() {
			link = null;
			data = null;
		}
		//parameterized constructor
		public ListNode(GroceryItem aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
	
	//Instance Variables GroceryList class
	ListNode head; //a ListNode which always points to the beginning of the linked list
	ListNode current; //a ListNode which moves to point at different items in the list
	ListNode previous; //a ListNode which points to the item behind current.
	
	
	//Constructor, A default constructor that initializes head to an empty ListNode and sets current and previous to point at the head.
	public GroceryList() {
		head = current = previous = null;
	}
	
	//Methods
	//goToNext: This moves the current node forward in the list by one node.  It doesn’t move forward if that node is null
	public void goToNext() {
		if(current == null)
			return;
		previous = current; 
		current = current.link;
	}

	//GetDataAtCurrent: returns the data at the current node as long as the current isn’t null
	public GroceryItem getDataAtCurrent() {
		if(current != null)
			return current.data;
		else
			return null;  //** should it return 0? but it's differents data(String and double), so null is nothing and agree with both types of this data
	}
	
	//setDataAtCurrent: takes in a parameter of type GroceryItem and sets the data at the current node to that value as long as current is not null
	public void setDataAtCurrent(GroceryItem aData) {
		if(current != null)
			current.data = aData;
	}
	
	//addItem:This method adds a new node at the end of the list (HINT: Look for first null element).  If the list is empty (thus head is null) then it starts the list.
	public void addItem(GroceryItem aData) {
		//create a new node
		ListNode newNode = new ListNode(aData,null);
		//check head (look for first null element).
		if(head == null) { //If the list is empty (thus head is null) 
			head = newNode; //then it starts the list.
			current = head;
			return; 
		}
		//find the end of the list
		ListNode temp = head;
		while(temp.link != null)  //temp != tail (temp then after that whiletemp == tail (temp.link = head_)
			temp = temp.link;
		//add to the end
		temp.link = newNode;
	}
	

	
	
	//insertAfterCurrent:creates a new node based on data that is passed in by a parameter and puts that node after the current position
	public void insertAfterCurrent(GroceryItem aData) {
		ListNode newNode = new ListNode(aData, current.link);
		if(current != null) {
			current.link = newNode;
		}
		else if(head != null) { //not sure about this part, but if current outside of the linked list bc the current is null
			return; //return void
		}
		else //empty list
			return;
	}
	
	
	
	//deleteCurrentNode:removes the current node from the list by resetting the links
	public void deleteCurrentNode() {
		if(current != null && previous != null) //if both current and previous are not null we know that the node										
		{                                       //we are removing is in the middle of the list
			previous.link = current.link; 	//the previous' link is now set to the current link to skip over that node
			current = current.link;         
		}
		//Another case is when the current is pointing at to the head
		else if (current != null && previous == null) {  //we can tell by seeing that the current is not null but previous is 
			head = current.link; //move the head to the current's link
			current = head; //finally move the current to the head and the previous head node is as the new head node has been moved forward
		}
		else {
			System.out.println("List was empty");
		}
	}
	
	//showList: prints out the contents of the list line-by-line
	public void showList() {
		ListNode temp = head; 
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	//sees whether target is on the list
	//contains: returns a true or false value based on whether or not the data passed in via a parameter is in the list
	public boolean contains(GroceryItem aData) {
		return find(aData) != null;
	}
	//return a reference to the first node containing the 
	//target data. If target is not on the list, returns null.
	private ListNode find(GroceryItem aData) {
		boolean found = false;
		ListNode temp = head;
		while((temp != null) && !found) {
			if(temp.data.equals(aData))
				found = true;
			else temp = temp.link;
		}
		return temp;
	}
	
	
	
	//totalCost: returns the sum of all of the groceries
	public double totalCost() {
		double sum = 0.0;
		ListNode temp = head;
		while(temp != null) {
			sum += temp.data.getValue();
			temp = temp.link;
		}
		//use while loop to traverse through list, get each price, sum and return
		return sum;
	}










}
