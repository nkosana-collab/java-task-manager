package com.prince;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TaskRepository repository = new TaskRepository();
        TaskManager manager = new TaskManager(repository);

        boolean running = true;

        while (running) {

            System.out.println("\n--- Task Manager ---");
            System.out.println("1. Add task");
            System.out.println("2. List tasks");
            System.out.println("3. Complete task");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();

                    Task task = manager.addTask(title);

                    System.out.println("Task created: " + task);
                    break;

                case 2:
                    System.out.println("\nTasks:");

                    if (repository.findAll().isEmpty()) {
                        System.out.println("No tasks.");
                    } else {
                        for (Task currentTask : repository.findAll()) {
                            System.out.println(currentTask);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task ID: ");
                    int completeId = scanner.nextInt();

                    try {
                        manager.completeTask(completeId);
                        System.out.println("Task completed.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter task ID: ");
                    int deleteId = scanner.nextInt();

                    try {
                        manager.deleteTask(deleteId);
                        System.out.println("Task deleted.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}