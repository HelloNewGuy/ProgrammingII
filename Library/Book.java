package Library;

public class Book {

    private int id;
    private String title;
    private String author;
    private String isbn;
    private int pages;

    // Default constructor
    public Book() {
        id = 0;
        title = "";
        author = "";
        isbn = "";
        pages = 0;
    }

    // Parameterized constructor
    public Book(int id, String title, String author, String isbn, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPages() {
        return pages;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    // print book info
    public void printBookInfo() {
        System.out.println("--------------------------");
        System.out.println("ID : " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Pages: " + pages);
    }
}