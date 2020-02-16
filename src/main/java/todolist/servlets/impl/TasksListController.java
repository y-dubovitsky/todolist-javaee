package todolist.servlets.impl;

import todolist.entity.Task;
import todolist.servlets.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tasks-list")
public class TasksListController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Task> tasks = getTasksService().getAllTasks(); //* делаем запрос к сервису и возвращаем список всех задач
        req.setAttribute("currentPage", "page/tasks.jsp");
        req.getRequestDispatcher("WEB-INF/JSP/page-template.jsp").forward(req, resp);
    }
}
