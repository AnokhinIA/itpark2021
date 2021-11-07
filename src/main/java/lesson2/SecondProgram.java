package lesson2;

public class SecondProgram {

    public static void main(String[] args) {

        int summa = addition (2,2);
        int difference = subtraction (5, 3);
        int resultOfMultiplication = multiplication (6, 6);
        int resultOfDivision = division (10, 2);
        int resultOfFuelCharge = fuelCharge(8, 1600,48);

        System.out.println(summa);
        System.out.println(difference);
        System.out.println(resultOfMultiplication);
        System.out.println(resultOfDivision);
        System.out.println(resultOfFuelCharge);
    }

    public static int addition (int arg1, int arg2) {
        int result = arg1 + arg2;
        return result;
    }
    public static int subtraction (int arg1, int arg2) {
        int result = arg1 - arg2;
        return result;
    }
    public static int multiplication(int arg1, int arg2) {
        int result = arg1 * arg2;
        return result;
    }
    public static int division (int arg1, int arg2) {
        int result = arg1 / arg2;
        return result;
    }

    /**
     * Формула расчета затрат на бензин
     * @param fuelConsumption - средний расход топлива автомобиля на 100 км
     * @param distance - расстояния
     * @param fuelPrice - стоимость топлива
     */
    public static int fuelCharge(int fuelConsumption, int distance, int fuelPrice) {
        int result = distance / 100 * fuelConsumption * fuelPrice;
        return result;
    }
}
