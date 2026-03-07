package Library;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Book> mainInventory;
    private ArrayList<Book> borrowedBooks;

    public Inventory() {
        mainInventory = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
    }

    // add book
    public boolean addBook(Book book) {

        for (Book b : mainInventory) {
            if (b.getId() == book.getId()) {
                return false; //duplicate id
            }
        }

        mainInventory.add(book);
        return true;
    }

    // Borrow book
    public boolean borrowBook(int id) {

        for (Book b : mainInventory) {
            if(b.getId() == id) {
                borrowedBooks.add(b);
                mainInventory.remove(b);
                return true;
            }
        }

        return false;
    }

    // Return book
    public boolean returnBook(int id) {

        for (Book b : borrowedBooks) {
            if(b.getId() == id) {
                mainInventory.add(b);
                borrowedBooks.remove(b);
                return true;
            }
        }

        return false;
    }

    // Print all books
    public void printAll() {

        if (mainInventory.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : mainInventory) {
            b.printBookInfo();
        }
    }

    // Search by title
    public void searchByTitle(String title) {

        boolean found = false;

        for (Book b : mainInventory) {

            if(b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                b.printBookInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching book found.");
        }
    }

    public int getMainInventoryCount() {
        return mainInventory.size();
    }
}