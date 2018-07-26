package src;

/**
 * This class represents a doubly linked list with an inner
 * node class.
 * 
 * @author Bengi Sevil
 * @version 07/05/2018
 * @param <E>
 *            Type template.
 *
 */
public class DLList<E> {
    /**
     * This inner class represents the nodes in the doubly linked list. It has
     * a data field of type E, and two pointers for the next and previous nodes.
     * 
     * @author Bengi Sevil
     * @version 07/05/2018
     *
     * @param <E>
     *            Type template for the object to be stored.
     */
    private static class Node<E> {
        private Node<E> next;
        private Node<E> previous;
        private E data;


        /**
         * Default constructor with parameter data
         * that creates a new node with the given data
         * stored.
         * 
         * @param data
         *            The data item to be stored in the node.
         */
        public Node(E data) {
            this.data = data;
        }


        /**
         * Returns the node after the current one.
         * 
         * @return
         *         The next field.
         */
        public Node<E> next() {
            return next;
        }


        /**
         * Returns the preceeding node to the current one.
         * 
         * @return
         *         The previous field.
         */
        public Node<E> previous() {
            return previous;
        }


        /**
         * Returns the data stored in the current node.
         * 
         * @return
         *         Data stored in the node.
         */
        public E getData() {
            return data;
        }


        /**
         * Sets the next field of the current node to
         * newNext.
         * 
         * @param newNext
         *            The next node to the current node.
         */
        public void setNext(Node<E> newNext) {
            next = newNext;
        }


        /**
         * Sets the previous node to the current node to be
         * newPrevious.
         * 
         * @param newPrevious
         *            The new previous node to the current node.
         */
        public void setPrevious(Node<E> newPrevious) {
            previous = newPrevious;
        }

    }

    private Node<E> head;
    private Node<E> tail;
    private int size;


    /**
     * Creates a new doublyLinkedList object and
     * calls the init method to initialize and
     * set up all private fields.
     */
    public DLList() {
        init();
    }


    /**
     * Initializes private fields. Sets the previous
     * and next fields for the head and tail, and
     * initializes size to 0.
     * 
     * Head and tail are sentinental nodes that do not
     * contain anything, but point to the first and last
     * nodes if they exist.
     */
    public void init() {
        head = new DLList.Node<E>(null);
        tail = new DLList.Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * Returns the current size of the doubly linked list.
     * 
     * @return
     *         The current size.
     */
    public int getSize() {
        return size;
    }


    /**
     * Checks whether the list is empty.
     * 
     * @return {@code true} if the doubly linked list is empty.
     *         {@code false} otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Calls init to reset all private fields to their
     * default values and empty the list.
     */
    public void clear() {
        init();
    }


    /**
     * Adds newEntry at the location specified by index.
     * 
     * @param index
     *            Index of the newEntry location.
     * @param newEntry
     *            The new data to be stored.
     * 
     * @throws IndexOutOfBoundsException
     *             if index is invalid.
     * 
     * @throws IllegalArgumentException
     *             if newEntry is null.
     * 
     */
    public void add(int index, E newEntry) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException("Invalid index for add.");
        }
        if (newEntry == null) {
            throw new IllegalArgumentException("New entry cannot be null");
        }

        Node<E> curr;
        if (index == (size - 1)) {
            curr = tail;
        }
        else {
            curr = getNode(index);
        }

        Node<E> newNode = new Node<E>(newEntry);
        newNode.setPrevious(curr.previous);
        newNode.setNext(curr.next);
        curr.previous.setNext(newNode);
        curr.setPrevious(newNode);
        size++;
    }


    /**
     * Adds newEntry to the end of the list.
     * 
     * @param newEntry
     *            The new entry being added.
     */
    public void add(E newEntry) {
        add(size, newEntry);
    }


    /**
     * Returns the node at the index value given.
     * 
     * @param index
     *            The index of the node.
     * @return
     *         The node at the given index.
     * 
     * @throws IndexOutOfBoundsException
     *             if the index is negative or greater than the size.
     */
    public Node<E> getNode(int index) {
        if (index < 0 || getSize() <= index) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<E> curr = head.next();
        for (int i = 0; i < index; i++) {
            curr = curr.next();
        }
        return curr;
    }


    /**
     * Returns the data stored in the node at the given index.
     * 
     * @param index
     *            The index of the node.
     * @return data stored in node at index given.
     */
    public E getData(int index) {
        return getNode(index).data;
    }


    /**
     * Returns the index of the node that contains the given obj.
     * 
     * @param obj
     *            The data that the node being searched for contains.
     * @return
     *         Index of the first occurence.
     */
    public int firstIndexOf(E obj) {
        Node<E> curr = head.next;
        for (int i = 0; i < size; i++) {
            if (curr.data.equals(obj)) {
                return i;
            }
            curr = curr.next();
        }
        // Not found
        return -1;
    }


    /**
     * Attempts to remove the node at the given index.
     * 
     * @param index
     *            Index of the item to be removed.
     * 
     * @throws IndexOutOfBoundsException
     *             if index is invalid.
     * 
     * @throws IllegalStateException
     *             if the list is empty.
     * 
     */
    public void remove(int index) {
        if (index < 0 || getSize() <= index) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (isEmpty()) {
            throw new IllegalStateException("Illegal to call remove");
        }
        Node<E> curr = getNode(index);
        curr.previous().setNext(curr.next());
        curr.next().setPrevious(curr.previous());
        size--;
    }


    /**
     * Attempts to remove the node containing element.
     * 
     * @param element
     *            The expected item stored in the node.
     * 
     * @return {@code true} if removed.
     *         {@code false} otherwise.
     * 
     * @throws IllegalStateException
     *             if the list is empty.
     * 
     */
    public boolean removeElement(E element) {
        if (isEmpty()) {
            throw new IllegalStateException("Illegal to call remove");
        }
        Node<E> curr = head.next();
        while (curr!=tail) {
            if (curr.getData().equals(element)) {
                curr.previous.setNext(curr.next());
                curr.next.setPrevious(curr.previous());
                size--;
                return true;
            }
            curr = curr.next();
        }
        return false;
    }

}
