package hw06;
//Diem Dao 
//Section 03
//Nov 2
import java.util.*;
import java.io.*;
public class ShapeTreeTester {
	//public static void main(String[] args) throws FileNotFoundException {
			
			/*System.out.println("Welcome to the shape tree tester!");
			System.out.println("Reading from file");
			
			BinaryTree shapeTree = new BinaryTree();
			
			String FILE_NAME = "/Users/diemdao/Desktop/shapeFile.txt"; 
			Scanner fileScanner = new Scanner(new File(FILE_NAME));
			String fileLine = "";
			while (fileScanner.hasNextLine()) {
				//Shape inShape = new Shape();//
				fileLine = fileScanner.nextLine();
				if(fileScanner.next().equalsIgnoreCase("rectangle")) {
					System.out.println(fileLine);
					Rectangle aRectangle = new Rectangle();
					double length = Double.parseDouble(fileScanner.next());
					aRectangle.setLength(length);
					double width = Double.parseDouble(fileScanner.next());
					aRectangle.setWidth(width);
					shapeTree.insert(aRectangle);
				}
			}
			fileScanner.close();*/
	public static final String DELIM = "\t";
	public static void main(String[] args) {
		
		BinaryTree shapeTree = new BinaryTree();
	
		System.out.println("Welcome to the shape tree tester!");
		System.out.println("Reading from file\n");
	
		try
		{
			Scanner fileScanner = new Scanner(new File("/Users/diemdao/Desktop/shapeFile.txt"));//read in the file
			String fileLine = "";
			String[] splitLines = fileLine.split(DELIM);
			while(fileScanner.hasNext())
			{
				fileLine = fileScanner.nextLine();
				splitLines = fileLine.split(DELIM);
				if(splitLines.length == 3)//shape name, side 1, side 2
				{
					if (splitLines[0].equalsIgnoreCase("rectangle"))//if it's a rectangle, then insert to the shapeTree
					{
						System.out.println(fileLine);//print out the line
						Rectangle aRectangle = new Rectangle(Double.parseDouble(splitLines[1]),
							Double.parseDouble(splitLines[2]));
						shapeTree.insert(aRectangle);//insert the rectangle in the shapeTree 
					}
					else if (splitLines[0].equalsIgnoreCase("right triangle"))//if it's a right triangle, then insert to the shapeTree
					{
						System.out.println(fileLine);
						RightTriangle aRightTriangle = new RightTriangle(Double.parseDouble(splitLines[1]),
							Double.parseDouble(splitLines[2]));
						shapeTree.insert(aRightTriangle);//insert the right triangle in the shapeTree 
					}
					else {//Rombus		
						System.out.println("Not properly formatted line. Yes you should check for these.  Not intentionally causing a kerfuffle");
						return;
					}
				}
				else if (splitLines.length == 2)//circle and its radius
					if (splitLines[0].equalsIgnoreCase("circle")) //if it's a circle, then insert to the shapeTree
					{
						System.out.println(fileLine);
						Circle aCircle = new Circle(Double.parseDouble(splitLines[1]));
						shapeTree.insert(aCircle);//insert the circle in the shapeTree 
					}
					else {//Rombus		
						System.out.println("Not properly formatted line. Yes you should check for these.  Not intentionally causing a kerfuffle");
						return;
					}
				else if (splitLines.length == 1)//Rombus		
				{
					System.out.println("Not properly formatted line. Yes you should check for these.  Not intentionally causing a kerfuffle");
				}
			}
			fileScanner.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			return;
		}
	
		//print 
		System.out.println("\nPrinting pre-order");
		shapeTree.printPreOrder();
	
		System.out.println("\nPrinting in-order");
		shapeTree.printInOrder();
	
		System.out.println("\nPrinting post-order");
		shapeTree.printPostOrder();
	
		System.out.println("\nThe max area is "+shapeTree.maxArea());
		
		Rectangle deleteRect = new Rectangle(2.0,7.0);
		System.out.print("\nDeleting "+deleteRect.toString());
		shapeTree.delete(deleteRect);
	
		System.out.println("\nPrinting in order");
		shapeTree.printInOrder();

		System.out.println("\nDeleting values larger than 30");
		shapeTree.deleteAreasGreaterThanValue(30);
		
		System.out.println("Printing in order");
		shapeTree.printInOrder();
	}
}
