package lab05;
//written by Diem Dao
//Sep 26, 2018
//Section 3
public class LinkedListQueue <T> { //assume this will have a generic type
	//internal class
	private class ListNode{
		private T data; //the data that's held in the node of a generic type
		private ListNode link; //a ListNode that points to the next element
		//defautl constructors
		public ListNode() {
			data = null;
			link = null;
		}
		//parameterized constructors
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
	
	//Attributes
	private ListNode head;//A ListNode that points to the first element of the queue
	private ListNode tail;//A ListNode that points to the last element of the queue
	public LinkedListQueue() {
		head = null;
		tail = head;
	}
	
	//Other methods
	//Enqueue: This method returns nothing and takes in some generic data that is added to the end of the queue.
	public void enqueue(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if(head == null)
		{
			head = newNode;
			tail = head;
			return;
		}
		this.tail.link = newNode;
		this.tail = newNode;
	}
	
	//Dequeue: This method removes and returns the first element's data of the queue as long as the head is not null
	public T dequeue() {
		ListNode temp = head;
		head = head.link;
		return temp.data;
	}
	
	//Peek: returns the first element's data, but doesn't remove the element
	public T peek() {
		return head.data;
	}
	
	//Print: prints out the entire queue
	public void print() {
		ListNode tempNode = head;
		while(tempNode != null)
		{
			System.out.println(tempNode.data.toString());
			tempNode = tempNode.link;
		}
	}
	
	
}
