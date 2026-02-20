package School;

import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSort {

    public static void selectionSort(ArrayList<Student> list, Comparator<Student> comparator) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            // swap elements
            Student temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }
}
