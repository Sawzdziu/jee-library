package library.model.dao;

import library.model.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book("Pan Tadeusz", "ISBN-123456789", 1987));
        books.add(new Book("Makbet", "ISBN-1324356446", 1998));
        books.add(new Book("Rok 1984", "ISBN-000000000", 1984));
        books.add(new Book("W pustyni i w puszczy", "ISBN-99999888877", 1975));
    }

    public static void addBook(Book book) {
        boolean exist = books.stream().noneMatch(u -> u.equals(book));
        if (exist) {
            books.add(book);
        }
    }

    public static List<Book> getAllBooks() {
        return books;
    }

    public static void deleteBook(Integer id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    public static void updateBook(Integer id, String title, String isbn, Integer year) {
        books.stream().filter(book -> book.getId().equals(id)).forEach(book -> {
            book.setTitle(title);
            book.setIsbn(isbn);
            book.setYear(year);
        });
    }
}
