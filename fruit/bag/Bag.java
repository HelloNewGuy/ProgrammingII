package fruit.bag;

import java.util.HashMap;
import java.util.Map;

/**
 * Optimized Bag implementation using Hashmap.
 * Stores each item with its frequency (count).
 * @param <T> the type of elements stored in the bag
 */
public class Bag<T> {

    // Map to store item -> count
    private Map<T, Integer> items;

    /**
     * Constructor initializes the Map
     */
    public Bag() {
        items = new HashMap<>();
    }

    /**
     * Adds an item to the bag.
     * If the item already exists, increment its count.
     * @param item the item to add
     */
    public void add(T item) {
        items.put(item, items.getOrDefault(item, 0) + 1);
    }

    /**
     * Removes one occurrence of the specified item from the bag.
     * If the count becomes zero, remove the item completely.
     * @param item the item remove
     */
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

    /**
     * Checks whether the bag contains the specified item.
     * @param item the item to check
     * @return true if the item exists, false otherwise
     */
    public boolean contains(T item) {
        return items.containsKey(item);
    }

    /**
     * Returns number of occurrences of the specified item.
     * @param item the item to count
     * @return number of occurrences (0 if not present)
     */
    public int count(T item) {
        return items.getOrDefault(item, 0);
    }

    /**
     * Returns a string representation of the bag contents.
     */
    @Override
    public String toString() {
        return items.toString();
    }
}