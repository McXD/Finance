package util;

import java.lang.Math;

/**
 * This class contains various static methods for miscellaneous financial calculation
 */
public class Calculator {
    /**
     * Calculate effective interest
     * effective interest rate can be defined as: amount (of money) after investment / original amount - 1
     * @param simpleInterestRate simple interest rate for period <code>period</code>
     * @param period number of periods
     * @return the effective interest rate
     */
    public static double effectiveInterestRate(double simpleInterestRate, double period){
        return Math.pow(1 + simpleInterestRate, period) - 1;
    }
}
