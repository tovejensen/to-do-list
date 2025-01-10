/*
 * A priority queue implemented with a min-heap to maintain o(logn) runtime.
 * Implements PriorityQueue interface.
 */
public class HeapPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

	protected final static int DEFAULT_SIZE = 10000;
	
	protected T[] storage;
	protected int currentSize;
	
	private static final int rootIndex = 1; //heap root index begins at 1

	/*
	* Purpose: Initialize this instance of HeapPriorityQueue with default size of 10001
	* Parameters: Class<T> dataType
	*/
	@SuppressWarnings({"unchecked"})
	public HeapPriorityQueue(Class<T> dataType) {
		storage = (T[]) java.lang.reflect.Array.newInstance(dataType, DEFAULT_SIZE+1);
		currentSize = 0;
	}
	
	/*
	* Purpose: Initialize this instance of HeapPriorityQueue with size determined by user
	* Parameters: Class<T> clazz, int size
	*/
	@SuppressWarnings({"unchecked"})
	public HeapPriorityQueue(Class<T> clazz, int size) {
		storage = (T[]) java.lang.reflect.Array.newInstance(clazz, size+1);
		currentSize = 0;
	}

	public void insert (T element) throws HeapFullException {
		if(isFull()){
			throw new HeapFullException();
		}
		if(currentSize==0){
			storage[rootIndex] = element;
			currentSize++;
		}
		else{
			currentSize++;
			storage[currentSize] = element;
			bubbleUp(currentSize);
		}	
    }
	
	/*
	* Purpose: recursively moves up element at parameter's index until heap property is restored
	* Parameters: int index
	*/
	private void bubbleUp(int index) {
		if(index <= 1 || storage[index].compareTo(storage[index/2])>=0){
			return;
		}
		else{
			swap(index, index/2);
			bubbleUp(index/2);
		}
	}
		
	/*
	* Purpose: Swaps elements at parameter's indices
	* Parameters: int i1, int i2
	*/
	private void swap(int i1, int i2){
		T temp = storage[i1];
		storage[i1] = storage[i2];
		storage[i2] = temp;
	}
	
	public T removeMin() throws HeapEmptyException {
		if(isEmpty()){
			throw new HeapEmptyException();
		}
		swap(1, currentSize);
		T temp = storage[currentSize];
		storage[currentSize] = null;
		currentSize--;
		bubbleDown(1);
		return temp;
	}
	
	/*
	* Purpose: recursively moves element at parameter's index down in heap until heap property is maintained
	* Parameters: int index
	*/
	private void bubbleDown(int index) {
		int leftChildI = index*2;
		int rightChildI = index*2+1;
		int minChildI;
		if(leftChildI>currentSize){
			return;
		}
		else if(rightChildI > currentSize || storage[rightChildI].compareTo(storage[leftChildI]) >= 0){
			minChildI = leftChildI;
		}
		else{
			minChildI = rightChildI;
		}
		if(storage[index].compareTo(storage[minChildI]) < 0){
			return;
		}
		else{
			swap(index, minChildI);
			bubbleDown(minChildI);
		}
	}

	public boolean isEmpty(){
		return(currentSize==0);
	}
	
	/*
	* Purpose: Returns whether heap is full
	* Parameters: nothing
	* Returns: boolean - boolean value of whether heap is full
	*/
	public boolean isFull() {
		return(currentSize+1==storage.length);
	}
	
	public int size () {
		return currentSize;
	}

	/*
	* Purpose: returns a String representing this HeapPriorityQueue formated as:
	*          storage[1] ... storage[n]
	* Parameters: none
	* Returns: String - a representation of this HeapPriorityQueue
	*/
	public String toString() {
		String s = "";
		String sep = "";
		for(int i=1; i<=currentSize; i++) {
			s += sep + storage[i];
			sep = " ";
		}
		return s;
	}
}
