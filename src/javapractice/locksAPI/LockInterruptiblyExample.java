package javapractice.locksAPI;

import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyExample {
    private static void testInterruptibly() {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread = new Thread(()->{
            int i  = 0;
            System.out.println("Before entering reentrant block");
            try {
                reentrantLock.lockInterruptibly();
                while(true) {
                    System.out.println("In this reentrant block "+ ++i);
                }
            }
            catch(InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
                );
        reentrantLock.lock();// lock first to make the lock in the thread "waiting" and then interruptible
        thread.start();
        thread.interrupt();
    }
    public static void main(String[] args) {
        testInterruptibly();
    }
}
