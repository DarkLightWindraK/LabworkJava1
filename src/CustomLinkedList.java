import java.util.NoSuchElementException;

/**
 * A custom implementation of a linked list.
 *
 * @param <E> the type of elements stored in the linked list
 */
public class CustomLinkedList<E> {

    /**
     * A node containing an element of type E.
     *
     * @param <E> the type of element stored in the node
     */
    public static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        /**
         * Constructor for creating a new node with a given previous node, element, and next node.
         *
         * @param prev    the previous node of the new node
         * @param element the element stored in the new node
         * @param next    the next node of the new node
         */
        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size;

    /**
     * Constructor for creating a new linked list with size 0.
     */
    public CustomLinkedList() {
        first = last = null;
        size = 0;
    }

    /**
     * Adds an element to the end of the linked list.
     *
     * @param element the element to add to the linked list
     */
    public void add(E element) {
        final Node<E> tempLast = last;
        final Node<E> newNode = new Node<>(tempLast, element, null);
        last = newNode;
        if (tempLast == null)
            first = newNode;
        else
            tempLast.next = newNode;
        size++;
    }

    /**
     * Gets the element at the specified index of the linked list.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is larger than or equal to the size of the linked list
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    /**
     * Removes the element at the specified index from the linked list.
     *
     * @param index the index of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is larger than or equal to the size of the linked list
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E savedValue = current.item;

        current.prev.next = current.next;
        current.next.next = current.prev;
        size--;
        return savedValue;
    }

    /**
     * Removes the specified element from the linked list.
     *
     * @param element the element to remove from the linked list
     * @return the removed element
     * @throws NoSuchElementException if the specified element is not found in the linked list
     */
    public E remove(E element) throws NoSuchElementException {
        Node<E> current = first;
        while (current != null && !current.item.equals(element)) {
            current = current.next;
        }
        if (current != null) {
            current.prev.next = current.next;
            current.next.next = current.prev;
            size--;
            return current.item;
        } else {
            throw new NoSuchElementException();
        }
    }

    public Node<E> getFirst() {
        return first;
    }

    public Node<E> getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }
}