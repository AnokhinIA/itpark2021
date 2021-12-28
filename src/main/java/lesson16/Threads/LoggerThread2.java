package lesson16.Threads;

public class LoggerThread2 extends Thread{
    private String value;

    public LoggerThread2(String value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int i =1; i <5; i++){
            System.out.println(value + " " + i);
        }
    }


}
