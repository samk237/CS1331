import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic implementation of a singly linked list.
 * This class represents a linked list, where each node stores data and a reference to the next node.
 * The list supports common operations such as adding, removing, and retrieving elements.
 * @author Samuel Khang
 * @version 2.0
 * @param <T> the type of data stored in the linked list
 */
public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;

    /**
     * Constructs an empty linked list.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Constructs a linked list from an array of data.
     * The order of the data in the linked list matches the order of the array.
     * @param data the array of elements to initialize the linked list
     * @throws IllegalArgumentException if the input array is null or contains null elements
     */
    public LinkedList(T[] data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("The array is null");
        }
        for (T datum : data) {
            if (datum == null) {
                throw new IllegalArgumentException("A data point in the array is null");
            }
            add(datum); // keep adding to end
        }
    }

    /**
     * Returns the head node of the linked list.
     *
     * @return the head node, or null if the list is empty
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Converts the linked list to an array.
     * The elements in the array are in the same order as they appear in the linked list.
     *
     * @return an array containing all elements in the linked list
     */
    public T[] toArray() {
        T[] arr = (T[]) new Object[size];
        Iterator<T> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            arr[i] = it.next();
            ++i;
        }
        return arr;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== LINKEDLIST %d =====\nisEmpty: %s\nsize: %d\nhead: %s\ndata: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (head == null ? "null" : head.getData())));

        T[] data = toArray();
        if (data == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < data.length - 1; ++i) {
                sb.append(String.format("%s, ", data[i])); // append all but last value
            }
            if (data.length > 0) {
                sb.append(String.format("%s", data[data.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    @Override
    public void add(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("element is null");
        }
        Node<T> newNode = new Node<>(element, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("The element is null");
        }
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("You are currently Out of Bounds!");
        }
        if (index == 0) {
            head = new Node<>(element, head);
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            Node<T> newNode = new Node<>(element, current.getNext());
            current.setNext(newNode);
        }

        size++;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Empty list");
        }

        if (head.getNext() == null) {
            head = null;
        }

        T data = head.getData();
        head = head.getNext();
        size--;
        return data;
    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (head == null) {
            throw new NoSuchElementException("Empty list");
        }
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }

        if (index == 0) {
            return remove();
        }

        Node<T> current = head;
        for (int i = 0; i < index - 1; ++i) {
            current = current.getNext();
        }

        Node<T> toRemove = current.getNext();
        current.setNext(toRemove.getNext());
        size--;
        return toRemove.getData();
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Empty list");
        }
        if (element == null) {
            throw new IllegalArgumentException("The element is null");
        }

        if (element.equals(head.getData())) {
            return remove();
        }

        Node<T> current = head;
        while (current.getNext() != null) {
            if (element.equals(current.getNext().getData())) {
                Node<T> toRemove = current.getNext();
                current.setNext(toRemove.getNext());
                size--;
                return toRemove.getData();
            }
            current = current.getNext();
        }
        throw new NoSuchElementException("No List!");
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("The element is null");
        }
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }

        Node<T> current = head;
        for (int i = 0; i < index; ++i) {
            current = current.getNext();
        }

        T old = current.getData();
        current.setData(element);
        return old;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("The element is null");
        }

        Node<T> current = head;
        while (current != null) {
            if (element.equals(current.getData())) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}