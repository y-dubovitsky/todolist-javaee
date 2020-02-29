package todolist.servlets;

import todolist.service.ServiceManager;
import todolist.service.SocialNetworkService;
import todolist.service.TasksService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet {

    private TasksService tasksService;
    private SocialNetworkService networkService;

    @Override
    public void init() throws ServletException {
        tasksService = ServiceManager.getInstance(getServletContext()).getTasksService();
        networkService = ServiceManager.getInstance(getServletContext()).getSocialNetworkService();
    }

    public final TasksService getTasksService() {
        return tasksService;
    }

    public SocialNetworkService getNetworkService() {
        return networkService;
    }
}