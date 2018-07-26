package employees;

import student.TestCase;

/**
 * EmployeeTest will test all of the methods in Employee to make
 * sure that they run and perform as expected
 *
 * @author Bengi Sevil (bsevil18)
 * @version May 23, 2018
 */

public class EmployeeTest extends TestCase {

    private Employee emp;
    private Employee empSameName;
    private Employee empDifferentName;
    private Employee empIdentical;
    private Employee empNull;


    /**
     * sets up each test method before it runs
     */
    public void setUp() {
        emp = new Employee("Bengi", 50);
        empSameName = new Employee("Bengi", 98);
        empDifferentName = new Employee("Sevil", 45);
        empIdentical = emp;
        empNull = null;
    }


    /**
     * Tests getName for accurate results.
     */
    public void testGetName() {
        assertEquals("Bengi", emp.getName());
    }


    /**
     * Tests getHourlyRate for accurate results.
     */
    public void testGetHourlyRate() {
        assertEquals(50, emp.getHourlyRate(), 0.01);
    }


    /**
     * Tests weeklyPay for accurate results.
     */
    public void testWeeklyPay() {
        assertEquals(2000, emp.weeklyPay(), 0.01);
    }


    /**
     * Tests equals for accurate results.
     */
    public void testEquals() {
        //this == other
        assertEquals(true, emp.equals(empIdentical));
        //Identical name
        assertEquals(true, emp.equals(empSameName));
        //Different name
        assertEquals(false, emp.equals(empDifferentName));
        //Null
        assertEquals(false, emp.equals(empNull));
        //Different class
        assertEquals(false, emp.equals("Different class"));
    }
}
