package todolist.servlets.ajax;

import todolist.entity.impl.Task;
import todolist.servlets.AbstractController;
import todolist.utils.TransitionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static todolist.constants.ApplicationConstants.MAX_TASKS_PER_HTML_PAGE;

/**
 * Загружает еще задачи в ту же колонку, без перезагрузки страницы
 */
@WebServlet("/ajax/html/more/tasks-list")
public class TasksListLoadMoreController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer page = Integer.parseInt(req.getParameter("page"));
        List<Task> tasks = getTasksService().getAllTasks(page, MAX_TASKS_PER_HTML_PAGE.getParam());
        req.setAttribute("tasks", tasks);
        TransitionUtils.forwardToFragment("tasks-list.jsp", req, resp);
    }
}