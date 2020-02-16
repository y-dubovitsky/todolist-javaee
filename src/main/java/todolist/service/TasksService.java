package todolist.service;

import todolist.entity.Task;

import java.util.List;

/**
 * Service providing work with the database
 */
public interface TasksService {

    /**
     * Return all tasks from database
     */
    List<Task> getAllTasks();

}
