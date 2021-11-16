package lesson3;

public class ThirdProgram {
    public static void main(String[] args) {

        solutionOfQuadraticEquation(2, -16, 18);
        System.out.println(resultOfFactorial(5));
    }

    /**
     * Метод для решения квадратного уравнения
     * @param a - 1-ый коэффициент
     * @param b - 2-ой кожффициент
     * @param c - свободный член
     */
    public static void solutionOfQuadraticEquation(int a, int b, int c) {
        int d = b * b - 4 * a * c;

        if (a == 0) {
            System.out.println("Первый коэффициент не может быть 0");
        } else if (d < 0) {
            System.out.println("Действительные корни уравнения отсутствуют");
        } else if (d == 0) {
            double x = -b / (2D * a);
            System.out.println(x);
        } else {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println(x1 + " " + x2);
        }
    }

    /**
     * Метод вычисления факториала
     * @param number - число, для которого необходимо вычислить факториал
     * @return - факториал числа
     */
    public static int resultOfFactorial(int number){
        int result;
        for (int i = result = 1; i <= number; i++) {
           result *= i;
        }
        return result;
    }
}