package javapractice.countdownlatch;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertThat;

public class CountdownLatchExample {
    @Test
    public void blockUntilCompletion() throws InterruptedException{
        List<String> outputScrapper = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(5);
        //limit(N) returns first N elements in the encounter order of the stream
        List<Thread> workers = Stream.generate(()-> new Thread(new Worker(outputScrapper, countDownLatch))).limit(5).collect(Collectors.toList());
        workers.forEach(Thread::start);
        countDownLatch.await();
        outputScrapper.add("Latch released");
        System.out.println(outputScrapper);
    }

    @Test
    public void whenLotsOfThreadInParallel_thenStartAtTheSameTime() throws InterruptedException{
        List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch readyThreadCounter = new CountDownLatch(5);
        CountDownLatch callingThreadBocker = new CountDownLatch(1);
        CountDownLatch completedThreadCounter = new CountDownLatch(5);
        List<Thread> workers = Stream.generate(()->new Thread(new WaitingWorker(outputScraper, readyThreadCounter, callingThreadBocker, completedThreadCounter)))
                .limit(5)
                .collect(Collectors.toList());
        workers.forEach(Thread::start);
        readyThreadCounter.await();
        outputScraper.add("Workers ready");
        callingThreadBocker.countDown();
        completedThreadCounter.await();;
        outputScraper.add("Workers completed");
        System.out.println(outputScraper);
    }
}
