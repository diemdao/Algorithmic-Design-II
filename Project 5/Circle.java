package hw06;
//Diem Dao 
//Section 03
//Nov 2
import java.math.*;//for PI
public class Circle extends Shape{//extend from the parent shape
	//Instance variables
	private double radius;
	
	//Constructors: Default and Parameterized
	public Circle() {
		this.radius = 0.0;
	}
	
	public Circle(double aRadius) {
		super();//get what is in the parent
		this.setRadius(aRadius);
	}
	
	//Accessors and mutators 
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getArea() {
		this.setArea(radius*radius*Math.PI); //A = pi*r^2
		return super.getArea();//because it inheriate from the parent
	}
	
	//toString
	public String toString() {
		return "Circle radius "+this.radius+" Area: "+this.getArea()+super.toString();
		
	}

}
