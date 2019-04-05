package hw06;
//Diem Dao 
//Section 03
//Nov 2
public class Shape implements ShapeInterface{//implements the ShapeInterface will allow the compare method
											//so they can insert to the tree
	//Instance variables
	private double area;
	
	//Constructors: Default and Parameterized
	public Shape() {
		this.area = 0.0;
	}
	public Shape(double anArea) {
		//ToDO
		this.setArea(anArea);
		
	}
	//Accessors and mutators 
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	
	//compareTo 
	public int compareTo(Object o) {
		Shape shape = (Shape)o;
		if(shape.getArea() > area) //if the value is greater than the area
			return -1;
		if(shape.getArea() < area)//if the value is less than the area
			return 1;
		return 0; //else if they are equal 
	}
	
	//ToString
	public String toString() {
		return " ";
	}
}
