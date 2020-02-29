package todolist.servlets;

import todolist.utils.TransitionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/personal-area")
public class PersonalAreaController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TransitionUtils.forwardToPage("personal-area.jsp", req, resp);
    }
}
