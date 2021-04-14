package SimpleThreadPool;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleThreadPoolTest {
    @Test
    public void testSimpleThreadPool() throws Exception {
        int runnableCount = 10;
        SimpleThreadPool threadPool = SimpleThreadPool.getInstance();
        final AtomicInteger count = new AtomicInteger(0);
        Runnable r = ()->count.getAndIncrement();
        for(int i = 0; i<runnableCount; i++) {
            threadPool.execute(r);
        }
        threadPool.stop();
        threadPool.awaitTermination();
        Assert.assertEquals("Runnables executed should be runnables sent to executable", runnableCount, count.get());
    }

    @Test
    public void testSimpleThreadPoolCustomThreadCount() throws Exception {
        int threadCount = 20;
        SimpleThreadPool threadPool = SimpleThreadPool.getInstance(threadCount);
        final AtomicInteger count = new AtomicInteger(0);
        Runnable r = ()-> {
            count.getAndIncrement();
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                //Do nothing
            }
        };
        for (int i = 0; i < threadCount; i++) {
            threadPool.execute(r);
        }
        threadPool.stop();
        // Threadpool should stop within 300ms as there are enough threads to handle all runnables
        threadPool.awaitTermination(300);
        Assert.assertEquals("All runnables must be executed",threadCount, count.get());
    }
}
