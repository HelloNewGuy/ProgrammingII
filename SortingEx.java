import java.util.Arrays;

// Bubble Sorting Example
public class SortingEx {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
         int[] numbers = {5, 2, 9, 1, 6};

         System.out.println("Before Sorting: " + Arrays.toString(numbers));

         bubbleSort(numbers);

         System.out.println("After sorting: " + Arrays.toString(numbers));
    }
}
