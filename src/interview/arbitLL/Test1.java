package interview.arbitLL;

public class Test1 extends Thread {
    int x = 0;
    @Override
    public void run() {
       for(int i = 0; i<10000000; i++) {
           x = x+1;
       }
    }
    public static void main(String[] args) throws InterruptedException {

        Test1 test1 = new Test1();
        test1.start();
        Test1 test2 = new Test1();
        test2.start();
        test1.join();
        test2.join();
        System.out.println("Value = "+ test1.x);
        System.out.println("Value2 = "+ test2.x);


    }
}
