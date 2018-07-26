package arraystack;

import student.TestCase;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * ArrayBasedStackTest will test all of the methods in ArrayBasedStack to make
 * sure that they run and perform as expected
 *
 * @author Bengi Sevil (bsevil18)
 * @version June 5, 2018
 */
public class ArrayBasedStackTest extends TestCase {
    private ArrayBasedStack<String> test1;
    private ArrayBasedStack<String> test2;


    /**
     * Sets up each test method before it runs
     */
    public void setUp() {
        test1 = new ArrayBasedStack<String>();
        test2 = new ArrayBasedStack<String>(5);

        test2.push("a");
        test2.push("b");
        test2.push("c");
        test2.push("d");
        test2.push("e");
    }


    /**
     * Tests isEmpty for accurate results.
     */
    public void testIsEmpty() {
        assertTrue(test1.isEmpty());
        assertFalse(test2.isEmpty());
    }


    /**
     * Tests peek for an empty stack.
     */
    public void testPeekEmpty() {
        Exception exception = null;

        try {
            test1.peek();
        }
        catch (EmptyStackException e) {
            exception = e;
        }

        assertNotNull(exception);
    }


    /**
     * Tests peek with non-empty stack.
     */
    public void testPeek() {
        test1.push("a");
        test1.push("b");

        assertEquals("b", test1.peek());
        assertEquals("b", test1.pop());
    }


    /**
     * Tests pop with empty stack.
     */
    public void testPopEmpty() {
        Exception exception = null;
        try {
            test1.pop();
        }
        catch (EmptyStackException e) {
            exception = e;
        }

        assertNotNull(exception);

    }


    /**
     * Tests pop with non-empty stack.
     */
    public void testPop() {
        assertEquals("e", test2.pop());
        assertEquals("d", test2.peek());
    }


    /**
     * Tests push to add a new item on top of the stack.
     */
    public void testPush() {
        test1.push("x");
        assertEquals("x", test1.peek());
        test1.push("y");
        assertEquals("y", test1.peek());
    }


    /**
     * Tests contains to check for an existing
     * and non-existing item.
     */
    public void testContains() {
        assertTrue(test2.contains("a"));
        assertFalse(test2.contains("x"));
    }


    /**
     * Tests size for accurate results.
     */
    public void testSize() {
        assertEquals(5, test2.size());
        test2.pop();
        assertEquals(4, test2.size());
    }


    /**
     * Tests clear to check if it clears out the stack.
     */
    public void testClear() {
        test1.clear();
        test2.clear();
        assertEquals(0, test1.size());
        assertEquals(0, test2.size());
    }


    /**
     * Tests toArray for accurate results.
     */
    public void testToArray() {
        Object[] temp;
        temp = new Object[test2.size()];
        temp[0] = "a";
        temp[1] = "b";
        temp[2] = "c";
        temp[3] = "d";
        temp[4] = "e";
        assertTrue(Arrays.equals(temp, test2.toArray()));
    }


    /**
     * Tests toString for accurate results
     */
    public void testToString() {
        String temp = "[a, b, c, d, e]";
        assertEquals(temp, test2.toString());

        temp = "[]";
        assertEquals(temp, test1.toString());
    }


    /**
     * Tests expandCapacity for accurate results.
     * The push method is called on a full stack to invoke this method.
     */
    public void testExpandCapacity() {
        test2.push("x");
        assertEquals("x", test2.peek());
        assertEquals(6, test2.size());
    }


    /**
     * Tests the equals method for accurate results.
     */

    public void testEquals() {
        ArrayBasedStack<String> temp = null;
        assertFalse(test2.equals(temp));
        assertTrue(test2.equals(test2));
        assertFalse(test2.equals("some object"));
        temp = new ArrayBasedStack<String>(5);
        temp.push("a");
        temp.push("b");
        temp.push("c");
        temp.push("d");
        temp.push("e");
        assertTrue(test2.equals(temp));
        assertFalse(test1.equals(test2));
        temp.clear();
        temp.push("x");
        temp.push("y");
        temp.push("z");
        temp.push("a");
        temp.push("e");
        assertFalse(test2.equals(temp));
    }

}
