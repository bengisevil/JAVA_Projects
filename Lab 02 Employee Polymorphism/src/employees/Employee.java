package employees;

// -------------------------------------------------------------------------
/**
 * Represents an average employee working 40 hours per week.
 *
 * @author Megan Rigsbee (mrigsbee), Bengi Sevil (bsevil18)
 * @version 2 May 23, 2018
 */
public class Employee {
    // ~ Fields ................................................................

    private String name;
    private double hourlyRate;


    // ~ Constructor ...........................................................
    /**
     * New Employee object.
     *
     * @param name
     *            Name of Employee
     * @param hourlyRate
     *            Pay rate of Employee (per hour).
     */
    public Employee(String name, double hourlyRate) {
        this.name = name;
        this.hourlyRate = hourlyRate;
    }

    // ~ Methods ...............................................................


    // ----------------------------------------------------------
    /**
     * Gets the employee's name.
     * 
     * @return the employee's name
     */
    public String getName() {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * Gets the pay rate (per hour).
     * 
     * @return the pay rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }


    // ----------------------------------------------------------
    /**
     * Amount paid to the employee for an average 40 hour work week.
     * 
     * @return weekly Weekly pay for employee
     */
    public double weeklyPay() {
        return hourlyRate * 40;
    }


    // ----------------------------------------------------------
    /**
     * Checks if two employees employee objects have the same name.
     * 
     * @param other
     *            Object other to compare to employee object.
     * @return true if equal, false otherwise.
     */
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Employee otherEmp = (Employee)other;
        return (otherEmp.name.equals(this.name));
    }

}
