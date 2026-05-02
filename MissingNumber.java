public class MissingNumber {
    public static int findMissing(int[] arr) {
        int n = arr.length;

        // Step 1: Expected sum from 1 to n+1
        int expectedSum = (n + 1) * (n + 2) / 2;

        // Step 2: Actual sum of array
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        // Step 3: Missing number
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 5, 1, 4};
        System.out.println("Missing number: " + findMissing(arr));
    }
}