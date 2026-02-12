public class RecursionMethod {

    public static void countdown(int n) {

        // Base Case
        if (n == 0) {
            System.out.println("Done!");
            return;
        }

        System.out.println(n);

        // Recursive call
        countdown(n - 1);
    }

    public static void main(String[] args) {
        countdown(5);
    }
}