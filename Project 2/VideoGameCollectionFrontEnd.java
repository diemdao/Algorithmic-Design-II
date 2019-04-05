package hw02;
//written by Diem Dao
//Sep 20, 2018
//Section 3
import java.util.Scanner;
public class VideoGameCollectionFrontEnd {
	public static void main(String[] args) {
		//TODO
		Scanner keyboard = new Scanner(System.in);
		//Creates a new instance of a videoGameCollection manager
		VideoGameCollectionManager videoGameManager = new VideoGameCollectionManager();
		System.out.println("Welcome to the video game database!");
		
		boolean quit = false;
		while(quit == false) {
			//Prompts the user
			System.out.println("Enter 1 to load the video game database\n"+
								"Enter 2 to search the database\n"+
								"Enter 3 to print current results\n"+
								"Enter 4 to print current results to file\n"+
								"Enter 0 to quit");
			//takes the input
			int input = keyboard.nextInt();
			//Does things
			switch(input) {
			case 0: 
				quit = true;
				break;
			case 1:
				/*
				 * Read a video game collection file.  The file is assumed to have the name and the console and its tab delimited.  
				 * It is advisable to put each of the games in a Linked List (Of your creation not an ArrayList or other list structure 
				 * built into Java) since number of games is not known.
				 */
				//keyboard.nextLine();
				System.out.println("Enter the file name JJCollection.txt");
				//String fileNameIn = keyboard.next();
				String fileNameIn = "/Users/diemdao/Desktop/JJCollection.txt";
				videoGameManager.ReadVideoGameFile(fileNameIn);
				break;
			case 2:
				/*
				 * Search the contents of the file that has already been loaded in from part 1.  
				 * The user enters the name of the game and then the name of the console. 
				 * Matches for the game and console entered are returned
				 * Partial matches for the name or console are acceptable
				 * This is not case sensitive
				 * User may use the character “*” to indicate they want all games or consoles.
				 */
				System.out.println("Enter the name of the game or '*' for all names Super");
				String namekeyboard = keyboard.nextLine();
				if(namekeyboard.equals(namekeyboard)){
					videoGameManager.PrintVideoGameList();
				}
				else if(namekeyboard.equals("*")) {
					videoGameManager.PrintVideoGameList();
				}
				else {
					System.out.println("error no match name");
				}
				
				System.out.println("Enter the name of the console or '*' for all consoles Nintendo");
				String consolkeyboard = keyboard.nextLine();
				if(consolkeyboard.equals(consolkeyboard)){
					videoGameManager.PrintVideoGameList();
				}
				else if(consolkeyboard.equals("*")) {
					videoGameManager.PrintVideoGameList();
				}
				else {
					System.out.println("error no match console");
				}
				//VideoGame newVideoGame = new VideoGame(name,console);
				videoGameManager.PrintVideoGameList();
			
				break;
			case 3:
				//Print out the current search results to the console
				videoGameManager.PrintVideoGameList();
				break;
			case 4:
				//Print out the current search results to a new file with the option to append to said file.  
				//The user must specify the name of the file and whether or not they append.
				System.out.println("Enter the file name to print out. superGames.txt \n"+
									"Append to file? True or false.");
				String fileNameOut = "/Users/diemdao/Desktop/superGames.txt";
				boolean append = keyboard.nextBoolean();
				videoGameManager.WriteVideoGameFile(fileNameOut, append);
				break;
			//case 5: no case 5 bc it's part of the while loop 
				//Keeps running this until the user quits
			}
		}
	}
}
