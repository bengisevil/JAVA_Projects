package recursion;

import student.TestCase;

/**
 * FibonacciGeneratorTest class tests the FibonacciGenerator class
 * to ensure all methods and constructors work accurately.
 *
 * @author Bengi Sevil bsevil18
 * @version 06.06.2018
 * 
 */

public class FibonacciGeneratorTest extends TestCase {

    /**
     * Sets up variables to be tested.
     */
    public void setUp() {
        new FibonacciGenerator();
    }


    /**
     * Tests fib to search for the nth in the fibonacci
     * sequence.
     */
    public void testFib() {
        assertEquals(0, FibonacciGenerator.fib(0));
        assertEquals(1, FibonacciGenerator.fib(1));
        assertEquals(1, FibonacciGenerator.fib(2));
        assertEquals(55, FibonacciGenerator.fib(10));
    }
}
