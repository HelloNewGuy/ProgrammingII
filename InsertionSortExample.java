import java.util.Arrays;

public class InsertionSortExample {

    public static void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];
            int j = i - 1;

            while (j >= 0 && numbers[j] > current) {
                numbers[j + 1] = numbers[j];
                j--;
            }

            numbers[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {34, 12, 25, 9, 67, 3, 18};

        System.out.println("Before sorting: " + Arrays.toString(numbers));

        insertionSort(numbers);

        System.out.println("After sorting: " + Arrays.toString(numbers));
    }
}