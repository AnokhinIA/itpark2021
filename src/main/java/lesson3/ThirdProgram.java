package lesson3;
// Решение квадратного уравления.
public class ThirdProgram {
    public static void main(String[] args) {
        solutionOfQuadraticEquation(2, 15, 18);
    }

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
}
