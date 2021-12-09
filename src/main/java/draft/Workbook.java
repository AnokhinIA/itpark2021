package draft;

import java.util.Arrays;

public class Workbook {
    public static void main(String[] args) {
        /*Тренировка с массивами
        * Массив является ссылочным типом
        * Объявление массива: тип[] имяПеременной
        * Выделение памяти для массива: переменнаяМассива = new тип[размер]
        * Можно в одну строку: тип[] имяПеременно = new тип[размер]
        * Например: int array[] = new int[5]
        */

        //пробуем
        //int[] array = new int[5];
        int[] array2 = {1,2,3,4};   //лаконичная запись, объявили и заполнили значениями, длина массива определяется автоматически

        //System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
        int[] array3 = new int[fillArray(array2).length];
        System.arraycopy(fillArray(array2),0,array3,0,fillArray(array2).length);
        System.out.println(Arrays.toString(array3));
    }

    public static int[] fillArray(int[] array3){
        array3[0] = 99;
        return array3;

    }

}
