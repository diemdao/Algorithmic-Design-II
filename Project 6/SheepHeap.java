package hw07;
//Diem Dao 
//Section 03, CSCE146
//Nov 09
public class SheepHeap {
	public static final int DEF_SIZE = 100; //default size of array 
	//instance variables
	private Sheep heap[];
	//Size: the number of elements in the heap
	private int size;//looking at last open element 
	
	//Constructors: Default and parameterized
	public SheepHeap() {//default
		heap = new Sheep [DEF_SIZE];
		size = 0;
	}
	public SheepHeap(int aSize) {
		heap = new Sheep[aSize];//change to the size that the user put in
		this.size = 0;
	}
	
	//addSheep: inserts a new instance of a sheep.  The sheep should be added to the bottom of the heap
	//and it is expected to climb up the heap until it’s on top of a heavier sheep but below a light sheep.
	public void addSheep(Sheep aValue) {
		if(size >= heap.length) {
			return;
			}
		heap[size] = aValue;
		//TODO climbUp, to check heap order
		climbUp();
		size++;
	}
	//climbUp: used by addSheep to allow the sheep to climb the heap and get in the right place.
	private void climbUp() {
		int index = size;
		while(index > 0 && 
				(heap[(index-1)/2].getWeight() < heap[index].getWeight())) {
			//Swap
			Sheep temp = heap[(index-1)/2];
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;//Go up to the parent
			}
	}
	
	//peek: this returns the head of the heap
		public Sheep peek(){
			if(heap == null)
				return null;
			return heap[0];//the head of the heap
		}
	//removeSheep: removes the sheep from atop the heap.  Then the sheep on the bottom of the heap, 
	//is put on the top and climbs down until it’s where it needs to be.
	public Sheep removeSheep() {
		Sheep root = peek();
		heap[0] = heap[size-1]; //root become the hat 
		heap[size-1] = null;
		size--;//substract out
		//TODO climbDown
		climbDown();
		return root;
	}
	//climbDown:  Used by remove sheep to move the sheep down to the right place.  Always pick the lighter 
	//of the sheep below it and swap if the current sheep is heavier than the lighter one.
	private void climbDown() {
		int index = 0; 
		while(index*2+1 < size) {//there is a left child
			int bigIndex = index*2+1; //assumes the left is larger, find the smallest child
			if(index*2+2 < size && 
					heap[index*2+1].getWeight() < heap[index*2+2].getWeight())
					{
					bigIndex = index*2+2;//we found out the right was larger
					}
			if(heap[index].getWeight() < heap[bigIndex].getWeight())//parent was smaller
			{
				//swap
				Sheep temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			else
				break;
			index = bigIndex; //update the index to continue
		}
	}
	
	
	
	 //sheepRollCall: Print out the sheep’s name and weight in breadth order
	public void SheepRollCall() {
		for(Sheep sheep : heap) {
			if(sheep != null) {
				System.out.println(sheep.toString());
			}
			else break;
		}
	}
	
	//sheepHeapSort: return a sorted array of sheep. It should preserve the heap.
	public void sheepHeapSort() {
		SheepHeap temp = new SheepHeap(heap.length);
		Sheep arrayHeap[] = heap.clone(); //create a copy of the heap
		for (int i = 0; i < size; i++) {
			temp.addSheep(arrayHeap[i]); //populate
		}
		for (int i = size; i >= 0; i--) {
			if (temp.peek() != null) { //checking value
				System.out.println(temp.removeSheep());
			}
		}
	}
	
}

