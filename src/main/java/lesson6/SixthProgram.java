package lesson6;

import java.util.Arrays;
import java.util.Scanner;

public class SixthProgram {
    public static void main(String[] args) {
        System.out.println("Задайте длину массива: ");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            String number = scanner.next();
            System.out.println("Введено некорректное значение:  " + number + " Ожидается целое число.");
        }
        int length = scanner.nextInt();
        double[] dim = new double[length];
        for (int i = 0; i < length; i++) {
            dim[i] = Math.random();
        }
        System.out.println("Массив заполнен случайными числами от 0 до 1: ");
        System.out.println(Arrays.toString(dim));
        System.out.println("-------------------");
        System.out.println("Минимальное значение массива: " + minValueFromDim(dim));
        System.out.println("-------------------");
        System.out.println("Максимальное значение массива: " + maxValueFromDim(dim));
        System.out.println("-------------------");
        System.out.println("Среднее значение массива: " + avgValueFromDim(dim));
    }

    private static double avgValueFromDim(double[] dim) {
        double result = dim[0];
        for (int i = 1; i < dim.length; i++) {
            result += dim[i];
        }
        result = result / dim.length;
        return result;
    }

    private static double maxValueFromDim(double[] dim) {
        double result = dim[0];
        for (int i = 1; i < dim.length; i++) {
            if (result < dim[i]) result = dim[i];
        }
        return result;
    }

    public static double minValueFromDim(double[] dim) {
        double result = dim[0];
        for (int i = 1; i < dim.length; i++) {
            if (result > dim[i]) result = dim[i];
        }
        return result;
    }


}
