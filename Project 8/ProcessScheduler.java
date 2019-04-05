package lab05;
//written by Diem Dao
//Sep 26, 2018
//Section 3
public class ProcessScheduler {
	//attributes
	//Processes: This is a linked list queue of processes. Hence forth known as the “process queue”.
	private LinkedListQueue<Process> processes;
	//Current Process: This is the currently running process of type Process.
	private Process currentProcess;
	
	//default constructors
	public ProcessScheduler() {
		processes = new LinkedListQueue<Process>();
		currentProcess = null;
	}
	
	//getCurrentProcess: This method takes no parameters and returns the currently running process. 
	//Note that this is not the first element of the process queue.
	public Process getCurrentProcess() {
		return currentProcess;
	}
	
	//addProcess: Taking in a process via a parameter it either sets the current process if the 
	//current process is null or it adds it to the process queue. 
	//Also it doesn’t return any values.
	public void addProcess(Process p) { //it take in 'p' look at the drive
		if(currentProcess == null)//current process is null
		{
			currentProcess = p;
		}
		else {//or it adds it to the process queue. 
			processes.enqueue(p);
		}
	}
	
	//runNextProcess: This method dequeues from the process queue and sets that to the 
	//current process.
	public void runNextProcess() {
		currentProcess = processes.dequeue();
	}
	
	//cancelCurrentProcess: The current process is cancelled and is replaced by the first element 
	//on the process queue. Make sure that the process is also removed from the process queue after 
	//the current process has been set. Neither parameters nor return values are expected for this method.
	public void cancelCurrentProcess() {
		currentProcess = null;
		processes.dequeue();
	}
	
	//printProcessQueue: This method should print all of the elements from the process queue.
	public void printProcessQueue() {
		processes.print();
	}
}
