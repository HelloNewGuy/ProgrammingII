import java.util.Arrays;

public class BinarySerachEx {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9};

        int index = Arrays.binarySearch(numbers, 3);

        if (index >= 0) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found.");
        }
    }
}
