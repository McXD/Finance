package cashflow;

import util.Calculator;

/**
 * This class represents money that has <e>time value</e>
 *
 * A <code>TimeMoney</code> has a face <code>amount</code>, which is the <e>value</e> of money at a specified <code>period</code>
 */
public class TimeMoney {
    private double period;
    private double amount;

    /**
     * This <code>TimeMoney</code> should have value <code>amount</code> at time <code>period</code>
     * @param period at this time the money has the value of this <code>amount</code>
     * @param amount the money has this <code>amount</code> worth of value at time <code>period</code>
     */
    public TimeMoney(double period, double amount){
        this.period = period;
        this.amount = amount;
    }

    /**
     * Calculate the value of this <code>TimeMoney</code>
     * @param atPeriod time at which the value is to be calculated
     * @param interestRate interest rate during the period
     * @return the value of this <code>TimeMoney</code> at <code>atPeriod</code> at <code>interestRate</code>
     */
    public double getValueAtPeriod(double atPeriod, double interestRate){
        return amount * (1 + Calculator.effectiveInterestRate(interestRate, atPeriod - period));
    }

    /**
     * Calculate the present value of this <code>TimeMoney</code>
     * This method is equivalent to <code>getValueAtPeriod(0, interestRate)</code>
     * @param interestRate interest rate during the period
     * @return the present value of this <code>TimeMoney</code>
     */
    public double getPresentValue(double interestRate){
        return this.getValueAtPeriod(0, interestRate);
    }

    public double getPeriod() {
        return period;
    }

    public void setPeriod(double atPeriod) {
        this.period = atPeriod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
