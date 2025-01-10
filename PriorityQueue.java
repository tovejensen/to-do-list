/*
 * A priority queue interface for objects that implement the 
 * Comparable interface.
 * This interface considers the minimum value to be the highest
 * priority.
 */
 
public interface PriorityQueue<T extends Comparable<T>> {
	
	/*
	* Purpose: Adds element into the PriorityQueue at the position according to the element's priority.
	* Parameters: T element
	* Throws: HeapFullException - if the PriorityQueue is full.
	*/
	public void insert(T element);

	/*
	* Purpose: Remove highest priority element from the PriorityQueue, where the smallest value will be of highest priority.
	* Parameters: None.
	* Returns: T - the highest priority object in the Queue.
	* Throws: HeapEmptyException - if the PriorityQueue is empty.
	*/
	public T removeMin();

	/*
	* Purpose: Determines if the PriorityQueue is empty or not.
	* Parameters: None.
	* Returns: boolean - true if PriorityQueue is empty, false otherwise.
	*/
	public boolean isEmpty();	

	/*
	* Purpose: Determines number of elements in the PriorityQueue.
	* Parameters: None.
	* Returns: int - the number of elements in the PriorityQueue.
	*/			
	public int size ();

}
 
