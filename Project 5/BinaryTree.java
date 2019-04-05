package hw06;
//Diem Dao 
//Section 03
//Nov 2
public class BinaryTree extends Shape{
	//internal class Node
	private class Node{
		private Shape data; 
		private Node leftChild;
		private Node rightChild;
		public Node() 
		{
			this.data = null;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	//Instance variables
	//root: a Node representing the first element in the tree.
	private Node root;
	public BinaryTree() {
		root = null;
	}
	
	//inserts a new shape into the tree
	public void insert(Shape aData) {
		Node newNode = new Node();
		newNode.data = aData;
		//check the root
		if(root == null)//if it's empty
			root = newNode;//place the data at the root
		else
			insert(root, aData);//recurcive
	}
	private Node insert(Node aNode, Shape aData) { //this node is internal to the class that is why it's private 
		if(aNode == null) {
			Node newNode = new Node();
			newNode.data = aData;
			aNode = newNode;
			}
			//use compareTo 
		else if(aData.compareTo(aNode.data) < 0) //Go Left
			aNode.leftChild = insert(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data) >= 0) //go right
			aNode.rightChild = insert(aNode.rightChild, aData);
		return aNode; //use recursion 
	}
	
	//delete: deletes the shape instance.  Keep in mind that in order for a shape to be equal it must
	//have the same same type and area, but the sides can be interchangeable.
	public void delete(Shape aData) {
		delete(root, aData);
	}
	private Node delete(Node aNode, Shape aData) {
		//find the value
		if(aNode == null)//Value not found so delete nothing
			return null;
		
		if (aData.compareTo(aNode.data) < 0)//go left
			aNode.leftChild = delete(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data) > 0)//GO right
			aNode.rightChild = delete(aNode.rightChild, aData);
		else //value is found
		{
			//assumes the right or perhaps both of the children are null
			//even if left is null it doesn't matter
			if(aNode.rightChild == null)
				return aNode.leftChild;
			//if the last didn't work then at least one child exists and that is the right
			if(aNode.leftChild == null)
				return aNode.rightChild;
			//if neither of those worked then we assume that both children are not null
			Node temp = aNode;//hold the node
			aNode = smallestInSubTree(aNode.rightChild);//get the minimum in the right tree
			aNode.rightChild = deleteSmallest(temp.rightChild);//then delete it
			delete(aNode.rightChild, aNode.data); //eliminate the duplicate
		}
		return aNode;
	}
	//find the smallest in sub tree
	private Node smallestInSubTree(Node aNode) {
		if(aNode == null)
			return null;
		else if(aNode.leftChild == null)
			return aNode;
		else
			return smallestInSubTree(aNode.leftChild);
	}
	//delete the smallest in tree
	private Node deleteSmallest(Node aNode) {
		if(aNode == null)
			return null;
		else if(aNode.leftChild == null)
			return aNode.rightChild;
		else
			return aNode.leftChild = deleteSmallest(aNode.leftChild);
	}
	
	// print pre-order traversal: Print the data.  
	//Next explore the left subtree.  Finally right explore subtree.
	public void printPreOrder()
	{
		printPreOrder(root);//starting from the root
	}
	private void printPreOrder(Node aNode) {//private method
		if(aNode == null)//if there is nothing then return 
			return;
		System.out.println(aNode.data);//Process
		printPreOrder(aNode.leftChild); //recursive left
		printPreOrder(aNode.rightChild);//recursive right
	}
			
			
	//print in-order traversal:  Explore the left subtree. Print the data. 
	//Finally explore the right subtree
	public void printInOrder() { //print in order
		printInOrder(root);
	}
	private void printInOrder(Node aNode) {
		if(aNode == null)
			return;
	printInOrder(aNode.leftChild);
	//the process is in between the left and right recursive
	System.out.println(aNode.data);//process
	printInOrder(aNode.rightChild);
	}
			
			
	//print post-order traversal:  Explore the left subtree. 
	//Then explore the right subtree.  Finally print out the data.
	public void printPostOrder() {
		printPostOrder(root);
	}
	private void printPostOrder(Node aNode) {
		if(aNode == null)
			return;
	printPostOrder(aNode.leftChild);
	printPostOrder(aNode.rightChild);
	System.out.println(aNode.data);//process
	}
	
	//max area: return the maximum area in the tree.  
	//Use the properties of the tree to make it efficient.
	public Node maxArea() {
		return maxArea(root);//get the max area
	}
	private Node maxArea(Node aNode) {//look at the farthest right, similar to find smallest value, but this method find max
		if(aNode == null)
			return null;
		else if(aNode.rightChild == null)
			return aNode;
		else
			return smallestInSubTree(aNode.rightChild);
	}
	
	// delete areas greater than value: For a given value all shapes with an area that’s strictly greater than those values
	//should be deleted. Use the principle of a binary search tree to help make it efficient.
	public void deleteAreasGreaterThanValue(double anArea) {//double because you need to get the area value
		if(maxArea(root) == null) {//find the max and check value if null then return nothing
			return;
		}
		if(maxArea(root).data.getArea() > anArea ) {//find the max then delete that value
			delete(maxArea(root).data);
			deleteAreasGreaterThanValue(anArea);
		}
		else
			return;
	}
	
			
}
