package cashflow;

/**
 * This class represents the perpetuity financial instrument
 */
public class Perpetuity extends CashFlow{
    private final double payment;

    /**
     * A <code>Perpetuity</code> is characterized by its periodic payment
     * @param payment periodic payment
     */
    public Perpetuity(double payment){
        this.payment = payment;
    }

    @Override
    public double getValueAtPeriod(double period, double interestRate) {
        double presentValue = payment / interestRate;

        return presentValue * (1 + util.Calculator.effectiveInterestRate(interestRate, period));
    }
}
