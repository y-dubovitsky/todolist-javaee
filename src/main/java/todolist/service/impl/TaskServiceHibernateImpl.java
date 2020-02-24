package todolist.service.impl;

import org.hibernate.Session;
import todolist.entity.impl.Task;
import todolist.service.TasksService;
import org.hibernate.query.Query;

import java.util.List;

public class TaskServiceHibernateImpl implements TasksService {

    private Session session;

    public TaskServiceHibernateImpl(Session session) {
        this.session = session;
    }

    /**
     * Return count of all tasks from database;
     *
     * @return
     */
    @Override
    public long totalTasksCount() {
        Query query = session.createQuery("select count(*) from todolist.entity.impl.Task"); // case matters "Tar or tar"
        long totalCount = (Long)query.uniqueResult();
        return totalCount;
    }

    @Override
    public List<Task> getAllTasks(int page, int limit) {
        int offset = (page - 1) * limit; //* offset - это с какой позиции выводить объекты из БД
        Query query = session.createQuery("from todolist.entity.impl.Task"); // case matters "Tar or tar"
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        List<Task> list = query.list();
        return list;
    }

    /**
     * Delete task by id
     *
     * @param id
     * @return
     */
    @Override
    public void deleteTask(int id) {
        Task task = session.get(Task.class, Long.valueOf(id)); //! Переделать сигнатуру?
        if(task != null){
            session.beginTransaction();
            session.delete(task);
            session.getTransaction().commit();
        }
    }


    /**
     * Edit task by id
     *
     * @param id
     * @return
     */
    @Override
    public boolean editTask(int id) {
        return false;
    }

    /**
     * Change task by id
     *
     * @param id
     * @param name
     * @param description
     * @return
     */
    @Override
    public boolean changeStateTask(int id, String name, String description) {
        return false;
    }
}
