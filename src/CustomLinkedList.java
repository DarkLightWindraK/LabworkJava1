import java.util.NoSuchElementException;

public class CustomLinkedList<E> {

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public CustomLinkedList() {
        size = 0;
    }

    Node<E> first, last;
    int size;

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

    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public E remove(int index) {
        if (index >= size) {
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

    public E remove(E element) {
        Node<E> current = first;
        while (current != null && current.item != element) {
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
}
