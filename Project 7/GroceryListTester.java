package lab04;
//written by Diem Dao
//Sep 13, 2018
//Section 3

import java.util.Scanner;

public class GroceryListTester {
	public static void main(String[] args) {
		//ToDo 
		//GroceryList<GroceryItem> priceGrocery = new GroceryList<GroceryItem>();
		//GroceryItem chicken = new GroceryItem("chicken", 3.0);
		//priceGrocery.addItem("chicken", 3.0);
		
		
		System.out.println("Grocery List Tester"
				+"\nCreating grocery list");
		System.out.println("Adding 5 grocery items"
				+"\nPrint out list");
		/*GroceryList thelist = new GroceryList();
		thelist.addItem(new GroceryItem("Taco Shells",2.0));
		thelist.addItem(new GroceryItem("Salsa",1.59));
		thelist.addItem(new GroceryItem("Chips",1.29));
		thelist.addItem(new GroceryItem("Ground Beef",4.59));
		thelist.addItem(new GroceryItem("Shredded Cheese",2.99)); 
		thelist.showList();*/
		
		GroceryList thelist = new GroceryList();
		GroceryItem firstIn = new GroceryItem("Taco Shells",2.0);
		GroceryItem secondIn = new GroceryItem("Salsa",1.59);
		GroceryItem thirdIn = new GroceryItem("Chips",1.29);
		GroceryItem fourthIn = new GroceryItem("Ground Beef",4.59);
		GroceryItem fifthIn = new GroceryItem("Shredded Cheese",2.99); 
		GroceryItem heartBurnMed = new GroceryItem("Heart Burn Medicine", 5.99);
		GroceryItem heathyItem = new GroceryItem("Banana", 0.99);
		
		
		thelist.addItem(firstIn);
		thelist.addItem(secondIn);
		thelist.addItem(thirdIn);
		thelist.addItem(fourthIn);
		thelist.addItem(fifthIn);
		thelist.showList();
		

		System.out.println("Moving current twice");
		thelist.goToNext();
		thelist.goToNext();
		thelist.insertAfterCurrent(heartBurnMed);
		System.out.println("Adding an item after current");
		System.out.println("Printing list");
		thelist.showList();
		
		
		System.out.println("Maybe I should add something healthy");
		thelist.insertAfterCurrent(heathyItem);
		thelist.showList();
		
		System.out.println("Nevermind let's get rid of that");
		thelist.goToNext();
		thelist.deleteCurrentNode();
		thelist.showList();
		
		
		System.out.println("Did I remember the salsa?");
		System.out.println(thelist.contains(secondIn));

		
		System.out.println("The total cost is 18.45");
		thelist.totalCost();
		System.out.println(thelist.totalCost());

		
		
	}

}
