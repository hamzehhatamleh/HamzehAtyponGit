import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//  Ahmad's Edition

public class TaskManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();

        System.out.println("Welcome to Simple To-Do List!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask(scanner, tasks);
                    break;
                case 2:
                    viewTasks(tasks);
                    break;
                case 3:
                    deleteTask(scanner, tasks);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addTask(Scanner scanner, List<String> tasks) {
        System.out.print("Enter task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    private static void viewTasks(List<String> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Your Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // this function was added by ahmad
    private static void deleteTask(Scanner scanner, List<String> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to delete.");
        } else {
            System.out.print("Enter the number of the task to delete: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (taskNumber > 0 && taskNumber <= tasks.size()) {   tasks.set(taskNumber - 1, "[Deleted] " + tasks.get(taskNumber - 1));

                tasks.remove(taskNumber - 1); // Remove the task at the specified index
                System.out.println("Task deleted successfully.");
            } else {
                System.out.println("Invalid task number. Please try again.");
            }
        }
    }
}

