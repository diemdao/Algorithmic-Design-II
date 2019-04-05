package lab07;
//Diem Dao 
//section 03
//oct 23, 2018
import java.util.*;
public class IntBSTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing the tree");
		StrBSTree tree = new StrBSTree();
		System.out.println("Inserting 10 words");
		System.out.println("\nInserting buzzwigs\n" + 
				"Inserting ABBREVIATIONS\n" + 
				"Inserting Cat\n" + 
				"Inserting food\n" + 
				"Inserting abovementioned\n" + 
				"Inserting ABSORBABILITIES\n" + 
				"Inserting VOLATILITY\n" +
				"Inserting I\n" + 
				"Inserting TWIRLIEST\n" + 
				"Inserting at\n" + 
				" ");
		
		//array of words to inster in 
		String[] arrayWords = {"buzzwigs","ABBREVIATIONS", "Cat", "food", "abovementioned", "ABSORBABILITIES", 
				"VOLATILITY","I", "TWIRLIEST", "at"};

		//go through each word and insert it in 
		for(int i = 0 ; i<arrayWords.length; i++) {
			tree.insert(arrayWords[i]);
		}
		
		System.out.println("Printing pre-order traversal");
		tree.printPreOrder();
		
		System.out.println("\nRemoving the word “food”");
		tree.remove("food");
		tree.printPreOrder();
		
		System.out.println("\nThe Depth of TWIRLIEST is " +tree.getDepth("TWIRLIEST"));
		
		System.out.println("Done!");
	}

}
