package lesson16.Threads;

import lesson16.Threads.LoginLevels.*;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private FileWriter logFile;
    private String text;

    public synchronized void writeFile(FileWriter logFile, String text) throws IOException {
        logFile.write(text);
    }



}
