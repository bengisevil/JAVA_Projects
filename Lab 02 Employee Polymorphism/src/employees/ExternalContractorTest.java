package employees;

import student.TestCase;

/**
 * ExternalContractorTest will test all of the methods in ExternalContractor to
 * make
 * sure that they run and perform as expected
 *
 * @author Bengi Sevil (bsevil18)
 * @version May 23, 2018
 */

public class ExternalContractorTest extends TestCase {

    private ExternalContractor cont1;


    /**
     * sets up each test method before it runs
     */
    public void setUp() {
        cont1 = new ExternalContractor("Bengi", 50);
    }


    /**
     * Tests getHourlyRate for accurate results.
     */
    public void testGetHourlyRate() {
        assertEquals(38.50, cont1.getHourlyRate(1), 0.01);
        assertEquals(41.75, cont1.getHourlyRate(2), 0.01);
        assertEquals(45.50, cont1.getHourlyRate(3), 0.01);
    }


    /**
     * Tests weeklyPay for accurate results.
     */
    public void testWeeklyPay() {
        assertEquals(835, cont1.weeklyPay(20, 2), 0.01);
    }

}
