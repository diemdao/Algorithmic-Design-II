package hw06;
//Diem Dao 
//Section 03
//Nov 2
public class Rectangle extends Shape{//extend from the parent shape
	//Instance variables
	private double length;
	private double width;
	
	//Constructors: Default and Parameterized
	public Rectangle() {
		this.length = 0.0;
		this.width = 0.0;
	}
	public Rectangle(double aLength, double aWidth) {
		super();//get what is in the parent
		this.setLength(aLength);
		this.setWidth(aWidth);
	}
	
	//Accessors and mutators 
	public double getLength() {
		return this.length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return this.width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getArea() {
		this.setArea(this.length*this.width); //A = length*width
		return super.getArea();//because it inheriate from the parent
	}
	
	//toString
	public String toString() {
		return "Rectangle side 1: "+this.length+" Side 2: "+this.width+" Area: "+this.getArea()+super.toString();
		
	}

}



