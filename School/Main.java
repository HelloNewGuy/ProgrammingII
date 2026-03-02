package School;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> originalList = new ArrayList<>();

        addStudent(originalList, 5, "Alice", "New York");
        addStudent(originalList, 2, "Bob", "Chicago");
        addStudent(originalList, 8, "Charlie", "Dallas");
        addStudent(originalList, 1, "David", "Boston");
        addStudent(originalList, 4, "Eve", "Miami");
        addStudent(originalList, 10, "Frank", "Seattle");
        addStudent(originalList, 3, "Grace", "Denver");
        addStudent(originalList, 7, "Hannah", "Atlanta");
        addStudent(originalList, 6, "Ian", "Phoenix");
        addStudent(originalList, 9, "Jack", "Austin");

        ArrayList<Student> workingList;

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n======= Student Menu =======");
            System.out.println("1 - View Original List");
            System.out.println("2 - Sort by Name");
            System.out.println("3 - Sort by Roll Number");
            System.out.println("4 - Search by Roll Number");
            System.out.println("5 - Exit Menu");
            System.out.println("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {

                case 1: // Original List
                    System.out.println("\nOriginal List:");
                    printList(originalList);
                    break;

                case 2: // Sort by Name
                    workingList = new ArrayList<>(originalList);
                    SelectionSort.selectionSort(workingList,
                            new StudentComparator.NameComparator());
                    System.out.println("\nSorted by Name:");
                    printList(workingList);
                    break;

                case 3: // Sort by Roll Number
                    workingList = new ArrayList<>(originalList);
                    SelectionSort.selectionSort(workingList,
                            new StudentComparator.RollNoComparator());
                    System.out.println("\nSorted by Roll Number:");
                    printList(workingList);
                    break;

                case 4: // Search by Roll Number
                    System.out.print("Enter Roll Number to search:");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid Roll Number.");
                        scanner.next();
                        break;
                    }

                    int roll = scanner.nextInt();
                    searchStudent(originalList, roll);
                    break;

                case 5: // Close program
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    // Rule: No duplicate
    public static void addStudent(ArrayList<Student> list,
                                  int rollno,
                                  String name,
                                  String address) {

        for (Student s : list) {
            if (s.getRollno() == rollno) {
                System.out.println("Duplicate roll number not allowed" + rollno);
                return;
            }
        }

        try {
            list.add(new Student(rollno, name, address));
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public static void searchStudent(ArrayList<Student> list, int rollno) {

        boolean found = false;

        for (Student s : list) {
            if (s.getRollno() == rollno) {
                System.out.println("\nStudent Found");
                System.out.println(s);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public static void printList(ArrayList<Student> students) {
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
