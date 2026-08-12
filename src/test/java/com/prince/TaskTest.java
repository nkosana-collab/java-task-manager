package com.prince;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TaskTest {


    /**
     * Given that a task was incomplete, 
     * Then I complete it--
     * When I check the status of the same task it should be completed. 
     */
    @Test
    void testComplete() {

        // Given:
        int id = 12345;
        String title = "register-students";
        Task task = new Task(id, title);

        assertFalse(task.isCompleted());

        // Then:
        task.complete();

        // When:
        assertTrue(task.isCompleted());
    }


    /**
     * Given that I have successfully created a new task.
     * Then I should be able to retrieve the task ID.
     */
    @Test
    void testGetId() {
       
        // Given:
        Task task = new Task(123, "count-stock");
        assertNotNull(task);

        // Then:
        assertEquals(123, task.getId());
    }


    /**
     * Given that I have successfully created a new task.
     * Then I should be able to retrieve the task title.
     */
    @Test
    void testGetTitle() {

        // Given:
        Task task = new Task(246, "pay-accounts");
        assertNotNull(task);

        // Then:
        assertEquals("pay-accounts", task.getTitle());
    }


    /**
     * Given that I have just correctly created a new task--
     * Then when I check its status immedeately it should say that it is not complete
     */
    @Test
    void testIsCompleted() {

        // Given:
        Task task = new Task(12345, "block-chain");
        assertNotNull(task);

        // Then when:
        assertFalse(task.isCompleted());
    }

    /**
     * Given that a task is created succefully.
     * When I retrieve the task a string--
     * Then I should get a string containing the task ID, Title and Completion status.
     */
    @Test
    void testToString() {

        // Given:
        Task task = new Task(123, "last task");
        assertNotNull(task);

        // When:
        String takString = task.toString();

        // Then: 
        String expected = task.getId() + ". " + task.getTitle() + " [" + "Incomplete" + "]";
        assertEquals(expected, takString);

        task.complete();
        String expected1 = task.getId() + ". " + task.getTitle() + " [" + "Completed" + "]";
        assertEquals(expected1, task.toString());
    }
}
