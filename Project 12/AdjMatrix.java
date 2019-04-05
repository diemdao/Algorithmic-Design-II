package lab10;
//Diem Dao 
//Nov 29
//section 03
import java.util.*;
public class AdjMatrix {
	private double[][] adjMatrix;
	public static final int DEF_SIZE = 10;
	private LinkedList<Integer> markedList;
	private Queue<Integer> vQ;

	public AdjMatrix() {
		init(DEF_SIZE);
	}
	public AdjMatrix(int size) {
		init(size);
	}
	public void init(int size) {
		if(size<=0)
			return;
		adjMatrix = new double[size][size];
		markedList = new LinkedList<Integer>();
		vQ = new LinkedList<Integer>();
	}
	//addEdge
	public void addEdge(int fromVert, int toVert, double weight) {
		if(!isValid(fromVert) || !isValid(toVert))
			return;
		adjMatrix[fromVert][toVert] = weight;
	}
	private boolean isValid(int index) {
		return index >= 0 && index < adjMatrix.length;
	}
	
	 public void printDFS() 
	  {//just like printDFS but in this lab we want to print out different set of cycles
	    for(int i=0;i<adjMatrix.length;i++) //use for loop 
	    {
	      markedList.clear();
	      printDFS(i);
	    }
	  }
	 
	  public void printDFS(int index)
	  {
	    markedList.add(index); //add index to marked list
	    for(int i=0;i<adjMatrix[index].length;i++)//loop through
	    {
	      if(adjMatrix[index][i] !=0 && markedList.contains(i) == false)//check if the index is valid and wherethe if it's contained
	      {
	        printDFS(i);
	        markedList.remove(markedList.size()-1);
	      }
	      else if(adjMatrix[index][i] !=0 && i == markedList.get(0)) //else if star over again
	      {
	        for(int j=0;j<markedList.size();j++) //checking the marked list
	        {
	          System.out.print(markedList.get(j)+ " ");
	        }
	        System.out.println(markedList.get(0));
	      }
	      
	    }
	  }
	
	/*public void printDFS() {
		markedList.clear();
		printDFS(0);
	}
	private void printDFS(int index) {
		System.out.println(index);
		markedList.add(index);
		for(int i=0; i<adjMatrix[index][i]; i++)
			if(adjMatrix[index][i] != 0 && !markedList.contains(i))
				printDFS(i);
	}
	
	public void printBFS() {
		markedList.clear();
		vQ.clear();
		markedList.add(0);
		vQ.add(0);
		System.out.println(0);
		printBFS(0);
	}
	
	private void printBFS(int index) {
		while(!vQ.isEmpty()) {
			int curr = vQ.remove();
			markedList.add(curr);
			for(int i = 0; i<adjMatrix.length; i++) {
				if(!markedList.contains(i) && !vQ.contains(i) && adjMatrix[curr][i] != 0) {
					System.out.println(i);
					vQ.add(i);
				}
			}
		}
	}*/
	

}
	
	
	

	
