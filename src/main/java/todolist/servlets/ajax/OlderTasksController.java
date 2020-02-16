package todolist.servlets.ajax;

import todolist.servlets.AbstractController;
import todolist.utils.TransitionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajax/html/older/products")
public class OlderTasksController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TransitionUtils.forwardToFragment("tasks-list.jsp", req, resp);
    }
}