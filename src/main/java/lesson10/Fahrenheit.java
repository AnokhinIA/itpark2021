package lesson10;

import static lesson10.T.*;

public class Fahrenheit implements Convertible {
    public double fahrenheit;

    @Override
    public void convert() {
        double celsius;
        double kelvin;
        celsius = (fahrenheit - 32) * 5 / 9;
        kelvin = celsius + 273.15;
        System.out.println(fahrenheit + " град. " + FAHRENHEIT + " = " + celsius + " град. " + CELSIUS);
        System.out.println(fahrenheit + " град. " + FAHRENHEIT + " = " + kelvin + " град. " + KELVIN);
    }

    public Fahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    @Override
    public double getValue() {
        return fahrenheit;
    }
}
