package hw05;
//Diem Dao 
//Oct 26, 2018
//CSCE146, section 03

public class BSTreeLL<T extends Comparable> {
	//internal class Node
		private class Node{
			private T data; //T can read in both name and its weight value 
			private Node leftChild;
			private Node rightChild;
			public Node(T aData) 
			{
				this.data = aData;
				this.leftChild = null;
				this.rightChild = null;
			}
		}
		
		//Instance variables
		//root: a Node representing the first element in the tree.
		private Node root;
		public BSTreeLL() {
			root = null;
		}
		
		//insert method, insert: inserts a new fruit into the tree
		public void insert(T aData) {//check the root 
			if(root == null)
				root = new Node(aData);
			else
				insert(root, aData);
		}
		//this method is the same name (insert) it's call overloading
		private Node insert(Node aNode, T aData) { //this node is internal to the class that is why it's private 
			if(aNode == null)
				aNode = new Node(aData);
			//use compareTo 
			else if(aData.compareTo(aNode.data) < 0) //Go Left
				aNode.leftChild = insert(aNode.leftChild, aData);
			else if(aData.compareTo(aNode.data) >= 0) //go right
				aNode.rightChild = insert(aNode.rightChild, aData);
			return aNode; //use recursion 
		}
		
		
		//delete method
		//delete: deletes the fruit instance.  Keep in mind that in order for a fruit to be equal it 
		//must have the same same type and weight.
		public void delete(T aData) {
			delete(root, aData);
		}
		private Node delete(Node aNode, T aData) {
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
				Node temp = aNode;
				aNode = smallestInSubTree(aNode.rightChild);
				aNode.rightChild = deleteSmallest(temp.rightChild);
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
		
		
}
		
	
		












