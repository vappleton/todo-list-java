import java.util.*;

public class ToDoList {

    private static Scanner userInput = new Scanner(System.in);
    private static Map<TaskCategory, List<String>> tasks = new HashMap<>();

    public enum TaskCategory {
        WORK, SCHOOL, SELF_CARE, FAMILY
    }

    private static void list(TaskCategory category, String task) {
        tasks.computeIfAbsent(category, k -> new ArrayList<>()).add(task);
    }

    private static void displayTasks() {
        for (TaskCategory category : TaskCategory.values()) {
            System.out.println(category + " Tasks:");
            List<String> taskList = tasks.getOrDefault(category, new ArrayList<>());
            if (taskList.isEmpty()) {
                System.out.println("No tasks in this category.");
            } else {
                for (int i = 0; i < taskList.size(); i++) {
                    System.out.println((i + 1) + ". " + taskList.get(i));
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to your task manager!");

        while (true) {
            System.out.println("Select the type of task you would like to add:");
            System.out.println("1. Work\n2. School\n3. Self-Care\n4. Family\n");

            String categoryInput = userInput.nextLine();
            TaskCategory category = null;

            switch (categoryInput) {
                case "1":
                    category = TaskCategory.WORK;
                    break;
                case "2":
                    category = TaskCategory.SCHOOL;
                    break;
                case "3":
                    category = TaskCategory.SELF_CARE;
                    break;
                case "4":
                    category = TaskCategory.FAMILY;
                    break;
                default:
                    System.out.println("Invalid category. Please choose a valid option.");
                    continue;
            }

            System.out.println("Enter Task Description:");
            String taskDescription = userInput.nextLine();
            list(category, taskDescription);
            System.out.println("Task Added!");

            System.out.println("Would you like to add another task? (Yes/No)");
            String response = userInput.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }

        System.out.println("Would you like to see your to-do list? (Yes/No)");
        String answer = userInput.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            displayTasks();
        } else {
            System.out.println("Goodbye!");
        }

        userInput.close();
    }
}
