package hw07;
//Diem Dao 
//Section 03, CSCE146
//Nov 09
import java.util.*;
import java.io.*;
public class SheepHeapTester {
	public static void main(String[] args) {
		
		SheepHeap heap = new SheepHeap();
		
		// It should add 15 sheep
		System.out.println("Adding 15 sheeps");
		System.out.println("Calling the sheep");
		Sheep sheep1 = new Sheep("Sheep1 ", 2.9);
		heap.addSheep(sheep1);
		Sheep sheep2 = new Sheep("Sheep2 ", 3.2);
		heap.addSheep(sheep2);
		Sheep sheep3 = new Sheep("Sheep3 ", 3.8);
		heap.addSheep(sheep3);
		Sheep sheep4 = new Sheep("Sheep4 ", 2.8);
		heap.addSheep(sheep4);
		Sheep sheep5 = new Sheep("Sheep5 ", 6.9);
		heap.addSheep(sheep5);
		Sheep sheep6 = new Sheep("Sheep6 ", 2.2);
		heap.addSheep(sheep6);
		Sheep sheep7 = new Sheep("Sheep7 ", 4.3);
		heap.addSheep(sheep7);
		Sheep sheep8 = new Sheep("Sheep8 ", 0.8);
		heap.addSheep(sheep8);
		Sheep sheep9 = new Sheep("Sheep9 ", 5.8);
		heap.addSheep(sheep9);
		Sheep sheep10 = new Sheep("Sheep10 ", 2.8);
		heap.addSheep(sheep10);
		Sheep sheep11 = new Sheep("Sheep11 ", 1.9);
		heap.addSheep(sheep11);
		Sheep sheep12 = new Sheep("Sheep12 ", 7.2);
		heap.addSheep(sheep12);
		Sheep sheep13 = new Sheep("Sheep13 ", 3.3);
		heap.addSheep(sheep13);
		Sheep sheep14 = new Sheep("Sheep14 ", 3.1);
		heap.addSheep(sheep14);
		Sheep sheep15 = new Sheep("Sheep15 ", 6.0);
		heap.addSheep(sheep15);

		heap.SheepRollCall();
		
		//Remove at least 5
		System.out.println("\nRemoving 5 sheep");
		for(int i = 0 ; i< 5; i++) {
			heap.removeSheep();
		}
		heap.SheepRollCall();

		//Demonstrate that these work by calling the sheep roll call
		//Then show the sheep heap sort works 
		System.out.println("\nHeap sort");
		heap.sheepHeapSort();
	}
}
