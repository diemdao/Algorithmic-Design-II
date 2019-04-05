package lab08;
//Diem Dao 
//Section 03
//Nov 2
public class ProcessHeap {
	//public static final int DEF_SIZE = 128;
	//instance variables
	//Heap: an array of type Process which represents the heap
	private Process heap[];
	//Size: the number of elements in the heap
	private int size;////looking at last open element 
	
	//Constructors: Default and parameterized
	public ProcessHeap() {//default
		heap = null;
		size = 0;
	}
	//parameterized
	//public ProcessHeap(Process[] aHeap, int aSize) {
	//bc look at the drive
	public ProcessHeap(int aSize) {
		//this.heap = aHeap;
		heap = new Process[aSize];
		this.size = 0;
	}
	
	//insert: this method which returns nothing adds a new element to the heap. 
	//It always adds the next element as the next element in breadth order and then bubbles 
	//it up based on the priority of the Process.
	public void insert(Process aValue) {
		if(size >= heap.length) {
			return;
			}
		heap[size] = aValue;
		//TODO bubble up, to check heap order
		bubbleUp();
		size++;
	}
	//then bubbles it up based on the priority of the Process.
	private void bubbleUp() {
		int index = size;
		while(index > 0 && 
				//heap[(index-1)/2].compareTo(heap[index])<0) {
				(heap[(index-1)/2].getPriority() < heap[index].getPriority())) {
			//Swap
			Process temp = heap[(index-1)/2];
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;//Go up to the parent
			}
	}
	
	
	//peek: this returns the head of the heap
	public Process peek(){
		if(heap == null)
			return null;
		return heap[0];//the head of the heap
	}
	
	//remove: This returns the root of the heap and then removes it from the heap.  
	//It must then move the last element in the heap (via breadth order) 
	//to the root and bubble that value down until it’s in the correct location.
	public Process remove() {
		Process root = peek();
		heap[0] = heap[size-1]; //root become the hat 
		heap[size-1] = null;
		size--;//substract out
		//TODO bubble down
		bubbleDown();
		return root;
	}
	
	private void bubbleDown() {
		int index = 0; 
		while(index*2+1 < size) {//there is a left child
			int bigIndex = index*2+1; //assumes the left is larger, find the smallest child
			if(index*2+2 < size && 
					heap[index*2+1].getPriority() < heap[index*2+2].getPriority())
					{
					bigIndex = index*2+2;//we found out the right was larger
					}
			if(heap[index].getPriority() < heap[bigIndex].getPriority())//parent was smaller
			{
				//swap
				Process temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			else
				break;
			index = bigIndex; //update the index to continue
		}
	}

	//printHeap: Prints the heap out in breadth order
	public void printHeap() {
		for (Process value : heap){ 
			if(value != null)
				System.out.println(value.toString());
			else break;
		}
	}
	
	//isEmpty: returns a true or false value for whether or not the queue is empty
	public boolean isEmpty() {
		return this.heap[0] == null;
	}
	
	
	
	//heapSort: Prints out the heap in sorted order.  The idea is to remove an element print that element 
	//and then repeat that until there are no more elements.
	public void heapSort() {
		for(int i= 0; i<size; i++) {
			System.out.println(remove());
	}
	}
	


}
	
	
	
	
	
	
	
	
	
	
	

