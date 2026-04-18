package fruit.bag;

import java.util.Scanner;

/**
 * Demonstration of optimized Bag class.
 * it works O(1) instead of O(n).
 * This helps for faster response when pulling counts
 * Since it is interactive user adds, removes, checks, and pulls items count
 */
public class BagDemo {

    public static void main(String[] args) {

        Bag<String> bag = new Bag<>();
        Scanner input = new Scanner(System.in);

        int choice;

        do {
            // Menu
            System.out.println("\n===== BAG MENU =====");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Check if item is in the bag");
            System.out.println("4. Count items in the bag");
            System.out.println("5. View the contents of the bag");
            System.out.println("0. Exit the bag");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter item to add: ");
                    String addItem= input.nextLine();
                    bag.add(addItem);
                    System.out.println(addItem + " added.");
                    break;

                case 2:
                    System.out.print("Enter item to remove: ");
                    String removeItem= input.nextLine();
                    bag.remove(removeItem);
                    System.out.println("One occurrence of " + removeItem + " removed (if it existed)");
                    break;

                case 3:
                    System.out.print("Enter item to check: ");
                    String checkItem = input.nextLine();
                    System.out.println("Contains " + checkItem + "? " + bag.contains(checkItem));
                    break;

                case 4:
                    System.out.print("Enter item to count: ");
                    String countItem= input.nextLine();
                    System.out.println("Count of " + countItem + ": " + bag.count(countItem));
                    break;

                case 5:
                    System.out.print("Bag contents: " + bag);
                    break;

                case 0:
                    System.out.print("Exiting program ... Good bye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        input.close();
    }
}