package lesson12;

public class ArrayRunner {
    public static void main(String[] args) {
        String[][] array = new String[][]{
                {"1", "3", "4", "6" },
                {"8", "9", "1", "1" },
                {"2", "3", "4", "2" },
                {"2", "3", "3", "2" }
        };
        ArraysSum arraysSum = new ArraysSum(array);
        try {
            System.out.println(arraysSum.sum());
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

