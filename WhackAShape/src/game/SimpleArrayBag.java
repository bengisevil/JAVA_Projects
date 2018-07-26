// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * SimpleArrayBag is an array bag containing items of type T.
 * It has a fixed size of 25 that is not expandable. The methods
 * and descriptions are provided below.
 * 
 * @param <T>
 *            Generic type.
 *
 * @author Bengi Sevil bsevil18
 * @version 06.06.2018
 * 
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {

    private T[] bag;
    private static final int MAX = 25;
    private int numberOfEntries;


    /**
     * SimpleArrayBag constructor. Creates a new SimpleArrayBag
     * object. Initializes the bag field to a new array of type T objects
     * of size MAX and the numberOfEntries as 0.
     */
    @SuppressWarnings("unchecked")
    public SimpleArrayBag() {
        T[] tempbag = (T[])new Object[MAX];
        bag = tempbag;
        numberOfEntries = 0;
    }


    /**
     * getCurrentSize returns the current size of the bag;
     * The number of Entries.
     * 
     * @return the total number of entries in the bag.
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    /**
     * Attempts to add a new a new entry to the arrayBag.
     * 
     * @param anEntry
     *            The new entry to be added.
     * @return {@code true} if the number of entries were less than 25.
     *         {@code false} otherwise.
     */
    public boolean add(T anEntry) {

        if (numberOfEntries < 25 && anEntry != null) {
            bag[numberOfEntries] = anEntry;
            numberOfEntries++;
            return true;

        }
        return false;

    }


    /**
     * Checks if the array bag is empty.
     * 
     * @return {@code true}, numberOfEntries is 0;
     *         {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (numberOfEntries == 0);
    }


    /**
     * Uses a TestableRandom object to generate an index value
     * between 0-9, and returns the value in the bag at that index.
     * If the bag is empty, it returns null.
     * 
     * @return The entry at the generated index, or null if the bag is empty.
     * 
     */
    @Override
    public T pick() {
        if (isEmpty()) {
            return null;
        }
        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);

        return bag[index];

    }


    /**
     * Helper method for the remove() method. Searches for the
     * entry in the bag that matches anEntry. Returns the index
     * of that value if there is a match; Returns -1 otherwise.
     * 
     * @param anEntry
     *            The entry to be searched for a match.
     * 
     * @return index of the entry if it exists, -1 otherwise.
     */

    private int getIndexOf(T anEntry) {
        for (int i = 0; bag[i] != null; i++) {
            if (bag[i].equals(anEntry)) {
                return i;
            }
        }

        return -1;
    }


    /**
     * Removes the given entry from the bag. Uses the genIndexOf
     * method to get the index of the item to be removed and to
     * check if it exists in the bag.
     * 
     * @return {@code true} If the entry was removed.
     *         {@code false} otherwise.
     */
    @Override
    public boolean remove(T anEntry) {
        if (isEmpty()) {
            return false;
        }
        int index = getIndexOf(anEntry);
        if (index != -1) {
            bag[index] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return true;
        }
        return false;
    }

}
