package hw05;
//Diem Dao 
//Oct 26, 2018
//CSCE146, section 03
public class FruitTree implements Comparable<FruitTree>{
	private String name;
	private double weight;

	public FruitTree() {
		this.name = "not yet";
		this.weight = 0;
	}
	public FruitTree(String aName, double aWeight)
	{
		//TODO
		this.setName(aName);
		this.setWeight(aWeight);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		//if(weight <= 0)
			this.weight = weight;
	}
	
	public String toString() {
		return this.name+ " "+this.weight;
	}
	
	public boolean equals(FruitTree aFruit) {
		//need to catch not null
		return aFruit != null 
				&& this.name.equals(aFruit.getName())
				&& this.weight == aFruit.getWeight();
	}
	
	public int compareTo(FruitTree aFruit) {
		FruitTree fruit = (FruitTree)aFruit;
		if(fruit.getWeight() > weight) //if the value is greater than the weight
			return -1;
		if(fruit.getWeight() < weight)//if the value is less than the weight
			return 1;
		return 0; //else if they are equal 
	}
	
}
