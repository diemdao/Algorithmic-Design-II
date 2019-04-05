package lab07;
//Diem Dao 
//section 03
//oct 23, 2018
public class StrBSTree {
	//internal class Node
	private class Node{
		private String data;
		private Node leftChild;
		private Node rightChild;
		public Node(String aData)
		{
			this.data = aData;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	
	//Instance variables
	//root: a Node representing the first element in the tree.
	private Node root;
	public StrBSTree() {
		root = null;
	}
	
	//Methods
/*	Insert method: This method returns nothing and takes in a string value that is then
	placed as a new node in the tree based on the binary tree properties.  A reminder values greater 
	than the parent go to the right subtree and values smaller go to the left subtree. 
	Also it may be a good idea to use a recursive method in order to place these values.*/
	public void insert(String data)
	{
		if(root == null)
		{
			root = new Node(data);
		}
		else
			insert(root, data);
	}
	public Node insert(Node aNode, String data) {
		if(aNode == null)
		{
			aNode = new Node(data);
		}
		else if(data.length() < aNode.data.length()) {//go left
			aNode.leftChild = insert(aNode.leftChild, data);
		}
		else if(data.length() > aNode.data.length()) //go right
		{
			aNode.rightChild = insert(aNode.rightChild, data);
		}
		return aNode;
	}
	
	/*remove: This method returns nothing and takes in an string value that is to be removed.  
	First the method must search for the value.  If the value is found it is removed while 
	preserving the integrity of the binary search tree.  Remember there are cases for the node 
	having no children, having one child, and having two children.*/
	public void remove(String aData) {
		root = remove(root, aData);
	}
	private Node remove(Node aNode, String aData) {
		//find the value
		if(aNode == null)//Value not found so delete nothing
			return null;
		
		if(aData.length() < aNode.data.length())//go left
			aNode.leftChild = remove(aNode.leftChild, aData);
		else if(aData.length() > aNode.data.length())//GO right
			aNode.rightChild = remove(aNode.rightChild, aData);
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
			aNode.data = smallestInSubTree(aNode.rightChild);
			remove(aNode.rightChild, aNode.data); //eliminate the duplicate
		}
		return aNode;
	}
	private String smallestInSubTree(Node aNode) {
		if(aNode.leftChild == null)
			return aNode.data;
		else
			return smallestInSubTree(aNode.leftChild);
	}
	
	/*printPreorder: This method which returns nothing and has no parameters prints the pre-order
	traversal of the tree.  For pre-order traversal each the value is printed out, then left subtree 
	must be visited, and finally each of the right subtrees is visited.  It is a good idea to make a 
	recursive method to assist with this.
	*/
	public void printPreOrder()//not in order? see his notes
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
	

	
	
	/*getDepth: The depth of a node is the number of edges from the root to that number.  This method
	returns nothing and takes in a parameter corresponding to the string value of a node whose depth 
	is returned.  If the value is not in the tree a -1 should be returned.  Again a recursive helper 
	method may be useful to solve this.*/
	public int getDepth(String aData) {
		return depth(root, aData, 0);
	}
	private int depth(Node aNode, String aData, int aDepth) {
		if(aNode == null) {
			return -1;
		}
		if(aData.length() < aNode.data.length())//go left
			{
			aDepth++;
			return depth(aNode.leftChild, aData, aDepth);
			}
		else if(aData.length() > aNode.data.length())//GO right
			{
			aDepth++;
			return depth(aNode.rightChild, aData, aDepth);
			}
		else
			return aDepth;
		
	}
	
}




