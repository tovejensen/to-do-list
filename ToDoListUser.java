import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Calendar;

/*
 * A user interface for managing a ToDoList through the command line.
 * Allows users to add tasks, view the highest-priority task, see the total number of tasks, and exit the.
 */
public class ToDoListUser{

    /*
     * Main method to run the to-do list program. Provides a console-based menu for interacting with the to-do list.
     * Parameters: String[] args - command-line arguments (not used in this program).
     */
    public static void main(String[] args){
        ToDoList toDo = new ToDoList();
        Scanner scan = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        int choice = 0;

        System.out.println("\nWelcome to your To-Do List!");

        while(choice != 4){
            System.out.print("\n=== Enter a number to choose an action: ===\n\n1. Add task\n2. View your highest priority task\n3. View how many tasks you have\n4. Exit\n\nEnter action number:");
            
            try{
                choice = scan.nextInt();
                scan.nextLine();
                if(choice == 1){

                    System.out.print("\nTask name:");
                    String taskName = scan.nextLine();

                    System.out.print("Priority number:");
                    int taskPriority = scan.nextInt();
                    scan.nextLine();

                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    int minute = cal.get(Calendar.MINUTE);
                    Task t = new Task(taskPriority, taskName, new Time(hour, minute));
                    toDo.addTask(t);
                    System.out.println("\nSuccessfully added!");
                }
                else if(choice == 2){
                    Task top = toDo.nextTask();
                    System.out.println("\nNext Task: " + top);
                }
                else if(choice == 3){
                    System.out.println("\nNumber of tasks in To-do list: " + toDo.numberTasksToDo());
                }
                else if(choice == 4){
                    return;
                }
                else{
                    System.out.println("\nInvalid choice. Try again.");
                }
                System.out.print("\nPress Enter to continue:");
                scan.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("\nPlease try again and enter a valid number.");
                System.out.print("\nPress Enter to continue:");
                scan.nextLine();
                scan.nextLine();
            }
            catch (HeapFullException e){
                System.out.println("\nTo-Do list is full. Please remove some tasks to continue task addition.");
                System.out.print("\nPress Enter to continue:");
                scan.nextLine();
            }
            catch (HeapEmptyException e){
                System.out.println("\nTo-Do list is empty, no more tasks to complete.");
                System.out.print("\nPress Enter to continue:");
                scan.nextLine();
            }   
        }
        scan.close();
    }
}