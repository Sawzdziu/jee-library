package library.servlet.book;

import library.model.dao.BookDAO;
import library.model.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createBook")
public class CreateBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String isbn = req.getParameter("isbn");
        String year = req.getParameter("year");

        if (!validateForm(title, isbn, year)) {
            BookDAO.addBook(new Book(title, isbn, Integer.valueOf(year)));
            resp.sendRedirect(resp.encodeRedirectURL("index.jsp"));
        } else {
            resp.sendRedirect(resp.encodeRedirectURL("createBook.jsp?validationError"));
        }
    }

    private boolean validateForm(String title, String isbn, String year) {
        return title.isEmpty() || isbn.isEmpty() || year.isEmpty();
    }
}
