package lesson16.Threads;

public class LoggerThread1 extends Thread{
    private String value;

    @Override
    public void run() {
        for (int i =1; i <5; i++){
            System.out.println(value + " " + i);
        }
    }

    public LoggerThread1(String value) {
        this.value = value;
    }
}
