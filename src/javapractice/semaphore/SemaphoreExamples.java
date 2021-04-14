package javapractice.semaphore;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SemaphoreExamples {
    @Test
    public void testBlockedWhenLimitReached() {
        int slots = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(slots);
        LoginQueueUsingSemaphore loginQueueUsingSemaphore = new LoginQueueUsingSemaphore(slots);
        IntStream.range(0, slots)
                .forEach(user->executorService.execute(loginQueueUsingSemaphore::tryLogin));
        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        }
        catch(InterruptedException e) {
            executorService.shutdownNow();
        }
        assertEquals(0, loginQueueUsingSemaphore.availableSlots());
        assertFalse(loginQueueUsingSemaphore.tryLogin());
        loginQueueUsingSemaphore.logout();
        assertTrue(loginQueueUsingSemaphore.availableSlots()>0);
        assertTrue(loginQueueUsingSemaphore.tryLogin());

    }

    @Test
    public void whenMutexWithMultipleThreads_thenBLocked() throws InterruptedException{
        int count = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        CounterUsingMutex counterUsingMutex = new CounterUsingMutex();
        IntStream.range(0, count)
                .forEach(user->
                        executorService.execute(
                                ()-> {
                                    try {
                                        counterUsingMutex.increase();
                                    }
                                    catch(InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                        ));
        executorService.shutdown();
        assertTrue(counterUsingMutex.hasQueuedThreads());
        try {
            if(!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        }
        catch(InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
