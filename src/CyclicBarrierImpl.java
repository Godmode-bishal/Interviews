import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements  Runnable{
    private int id;
    private Random random;
    private CyclicBarrier cyclicBarrier;

     Worker(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.random = new Random();
        this.cyclicBarrier =  cyclicBarrier;
    }

    @Override
    public void run() {
        doWork();
    }

     private void doWork() {
         System.out.println("Thread with ID = " +id+ "starting !!");
         try {
             Thread.sleep(random.nextInt(3000));
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println("Thread with ID = " +id+ "finishing !!");
         try {
             cyclicBarrier.await();
             System.out.println("After await..");
         } catch (InterruptedException e) {
             e.printStackTrace();
         } catch (BrokenBarrierException e) {
             e.printStackTrace();
         }
     }

     @Override
     public String toString() {
         return ""+this.id;
     }
 }

public class CyclicBarrierImpl {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("All the tasks are finished");
            }
        });
        for(int i=0; i<5; i++) {
            executorService.execute(new Worker(i+1, cyclicBarrier));
        }
        executorService.shutdown();
    }
}
