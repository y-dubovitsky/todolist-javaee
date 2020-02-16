package todolist.servlets;

import todolist.service.impl.ServiceManager;
import todolist.service.TasksService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet {

    private TasksService tasksService;

    @Override
    public void init() throws ServletException {
        TasksService serviceManager = ServiceManager.getInstance(getServletContext()).getTasksServiceImpl();
    }

    public final TasksService getTasksService() {
        return tasksService;
    }
}
