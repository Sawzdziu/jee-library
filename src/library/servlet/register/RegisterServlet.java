package library.servlet.register;

import library.model.dao.UsersDAO;
import library.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String city = req.getParameter("city");
        String email = req.getParameter("email");
        String role = req.getParameter("role");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (!validateForm(name, surname, city, email, role, username, password)) {
            if (userExist(username))
                resp.sendRedirect(resp.encodeRedirectURL("register.jsp?userExist"));
            else {
                UsersDAO.addUser(new User(name, surname, role, username, password, city));
                req.getSession().setAttribute("username", username);
                resp.sendRedirect(resp.encodeRedirectURL("index.jsp"));
            }
        } else {
            resp.sendRedirect(resp.encodeRedirectURL("register.jsp?validationError"));
        }
    }

    private boolean validateForm(String name, String surname, String city, String email, String role, String username, String password) {
        return name.isEmpty()
                || surname.isEmpty()
                || city.isEmpty()
                || email.isEmpty()
                || role.isEmpty()
                || username.isEmpty()
                || password.isEmpty();
    }


    private boolean userExist(String username) {
        return UsersDAO.getAllUsers().stream().anyMatch(user -> user.getLogin().equals(username));
    }
}
