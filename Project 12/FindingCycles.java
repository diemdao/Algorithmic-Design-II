package lab10;
//Diem Dao 
//Nov 29
//section 03
import java.util.*;
public class FindingCycles {
	public static void main(String[] args) {
		AdjMatrix matrix = new AdjMatrix();
		
		matrix.addEdge(2, 1, 1.2);//fromVert, toVert, weight just find any distance there is no required
		matrix.addEdge(3, 1, 1.2);
		matrix.addEdge(1, 5, 1.2);
		matrix.addEdge(5, 2, 1.2);
		matrix.addEdge(5, 3, 1.2);
		matrix.addEdge(5, 7, 1.2);
		matrix.addEdge(4, 2, 1.2);
		matrix.addEdge(6, 3, 1.2);
		matrix.addEdge(7, 4, 1.2);
		matrix.addEdge(7, 6, 1.2);
		
		System.out.println("The Cycles in this graph are");
		matrix.printDFS();
		
	}
}
