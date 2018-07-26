package recursion;

import student.TestCase;

/**
 * PalindromeCheckerTest class tests the PalindromeChecker class
 * to ensure all methods and constructors work accurately.
 *
 * @author Bengi Sevil bsevil18
 * @version 06.06.2018
 * 
 */

public class PalindromeCheckerTest extends TestCase {

    /**
     * Sets up everything for the tests.
     */
    public void setUp() {
        new PalindromeChecker();
    }


    /**
     * Tests isPalindrome for accurate results.
     */
    public void testIsPalindrome() {
        String nullStr = null;
        assertFalse(PalindromeChecker.isPalindrome(nullStr));
        assertTrue(PalindromeChecker.isPalindrome(""));
        assertTrue(PalindromeChecker.isPalindrome("a"));
        assertTrue(PalindromeChecker.isPalindrome(
            "Go hang a salami, I'm a lasagna hog."));
        assertTrue(PalindromeChecker.isPalindrome(
            "A Toyota! Race fast, safe car. A Toyota."));
        assertTrue(PalindromeChecker.isPalindrome(
            "\"Tie Mandie,\" I'd name it."));
        assertTrue(PalindromeChecker.isPalindrome("Wonton? Not now."));
        assertFalse(PalindromeChecker.isPalindrome("Bengi"));
        assertTrue(PalindromeChecker.isPalindrome("1.2.1"));
        assertTrue(PalindromeChecker.isPalindrome("5/12/15"));        
        assertFalse(PalindromeChecker.isPalindrome("52/12/15"));
        
    }

}
