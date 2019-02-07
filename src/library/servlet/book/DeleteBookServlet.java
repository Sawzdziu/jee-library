package library.servlet.book;

import library.model.dao.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("id");

        try {
            BookDAO.deleteBook(Integer.valueOf(bookId));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect(resp.encodeRedirectURL("books.jsp"));
    }
}
