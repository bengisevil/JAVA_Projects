package collections;

import student.TestCase;

/**
 * MovieTest will test all of the methods in Movie and MovieADT to make
 * sure that they run and perform as expected
 *
 * @author Bengi Sevil (bsevil18)
 * @version May 25, 2018
 */

public class MovieTest extends TestCase {

    private Movie mov;
    private Movie movDiffTitle;
    private Movie movSameTitle;
    private Movie movNull;


    /**
     * sets up each test method before it runs
     */
    public void setUp() {
        mov = new Movie("Little Miss Sunshine");
        mov.setGenre("Comedy");
        mov.setRating(5);
        mov.setYear(2006);

        movDiffTitle = new Movie("Love, Simon.");
        mov.setGenre("Romantic Comedy");
        mov.setRating(4);
        mov.setYear(2018);

        movSameTitle = new Movie("Little Miss Sunshine");
        mov.setGenre("Comedy");
        mov.setRating(5);
        mov.setYear(2006);

        movNull = null;
    }


    /**
     * Tests getTitle for accurate results.
     */
    public void testGetTitle() {
        assertEquals("Little Miss Sunshine", mov.getTitle());
    }


    /**
     * Tests getGenre for accurate results.
     */
    public void testGetGenre() {
        assertEquals("Comedy", mov.getGenre());
        mov.setGenre("Drama");
        assertEquals("Drama", mov.getGenre());
    }


    /**
     * Tests getRating for accurate results.
     */
    public void testGetRating() {
        assertEquals(5, mov.getRating());
        mov.setRating(4);
        assertEquals(4, mov.getRating());
    }


    /**
     * Tests getYear for accurate results.
     */
    public void testGetYear() {
        assertEquals(2006, mov.getYear());
        mov.setYear(2005);
        assertEquals(2005, mov.getYear());
    }


    /**
     * Tests equals for accurate results.
     */
    public void testEquals() {
        // this == other
        assertEquals(true, mov.equals(mov));
        // Identical name
        assertEquals(true, mov.equals(movSameTitle));
        // Different name
        assertEquals(false, mov.equals(movDiffTitle));
        // Null
        assertEquals(false, mov.equals(movNull));
        // Different class
        assertEquals(false, mov.equals("Different class"));
    }
}
