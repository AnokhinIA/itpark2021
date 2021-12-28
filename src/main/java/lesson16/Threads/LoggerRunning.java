package lesson16.Threads;

public class LoggerRunning {
    public static void main(String[] args) throws InterruptedException {
        Thread loginThread = new LoggerThread1("Igor");
        loginThread.start();
        loginThread.join();
        new LoggerThread2("Igor2").start();

    }
}
