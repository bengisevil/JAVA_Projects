package deque;

/**
 * A deque implemented using a doubly-linked chain.
 *
 * @param <T>
 *            The type of elements contained in the deque.
 *
 * @author Bengi Sevil (bsevil18)
 * @version 06.11.2018
 */
public class Lab08Deque<T> extends DLinkedDeque<T> {

    /**
     * Lab08Deque Default Constructor. Creates a new object of
     * type Lab08Deque. Call's the parent class DLinkedDeque's
     * default constructor to initialize firstNode, lastNode and
     * size.
     */
    public Lab08Deque() {
        super();
    }


    /**
     * Inserts a new item at the front of the deque.
     * 
     * @throws IllegalArgumentException
     *             if newEntry is null.
     * @param newEntry
     *            the item to insert.
     */
    public void addToFront(T newEntry) throws IllegalArgumentException {
        if (newEntry == null) {
            throw new IllegalArgumentException();
        }
        DLNode<T> newNode = new DLNode<T>(newEntry);

        newNode.setNextNode(firstNode);
        if (firstNode != null) {
            firstNode.setPreviousNode(newNode);
        }
        firstNode = newNode;

        if (lastNode == null) {
            lastNode = firstNode;
        }
        size++;

    }


    /**
     * Insert a new item at the rear of the deque.
     * 
     * @throws IllegalArgumentException
     *             if newEntry is null.
     * 
     * @param newEntry
     *            the item to insert.
     */
    public void addToBack(T newEntry) throws IllegalArgumentException {
        if (newEntry == null) {
            throw new IllegalArgumentException();
        }
        DLNode<T> newNode = new DLNode<T>(newEntry);

        newNode.setPreviousNode(lastNode);
        if (lastNode != null) {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;

        if (firstNode == null) {
            firstNode = lastNode;
        }
        size++;
    }


    /**
     * Remove the item at the front of the deque.
     * 
     * @return The item that was removed
     * @throws EmptyQueueException
     *             if there is not an element at the front
     */
    public T removeFront() {
        if (size == 0) {
            throw new EmptyQueueException();
        }
        DLNode<T> oldFront = firstNode;
        firstNode = firstNode.getNextNode();
        size--;
        if (firstNode == null) {
            lastNode = null;
        }
        else {
            firstNode.setPreviousNode(null);
        }
        return oldFront.getData();
    }


    /**
     * Remove the item at the rear of the deque.
     * 
     * @return The item that was removed
     * @throws EmptyQueueException
     *             if there is no element at the front
     */
    public T removeBack() {
        if (size == 0) {
            throw new EmptyQueueException();
        }
        DLNode<T> oldBack = lastNode;
        lastNode = lastNode.getPreviousNode();
        size--;
        if (lastNode == null) {
            firstNode = null;
        }
        else {
            lastNode.setNextNode(null);
        }
        return oldBack.getData();

    }


    /**
     * Get the item at the front (the head) of the deque. Does not alter the
     * deque.
     * 
     * @return the item at the front of the deque.
     * @throws EmptyQueueException
     *             if no element at the front
     */
    public T getFront() {
        if (firstNode == null) {
            throw new EmptyQueueException();
        }
        return firstNode.getData();
    }


    /**
     * Get the item at the rear (the tail) of the deque. Does not alter the
     * deque.
     * 
     * @return the item at the rear of the deque.
     * @throws EmptyQueueException
     *             if no element at rear
     * 
     */
    public T getBack() {
        if (lastNode == null) {
            throw new EmptyQueueException();
        }
        return lastNode.getData();

    }


    /**
     * Check if the deque is empty
     * 
     * @return true if the deque has no items
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Empty the deque.
     */
    public void clear() {
        for (DLNode<T> temp = firstNode; temp != null; temp = temp
            .getNextNode()) {
            removeFront();
        }
        firstNode = null;
        lastNode = null;
    }


    // ----------------------------------------------------------
    /**
     * Returns a string representation of this deque. A deque's string
     * representation is written as a comma-separated list of its contents (in
     * front-to-rear order) surrounded by square brackets, like this:
     * 
     * [52, 14, 12, 119, 73, 80, 35]
     * 
     * An empty deque is simply [].
     *
     * @return a string representation of the deque
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        DLNode<T> p = firstNode;
        while (p != null) {
            if (s.length() > 1) {
                s.append(", ");
            }
            s.append(p.getData());
            p = p.getNextNode();
        }
        s.append("]");
        return s.toString();
    }

}
