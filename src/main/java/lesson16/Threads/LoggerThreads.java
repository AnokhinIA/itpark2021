package lesson16.Threads;

import java.util.Random;

public class LoggerThreads extends Thread {

    private Logger logger;

    @Override
    public void run() {
        String current = Thread.currentThread().getName();

        try {
            while (true) {
                Thread.sleep(new Random().nextInt(5000));
                this.logger.writeFile(current);
            }
        } catch (InterruptedException e) {
            System.out.println(current + " остановлен");
        }

    }

    public LoggerThreads(Logger logger) {
        this.logger = logger;
    }


}
