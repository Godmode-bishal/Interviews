package javapractice.locksAPI;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyLockExample implements Runnable {
    private  Resource resource;
    private Lock lock;

    ConcurrencyLockExample(Resource r) {
        this.resource = r;
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        try {
            if(lock.tryLock(10, TimeUnit.SECONDS)) {
                resource.doSomething();
            }
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
        resource.doLogging();
    }

    public static void main(String[] args) {
        Resource resource = new Resource();
        ConcurrencyLockExample concurrencyLockExample = new ConcurrencyLockExample(resource);
        Thread thread = new Thread(concurrencyLockExample);
        thread.start();
    }
}
