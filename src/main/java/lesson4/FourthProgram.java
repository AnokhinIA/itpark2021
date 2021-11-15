package lesson4;

public class FourthProgram {
    public static void main(String[] args) {
        System.out.println(extractionOfSquareRoot(9));
    }

    public static int extractionOfSquareRoot(int number) {
        int result;
        for (int i = result = 1; i * i != number; i++) {
            result = i + 1;
        }
        return result;
    }
}