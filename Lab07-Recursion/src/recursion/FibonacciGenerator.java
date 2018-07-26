package recursion;

/**
 * FibonacciGenerator class generates a Fibonacci sequence
 * and implements the method that searches for a particular
 * nth number in the generated sequence.
 *
 * @author Bengi Sevil bsevil18
 * @version 06.06.2018
 * 
 */

public class FibonacciGenerator {

    /**
     * Recursive method that calculates and returns the nth
     * number in the Fibonacci sequence.
     * 
     * @precondition n is not negative.
     * 
     * @param n
     *            nth number to be found.
     * @return The number that is found.
     */
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return (fib(n - 1) + fib(n - 2));
    }
}
