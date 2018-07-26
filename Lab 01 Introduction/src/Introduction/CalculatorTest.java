package Introduction;
import student.TestCase;


/**
 *  CalculatorTest will test all of the methods in Calculator to make
 *  sure that they run and perform as expected
 *
 * @author  Bengi Sevil bsevil18
 * @version May 22, 2018
 */

public class CalculatorTest extends TestCase
{
    private Calculator myCalc;
    private Calculator badInput;
    /**
     * sets up each test method before it runs
     */
    public void setUp()
    {
        myCalc = new Calculator(12, 3);
        badInput = new Calculator(12, 0);
    }
    /**
     * Tests getFirstInput for accurate results.
     */
    public void testGetFirstInput()
    {
        assertEquals(12, myCalc.getFirstInput(), 0.01);
    }
    /**
     * Tests getSecondInput for accurate results.
     */
    public void testGetSecondInput()
    {
        assertEquals(3, myCalc.getSecondInput(), 0.01);
    }
    /**
     * Tests multiply for accurate results.
     */
    public void testMultiply()
    {
        assertEquals(36, myCalc.multiply(), 0.01);
    }
    /**
     * Tests divide for accurate results.
     */
    public void testDivide()
    {
        assertEquals(4, myCalc.divide(), 0.01);
        assertEquals(Double.NaN, badInput.divide(), 0.01);
    }
    /**
     * Tests add for accurate results.
     */
    public void testAdd()
    {
        assertEquals(15, myCalc.add(), 0.01);
    }
    /**
     * Tests subtract for accurate results.
     */
    public void testSubtract()
    {
        assertEquals(9, myCalc.subtract(), 0.01);
    }
    /**
     * Tests power for accurate results.
     */
    public void testPower()
    {
        assertEquals(1728, myCalc.power(), 0.01);
    }
    

}
