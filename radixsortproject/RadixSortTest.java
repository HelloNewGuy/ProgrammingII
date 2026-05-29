package radixsortproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class RadixSortTest {

    public static void main(String[] args) {

        ArrayList<Integer> numbersList = new ArrayList<>();

        try {
            Scanner fileReader = new Scanner(new File("D:\\github learn\\practice 2\\Programming  II\\radixsortproject\\numbers.txt"));

            while (fileReader.hasNextInt()) {
                numbersList.add(fileReader.nextInt());
            }

            fileReader.close();

            Integer[] numbers = numbersList.toArray(new Integer[0]);

            System.out.println("Original Array:");
            System.out.println(Arrays.toString(numbers));

            RadixSort.radixSort(numbers);

            System.out.println("\nSorted Array:");
            System.out.println((Arrays.toString(numbers)));

        } catch (FileNotFoundException e) {
            System.out.println("Error: numbers.txt not found.");
        }
    }
}
