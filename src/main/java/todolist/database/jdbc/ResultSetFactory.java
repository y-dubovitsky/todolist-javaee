package todolist.database.jdbc;

import todolist.entity.impl.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetFactory {

    public static final ResultSetHandler<Task> TASK_RESULT_SET_HANDLER = new ResultSetHandler<Task>() {

        /**
         * Этот метод преобразует Result set в объект T
         * @param resultSet
         * @return
         * @throws SQLException
         */
        @Override
        public Task resultSetHandler(ResultSet resultSet) throws SQLException {
            if (resultSet != null) {
                Task task = new Task();
                task.setId(resultSet.getLong("id"));
                task.setName(resultSet.getString("name"));
                task.setCreationTime(resultSet.getTimestamp("creation_time"));
                task.setDescription(resultSet.getString("description"));
                task.setId_importance(resultSet.getInt("id_importance"));
                return task;
            }
            return null;
        }
    };

    public static final List<Task> getListResultSetHandler(ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            List<Task> tasks = new ArrayList<>();
            while (resultSet.next()) {
                tasks.add(TASK_RESULT_SET_HANDLER.resultSetHandler(resultSet));
            }
            return tasks;
        }
        return null;
    }
}
