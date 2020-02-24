package todolist.service.impl;

import todolist.database.jdbc.ResultSetFactory;
import todolist.entity.impl.Task;
import todolist.exception.InternalApplicationException;
import todolist.service.TasksService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TasksServiceJDBCImpl implements TasksService {

    /**
     * A factory for connections to the physical data source that this DataSource object represents.
     */
    private DataSource dataSource;

    /**
     * Constructor
     * @param dataSource
     */
    public TasksServiceJDBCImpl(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    /**
     * Return count of all tasks from database;
     *
     * @return
     */
    @Override
    public long totalTasksCount() {
        return 0;
    }

    @Override
    public List<Task> getAllTasks(int page, int limit) {
        try(Connection connection = dataSource.getConnection()) {
            int offset = (page - 1) * limit;
            PreparedStatement preparedStatement = connection.prepareStatement("select * from task limit ? offset ?");
            preparedStatement.setInt(1, limit); //TODO Улучшить! Декомпозировать метод
            preparedStatement.setInt(2, offset);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Task> tasks = ResultSetFactory
                    .getListResultSetHandler(resultSet);
            return tasks;
        } catch (SQLException e) {
            throw new InternalApplicationException("Cant execute sql query " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteTask(int id) {

    }

    @Override
    public boolean editTask(int id) {
        return false;
    }

    @Override
    public boolean changeStateTask(int id, String name, String description) {
        return false;
    }
}
