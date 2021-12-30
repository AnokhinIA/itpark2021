package lesson16.Threads;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Задание 16. Опциональное практическое задание (Ментор: Тухватуллин Булат)
 * 1. Создать класс Logger, параметризуемый текстом сообщения и уровнем логирования (ERROR, WARN, INFO, DEBUG, TRACE).
 * 2. Реализовать в данном классе метод записи в файл, помещающий следующую информацию: <текущее время> <статус> <сообщение>
 * 3. Создать три потока, каждый из которых создает сообщение, дополнив его информацией о наименовании/идентификаторе потока.
 * Формат выводимой информации: <текущее время> <статус> <идентификатор> <сообщение>
 * 4. Каждый поток пишет в файл со случайной периодичностью, но задержка должна составлять не более 5 секунд
 * (т.е. поток после записи засыпает на случайно определенное время (но не более 5 секунд),
 * после пробуждения - вновь пишет информацию в файл с сохранением уже имеющейся информации).
 * 5. По истечении минуты работы программы, необходимо остановить работу потоков и вывести содержимое сформированного файла в консоль.
 */

public class LoggerRunning {
    public static void main(String[] args) throws InterruptedException, IOException {
        FileWriter logFile = new FileWriter("errors.log");
        Logger logger = new Logger(new String[]{"ERROR", "WARN", "INFO", "DEBUG", "TRACE"}, logFile, " сообщение об ошибке ");

        Thread loggerThread1 = new LoggerThreads(logger);
        Thread loggerThread2 = new LoggerThreads(logger);
        Thread loggerThread3 = new LoggerThreads(logger);
        loggerThread1.start();
        loggerThread2.start();
        loggerThread3.start();
        System.out.println("Идет работа потоков и запись в файл.");
        Thread.sleep(60000);
        loggerThread1.interrupt();
        loggerThread2.interrupt();
        loggerThread3.interrupt();
        logFile.close();

        System.out.println("Вывод log файла на экран");
        FileReader logFileRead = new FileReader("errors.log");
        Scanner scan = new Scanner(logFileRead);
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
    }
}
