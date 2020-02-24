package todolist.service;


import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import todolist.service.impl.TaskServiceHibernateImpl;
import todolist.service.impl.TasksServiceJDBCImpl;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class ServiceManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);

    /**
     * Создаем объект класса через Синглтон
     * @param context - контекст приложения
     * @return
     */
    public static ServiceManager getInstance(ServletContext context) {
        ServiceManager instance = (ServiceManager) context.getAttribute("SERVICE_MANAGER");
        if (instance == null) {
            instance = new ServiceManager(context);
            context.setAttribute("SERVICE_MANAGER", instance);
        }
        return instance;
    }

    /**
     * Getters
     * @return
     */
    public TasksService getTasksService() {
        return tasksService;
    }

    public String getApplicationProperty(String key) {
        return applicationProperties.getProperty(key);
    }

    /**
     * Close DataSource
     */
    public void close() {
        //? Добавить close session?
        try {
            dataSource.close();
        } catch (SQLException e) {
            LOGGER.error("Close dataSource failed " + e.getMessage(), e);
        }
    }

    private final Properties applicationProperties = new Properties();
    private BasicDataSource dataSource;
    private Session session;
    private final TasksService tasksService;

    /**
     * Constructor
     * @param context
     */
    private ServiceManager(ServletContext context) {
        tasksService = tasksServiceFactory((String)context.getAttribute("TASK_SERVICE_TYPE"));
    }

    /**
     * Create and init DataSource
     * @return
     */
    private BasicDataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDefaultAutoCommit(false);
        dataSource.setRollbackOnReturn(true); //* когда возврат соединения в пул, если мы не сделали комит, то RollBack
        dataSource.setUrl(getApplicationProperty("db.url"));
        dataSource.setUsername(getApplicationProperty("db.username"));
        dataSource.setPassword(getApplicationProperty("db.password"));
        dataSource.setInitialSize(Integer.valueOf(getApplicationProperty("db.pool.initSize")));
        dataSource.setMaxTotal(Integer.valueOf(getApplicationProperty("db.pool.maxSize")));
        dataSource.setDriverClassName(getApplicationProperty("db.driver"));
        return dataSource;
    }

    /**
     * Hibernate settings
     * Get session
     * @return
     */
    private static Session getSession() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }

    /**
     * Простая фабрика, обеспечивающее простое переключение между разными реализациями работы с БД
     * @param taskServiceType
     * @return
     */
    private TasksService tasksServiceFactory(String taskServiceType) {
        if (taskServiceType.equals("TasksServiceJDBCImpl")) {
            loadApplicationProperties();
            dataSource = createDataSource();
            return new TasksServiceJDBCImpl(dataSource);
        }
        if (taskServiceType.equals("TaskServiceHibernateImpl")) {
            session = getSession();
            return new TaskServiceHibernateImpl(session);
        } else {
            return null;
        }
    }

    /**
     * Load all properties from file.
     */
    private void loadApplicationProperties(){
        try(InputStream in = ServiceManager.class.getClassLoader().getResourceAsStream("application.properties")) {
            applicationProperties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
