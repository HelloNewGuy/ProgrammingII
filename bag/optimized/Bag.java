package bag.optimized;

import java.util.HashMap;
import java.util.Map;

/**
 * Optimized Bag implementation using HashMap.
 * Stores elements and their counts.
 */
public class Bag<T> {

    private Map<T, Integer> items;

    public Bag() {
        items = new HashMap<>();
    }

    // Add an item
    public void add(T item) {
        items.put(item, items.getOrDefault(item, 0) + 1);
    }

    // Remove one occurrence
    public void remove(T item) {
        if (items.containsKey(item)) {
            int count = items.get(item);
            if (count > 1) {
                items.put(item, count - 1);
            } else {
                items.remove(item);
            }
        }
    }

    // Check if item exists
    public boolean contains(T item) {
        return items.containsKey(item);
    }

    // Count occurrences
    public int count(T item) {
        return items.getOrDefault(item, 0);
    }

    /**
     * NEW: returns total number of elements this includes all duplicates.
     */
    public int size() {
        int total = 0;
        for (int count : items.values()) {
            total += count;
        }
        return total;
    }

    /**
     * NEW: Merge another bag into this bag
     */
    public void merge(Bag<T> otherBag) {
        for (Map.Entry<T, Integer> entry : otherBag.items.entrySet()) {
            T item = entry.getKey();
            int count = entry.getValue();

            items.put(item, items.getOrDefault(item, 0) + count);
        }
    }

    /**
     * NEW: Return a new bag with only distinct elements (count - 1)
     */
    public Bag<T> distinct() {
        Bag<T> distinctBag = new Bag<>();

        for (T item : items.keySet()) {
            distinctBag.add(item); // only once
        }

        return distinctBag;
    }

    @Override
    public String toString() {
        return items.toString();
    }
}