package lesson16.Threads;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Logger {

    private final FileWriter logFile;
    private final String[] logLevel;
    private final String message;

    public synchronized void writeFile(String threadMessage) {

        String logMessage = new Date() + " | " +
                this.logLevel[new Random().nextInt(4)] + " | " +
                threadMessage + " | " +
                message + " | " +
                System.lineSeparator();
        try {
            logFile.write(logMessage);

        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
    }


    public Logger(String[] logLevel, FileWriter logFile, String message) {
        this.logLevel = logLevel;
        this.logFile = logFile;
        this.message = message;

    }
}
