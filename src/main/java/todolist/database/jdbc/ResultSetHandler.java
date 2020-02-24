package todolist.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Интерфейс, позволяющий преобразовать результат sql запроса в объект
 * @param <T>
 */
public interface ResultSetHandler<T> {

    /**
     * Этот метод устанавливает правила преобразования ResultSet в объект Entity
     * @param resultSet
     * @return
     */
    T resultSetHandler(ResultSet resultSet) throws SQLException;

}
