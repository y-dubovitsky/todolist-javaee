package todolist.servlets.impl;

import com.vk.api.sdk.client.VkApiClient;
import todolist.servlets.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign-in")
public class SignInController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getNetworkService().getCode(resp);
    }
}
