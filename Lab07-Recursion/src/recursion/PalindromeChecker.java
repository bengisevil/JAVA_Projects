package recursion;

/**
 * PalindromeChecker class contains a method that
 * checks if a given string is a palindrome.
 *
 * @author Bengi Sevil bsevil18
 * @version 06.06.2018
 * 
 */

public class PalindromeChecker {
    /**
     * Checks if a given string is a palindrome.
     * 
     * @param str
     *            The string to be checked.
     * @return {@code true}, if str is a palindrome;
     *         {@code false} otherwise.
     */
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() <= 1) {
            return true;
        }
        str = str.replaceAll("[.,'!?/\\-\"\\s+]", "").toLowerCase();
        char[] rev = new char[str.length()];
        int index = 0;
        for (int i = (str.length() - 1); i >= 0; i--) {
            rev[index] = str.charAt(i);
            index++;
        }
        String reversed = new String(rev);
        return (reversed.equals(str));

    }
}
