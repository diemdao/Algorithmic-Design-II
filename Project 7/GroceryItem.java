package lab04;
//written by Diem Dao
//Sep 13, 2018
//Section 3

public class GroceryItem {
	//instance variables
	private String name;
	private double value;
	
	//constructors
	public GroceryItem() { //defaul constructor
		this.name = "no name yet";
		this.value = 0.0;
	}
	
	//Parameterized constructor
	public GroceryItem(String aName, double aValue) {
		this.name = aName;
		this.value = aValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		if(value >= 0.0) {
		this.value = value;}
	}
	
	//Methods
	//toString method
	public String toString() {
		return "Name: "+this.name+ " ,Price: "+this.value;
	}
	
	//equals method
	public boolean equals(GroceryItem aGroceryItem) {
		return aGroceryItem != null 
				&& this.name.equals(aGroceryItem.getName()) 
				&& this.value == aGroceryItem.getValue();
	}
	
}
