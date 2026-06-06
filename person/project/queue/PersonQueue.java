package person.project.queue;

public class PersonQueue {
    private Person[] queue;
    private int size;

    public PersonQueue(int capacity) {
        queue = new Person[capacity];
        size = 0;
    }

    public void add(Person person) {
        if (size < queue.length) {
            queue[size] = person;
            size++;
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(queue[i]);
        }
    }

    public void sortByLastNameDescending() {
        quickSortByLastName(0, size -1);
    }

    public void sortByAgeDescending() {
        quickSortByAge(0, size -1);
    }

    private void quickSortByLastName(int low, int high) {
        if (low < high) {
            int pivotIndex = partitionByLastName(low, high);

            quickSortByLastName(low, pivotIndex - 1);
            quickSortByLastName(pivotIndex + 1, high);
        }
    }

    private int partitionByLastName(int low, int high) {
        String pivot = queue[high].lastName;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (queue[j].lastName.compareToIgnoreCase(pivot) > 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    private void quickSortByAge(int low, int high) {
        if (low < high) {
            int pivotIndex = partitionByAge(low, high);

            quickSortByAge(low, pivotIndex - 1);
            quickSortByAge(pivotIndex + 1, high);
        }
    }

    private int partitionByAge(int low, int high) {
        int pivot = queue[high].age;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (queue[j].age > pivot) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Person temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }
}