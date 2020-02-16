package todolist.service.impl;

import todolist.constants.ApplicationConstants;
import todolist.service.TasksService;

import javax.servlet.ServletContext;

public class ServiceManager {

    private final TasksService tasksService;

    //! Singleton
    public static ServiceManager getInstance(ServletContext servletContext) {
        ServiceManager serviceManager = (ServiceManager) servletContext.getAttribute("SERVICE_MANAGER");
        if(serviceManager == null) {
            serviceManager = new ServiceManager();
            servletContext.setAttribute(ApplicationConstants.SERVICE.name(), serviceManager); //? Плохо так
        }
        return serviceManager;
    }


    private ServiceManager() {
        tasksService = new TasksServiceImpl();
    }

    public void close() {
        //?
    }

    public TasksService getTasksServiceImpl() {
        return tasksService;
    }
}
