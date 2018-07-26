// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package game;

import bag.SimpleBagInterface;
import student.TestableRandom;
import bag.Node;

/**
 * SimpleLinkedBag is a linked bag containing items of type T.
 * It uses the Node class to contain each item. Initially the first
 * node is null. The method implementations and descriptions are
 * provided below.
 * 
 * @param <T>
 *            Generic type.
 *
 * @author Bengi Sevil bsevil18
 * @version 06.06.2018
 * 
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {

    private Node<T> firstNode;
    private int numberOfEntries;


    /**
     * SimpleLinkedBag constructor. Creates a new SimpleLinkedBag
     * object; Initializes the firstNode null and the numberOfEntries
     * to 0.
     */
    public SimpleLinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }


    /**
     * Attempts to add a new element to the LinkedBag by
     * creating a new node to contain this element, and
     * setting its next to null (firstNode).
     * If the element is null, nothing gets added.
     * 
     * @param newEntry
     *            The new entry to be added to the bag.
     * 
     * @return {@code true} If the element was added.
     *         {@code false} otherwise.
     * 
     */
    @Override
    public boolean add(T newEntry) {
        if (newEntry == null) {
            return false;
        }

        Node<T> newNode = new Node<T>(newEntry);
        newNode.setNext(firstNode);
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }


    /**
     * Returns the current size of the linked bag.
     * 
     * @return the number of elements in the linked bag.
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    /**
     * Checks whether the bag is empty or not.
     * 
     * @return {@code true} If the bag is empty.
     *         {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (numberOfEntries == 0);
    }


    /**
     * Picks an element from the bag based on the randomly
     * generated number between 0-9 and uses this index to traverse
     * through the linked list, and return the element.
     * If the bag is empty, return null.
     * 
     * @return The element that is randomly picked;
     *         Can be null if the bag is empty.
     */
    @Override
    public T pick() {
        if (isEmpty()) {
            return null;
        }

        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);

        Node<T> pick = firstNode;
        int i = 0;
        while (i < index) {
            pick = pick.next();
            i++;
        }

        return pick.data();

    }


    /**
     * Private helper method for the remove method.
     * Searches for the entry given in the linked bag.
     * Traverses through the linked list until the data field
     * of the current node is equal to anEntry. If nothing is found
     * returns null.
     * 
     * @param anEntry
     *            The entry to be searched for.
     * 
     * @return The node that contains the element if it was found,
     *         null otherwise.
     */
    private Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;

        for (Node<T> curr = firstNode; curr != null; curr = curr.next()) {
            if (curr.data().equals(anEntry)) {
                found = true;
                currentNode = curr;
            }
        }

        if (found) {
            return currentNode;
        }
        return null;
    }


    /**
     * Removes the specified entry from the linked bag. Uses the
     * private method getReferenceTo to check if the element exists
     * in the bag and to obtain its current node if it does.
     * The numberOfElements is decremented and the bag is updated.
     * 
     * @param anEntry
     *            The entry to be removed from the bag.
     * 
     * @return {@code true} If the removal was successful.
     *         {@code false} otherwise.
     */
    @Override
    public boolean remove(T anEntry) {
        if (isEmpty()) {
            return false;
        }
        Node<T> curr = getReferenceTo(anEntry);

        if (curr == null) {
            return false;
        }

        Node<T> temp = firstNode.next();
        curr = firstNode;
        firstNode = temp;
        numberOfEntries--;
        return true;
    }

}
