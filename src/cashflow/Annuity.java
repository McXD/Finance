package cashflow;

/**
 * This class represents the Annuity financial instrument, a special kind of cash flow
 */
public class Annuity extends CashFlow{
    private final double payment;
    private final double periodCnt;

    /**
     * A <code>Annuity</code> is characterized by its annual payment, and the amount of period this payment lasts
     * @param payment annual payment
     * @param periodCnt period count
     */
    public Annuity(double payment, double periodCnt){
        this.payment = payment;
        this.periodCnt = periodCnt;
    }

    @Override
    public double getValueAtPeriod(double period, double interestRate) {
        double presentValueFactor = 1 + util.Calculator.effectiveInterestRate(interestRate, -this.periodCnt);
        double annuityFactor = (1 - presentValueFactor) / interestRate;
        double presentValue = this.payment * annuityFactor;

        return presentValue * ( 1 + util.Calculator.effectiveInterestRate(interestRate, period));
    }
}
