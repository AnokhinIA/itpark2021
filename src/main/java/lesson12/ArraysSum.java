package lesson12;

public class ArraysSum {
    public String[][] array;

    private void checkArray() {
        if (array.length != 4) throw new MyArraySizeException("Ошибка, массивов не 4, а " + array.length);

        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Ошибка, в массиве № " + i + " не 4 значения, а " + array[i].length);
            }
        }
    }

    public int sum() {
        checkArray();
        int sum = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                try {
                    sum = sum + Integer.parseInt(array[j][i]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В массиве №" + j + " в ячейке " + i + " символ " + array[j][i] + " вместо числа. Преобразование невозможно.");
                }
            }
        }
        return sum;
    }

    public ArraysSum(String[][] array) {
        this.array = array;
    }
}
