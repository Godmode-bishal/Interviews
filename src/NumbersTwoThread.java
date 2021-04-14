import java.util.concurrent.atomic.AtomicBoolean;

public class NumbersTwoThread implements Runnable{
    static AtomicBoolean signal;
    private int start;
    private String name;

    NumbersTwoThread(int start, String name) {
        this.start = start;
        this.name = name;
    }
    @Override
    public void run() {
        while (start<=20) {
            while (this.name.equalsIgnoreCase("1") && signal.get()) {
                System.out.println(start);
                start += 2;
                signal.compareAndSet(true, false);
            }
            while (this.name.equalsIgnoreCase("2") && !signal.get()) {
                System.out.println(start);
                start += 2;
                signal.compareAndSet(false, true);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean signal = new AtomicBoolean(true);
        NumbersTwoThread.signal = signal;
        Thread thread1 = new Thread(new NumbersTwoThread( 0, "1"));
        Thread thread2 = new Thread(new NumbersTwoThread(1, "2"));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
