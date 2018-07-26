package icecream;

import student.TestCase;

/**
 * IceCreamConeTest will test all of the methods in IceCreamCone to make
 * sure that they run and perform as expected
 *
 * @author Bengi Sevil (bsevil18)
 * @version May 30, 2018
 */

public class IceCreamConeTest extends TestCase {

    private IceCreamCone cone1;
    private IceCreamCone cone2;


    /**
     * Sets up each test method before it runs
     */
    public void setUp() {
        cone1 = new IceCreamCone();
        cone1.addScoop("strawberry");
        cone1.addScoop("chocolate");
        cone1.addScoop("vanilla");
        cone1.addScoop("lemon");

        cone2 = new IceCreamCone();
        cone2.addScoop("cookie dough");
        cone2.addScoop("peanut butter");
    }


    /**
     * Tests eatScoop for accurate results.
     */
    public void testEatScoop() {
        assertEquals("lemon", cone1.eatScoop());
        assertEquals("vanilla", cone1.currentScoop());
    }


    /**
     * Tests addScoop for accurate results.
     */
    public void testAddScoop() {
        cone1.addScoop("cherry");
        assertEquals("cherry", cone1.currentScoop());
    }


    /**
     * Tests numScoops for accurate results.
     */
    public void testNumScoops() {
        assertEquals(4, cone1.numScoops());
        assertEquals(2, cone2.numScoops());
    }


    /**
     * Tests contains for accurate results.
     */
    public void testContains() {
        assertTrue(cone1.contains("strawberry"));
        assertFalse(cone2.contains("strawberry"));
    }


    /**
     * Tests empty for accurate results.
     */
    public void testEmpty() {
        assertFalse(cone1.emptyCone());
        IceCreamCone emptyCone = new IceCreamCone();
        assertTrue(emptyCone.emptyCone());
    }


    /**
     * Tests currentScoop for accurate results.
     */
    public void testCurrentScoop() {
        assertEquals("lemon", cone1.currentScoop());
    }


    /**
     * Test method for toString. Should be in brackets with commas.
     */
    public void testToString() {
        assertEquals(cone1.toString(),
            "[strawberry, chocolate, vanilla, lemon]");
        assertEquals(cone2.toString(), "[cookie dough, peanut butter]");
        IceCreamCone emptyCone = new IceCreamCone();
        assertEquals(emptyCone.toString(), "[]");

    }


    /**
     * Tests equals for accurate results
     */
    public void testEquals() {
        IceCreamCone nullCone = null;
        assertTrue(cone1.equals(cone1));
        assertFalse(cone1.equals(nullCone));
        assertFalse(cone1.equals("Some bag"));

        IceCreamCone emptyCone = new IceCreamCone();
        assertFalse(cone1.equals(emptyCone));
        assertFalse(emptyCone.equals(cone1));

        IceCreamCone sameCone = new IceCreamCone();
        sameCone.addScoop("strawberry");
        sameCone.addScoop("chocolate");
        sameCone.addScoop("vanilla");
        sameCone.addScoop("lemon");
        assertTrue(cone1.equals(sameCone));
        assertFalse(cone1.equals(cone2));

    }

}
