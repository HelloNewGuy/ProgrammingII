package School;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(5, "Alice", "New York"));
        students.add(new Student(2, "Bob", "Chicago"));
        students.add(new Student(8, "Charlie", "Dallas"));
        students.add(new Student(1, "David", "Boston"));
        students.add(new Student(4, "Eve", "Miami"));
        students.add(new Student(10, "Frank", "Seattle"));
        students.add(new Student(3, "Grace", "Denver"));
        students.add(new Student(7, "Hannah", "Atlanta"));
        students.add(new Student(6, "Ian", "Phoenix"));
        students.add(new Student(9, "Jack", "Austin"));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n======= Student Menu =======");
            System.out.println("1 - View Original List");
            System.out.println("2 - Sort by Name");
            System.out.println("3 - Sort by Roll Number");
            System.out.println("4 - Exit Menu");
            System.out.println("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1: // Original List
                    System.out.println("\nOriginal List:");
                    printList(students);
                    break;

                case 2: // Sort by Name
                    SelectionSort.selectionSort(students, new StudentComparator.NameComparator());
                    System.out.println("\nSorted by Name:");
                    printList(students);
                    break;

                case 3: // Sort by Roll Number
                    SelectionSort.selectionSort(students, new StudentComparator.RollNoComparator());
                    System.out.println("\nSorted by Roll Number:");
                    printList(students);
                    break;

                case 4: // Close program
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        scanner.close();
    }

    public static void printList(ArrayList<Student> students) {
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
