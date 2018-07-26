package recursion;

/**
 * ReverseStringGenerator class contains a method that
 * reverses a given string.
 *
 * @author Bengi Sevil bsevil18
 * @version 06.06.2018
 * 
 */

public class ReverseStringGenerator {

    /**
     * Reverses a given string.
     * 
     * @param str
     *            The string to be reversed.
     * @return The reversed string.
     */
    public static String reverse(String str) {
        if (str.length() <= 1) {
            return str;
        }

        char[] rev = new char[str.length()];
        int index = 0;
        for (int i = (str.length() - 1); i >= 0; i--) {
            rev[index] = str.charAt(i);
            index++;
        }

        String reversed = new String(rev);
        return reversed;
    }
}
