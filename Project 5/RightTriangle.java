package hw06;
//Diem Dao 
//Section 03
//Nov 2
public class RightTriangle extends Shape{//extends from the parent shape
		//Instance variables
		private double height;
		private double base;
		
		//Constructors: Default and Parameterized
		public RightTriangle() {
			this.height = 0.0;
			this.base = 0.0;
		}
		public RightTriangle(double aHeight, double aBase) {
			super();//get what is in the parent
			this.setHeight(aHeight);
			this.setBase(aBase);
		}
		
		//Accessors and mutators 
		public double getHeight() {
			return this.height;
		}
		public void setHeight(double height) {
			this.height = height;
		}
		public double getBase() {
			return this.base;
		}
		public void setBase(double base) {
			this.base = base;
		}
		public double getArea() {
			this.setArea((this.height*this.base)/2); //A = (height*base)/2 
			return super.getArea();//because it inheriate from the parent
		}
		
		//toString
		public String toString() {
			return "Right Rectangle side 1: "+this.height+" Side 2: "+this.base+" Area: "+this.getArea()+super.toString();
			
		}
}
