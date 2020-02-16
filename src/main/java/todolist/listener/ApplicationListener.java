package todolist.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import todolist.constants.ApplicationConstants;
import todolist.service.impl.ServiceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Starting when application initialized
 */
public class ApplicationListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);
    private ServiceManager serviceManager;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            serviceManager = (ServiceManager) sce.getServletContext().getAttribute(ApplicationConstants.SERVICE.name()); //! В этот момент создается синглтон сервиса
        } catch (RuntimeException e) {
            LOGGER.error("");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        serviceManager.close();
        LOGGER.info("Application destroyed");
    }
}
