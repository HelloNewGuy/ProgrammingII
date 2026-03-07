package Library;

import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        int choice = 0;

        while (choice != 6) {

            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search by Title");
            System.out.println("5. Print All Books");
            System.out.println("6. Exit");

            try {

                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Id: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();

                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();

                        System.out.print("Enter Pages: ");
                        int pages = scanner.nextInt();

                        Book newBook = new Book(id, title, author, isbn, pages);

                        if (inventory.addBook(newBook)) {
                            System.out.println("Book added to the library.");
                        } else {
                            System.out.println("Book ID already exists.");
                        }

                        break;

                    case 2:

                        System.out.print("Enter book ID to borrow: ");
                        int borrowId = scanner.nextInt();

                        if (inventory.borrowBook(borrowId)) {
                            System.out.println("Book successfully borrowed.");
                        } else {
                            System.out.println("Book not found or already borrowed.");
                        }

                        break;

                    case 3:

                        System.out.print("Enter book ID to return: ");
                        int returnId = scanner.nextInt();

                        if (inventory.returnBook(returnId)) {
                            System.out.println("Book successfully returned.");
                        } else {
                            System.out.println("Book not found in borrowed list.");
                        }

                        break;

                    case 4:

                        System.out.print("Enter title to search: ");
                        String searchTitle = scanner.nextLine();

                        inventory.searchByTitle(searchTitle);

                        break;

                    case 5:

                        inventory.printAll();

                        break;

                    case 6:

                        System.out.println("Exiting the program. Goodbye!");

                        break;

                    default:

                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {

                System.out.println("Invalid input. Please enter correct data.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
