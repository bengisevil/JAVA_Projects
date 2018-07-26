package employees;

import student.TestCase;

/**
 * PartTimeEmployeeTest will test all of the methods in PartTimeEmployee to make
 * sure that they run and perform as expected
 *
 * @author Bengi Sevil (bsevil18)
 * @version May 23, 2018
 */

public class PartTimeEmployeeTest extends TestCase {

    private PartTimeEmployee emp;
    private PartTimeEmployee overEmp;


    /**
     * sets up each test method before it runs
     */
    public void setUp() {
        emp = new PartTimeEmployee("Bengi", 50, 15);
        overEmp = new PartTimeEmployee("Sevil", 50, 45);
    }


    /**
     * Tests getHoursWorked for accurate results.
     */
    public void testGetHoursWorked() {
        assertEquals(15, emp.getHoursWorked());
    }


    /**
     * Tests weeklyPay for accurate results.
     */
    public void testWeeklyPay() {
        assertEquals(750, emp.weeklyPay(), 0.01);
        assertEquals(2000, overEmp.weeklyPay(), 0.01);
    }

}
