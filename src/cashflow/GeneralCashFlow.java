package cashflow;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represent cash flow in its most general form.
 * Specifically, a <code>GeneralCashFlow</code> is a series of {@link TimeMoney}
 */
public class GeneralCashFlow extends CashFlow{
    private List<TimeMoney> money;

    /**
     * Construct an empty instance
     */
    public GeneralCashFlow(){
        money = new ArrayList<TimeMoney>();
    }

    /**
     * A wrapper around a <code>TimeMoney</code>
     * @param money
     */
    public GeneralCashFlow(TimeMoney money){
        this.money = new ArrayList<TimeMoney>();
        this.money.add(money);

    }

    public GeneralCashFlow(List<TimeMoney> money){
        this.money = money;
    }

    /**
     * Insert a single <code>TimeMoney</code>
     * @param aMoney new <code>TimeMoney</code>
     */
    public void insert(TimeMoney aMoney){
        money.add(aMoney);
    }

    /**
     * Insert a list of <code>TimeMoney</code>
     * @param moneyList new <code>TimeMoney</code>s
     */
    public void insert(List<TimeMoney> moneyList){
        this.money.addAll(moneyList);
    }

    @Override
    public double getValueAtPeriod(double period, double interestRate) {
        double result = 0;

        for (TimeMoney m : money){
            result += m.getValueAtPeriod(period, interestRate);
        }

        return result;
    }
}
