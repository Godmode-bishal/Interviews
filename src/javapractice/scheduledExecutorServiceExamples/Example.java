package javapractice.scheduledExecutorServiceExamples;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Example {
    public void example() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        ScheduledFuture scheduledFuture = executorService.scheduleWithFixedDelay (()->
        {
            System.out.println("Called");
            //return "Called!";
        },5,5, TimeUnit.SECONDS);
        //executorService.shutdown();
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.example();
    }
}
