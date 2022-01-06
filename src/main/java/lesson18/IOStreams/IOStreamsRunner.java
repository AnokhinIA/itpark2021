package lesson18.IOStreams;


import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * (+) 1. Добавить поддержку Maven для проекта
 * (+) 2. Имеется в распоряжении текстовый файл, состоящий из  нескольких строк (можно расположить в папке с ресурсами  или наполнить отдельным раннером). Необходимо в  отдельном потоке считывать его содержимое, перекладывая  каждую строку в отдельный файл (количество создаваемых  файлов соответствует количеству строк в файле).
 * (-) 3. Рекомендую начинать думать о проекте (в части темы для  разработки)
 */

public class IOStreamsRunner {
    @SneakyThrows
    public static void main(String[] args) {
        FileReader logFileRead = new FileReader("testFile.txt");
        Scanner scan = new Scanner(logFileRead);
        ArrayList<String> textFromFile = new ArrayList<>();
        while (scan.hasNextLine()) {
            textFromFile.add(scan.nextLine());
        }
        int count = 1;
        for (String line : textFromFile) {
            FileWriter lineFile = new FileWriter("Line" + count + ".txt");
            lineFile.write(line);
            System.out.println("Строка №" + count + ": " + "\"" + line + "\" Записано в файл: Line" + count + ".txt");
            count++;
            lineFile.close();
        }
    }
}