package com.prince;

public class TaskManager {

    private final TaskRepository repository;
    private int nextId = 1;

    public TaskManager(TaskRepository repository) {
        this.repository = repository;
    }

    public Task addTask(String title) {
        Task task = new Task(nextId, title);
        repository.save(task);
        nextId++;

        return task;
    }

    public Task getTask(int id) {
        return repository.findById(id);
    }

    public void completeTask(int id) {
        Task task = repository.findById(id);

        if (task == null) {
            throw new IllegalArgumentException("Task not found");
        }

        task.complete();
    }

    public void deleteTask(int id) {
        Task task = repository.findById(id);

        if (task == null) {
            throw new IllegalArgumentException("Task not found");
        }

        repository.delete(id);
    }
}