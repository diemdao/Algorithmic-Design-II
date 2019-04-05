package hw07;
//Diem Dao 
//Section 03, CSCE146
//Nov 09
public class Sheep {
	//instance variables
	private String name;
	private double weight;
	
	//constructors
	public Sheep() {//default
		this.name = "no name yet";
		this.weight = 0;
	}
	//Parameterized 
	public Sheep(String aName, double aWeight) {
		this.name = aName;
		this.weight = aWeight;
	}
	//Accessors and mutators
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Method
	public String toString() {
		return this.name+ " "+this.weight;
	}
}
