package com.prince;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TaskManagerTest {

    private TaskRepository repo = new TaskRepository();
    private TaskManager manager = new TaskManager(repo);


    /**
     * Given that I have provided a valid title
     * Then the TaskManager must create a valid task.
     */
    @Test
    void testAddTask() {

        // Given:
        Task task = manager.addTask("add-pipeline");

        // Then:
        assertTrue(task instanceof Task);
    }


    /**
     * Given That I complete a task.
     * Then the TaskManager must keep track of task status update.
     */
    @Test
    void testCompleteTask() {

        // Given:
        Task task = manager.addTask("add-dockerfile");
        manager.completeTask(task.getId());

        // Then:
        assertTrue(task.isCompleted());

    }

    /**
     * Given That I have created a task.
     * When I delete that task and then try to search that task--
     * Then I should get an error.
     */
    @Test
    void testDeleteTask() {

        // Given:
        Task task = manager.addTask("new-task");
        assertNotNull(manager.getTask(task.getId()));

        // When:
        manager.deleteTask(task.getId());

        // Then:
        assertThrows(IllegalArgumentException.class, () -> {
            manager.getTask(task.getId());
        });

    }


    /**
     * Given That I have created a new task.
     * When I try to retrieve that task--
     * Then I should get that task in return.
     */
    @Test
    void testGetTask() {

        // Given:
        Task task = manager.addTask("last-task");

        // When & Then:
        assertEquals(task, manager.getTask(task.getId()));
    }
}
