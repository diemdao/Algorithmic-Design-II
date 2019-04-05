package lab06;
//written by Diem Dao
//oct 11,2018
//section 03

import java.util.*;
public class containedWords {
	public static void main(String[] args) {
		//TODO
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter 2 words. I will determine if the letters of one is contained in the other");
		String word1 = keyboard.nextLine();
		String word2 = keyboard.nextLine();
	
		if(isContains(word1, word2, word1.length(), word2.length())) {
			System.out.println("They are contained!");
		}
		else {
			System.out.println("They are not contained");
		}
	}	
	
	public static boolean isContains(String word1, String word2, int index1, int index2) { 
		//Also if both strings are empty then return true.
		  if(index1 == 0)
	           return true;
		  if (index2 == 0)
	    	  return false;
		//If the size of the first word is larger than the second then it should automatically return false.
		  if(word1.length() > word2.length()) 
				return false;
		  
		  //if word1's charaters(start at 0) is equal to word2's charaters
		  //start from the end of the word and go back
	      if(word1.charAt(index1-1) == word2.charAt(index2-1)) {
	    	  return isContains(word1, word2, index1-1, word2.length()); //Index1-1 = word1.length-1
	      }
	      //this make it loop back 
	      return isContains(word1, word2, index1, index2-1);
	   
		
	}
	
	/*//this method will not delete the first character and go back 
	public static boolean containCharacter(String word1, char c) { 
		 if(word1.length() == 0)
	           return false;
	
		 //true if word1 is the same character as word2?
		 if(word1.charAt(0) == c) {
			 return true;
		 }
		 
		 //return containCharacter 
		 return containCharacter(word1.substring(1, word1.length()), c);
		  
	}*/
}
