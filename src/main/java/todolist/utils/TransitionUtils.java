package todolist.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Utility class for navigating pages
 */
public class TransitionUtils {

    public static void forwardToFragment(String jspFragment, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/JSP/fragment/" + jspFragment).forward(req, resp);
    }
}
