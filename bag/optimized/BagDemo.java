package bag.optimized;

import java.util.Scanner;

/**
 * Interactive program demonstration all Bag features.
 */
public class BagDemo {

    public static void main(String[] args) {

        Bag<String> bag1 = new Bag<>();
        Bag<String> bag2 = new Bag<>();

        Scanner input = new Scanner(System.in);

        int choice;
        int activeBag = 1; // Default selection

        do {
            System.out.println("\n===== BAG MENU =====");
            System.out.println("Currently using: Bag" + activeBag);
            System.out.println("1. Switch active bag");
            System.out.println("2. Add item");
            System.out.println("3. Remove item");
            System.out.println("4. Check item");
            System.out.println("5. Count item");
            System.out.println("6. View current bag");
            System.out.println("7. View both bags");
            System.out.println("8. Size of current bag");
            System.out.println("9. Merge other bag into current");
            System.out.println("10. Show distinct items (Current bag)");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine(); // consume newline

            // Determine which bag is active
            Bag<String> current = (activeBag == 1) ? bag1 : bag2;
            Bag<String> other = (activeBag == 1) ? bag2 : bag1;

            switch (choice) {

                case 1:
                    System.out.print("Select bag (1 or 2): ");
                    int selected = input.nextInt();
                    if (selected == 1 || selected == 2) {
                        activeBag = selected;
                    } else {
                        System.out.println("Invalid selection.");
                    }
                    break;

                case 2:
                    System.out.print("Enter item to add: ");
                    String addItem = input.nextLine();
                    current.add(addItem);
                    System.out.println(addItem + " added.");
                    break;

                case 3:
                    System.out.print("Enter item to remove: ");
                    String removeItem = input.nextLine();
                    current.remove(removeItem);
                    System.out.println("Removed one occurrence (if it existed).");
                    break;

                case 4:
                    System.out.print("Enter item to check: ");
                    String checkItem = input.nextLine();
                    System.out.println("Exists? " + current.contains(checkItem));
                    break;

                case 5:
                    System.out.print("Enter item to count: ");
                    String countItem = input.nextLine();
                    System.out.println("Count: " + current.count(countItem));
                    break;

                case 6:
                    System.out.println("Current Bag: " + current);
                    break;

                case 7:
                    System.out.println("Bag1: " + bag1);
                    System.out.println("Bag2: " + bag2);
                    break;

                case 8:
                    System.out.println("Size: " + current.size());
                    break;

                case 9:
                    current.merge(other);
                    System.out.println("Other bag merged into current bag.");
                    break;

                case 10:
                    Bag<String> distictBag = current.distinct();
                    System.out.println("Distinct elements: " + distictBag);
                    break;

                case 0:
                    System.out.println("Exiting... Goodbye!!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);

        input.close();
    }
}