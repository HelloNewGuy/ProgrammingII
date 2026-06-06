package person.project.queue;

import java.util.Scanner;

public class Main {

    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z -]+");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        PersonQueue queue = new PersonQueue(5);

        for (int i = 0; i < 5; i++) {

            System.out.println("\nEnter information for person #" + (i + 1));

            String firstName;

            do {
                System.out.print("First Name: ");
                firstName = input.nextLine().trim();

                if (!isValidName(firstName)) {
                    System.out.println("Invalid input. Names may only contain letters, spaces, and hyphens.");
                }
            } while (!isValidName(firstName));

            String lastName;

            do {
                System.out.print("Last Name: ");
                lastName = input.nextLine().trim();

                if (!isValidName(lastName)) {
                    System.out.println("Invalid input. Names may only contain letters, spaces, and hyphens.");
                }
            } while (!isValidName(lastName));

            int age = 0;
            boolean validAge = false;

            while (!validAge) {

                System.out.print("Age: ");

                if (input.hasNextInt())   {

                    age = input.nextInt();

                    if (age > 0) {
                        validAge = true;
                    } else {
                        System.out.println("Age must be greater than 0.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                }

                input.nextLine();
            }

            queue.add(new Person(firstName, lastName, age));
        }
        System.out.println("\n=================================");
        System.out.println("ORIGINAL QUEUE");
        System.out.println("=================================");
        queue.display();

        queue.sortByLastNameDescending();

        System.out.println("\n=================================");
        System.out.println("SORTED BY LAST NAME (DESCENDING");
        System.out.println("=================================");
        queue.display();

        queue.sortByAgeDescending();

        System.out.println("\n=================================");
        System.out.println("SORTED BY AGE (DESCENDING)");
        System.out.println("=================================");
        queue.display();

        input.close();
    }
}