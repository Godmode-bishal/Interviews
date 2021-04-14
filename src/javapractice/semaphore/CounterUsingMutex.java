package javapractice.semaphore;

import java.util.concurrent.Semaphore;

public class CounterUsingMutex {
    private Semaphore mutex;
    private int count;
    CounterUsingMutex() {
        mutex = new Semaphore(1);
        count = 0;
    }

    void increase() throws InterruptedException {
        mutex.acquire();
        this.count++;
        Thread.sleep(1000);
        mutex.release();
    }

    int getCount() {
        return this.count;
    }

    boolean hasQueuedThreads() {
        return mutex.hasQueuedThreads();
    }
}
