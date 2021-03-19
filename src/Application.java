import cashflow.*;

public class Application {
    public static void main(String[] args){
        GeneralCashFlow general = new GeneralCashFlow();
        general.insert(new TimeMoney(0, -10000));
        general.insert(new TimeMoney(1, 2000));
        general.insert(new TimeMoney(2, 2000));
        general.insert(new TimeMoney(3, 4000));
        general.insert(new TimeMoney(4, 4000));
        general.insert(new TimeMoney(5, 5000));

        System.out.println(general.getPresentValue(0.1));
    }
}
