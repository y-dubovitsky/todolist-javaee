package todolist.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import todolist.service.ServiceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static todolist.constants.ApplicationConstants.TASK_SERVICE_TYPE;

/**
 * Starting when application initialized
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);
    private ServiceManager serviceManager;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            //! В этом блоке кода инициализируется serviceManager когда приложение стартует
            sce.getServletContext().setAttribute("TASK_SERVICE_TYPE", TASK_SERVICE_TYPE.getValue()); //? Как эффективнее использовать Enum
            serviceManager = ServiceManager.getInstance(sce.getServletContext());
        } catch (RuntimeException e) {
            LOGGER.error("Web application 'todo-list' init failed: "+e.getMessage(), e);
            throw e;
        }
        LOGGER.info("Web application 'todo-list' initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        serviceManager.close();
        LOGGER.info("Web application 'todo-list' destroyed");
    }
}
