package deque;

import student.TestCase;

/**
 * Tests for the DLinkedDeque class.
 *
 * @author Bengi Sevil (bsevil18)
 * @version 06.12.2018
 */
public class Lab08DequeTest extends TestCase {

    private Lab08Deque<String> deque;


    /**
     * Creates two brand new, empty sets for each test method.
     */
    public void setUp() {
        deque = new Lab08Deque<String>();
    }


    /**
     * Tests addToFront for accurate results.
     * Regular addition and null item addition is tested.
     */
    public void testAddToFront() {
        // Adding a null item
        Exception exception = null;
        try {
            deque.addToFront(null);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);

        // Adding an item to an empty list
        deque.addToFront("apple");
        assertEquals("apple", deque.getFront());
        assertEquals("apple", deque.getBack());

        // Adding an item to a non-empty list
        deque.addToFront("mango");
        assertEquals("mango", deque.getFront());
        assertEquals("apple", deque.getBack());

    }


    /**
     * Tests addToFront for accurate results.
     * Regular addition and null item addition is tested.
     */
    public void testAddToBack() {
        // Adding a null item
        Exception exception = null;
        try {
            deque.addToBack(null);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);

        // Adding an item to an empty list
        assertEquals(0, deque.size());
        deque.addToBack("apple");
        assertEquals("apple", deque.getFront());
        assertEquals("apple", deque.getBack());
        assertEquals(1, deque.size());

        // Adding an item to a non-empty list
        deque.addToBack("mango");
        assertEquals("mango", deque.getBack());
        assertEquals("apple", deque.getFront());
        assertEquals(2, deque.size());
    }


    /**
     * Tests removeFront for accurate results.
     * Removal from an empty queue and non-empty queue
     * cases are both tested.
     */
    public void testRemoveFront() {
        // Empty queue
        Exception exception = null;
        try {
            deque.removeFront();
        }
        catch (EmptyQueueException e) {
            exception = e;
        }
        assertNotNull(exception);

        // Non-empty queue, single item
        deque.addToFront("banana");
        assertEquals("banana", deque.removeFront());
        assertEquals(0, deque.size());

        // Non-empty queue with multiple items
        deque.addToFront("plum");
        deque.addToFront("kiwi");
        assertEquals("kiwi", deque.removeFront());
        assertEquals(1, deque.size());
    }


    /**
     * Tests removeBack for accurate results.
     * Removal from an empty queue and non-empty queue
     * cases are both tested.
     */
    public void testRemoveBack() {
        // Empty queue
        Exception exception = null;
        try {
            deque.removeBack();
        }
        catch (EmptyQueueException e) {
            exception = e;
        }
        assertNotNull(exception);

        // Non-empty queue, single item
        deque.addToFront("banana");
        assertEquals("banana", deque.removeBack());
        assertEquals(0, deque.size());

        // Non-empty queue with multiple items
        deque.addToFront("plum");
        deque.addToFront("kiwi");
        assertEquals("plum", deque.removeBack());
        assertEquals(1, deque.size());
    }


    /**
     * Tests getFront to check if it returns the front
     * item.
     */
    public void testGetFront() {
        // Empty queue
        Exception exception = null;
        try {
            deque.getFront();
        }
        catch (EmptyQueueException e) {
            exception = e;
        }
        assertNotNull(exception);

        // Non-empty queue with 1 item
        deque.addToFront("raspberry");
        assertEquals("raspberry", deque.getFront());

        // Non-empty queue with more than 1 item
        deque.addToFront("chocolate");
        deque.addToBack("cream");
        assertEquals("chocolate", deque.getFront());
    }


    /**
     * Tests getBack to check if it returns the back
     * item.
     */
    public void testGetBack() {
        // Empty queue
        Exception exception = null;
        try {
            deque.getBack();
        }
        catch (EmptyQueueException e) {
            exception = e;
        }
        assertNotNull(exception);

        // Non-empty queue with 1 item
        deque.addToFront("raspberry");
        assertEquals("raspberry", deque.getBack());

        // Non-empty queue with more than 1 item
        deque.addToFront("chocolate");
        deque.addToBack("cream");
        assertEquals("cream", deque.getBack());
    }


    /**
     * Tests isEmpty for accurate results.
     */
    public void testIsEmpty() {
        assertTrue(deque.isEmpty());
        deque.addToBack("pie");
        assertFalse(deque.isEmpty());
    }


    /**
     * Tests clear for accurate results.
     */
    public void testClear() {
        assertEquals(0, deque.size());
        deque.clear();
        assertEquals(0, deque.size());

        deque.addToBack("sour cherry");
        deque.addToBack("blueberry");
        assertEquals(2, deque.size());
        deque.clear();
        assertEquals(0, deque.size());
    }


    /**
     * Tests toString for accurate output.
     */
    public void testToString() {
        String temp = "[apple, banana, kiwi]";
        deque.addToBack("apple");
        deque.addToBack("banana");
        deque.addToBack("kiwi");

        assertTrue(temp.equals(deque.toString()));

    }

}
