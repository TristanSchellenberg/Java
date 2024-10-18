import java.util.ArrayList;
import java.util.Scanner;

public class TaskManagerApp {
    public static void main(String[] args) {
        ArrayList<String> taskList = new ArrayList<>();
        Scanner userInput = new Scanner(System.in);
        
        while (true) {
            displayTasks(taskList);
            displayMenu();

            int userChoice = userInput.nextInt();
            userInput.nextLine(); // clear newline

            switch (userChoice) {
                case 1:
                    addTask(taskList, userInput);
                    break;
                case 2:
                    removeTask(taskList, userInput);
                    break;
                case 3:
                    System.out.println("Exiting Task Manager.");
                    userInput.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Display the current list of tasks
    public static void displayTasks(ArrayList<String> tasks) {
        System.out.println("==== Current Task List ====");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println("===========================");
    }

    // Display the menu options
    public static void displayMenu() {
        System.out.println("1. Add a new task");
        System.out.println("2. Remove a task");
        System.out.println("3. Exit Tristan's app");
        System.out.print("Enter your choice: ");
    }

    // Add a new task to the list
    public static void addTask(ArrayList<String> tasks, Scanner input) {
        System.out.print("Enter the task to add: ");
        String newTask = input.nextLine();
        tasks.add(newTask);
        System.out.println("Task added successfully!");
    }

    // Remove a task from the list
    public static void removeTask(ArrayList<String> tasks, Scanner input) {
        System.out.print("Enter the task number to remove: ");
        int taskNumber = input.nextInt();
        input.nextLine(); // clear newline

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
