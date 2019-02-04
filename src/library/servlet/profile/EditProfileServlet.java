package library.servlet.profile;

import library.model.dao.UsersDAO;
import library.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editProfile")
public class EditProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String city = req.getParameter("city");
        String role = req.getParameter("role");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (!validateForm(id, name, surname, city, role, username, password)) {
            if (userExist(username))
                resp.sendRedirect(resp.encodeRedirectURL("editProfile.jsp?userExist"));
            else {
                UsersDAO.updateUser(Integer.valueOf(id), name, surname, role, username, password, city);
                req.getSession().setAttribute("username", username);
                resp.sendRedirect(resp.encodeRedirectURL("index.jsp"));
            }
        } else {
            resp.sendRedirect(resp.encodeRedirectURL("editProfile.jsp?validationError"));
        }
    }

    private boolean validateForm(String id, String name, String surname, String city, String role, String username, String password) {
        return id.isEmpty()
                || name.isEmpty()
                || surname.isEmpty()
                || city.isEmpty()
                || role.isEmpty()
                || username.isEmpty()
                || password.isEmpty();
    }


    private boolean userExist(String username) {
        return UsersDAO.getAllUsers().stream().anyMatch(user -> user.getLogin().equals(username));
    }
}
