/*
 * Exception thrown when attempting to remove an element from an empty heap.
 * Extends RuntimeException.
 */
public class HeapEmptyException extends RuntimeException {
	
	/*
	* Purpose: Constructs a runtime exception with a detail message.
	* Parameters: String msg
	*/
	public HeapEmptyException(String msg) {
		super(msg);
	}

	/*
	*Purpose: Constructs a runtime exception without a detail message.
	* Parameters: None.
	*/
	public HeapEmptyException() {
		super();
	}
	
}
