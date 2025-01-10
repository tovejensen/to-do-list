/*
 * Represents a ToDoList that manages tasks using a HeapPriorityQueue.
 * Tasks are prioritized based on their priority level and insertion time.
 */
public class ToDoList {

	private PriorityQueue<Task> tasks;
	
	/*
     * Constructs an empty ToDoList that stores Tasks with a default-sized HeapPriorityQueue.
     */
	public ToDoList() {
		tasks = new HeapPriorityQueue<Task>(Task.class);
	}

	/*
     * Constructs an empty ToDoList that stores Tasks with a HeapPriorityQueue of a specified size.
	 * Parameters: int size
     */
	public ToDoList(int size) {
		tasks = new HeapPriorityQueue<Task>(Task.class, size);
	}

	/*
     * Adds a task to the ToDoList.
     * Parameters: Task t.
     * Throws: HeapFullException if the ToDoList is full.
     */
	public void addTask(Task t) {
		try{
			tasks.insert(t);
		}
		catch(HeapFullException e){
			throw new HeapFullException();
		}
	}
	
	/*
     * Returns current ToDoList size.
     * Parameters: None.
     * Returns: int - number of Tasks in ToDoList.
     */
	public int numberTasksToDo() {
		return tasks.size();
	}

	/*
     * Removes and returns task with minimum priority or time added.
     * Parameters: None.
     * Returns: Task - most urgent Task.
	 * Throws: HeapEmptyException if ToDoList is empty
     */
	public Task nextTask() {
		try{
			return tasks.removeMin();
		}
		catch(HeapEmptyException e){
			throw new HeapEmptyException();
		}
	}
}

