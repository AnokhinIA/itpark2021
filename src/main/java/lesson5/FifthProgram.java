package lesson5;

import java.util.Scanner;

public class FifthProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер члена последовательности ряда Фибоначчи (от 2 до n):");
        while (!scanner.hasNextInt()) {
            String number = scanner.next();
            System.out.println("Введено некорректное значение: " + number + " Ожидается целое число.");
        }
        int value = scanner.nextInt();
        System.out.println(calculateOfValueFibonacci(value));
    }

    public static int calculateOfValueFibonacci(int value) {
        int f0 = 0;
        int f1 = 1;
        int fNext = 1;
        for (int i = 2; i <= value; i++) {
            fNext = f0 + f1;
            f0 = f1;
            f1 = fNext;
        }
        return fNext;
    }
}
