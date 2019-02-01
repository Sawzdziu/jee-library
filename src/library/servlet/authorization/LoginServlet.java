package library.servlet.authorization;

import library.model.dao.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (isValid(username, password)) {
            req.getSession().setAttribute("username", username);
            resp.sendRedirect(resp.encodeRedirectURL("index.jsp"));

        } else {
            resp.sendRedirect(resp.encodeRedirectURL("login.jsp?invalidLogin"));
        }
    }

    private boolean isValid(String username, String password) {
        return UsersDAO.getAllUsers().stream().anyMatch(user -> user.getLogin().equals(username) && user.getPassword().equals(password));
    }
}
