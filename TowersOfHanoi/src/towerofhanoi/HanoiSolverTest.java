// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package towerofhanoi;

import student.TestCase;

/**
 * The HanoiSolverTest class tests all the methods in the class HanoiSolver
 * for accurate behavior.
 * 
 * @author Bengi Sevil
 * @version 06.14.2018
 */
public class HanoiSolverTest extends TestCase {
    private HanoiSolver test;
    private HanoiSolver empty;


    /**
     * Initializes a new object of type HanoiSolver named
     * test with 5 as the number of discs, and an empty one
     * named empty.
     */
    public void setUp() {
        test = new HanoiSolver(5);
        empty = new HanoiSolver(10);
        for (int i = 5; i > 0; i--) {
            Disc disc = new Disc(i);
            test.getTower(Position.LEFT).push(disc);
        }
    }


    /**
     * Tests discs method for accurate behavior.
     */
    public void testDiscs() {
        assertEquals(5, test.discs());
    }


    /**
     * Tests getTower for accurate behavior.
     */
    public void testGetTower() {
        Tower left = new Tower(Position.LEFT);
        Tower mid = new Tower(Position.MIDDLE);
        Tower right = new Tower(Position.RIGHT);
        assertTrue(left.position().equals(test.getTower(Position.LEFT)
            .position()));
        assertTrue(left.position().equals(test.getTower(Position.OTHER)
            .position()));
        assertTrue(mid.position().equals(test.getTower(Position.MIDDLE)
            .position()));
        assertTrue(right.position().equals(test.getTower(Position.RIGHT)
            .position()));
    }


    /**
     * Tests toString method for accurate results.
     */
    public void testToString() {
        // Empty towers
        assertEquals("[][][]", empty.toString());

        // All 3 towers with 1 disc
        Disc temp = new Disc(2);
        empty.getTower(Position.LEFT).push(temp);
        empty.getTower(Position.MIDDLE).push(temp);
        empty.getTower(Position.RIGHT).push(temp);

        assertEquals("[2][2][2]", empty.toString());

        empty.getTower(Position.LEFT).clear();
        empty.getTower(Position.MIDDLE).clear();
        empty.getTower(Position.RIGHT).clear();

        // All three towers with multiple disc
        for (int i = 5; i > 0; i--) {
            Disc disc = new Disc(i);
            empty.getTower(Position.LEFT).push(disc);
        }

        for (int i = 4; i > 0; i--) {
            Disc disc = new Disc(i);
            empty.getTower(Position.MIDDLE).push(disc);
        }

        for (int i = 3; i > 0; i--) {
            Disc disc = new Disc(i);
            empty.getTower(Position.RIGHT).push(disc);
        }

        assertEquals("[1, 2, 3, 4, 5][1, 2, 3, 4][1, 2, 3]", empty.toString());

        // First tower non-empty, right and middle empty.
        empty.getTower(Position.MIDDLE).clear();
        empty.getTower(Position.RIGHT).clear();

        assertEquals("[1, 2, 3, 4, 5][][]", empty.toString());
    }


    /**
     * Tests the move method for accurate results.
     */
    public void testMove() {
        test.solve();
        Exception exception = null;
        try {
            empty.solve();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(test.getTower(Position.LEFT).isEmpty());
        assertTrue(test.getTower(Position.MIDDLE).isEmpty());
        assertFalse(test.getTower(Position.RIGHT).isEmpty());
    }
}
