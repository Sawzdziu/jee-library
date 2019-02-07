package library.servlet.book;

import library.model.dao.BookDAO;
import library.model.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/editBook")
public class EditBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(resp.encodeRedirectURL("editBook.jsp?id=" + req.getParameter("id")));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookId");
        String title = req.getParameter("title");
        String isbn = req.getParameter("isbn");
        String year = req.getParameter("year");

        if (!validateForm(bookId, title, isbn, year)) {
            try {
                BookDAO.updateBook(Integer.valueOf(bookId), title, isbn, Integer.valueOf(year));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect(resp.encodeRedirectURL("books.jsp"));
        } else {
            resp.sendRedirect(resp.encodeRedirectURL("editBook.jsp?validationError&id=" + bookId));
        }
    }

    private boolean validateForm(String bookId, String title, String isbn, String year) {
        return bookId.isEmpty() || title.isEmpty() || isbn.isEmpty() || year.isEmpty();
    }
}
