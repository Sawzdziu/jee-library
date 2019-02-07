package library.model.dao;

import library.model.DataBaseConnector;
import library.model.entity.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class BookDAO {

    static {
        try {
            addBook(new Book("Pan Tadeusz", "ISBN-123456789", 1987));
            addBook(new Book("Makbet", "ISBN-1324356446", 1998));
            addBook(new Book("Rok 1984", "ISBN-000000000", 1984));
            addBook(new Book("W pustyni i w puszczy", "ISBN-99999888877", 1975));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean bookExist(Book book) throws SQLException {
        String bookExist = "SELECT 1 FROM book WHERE title = ? AND isbn = ? limit 1;";
        PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(bookExist);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getIsbn());
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    public static void addBook(Book book) throws SQLException {
        if (!bookExist(book)) {
            String addBook = "INSERT INTO \"book\" (title, isbn, year) VALUES (?, ?, ?);";
            PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(addBook);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getIsbn());
            statement.setInt(3, book.getYear());
            statement.executeUpdate();
            statement.close();
        }
    }

    public static List<Book> getAllBooks() throws SQLException {
        ResultSet resultSet;
        Statement statement = DataBaseConnector.getConnection().createStatement();
        resultSet = statement.executeQuery("SELECT * FROM \"book\"");
        List<Book> books = new LinkedList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String isbn = resultSet.getString("isbn");
            Integer year = resultSet.getInt("year");
            books.add(new Book(id, title, isbn, year));
        }
        statement.close();
        return books;
    }

    public static void deleteBook(Integer id) throws SQLException {
        String deleteBook = "DELETE FROM \"book\" WHERE id = ?;";
        PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(deleteBook);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public static void updateBook(Integer id, String title, String isbn, Integer year) throws SQLException {
        String updateBook = "UPDATE \"book\" SET title = ?, isbn = ?, year = ? WHERE id = ?;";
        PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(updateBook);
        statement.setString(1, title);
        statement.setString(2, isbn);
        statement.setInt(3, year);
        statement.setInt(4, id);
        statement.executeUpdate();
    }
}
