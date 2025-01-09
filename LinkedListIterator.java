import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * An iterator for the LinkedList class.
 * Provides traversal over the elements of a linked list in the order they appear.
 * @author Samuel Khang
 * @version 1.0
 * @param <T> the type of data stored in the nodes of the linked list
 */
public class LinkedListIterator<T> implements Iterator<T> {

    private Node<T> next;
    /**
     * Constructs an iterator for the specified linked list.
     * The iterator starts at the head of the linked list.
     *
     * @param a the linked list to iterate over
     * @throws IllegalArgumentException if the linked list is null
     */
    public LinkedListIterator(LinkedList<T> a) throws IllegalArgumentException {
        if (a == null) {
            throw new IllegalArgumentException("linked list cannot be null");
        }
        next = a.getHead();
    }
    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public T next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("No more nodes");
        }
        Node<T> origin = next;
        next = next.getNext();
        return origin.getData();
    }

}
