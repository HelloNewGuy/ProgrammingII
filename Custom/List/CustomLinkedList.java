package Custom.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CustomLinkedList {
    private Node head;

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public boolean delete(int data) {
        if (head == null) {
            return false;
        }

        if (head.data == data) {
            head = head.next;
            return true;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    public void display() {
        Iterator<Integer> iterator = iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }

        System.out.println();
    }

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            int data = current.data;
            current = current.next;
            return data;
        }
    }

    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        try {
            File file = new File("D:\\github learn\\practice 2\\Programming  II\\Custom\\List\\numbers.txt");
            Scanner input = new Scanner(file);

            while (input.hasNextInt()) {
                linkedList.insert(input.nextInt());
            }

            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please make sure numbers.txt exists.");
        }

        System.out.println("Linked List after reading from the file:");
        linkedList.display();

        System.out.println("Deleting 2 from the list...");
        boolean deleted = linkedList.delete(2);

        if (deleted) {
            System.out.println("2 was deleted.");
        } else {
            System.out.println("2 was not found.");
        }

        System.out.println("Linked List after deletion:");
        linkedList.display();

        System.out.println("Traversing using custom iterator:");
        Iterator<Integer> iterator = linkedList.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}