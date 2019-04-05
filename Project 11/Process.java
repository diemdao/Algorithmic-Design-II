package lab08;
//Diem Dao 
//Section 03
//Nov 2
public class Process {
	//instance variables
	private int priority;
	private double time;
	private String name;
	
	//constructors
	public Process() {//default
		this.priority = 0;
		this.time = 0.0;
		this.name = "no name yet";
	}
	//Parameterized look at the driver! how it take in things
	public Process(String aName, int aPriority, double aTime) {
		this.priority = aPriority;
		this.time = aTime;
		this.name = aName;
	}
	//Accessors and mutators
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Method
	public String toString() {
		return this.name+ " " +this.priority+ " "+this.time;
	}
	
	
	
}
