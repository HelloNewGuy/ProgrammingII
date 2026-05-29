package radixsortproject;

public class RadixSort {

    public static void radixSort(Integer[] array) {
        int max = getMax(array);

        // Sort by each digit place (1s, 10s, 100s...)
        for (int place = 1; max / place > 0; place *= 10) {
            countingSortByDigit(array, place);
        }
    }

    private static int getMax(Integer[] array) {
        int max = array[0];

        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private static void countingSortByDigit(Integer[] array, int place) {
        int n = array.length;
        Integer[] output = new Integer[n];
        int[] count = new int[10];

        // Count digit occurrences
        for (int num : array) {
            int digit = (num / place) % 10;
            count[digit]++;
        }

        // Convert count into position indexes
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array from right to left
        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / place) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        // Copy sorted values back
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }
}