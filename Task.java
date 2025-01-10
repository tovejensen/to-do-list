/*
 * Represents a Task in a to-do list, describes a priority rating, title and time of insertion.
 */
public class Task implements Comparable<Task>{

	private int priorityLevel;
	private String title;
	private Time insertionTime;

	/*
	* Purpose: Initialize instance of Task with a task priority level, title and time of being made
	* Parameters: int priorityLevel, String title, Time insertionTime
	*/
	public Task(int priorityLevel, String title, Time insertionTime) {
		this.priorityLevel = priorityLevel;
		this.title = title;
		this.insertionTime = insertionTime;
	}

	/*
	* Purpose: Get the Task's priority level.
	* Parameters: None.
	* Returns: int - the Task's priority level.
	*/
	public int getPriorityLevel() {
		return priorityLevel;
	}

	/*
	* Purpose: Set the Task's priority level.
	* Parameters: int priorityLevel.
	*/
	public void setPriorityLevel (int priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	/*
	* Purpose: Get the Task's title.
	* Parameters: None.
	* Returns: String - the Task's title.
	*/
	public String getTitle() {
		return title;
	}

	/*
	* Purpose: Set the Task's title.
	* Parameters: String name.
	*/
	public void setTitle (String name) {
		this.title = name;
	}

	/*
	* Purpose: Get the Task's time created.
	* Parameters: None.
	* Returns: Time - the Task's time created.
	*/
	public Time getTime() {
		return insertionTime;
	}

	/*
	* Purpose: Set the Task's time created.
	* Parameters: Time checkinTime.
	*/
	public void setTime (Time checkinTime) {
		this.insertionTime = checkinTime;
	}

	/*
	* Purpose: returns a String representing this Task's title
	* Parameters: none
	* Returns: String - a representation of this Task
	*/
	public String toString() {
		return title;
	}

	/* Purpose: returns the result of comparing this priorityLevel and
	 *          other priorityLevel if they are not equal
 	 *	        if priorityLevels are equal, it returns the result of 
	 *          comparing this checkinTime to other checkinTime
	 * Parameters: Task other
	 * Precondition: other is not null
	 * Returns: a value < 0 if this Task is before other Task
	 *          a value == 0 if this Task is the same as other Task
	 *          a value > 0 if this Task is after other Task
	 */
	public int compareTo(Task other) {
		if (this.priorityLevel == other.priorityLevel){
			if(this.insertionTime.compareTo(other.insertionTime) == 0){
				return 0;
			}
			else if (this.insertionTime.compareTo(other.insertionTime) > 0){
				return 1;
			}
			else{
				return -1;
			}
		}
		else if (this.priorityLevel<other.priorityLevel){
			return -1;
		}
		else{
			return 1;
		}
	}

	/* Purpose: determines whether the title of this Task
	 *          is the same as the other Task's title
	 * Parameters: Task other
	 * Precondition: other is not null
	 * Returns: true if this Task is the same as other, false otherwise
	 */
	public boolean equals(Task other) {
		if(this == null || other == null){
			return false;
		}
		else if(this.title.compareTo(other.getTitle()) == 0){
			return true;
		}else{
			return false;
		}
	}
}

