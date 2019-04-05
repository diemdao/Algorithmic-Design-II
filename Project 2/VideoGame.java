package hw02;

//written by Diem Dao
//Sep 20, 2018
//Section 3
public class VideoGame {
	private String name;
	private String console;
	
	//defualt constructor
	public VideoGame() {
		this.name = "No name yet";
		this.console = "No console yet";
	}

	public VideoGame(String aName, String aConsole) {
		//TODO
		this.setName(aName);
		this.setConsole(aConsole);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	
	public String toString() {
		return "Name: " +this.name+ " Console: "+this.console;
	}
	
	public boolean equals(VideoGame aVideoGame) {
		//need to catch not null
		return aVideoGame != null && this.name.equals(aVideoGame.getName())
				&& this.console.equals(aVideoGame.getConsole());

	}
	
	
	
	
	
	
	
	
	
}
