package library.model.entity;

public class Book {

    private Integer id;
    private String title;
    private String isbn;
    private Integer year;

    public Book() {
        this.id = -1;
        this.title = "Title";
        this.isbn = "ISBN";
        this.year = 0;
    }

    public Book(Integer id, String title, String isbn, Integer year) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
    }
}
