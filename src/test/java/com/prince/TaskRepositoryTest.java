package com.prince;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TaskRepositoryTest {

    /**
     * Given that I have added multiple tasks to repo.
     * When delet and I try to search the deleted task--
     * Then I should get a null. 
     */
    @Test
    void testDelete() {

        // Given: 
        TaskRepository repo = new TaskRepository();
        Task task1 = new Task(1, "taskOne");
        Task task2 = new Task(2, "TaskTwo");

        repo.save(task1);
        repo.save(task2);

        assertNotNull(repo.findById(1));

        // When: 
        repo.delete(1);

        // Then:
        assertThrows(IllegalArgumentException.class,() -> {
            repo.findById(1);
        });

        
    }


    /**
     * Given that I have a valid repository with multiple tasks in it.
     * When I retrieve the repository--
     * Then I should get a list containing all the tasks.
     */
    @Test
    void testFindAll() {
        
        // Given: 
        TaskRepository repo = new TaskRepository();
        Task task1 = new Task(1, "taskOne");
        Task task2 = new Task(2, "TaskTwo");

        repo.save(task1);
        repo.save(task2);

        // When & Then:
        assertEquals(repo.findAll().size(), 2);
    }


    /**
     * Given that I have created a repository and added multiple tasks correctly. 
     * When I search for a particular task by it's ID--
     * Then I should get that task back.
     */
    @Test
    void testFindById() {

        // Given:
        TaskRepository repo = new TaskRepository();
        Task task1 = new Task(1, "taskOne");
        Task task2 = new Task(2, "TaskTwo");

        repo.save(task1);
        repo.save(task2);
        
        // When & Then:
        assertEquals(repo.findById(1), task1);
        assertEquals(repo.findById(2), task2);
    }


    /**
     * Given that I have created a task and repository.
     * When I attempt to save my task into the repository--
     * Then the repository should store my task.
     */
    @Test
    void testSave() {

        // Given:
        TaskRepository repo = new TaskRepository();
        Task task = new Task(123, "Go-through-practise");
        assertNotNull(task);
        assertNotNull(repo);
        
        // When:
        repo.save(task);

        // Then:
        assertEquals(repo.findById(task.getId()), task);
    }
}
