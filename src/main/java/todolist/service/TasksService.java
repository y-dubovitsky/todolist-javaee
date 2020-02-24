package todolist.service;

import todolist.entity.impl.Task;

import java.util.List;

/**
 * Service providing work with the database
 */
public interface TasksService {

    /**
     * Return count of all tasks from database;
     * @return
     */
    long totalTasksCount();

    /**
     * Return all tasks from database
     * @param page - page number
     * @param limit - max task for showing on page
     * @return
     */
    List<Task> getAllTasks(int page, int limit);

    /**
     * Delete task by id
     * @param id
     * @return
     */
    void deleteTask(int id);

    /**
     * Edit task by id
     * @param id
     * @return
     */
    boolean editTask(int id);

    /**
     * Change task by id
     * @param id
     * @return
     */
    boolean changeStateTask(int id, String name, String description);

}
