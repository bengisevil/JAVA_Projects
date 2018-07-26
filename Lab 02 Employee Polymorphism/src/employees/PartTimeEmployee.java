/**
 * 
 */
package employees;

// -------------------------------------------------------------------------
/**
 * Represents an average employee working less than 40 hours per week.
 *
 * @author Bengi Sevil (bsevil18)
 * @version May 23, 2018
 */
public class PartTimeEmployee extends Employee {
    // ~ Fields ................................................................

    private int hoursPerWeek;


    // ~ Constructor ...........................................................
    /**
     * New PartTimeEmployee object.
     *
     * @param name
     *            Name of Employee
     * @param hourlyRate
     *            Pay rate of Employee (per hour)
     * @param hoursPerWeek
     *            hours worked per week.
     */
    public PartTimeEmployee(String name, double hourlyRate, int hoursPerWeek) {
        super(name, hourlyRate);
        this.hoursPerWeek = hoursPerWeek;
    }

    // ~ Methods ...............................................................


    // ----------------------------------------------------------
    /**
     * Gets the employee's hours worked per week.
     * 
     * @return number of hours per week.
     */
    public int getHoursWorked() {
        return hoursPerWeek;
    }


    // ----------------------------------------------------------
    /**
     * Amount paid to the employee for an average 40 hours or less per week.
     * 
     * @return Weekly pay for part time employee
     */
    public double weeklyPay() {
        double pay = 0;
        if (hoursPerWeek < 40) {
            pay = super.getHourlyRate() * hoursPerWeek;
        }
        else {
            pay = super.getHourlyRate() * 40;
        }
        return pay;
    }

}
