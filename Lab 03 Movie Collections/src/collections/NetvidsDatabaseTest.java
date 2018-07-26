package collections;

import student.TestCase;
import java.util.NoSuchElementException;

/**
 * NetvidsDatabaseTest will test all of the methods in NetVidsDatabase to make
 * sure that they run and perform as expected
 *
 * @author Bengi Sevil (bsevil18)
 * @version May 25, 2018
 */

public class NetvidsDatabaseTest extends TestCase {

    private NetvidsDatabase netvid;
    private Movie mov;


    /**
     * sets up each test method before it runs
     */
    public void setUp() {
        netvid = new NetvidsDatabase();
        mov = new Movie("Shutter Island");
        mov.setGenre("Thriller");
        mov.setRating(5);
        mov.setYear(2011);
    }


    /**
     * Tests addMovie for accurate results.
     */
    public void testAddMovie() {
        assertTrue(netvid.addMovie(mov));
        assertFalse(netvid.addMovie(mov));
        assertTrue(netvid.remove(mov).equals(mov));
    }


    /**
     * Tests remove method when the object to be removed is present.
     */
    public void testRemove() {
        // Case 1
        Movie testMov = new Movie("Avengers");
        netvid.addMovie(mov);
        netvid.addMovie(testMov);
        assertEquals(netvid.size(), 2);
        assertEquals(testMov, netvid.remove(testMov));
        assertEquals(netvid.size(), 1);
        assertFalse(netvid.contains(testMov));
        netvid.remove(mov);
        

    }


    /**
     * Tests remove method when the object to be removed is null.
     */
    public void testRemoveNull() {
        // Case 2
        Movie testMov = null;
        Exception exception = null;

        try {
            netvid.remove(testMov);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }

        assertNotNull(exception);

    }


    /**
     * Tests remove method when the object to be removed is not present.
     */
    public void testRemoveNo() {
        // Case 1
        Movie present = new Movie("Avengers");
        Movie notPresent = new Movie("Stranger Things");
        netvid.addMovie(present);
        Exception exception = null;

        try {
            netvid.remove(notPresent);
        }
        catch (NoSuchElementException e) {
            exception = e;
        }

        assertNotNull(exception);

    }


    /**
     * Tests contains for accurate results.
     */
    public void testContains() {
        Movie temp = new Movie("Avengers");
        Movie temp2 = new Movie("Power");
        netvid.addMovie(temp);
        assertTrue(netvid.addMovie(temp2));
        Movie movNull = null;
        netvid.addMovie(movNull);
        assertFalse(netvid.contains(movNull));
        assertTrue(netvid.contains(temp));
        netvid.remove(temp2);
        netvid.remove(temp);
        assertFalse(netvid.contains(temp));
        
    }


    /**
     * Tests isEmpty for accurate results.
     */
    public void testIsEmpty() {
        assertTrue(netvid.isEmpty());
        netvid.addMovie(mov);
        assertFalse(netvid.isEmpty());
        netvid.remove(mov);
    }


    /**
     * Tests size for accurate results.
     */
    public void testSize() {
        assertEquals(0, netvid.size());
        netvid.addMovie(mov);
        assertEquals(1, netvid.size());
        netvid.remove(mov);
    }


    /**
     * Tests size for accurate results.
     */
    public void testExpandCapacity() {

        for (int i = 0; i < 10; i++) {
            Movie temp = new Movie("Mov" + i);
            netvid.addMovie(temp);
        }
        assertTrue(netvid.addMovie(mov)); // This will invoke expandCapacity
        

    }


    /**
     * Tests capacity for accurate results.
     */
    public void testCapacity() {

        assertEquals(10, netvid.capacity());

    }

}
