package linkedlist;

import java.util.Arrays;
import student.TestCase;

/**
 * 
 * Tests the equals and toArray methods of a singly linked list.
 * 
 * @author Margaret Ellis (maellis1)
 * 
 * @author Jeff Robertson (thejar)
 * 
 * @author Bengi Sevil (bsevil18)
 * 
 * @version 6.12.2018
 *
 */
public class SLLEqualsToArrayTest extends TestCase {

    private SinglyLinkedList<String> emptyListA;
    private SinglyLinkedList<String> emptyListB;
    private SinglyLinkedList<String> smallListA;
    private SinglyLinkedList<String> smallListB;
    private SinglyLinkedList<String> bigListA;
    private SinglyLinkedList<String> bigListB;
    private String nullObject;


    /**
     * Initializes 2 empty lists, 2 lists with a small number of items, and 2
     * lists with a large number of items
     */
    public void setUp() {
        emptyListA = new SinglyLinkedList<String>();
        emptyListB = new SinglyLinkedList<String>();

        smallListA = new SinglyLinkedList<String>();
        smallListB = new SinglyLinkedList<String>();

        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");

        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");

        bigListA = new SinglyLinkedList<String>();

        for (int i = 0; i < 100; i++) {
            bigListA.add("sport" + i);
        }

        bigListB = new SinglyLinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }

        // to be explicit
        nullObject = null;
    }


    /**
     * Tests the size method for accurate results.
     */
    public void testSize() {
        assertEquals(0, emptyListA.size());
        assertEquals(3, smallListA.size());
    }


    /**
     * Tests the add method with index and newElement
     * for accurate results.
     */
    public void testAddToIndex() {
        // Adding a null obj
        Exception exception = null;
        try {
            smallListA.add(0, null);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }

        assertNotNull(exception);

        // Adding to an empty list
        emptyListA.add(0, "apple");
        assertEquals(1, emptyListA.size());

        // Adding to non-empty list
        emptyListA.add(0, "strawberry");
        assertEquals(2, emptyListA.size());

        // Adding to out-of-bounds
        try {
            smallListA.add(5, "yeti");
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);
        try {
            smallListA.add(-2, "yeti");
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * Tests add method with newElement argument
     */
    public void testAdd() {
        // Adding a null obj
        Exception exception = null;
        try {
            smallListA.add(null);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }

        assertNotNull(exception);

        // Adding to an empty list
        emptyListA.add("apple");
        assertEquals(1, emptyListA.size());

        // Adding to non-empty list
        emptyListA.add("strawberry");
        assertEquals(2, emptyListA.size());
    }


    /**
     * Test isEmpty for accurate results.
     */
    public void testIsEmpty() {
        assertTrue(emptyListA.isEmpty());
        assertFalse(smallListA.isEmpty());
    }


    /**
     * Tests remove element for accurate results.
     */
    public void testRemove() {
        // Remove from empty list
        assertFalse(emptyListA.remove("soccer"));

        // Remove null item
        Exception exception = null;
        try {
            smallListA.remove(null);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);

        // Remove an existing item
        assertTrue(smallListA.remove("soccer"));
        assertEquals(2, smallListA.size());
        assertTrue(bigListA.remove("sport10"));

        // Remove non-existing item
        assertFalse(smallListA.remove("apple"));
        assertEquals(2, smallListA.size());
    }


    /**
     * Tests remove with index and item to be removed
     * for accurate results.
     */
    public void testRemoveIndex() {
        // Remove from empty list
        Exception exception = null;
        try {
            emptyListA.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);

        try {
            emptyListA.remove(-3);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);

        // Remove from non-existing location
        try {
            smallListA.remove(20);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);

        try {
            smallListA.remove(-1);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);

        // Remove an existing item
        assertTrue(smallListA.remove(0));
        assertFalse(smallListA.contains("soccer"));
        smallListA.add("a");
        smallListA.add("a");
        assertEquals(4, smallListA.size());
        assertTrue(bigListA.remove(10));
        assertFalse(bigListA.contains("sport10"));

    }


    /**
     * Tests get method for accurate results.
     */
    public void testGet() {
        // Get on empty list
        Exception exception = null;
        try {
            emptyListA.get(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);

        // Negative index and empty list
        try {
            emptyListA.get(-5);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);
        
        try {
            bigListA.get(140);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);

        // Get existing item
        assertEquals("sport30", bigListA.get(30));

        bigListA.add(20, "sparkle");
        bigListA.add(100, "blingbling");
        emptyListA.add(0, "a");
        assertEquals("sparkle", bigListA.get(20));
        assertEquals("blingbling", bigListA.get(100));
        assertEquals("sport99", bigListA.get(101));
        assertEquals("a", emptyListA.get(0));

        try {
            smallListA.get(5);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * Tests contains for accurate results.
     */
    public void testContains() {
        Exception exception = null;
        try {
            emptyListA.contains(null);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);

        assertFalse(emptyListA.contains("soccer"));
        assertTrue(smallListA.contains("soccer"));
        assertFalse(smallListA.contains("apple"));
    }


    /**
     * Tests clear for accurate results.
     */

    public void testClear() {
        emptyListA.clear();
        assertEquals(0, emptyListA.size());

        bigListA.clear();
        assertEquals(0, bigListA.size());
    }


    /**
     * Tests lastIndexOf for accurate results.
     */
    public void testLastIndexOf() {
        Exception exception = null;
        try {
            emptyListA.lastIndexOf(null);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);

        smallListA.add("soccer");
        assertEquals(3, smallListA.lastIndexOf("soccer"));
    }


    /**
     * Tests toString for accurate results.
     */
    public void testToString() {
        String str = "{soccer, swimming, gymnastics}";

        assertEquals(str, smallListA.toString());
    }


    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList() {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(emptyListA.equals(nullObject));
        assertFalse(emptyListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));
        smallListA.clear();
        assertEquals(emptyListA, smallListA);
    }


    /**
     * Tests the equals method on a list with a small number of items in it
     */
    public void testEqualsSmallList() {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));

        // Make smallListA and smallListB differ in
        // content, but have the same size
        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));

        // Replace the last element in smallListA
        // to make smallListA and smallListB equal again
        smallListA.remove("rope jumping");
        smallListA.add("jump roping");
        assertTrue(smallListA.equals(smallListB));
    }


    /**
     * Tests the equals method on a list with a large number of items in it
     */
    public void testEqualsBigList() {
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));

        // Same content, same size, but reversed
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        StringBuilder temp = new StringBuilder();
        temp.append("sport");
        for (int i = 100; i > 0; i--) {
            temp.append(i);
            bigListB.add(temp.toString());
        }
        assertFalse(bigListA.equals(bigListB));

        // one a subset of the other but with dups
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // make them equal again
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        assertTrue(bigListA.equals(bigListB));

    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty() {

        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));

    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents() {

        Object[] origArray = { "soccer", "swimming", "gymnastics" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));

    }

}
