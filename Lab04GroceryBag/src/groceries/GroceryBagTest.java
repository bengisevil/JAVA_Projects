package groceries;

import student.TestCase;
import student.TestableRandom;
import java.util.stream.IntStream;
/**
 * GroceryBagTest will test all of the methods in GroceryBag to make
 * sure that they run and perform as expected
 *
 * @author Bengi Sevil (bsevil18)
 * @version May 30, 2018
 */

public class GroceryBagTest extends TestCase {

    private GroceryBag bag1; // unordered
    private GroceryBag bag3; // ordered
    private GroceryBag bag4; // ordered with duplicates


    /**
     * Sets up each test method before it runs
     */
    public void setUp() {
        bag1 = new GroceryBag();
        bag1.add("apples");
        bag1.add("chips");
        bag1.add("yogurt");
        bag1.add("chicken");
        bag1.add("pasta");

        bag3 = new GroceryBag();
        bag3.add("apples");
        bag3.add("chicken");
        bag3.add("chicken");
        bag3.add("pasta");
        bag3.add("pizza");
        bag3.add("soda");
        bag3.add("yogurt");
        bag3.add("wheat");

        bag4 = new GroceryBag();
        bag4.add("chicken");
        bag4.add("chicken");
        bag4.add("pasta");
        bag4.add("pasta");
        bag4.add("yogurt");

    }


    /**
     * Tests intersection for accurate results.
     */
    public void testIntersection() {

        GroceryBag inter = new GroceryBag();
        inter.add("apples");
        inter.add("chicken");
        inter.add("pasta");
        inter.add("yogurt");

        assertTrue(bag1.intersection(bag3).equals(inter));

        inter.remove("apples");
        inter.add("chicken");

        assertEquals(inter, bag3.intersection(bag4));
        
    }


    /**
     * Tests equals for accurate results
     */
    public void testEquals() {
        GroceryBag nullBag = null;
        assertTrue(bag1.equals(bag1));
        assertFalse(bag1.equals(nullBag));
        assertFalse(bag1.equals("Some bag"));

        GroceryBag emptyBag = new GroceryBag();
        assertFalse(bag1.equals(emptyBag));
        assertFalse(emptyBag.equals(bag1));

        GroceryBag sameBag1 = new GroceryBag();
        sameBag1.add("apples");
        sameBag1.add("chips");
        sameBag1.add("yogurt");
        sameBag1.add("chicken");
        sameBag1.add("pasta");
        assertTrue(bag1.equals(sameBag1));
        assertFalse(bag1.equals(bag4));

    }
    
    public void test() {
        TestableRandom r = new TestableRandom();
        int[] values = IntStream.range(100, 201).toArray();
        TestableRandom.setNextInts(values);
        int a = r.nextInt(200);
        a = r.nextInt(200);
        
    }

}
