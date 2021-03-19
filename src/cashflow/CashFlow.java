package cashflow;

/**
 * This class represents cash flow
 *
 * <p>
 *     Cash flow here can be thought of as <e>an object whose value is interpreted based on interest rate and time period</e>
 * </p>
 */
public abstract class CashFlow {
    /**
     * Calculate the value of this <code>CashFlow</code> at <code>period</code> with <code>interestRate</code>
     * @param period period is relevant to what the user has defined as base
     * @param interestRate interest rate used
     * @return value of this <code>Codew</code> at period <code>period</code> at interest rate <code>interestRate</code>
     */
    public abstract double getValueAtPeriod(double period, double interestRate);

    /**
     * Calculate the present value of this <code>CashFlow</code> with <code>interestRate</code>
     * This method is equivalent to <code>getValueAtPeriod(0, interestRate)</code>
     * @param interestRate the interest rate
     * @return present value of this <code>CashFlow</code>
     */
    public double getPresentValue(double interestRate){
        return getValueAtPeriod(0, interestRate);
    }

    /**
     * Compound two <code>CashFlow</code>s
     * @param cashflow another <code>CashFlow</code>
     * @return the compounded <code>CashFlow</code>
     */
    public CashFlow add(CashFlow cashflow){
        return new CashFlow(){
            @Override
            public double getValueAtPeriod(double period, double interestRate) {
                return CashFlow.this.getValueAtPeriod(period, interestRate) + cashflow.getValueAtPeriod(period, interestRate);
            }
        };
    }
}