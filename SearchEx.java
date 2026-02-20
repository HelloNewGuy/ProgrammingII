public class SearchEx {

    // Linear Search Method
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // return index if found
            }
        }
        return -1; // return -1 if not found
    }

    public static void main(String[] args) {
        int[] numbers = {10, 25, 30, 45, 50};

        int result = linearSearch(numbers, 30);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}