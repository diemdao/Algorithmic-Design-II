package hw02;
//written by Diem Dao
//Sep 20, 2018
//Section 3
import java.util.*;
import java.io.*;
public class VideoGameCollectionManager {
	private GenericLinkedList<VideoGame> videoGames; //used to store videogame
	//The files are assumed to be tab delimited. Think of a tab as indicating the next column of an excel document
	public static final String FILE_NAME = "/Users/diemdao/Desktop/grades.txt"; 
	private static final String DELIM = "\t";
	//Constructor
	public VideoGameCollectionManager()
	{
		videoGames = new GenericLinkedList<VideoGame>();
	}
	
	public void ReadVideoGameFile(String fileName) {
		videoGames = new GenericLinkedList<VideoGame>();
		try {
			//create a new file scanner
			Scanner fileScanner = new Scanner(new File(fileName));
			//Reads each line in the file one-by-one
			while(fileScanner.hasNextLine())
			{
				//Stores the next line of code
				String nextLine = fileScanner.nextLine();
				//that line is then split using the delimiter 
				String[] splitStrings = nextLine.split(DELIM);
				//If the newly created array is not 2 items in length then 
				//that line is not correctly formated and should be ignored
				if(splitStrings.length != 2)
					continue;
				String name = splitStrings[0];//the first element is the name
				String console = splitStrings[1]; //next is the console
				
				VideoGame newVideoGame = new VideoGame(name,console);//new video game is constructed
				videoGames.insert(newVideoGame);//add to array list
			}
			fileScanner.close();//Don't forget to close it
			
		}
		catch(Exception e) {
			System.out.println("Oh no error exception");
		}
	}
	
	//write file
	public void WriteVideoGameFile(String fileName, boolean append) {
		if(videoGames == null)//if the file name is null then return
			return;
		try 
		{
			//Create the new instance of a print writer 
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName,append));
			//this is a "for each" loop where each element in the array list (videoGames)
			//is iterated through, stored in the local variable aVideaGame, and then  is used
			//to print to the file
			while(videoGames.hasMore()) {
				VideoGame aVideoGame = videoGames.getCurrent();
				//Prints to the file
				fileWriter.println(aVideoGame.getName()+DELIM+
						aVideoGame.getConsole());
				videoGames.gotoNext();
			}
			fileWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
	}
	
	//This method prints everything is the array list
	public void PrintVideoGameList() {
		videoGames.resetCurrent();
		//the for each loop goes through each videogame and print out the information
		while(videoGames.hasMore()) {
			VideoGame aVideoGame = videoGames.getCurrent();
			System.out.println(aVideoGame.getName()+DELIM+aVideoGame.getConsole());
			videoGames.gotoNext();
		}
	}
	
	//Adds a new videogame to the list
	public void addNewVideoGame(VideoGame newVideoGame)
	{
		videoGames.insert(newVideoGame);
	}
	
	//removes the videogame from the array list
	public void removeVideoGame(VideoGame removeVideoGame) {
		//finds the index of the videoGame
		//int index = videogames.indexOf(removeVideoGame);
		//remove said videoGame
		//videoGames.remove(index);
		videoGames.resetCurrent();
		while(!videoGames.getCurrent().equals(removeVideoGame)) {
			videoGames.gotoNext();
		}
		videoGames.deleteCurrent();
			
	}

}
