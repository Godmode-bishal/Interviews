package morganstanley;

public class Thread3 implements Runnable {

    @Override
    public void run() {
        System.out.println("running");
    }
    public static void main(String[] args) {
        Thread t =  new Thread(new Thread3());
        t.run();
        t.run();
        t.start();
    }
}
