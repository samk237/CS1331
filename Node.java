/**
 * A generic node for a singly linked list.
 * Each node stores data and a reference to the next node in the list.
 * @author Samuel Khang
 * @version 1.0
 * @param <T> the type of data stored in the node
 */
public class Node<T> {
    private T data;
    private Node<T> next;
    /**
     * Constructs a node with the specified data and next node reference.
     *
     * @param data the data to store in the node
     * @param next the reference to the next node in the list
     * @throws IllegalArgumentException if the data is null
     */
    public Node(T data, Node<T> next) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Null Value was passed");
        }
        this.data = data;
        this.next = next;
    }
    /**
     * Constructs a node with the specified data and sets the next node reference to null.
     *
     * @param data the data to store in the node
     * @throws IllegalArgumentException if the data is null
     */
    public Node(T data) throws IllegalArgumentException {
        this(data, null);
    }
    /**
     * Retrieves the data stored in the node.
     *
     * @return the data stored in the node
     */
    public T getData() {
        return data;
    }
    /**
     * Retrieves the reference to the next node in the list.
     *
     * @return the reference to the next node, or null if there is no next node
     */
    public Node<T> getNext() {
        return next;
    }
    /**
     * Sets the reference to the next node in the list.
     *
     * @param next the reference to the next node
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
    /**
     * Sets the data stored in the node.
     *
     * @param data the new data to store in the node
     * @throws IllegalArgumentException if the data is null
     */
    public void setData(T data) {
        this.data = data;
    }

}
