package javapractice.executorServicePractice;

import java.util.concurrent.*;

public class ExecutorServiceSubmitExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future future = executorService.submit(()-> System.out.println("Asynchronous task"));
        Future callableFuture = executorService.submit(()->{
            System.out.println("Async callback");
            return "Callable result";
        });
        System.out.println("future.get() = "+callableFuture.get());
        executorService.shutdown();
    }
}