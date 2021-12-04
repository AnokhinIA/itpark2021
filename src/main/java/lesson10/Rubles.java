package lesson10;

import java.math.BigDecimal;

import static lesson10.Currency.*;

public class Rubles implements Convertible {
    public double rubles;

    @Override
    public void convert() {
        double usd;
        usd = rubles / 75.00;
        double eur = rubles / 80.00;
        System.out.println(rubles + " " + RUR + " = " + usd + "  " + USD);
        System.out.println(rubles + " " + RUR + " = " + eur + "  " + EUR);
    }

    public Rubles(double rubles) {
        this.rubles = rubles;
    }

    @Override
    public double getValue() {
        return rubles;
    }
}
