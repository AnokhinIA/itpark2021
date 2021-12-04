package lesson10;

public class Convertor {
    public static void main(String[] args) {

        Convertible celsius = new Celsius(36.00);
        Convertible fahrenheit = new Fahrenheit(0.00);
        Convertible rubles = new Rubles(140_000.00);

        celsius.convert();
        System.out.println("---------------------");
        fahrenheit.convert();
        System.out.println("---------------------");
        rubles.convert();

    }
}
