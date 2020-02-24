package todolist.servlets;

import todolist.service.ServiceManager;
import todolist.service.TasksService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet {

    private TasksService tasksService;

    @Override
    public void init() throws ServletException {
        tasksService = ServiceManager.getInstance(getServletContext()).getTasksService();
    }

    public final TasksService getTasksService() {
        return tasksService;
    }
}