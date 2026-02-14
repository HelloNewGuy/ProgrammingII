import java.util.Scanner;
import java.util.InputMismatchException;

public class RecursiveProduct {

    // Recursive method to calculate product
    public static double calculateProduct(double[] numbers, int index) {
        // Base Case
        if (index == numbers.length - 1) {
            return numbers[index];
        }

        // Recursive Case
        return numbers[index] * calculateProduct(numbers, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[5];

        System.out.println("Enter five numbers:");

        int count = 0;

        while (count < 5) {
            try {
                System.out.print("Number " + (count + 1) + ": ");
                numbers[count] = scanner.nextDouble();
                count++; // Only move on to the next index if input is valid
            } catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }

        double product = calculateProduct(numbers, 0);

        System.out.println("The product of the five numbers is: " + product);

        scanner.close();
    }
}