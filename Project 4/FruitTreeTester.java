package hw05;
//Diem Dao 
//Oct 26, 2018
//CSCE146, section 03
import java.util.*;
import java.io.*;
public class FruitTreeTester {
	public static void main(String[] args) throws FileNotFoundException {
				
		System.out.println("Welcome to the fruit tree!");
		System.out.println("Populating tree file file");
		
		BSTreeLL<FruitTree> fruitTree = new BSTreeLL<FruitTree>();
		
		String FILE_NAME = "/Users/diemdao/Desktop/fruitFile.txt"; 
		Scanner fileScanner = new Scanner(new File(FILE_NAME));
		while (fileScanner.hasNextLine()) {
			FruitTree inTree = new FruitTree(); //easier to put both string and double into one object 
			inTree.setName(fileScanner.next()); //get the string in the file to inTree
			double weight = Double.parseDouble(fileScanner.next());//convert the string to double
			inTree.setWeight(weight); //get the weight(double value) in the file to inTree
			fruitTree.insert(inTree); //insert what is in the file(inTree)
			fileScanner.nextLine();
		}
		fileScanner.close();
		
		
		System.out.println("\nPrinting the in-order traversal");
		fruitTree.printInOrder();
		
		System.out.println("\nPrinting the pre-order traversal");
		fruitTree.printPreOrder();
		
		System.out.println("\nPrinting the post-order traversal");
		fruitTree.printPostOrder();
		
		FruitTree deleteFruit = new FruitTree("Apple", 0.4859853412170728);
		System.out.println("\nDeleting " + deleteFruit.toString());
		fruitTree.delete(deleteFruit);
		
		System.out.println("\nPrinting the in-order traversal");
		fruitTree.printInOrder();
	}
	
	
	//this method below wouldn't work because it can only read but can't insert
	//read in method
/*	private BSTreeLL fruits;
	public static final String DELIM = "\t";
	public static final int FIELD_AMT = 2; //name, weight 
	//public static final String FILE_NAME = "/Users/diemdao/Desktop/fruitFile.txt"; 
	public void readFile(String fileName)
	{
				try {
					Scanner fileScanner = new Scanner(new File(""));
					fruits = new BSTreeLL();
					while (fileScanner.hasNextLine()) {
						String fileLine = fileScanner.nextLine();
						String [] splitLines = fileLine.split(DELIM);
						if(splitLines.length == FIELD_AMT) {
							FruitTree newfruit = new FruitTree(splitLines[0], 
									Double.parseDouble(splitLines[1]));
						}
					}
					fileScanner.close();
				}
				catch(Exception e) {
					System.out.println(e);
				}
	}*/
	
}
	
	
	
	
	
	
	
	
	
		

