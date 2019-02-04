package library.model.entity;

public class Book {

    private static Integer actualID = 0;
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

    public Book(String title, String isbn, Integer year) {
        this(actualID++, title, isbn, year);
    }

    public Book(Integer id, String title, String isbn, Integer year) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
