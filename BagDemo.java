import java.util.HashMap;
import java.util.Map;

/**
 * Optimized generic Bag class using HashMap.
 * A bag allows duplicate elements and stores
 * how many times each item appears.
 */
class Bag<T> {
    // Stored items and their frequencies
    private Map<T, Integer> items;

    /**
     * constructor initializes the HashMap.
     */

    public Bag() {
        items = new HashMap<>();
    }

    /**
     * Adds one occurrence of an item to the bag.
     */
    public void add(T item) {
        items.put(item, items.getOrDefault(item, 0) + 1);
    }

    /**
     * Removes one occurrence of an item if it exists.
     */
    public void remove(T item) {

        // Check if item exists
        if (items.containsKey(item)) {

            int count = items.get(item);

            // Decrease count if more than one exists
            if (count > 1) {
                items.put(item, count - 1);
            }

            // Remove item completely if only one exists
            else {
                items.remove(item);
            }
        }
    }

    /**
     * Returns true if the item exists in the bag.
     */
    public boolean contains(T item) {
        return items.containsKey(item);
    }

    /**
     * Returns the number of occurrences of an item.
     */
    public int count(T item) {
        return items.getOrDefault(item, 0);
    }

    /**
     * Returns the total number of elements,
     * including duplicates.
     */
    public int size() {

        int total = 0;

        // Add all frequencies together
        for (int count : items.values()) {
            total += count;
        }

        return total;
    }

    /**
     * Merges another bag into the current abg.
     */
    public void merge(Bag<T> otherBag) {

        // Loop through all entries in otherBag
        for (Map.Entry<T, Integer> entry : otherBag.items.entrySet()) {

            T item = entry.getKey();
            int count = entry.getValue();

            // Add counts together
            items.put(item, items.getOrDefault(item, 0) + count);
        }
    }

    /**
     * Returns a new bag containing only distinct elements.
     * Each item appears once.
     */
    public Bag<T> distinct() {

        Bag<T> distinctBag = new Bag<>();

        // Add each unique item once
        for (T item : items.keySet()) {
            distinctBag.add(item);
        }

        return distinctBag;
    }

    /**
     * Returns bag contents as a string.
     */
    @Override
    public String toString() {
        return items.toString();
    }
}

/**
 * Demonstrates all Bag functionality.
 */
public class BagDemo {

    public static void main(String[] args) {

        // create two bag objects
        Bag<String> bag1 = new Bag<>();
        Bag<String> bag2 = new Bag<>();

        // ----------------------------
        // Add elements to Bag1
        // ----------------------------
        bag1.add("Apple");
        bag1.add("Apple");
        bag1.add("Banana");
        bag1.add("Orange");

        // ----------------------------
        // Add elements to Bag2
        // ----------------------------
        bag2.add("Banana");
        bag2.add("Orange");
        bag2.add("Orange");
        bag2.add("Grapes");

        // ----------------------------
        // Print original bag contents
        // ----------------------------
        System.out.println("Bag1: " + bag1);
        System.out.println("Bag2: " + bag2);

        // ----------------------------
        // Test size()
        // ----------------------------
        System.out.println("\nSize of Bag1: " + bag1.size());
        System.out.println("Size of Bag2: " + bag2.size());

        // ----------------------------
        // Test contains()
        // ----------------------------
        System.out.println("\nBag1 contains Apple? " + bag1.contains("Apple"));
        System.out.println("Bag1 contains Mango? " + bag1.contains("Mango"));

        // ----------------------------
        // Test count()
        // ----------------------------
        System.out.println("\nCount of Apple in Bag1: " + bag1.count("Apple"));
        System.out.println("Count of Banana in Bag1: " + bag1.count("Banana"));
        System.out.println("Count of Mango in Bag1: " + bag1.count("Mango"));

        // ----------------------------
        // Remove one occurrence
        // ----------------------------
        bag1.remove("Apple");

        System.out.println("\nAfter removing one Apple:");
        System.out.println("Bag1: " + bag1);
        System.out.println("Count of Apple in Bag1: " + bag1.count("Apple"));

        // ----------------------------
        // Merge Bag2 into Bag1
        // ----------------------------
        bag1.merge(bag2);

        System.out.println("\nAfter merging Bag2 into Bag1:");
        System.out.println("Merged Bag1:" + bag1);
        System.out.println("Merged Bag1 Size: " + bag1.size());

        // ----------------------------
        // Create distinct bag
        // ----------------------------
        Bag<String> distinctBag = bag1.distinct();

        System.out.println("\nDistinct elements in Bag1:");
        System.out.println(distinctBag);
    }
}
