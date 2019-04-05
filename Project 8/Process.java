package lab05;
//written by Diem Dao
//Sep 26, 2018
//Section 3
public class Process {
	//Attributes
	private String name;
	private double completionTime;
	
	//Constructors default
	public Process() {
		this.name = "no name yet";
		this.completionTime = 0.0;
	}
	//Constructors parameterized
	public Process(String aName, double aCompletionTime) {
		//TODO
		this.name = aName;
		this.completionTime = aCompletionTime;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCompletionTime() {
		return completionTime;
	}
	public void setCompletionTime(double completionTime) {
		if(completionTime >= 0.0)
		{
			this.completionTime = completionTime;
		}
	}
	
	//method
	public String toString() {
		return "Process Name: " +this.name+ " Completion Time: " +this.completionTime;
	}

}
