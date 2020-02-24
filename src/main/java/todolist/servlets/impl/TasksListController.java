package todolist.servlets.impl;

import todolist.entity.impl.Task;
import todolist.servlets.AbstractController;
import todolist.utils.PageUtils;
import todolist.utils.TransitionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static todolist.constants.ApplicationConstants.*;

@WebServlet("/tasks-list")
public class TasksListController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Task> tasks = getTasksService().getAllTasks(1, MAX_TASKS_PER_HTML_PAGE.getParam()); //* делаем запрос к сервису и возвращаем список всех задач
        req.setAttribute("tasks", tasks);
        long totalTasks = getTasksService().totalTasksCount();
        long totalPages = PageUtils.pagesTotalCount(totalTasks, MAX_TASKS_PER_HTML_PAGE.getParam());
        req.setAttribute("totalTasks", totalTasks);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", "page/tasks.jsp");
        TransitionUtils.forwardToPageTemplate(req, resp);
    }
}
