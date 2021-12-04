package lesson10;

import static lesson10.T.*;

public class Celsius implements Convertible {
    public double celsius;

    @Override
    public void convert() {
        double fahrenheit;
        double kelvin;
        fahrenheit = celsius * 9 / 5 + 32;
        kelvin = celsius + 273.15;
        System.out.println(celsius + " град. " + CELSIUS + " = " + fahrenheit + " град. " + FAHRENHEIT);
        System.out.println(celsius + " град. " + CELSIUS + " = " + kelvin + " град. " + KELVIN);
    }

    public Celsius(double celsius) {
        this.celsius = celsius;
    }

    @Override
    public double getValue() {
        return celsius;
    }
}
