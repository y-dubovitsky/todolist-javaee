package todolist.servlets.impl;

import todolist.servlets.AbstractController;
import todolist.utils.TransitionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-task")
public class DeleteTaskController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Before " + getTasksService().totalTasksCount());
        int taskId = Integer.parseInt(req.getParameter("task-id"));
        getTasksService().deleteTask(taskId);
        System.out.println("After " + getTasksService().totalTasksCount());
        req.setAttribute("currentPage", "page/tasks.jsp");
        TransitionUtils.forwardToPageTemplate(req, resp);
    }
}
