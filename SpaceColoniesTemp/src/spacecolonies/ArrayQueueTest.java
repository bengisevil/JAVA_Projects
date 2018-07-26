// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package spacecolonies;

import student.TestCase;

/**
 * This class tests the methods in the ArrayQueue class.
 * 
 * @author Bengi Sevil
 * @version 06.20.2018
 *
 */
public class ArrayQueueTest extends TestCase {
    ArrayQueue<Person> queue1;
    ArrayQueue<Person> queue2;


    /**
     * Creates new ArrayQueue objects of type person.
     */
    public void setUp() {
        queue1 = new ArrayQueue<Person>();
        queue2 = new ArrayQueue<Person>();
    }


    /**
     * Tests getLength method for accurate results.
     */
    public void testGetLength() {
        assertEquals(11, queue1.getLength());
    }


    /**
     * Tests the getSize method for accurate results.
     */
    public void testGetSize() {
        Person temp = new Person("Jane Doe", 2, 3, 4, "Nars");
        assertEquals(0, queue1.getSize());
        queue1.enqueue(temp);
        assertEquals(1, queue1.getSize());
        queue1.dequeue();
        assertEquals(0, queue1.getSize());
    }


    /**
     * Tests the isEmpty method for accurate results.
     */
    public void testIsEmpty() {
        assertTrue(queue1.isEmpty());
        Person temp = new Person("Jane Doe", 2, 3, 4, "Nars");
        queue1.enqueue(temp);
        assertFalse(queue1.isEmpty());
    }


    /**
     * Tests the enqueue method for accurate results.
     */
    public void testEnqueue() {
        Person temp1 = new Person("Jane Doe", 2, 3, 4, "Nars");
        Person temp2 = new Person("James Doe", 1, 5, 2, "Nars");

        assertEquals(0, queue1.getSize());
        queue1.enqueue(temp1);
        assertEquals(1, queue1.getSize());
        assertEquals(temp1, (queue1.getFront()));

        queue1.enqueue(temp1);
        queue1.enqueue(temp2);
        assertEquals(3, queue1.getSize());
        assertEquals(temp1, (queue1.getFront()));

        for (int i = 0; i < 100; i++) {
            queue2.enqueue(temp1);
        }
        Exception exception = null;
        try {
            queue2.enqueue(temp1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * Tests the dequeue method for accurate results.
     */
    public void testDequeue() {
        Person temp1 = new Person("Jane Doe", 2, 3, 4, "Nars");
        Person temp2 = new Person("James Doe", 1, 5, 2, "Nars");

        assertEquals(0, queue1.getSize());
        queue1.enqueue(temp1);
        assertEquals(1, queue1.getSize());
        assertEquals(temp1, (queue1.getFront()));

        assertEquals(temp1, queue1.dequeue());
        assertEquals(0, queue1.getSize());

        queue1.enqueue(temp1);
        queue1.enqueue(temp2);
        assertEquals(2, queue1.getSize());
        assertEquals(temp1, queue1.dequeue());
        assertEquals(temp2, queue1.dequeue());

        assertEquals(null, queue2.dequeue());
    }


    /**
     * Tests the getFront() method for accurate results.
     */
    public void testGetFront() {
        Person temp1 = new Person("Jane Doe", 2, 3, 4, "Nars");
        Person temp2 = new Person("James Doe", 1, 5, 2, "Nars");

        assertEquals(0, queue1.getSize());
        queue1.enqueue(temp1);
        assertEquals(1, queue1.getSize());
        assertEquals(temp1, (queue1.getFront()));
        queue1.enqueue(temp2);
        assertEquals(temp1, (queue1.getFront()));
        queue1.dequeue();
        assertEquals(temp2, (queue1.getFront()));

        assertEquals(null, queue2.getFront());
    }


    /**
     * Tests the clear method for accurate results.
     */
    public void testClear() {
        Person temp1 = new Person("Jane Doe", 2, 3, 4, "Nars");
        Person temp2 = new Person("James Doe", 1, 5, 2, "Nars");

        for (int i = 0; i < 15; i++) {
            queue1.enqueue(temp1);
            queue1.enqueue(temp2);
        }

        assertEquals(30, queue1.getSize());

        queue1.clear();
        assertEquals(0, queue1.getSize());

    }


    /**
     * Tests the toArray method for accurate results.
     */
    public void testToArray() {
        Exception exception = null;
        try {
            queue1.toArray();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);

        Person temp1 = new Person("Jane Doe", 2, 3, 4, "Nars");
        Person temp2 = new Person("James Doe", 1, 5, 2, "Nars");

        queue1.enqueue(temp1);

        Object[] arr = new Object[queue1.getLength()];
        arr[0] = temp1;
        Object[] q1 = queue1.toArray();

        for (int i = 0; i < queue1.getSize() - 1; i++) {
            assertTrue(arr[i].equals(q1[i]));
        }

        queue1.enqueue(temp2);
        arr[1] = temp2;
        q1 = queue1.toArray();
        for (int i = 0; i < queue1.getSize() - 1; i++) {
            assertTrue(arr[i].equals(q1[i]));
        }

    }


    /**
     * Tests the toString method for accurate results.
     */
    public void testToString() {
        assertEquals("[]", queue1.toString());
        Person temp1 = new Person("Jane Doe", 2, 3, 4, "Nars");
        Person temp2 = new Person("James Doe", 1, 5, 2, "Nars");
        queue1.enqueue(temp1);
        queue1.enqueue(temp2);

        String str =
            "[Jane Doe A:2 M:3 T:4 Wants: Nars, James Doe A:1 M:5 T:2 Wants: Nars]";
        assertEquals(str, queue1.toString());
    }


    /**
     * Tests the equals method for accurate results.
     */
    public void testEquals() {
        Person temp = new Person("a", 1, 2, 3, "");
        Person temp1 = new Person("b", 1, 2, 3, "a");
        queue1.enqueue(temp);
        queue2.enqueue(temp);
        assertTrue(queue1.equals(queue1));
        assertTrue(queue1.equals(queue2));
        assertFalse(queue1.equals(null));
        assertFalse(queue1.equals("a"));
        queue2.enqueue(temp);
        assertFalse(queue1.equals(queue2));
        queue1.enqueue(temp1);
        assertFalse(queue1.equals(queue2));
    }

}
