package javapractice.competableFuture;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;


public class ComparableFutureExample {
    public Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(1000);
            completableFuture.complete("Hello");
            return null;
        });
        return completableFuture;
    }
    @Test
    public void completableFutureTest() throws InterruptedException, ExecutionException {
        Future<String> completableFuture = calculateAsync();
        String result = completableFuture.get();
        assertEquals("Hello", result);
    }

    @Test
    public void completableFuturesupplyAsyncTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->"Hello");
        assertEquals("Hello", completableFuture.get());
    }

    @Test
    public void thenApplyExample() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->"Hello");
        CompletableFuture<String> completableFuture1 = completableFuture.thenApply((s)->s+" World");
        assertEquals("Hello World", completableFuture1.get());
    }

    @Test
    public void thenAcceptsExample() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->"Hello");
        CompletableFuture<Void> completableFuture1 = completableFuture.thenAccept((s)-> System.out.println(s + " World"));
        assertEquals("Hello World", completableFuture1.get());
    }

    @Test
    public void thenRunExample() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->"Hello");
        CompletableFuture<Void> completableFuture1 = completableFuture.thenRun(()-> System.out.println("Hello World"));
    }

    @Test
    public void thenComposeExample() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->"Hello").thenCompose(s->CompletableFuture.supplyAsync(()->s + " World"));
        assertEquals("Hello World", completableFuture.get());
    }

    @Test
    public void thenCombineExample() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->"Hello").thenCombine(CompletableFuture.supplyAsync(()-> " World"), (s1,s2)->s1+s2);
        assertEquals("Hello World", completableFuture.get());
    }

    @Test
    public void thenAcceptBoth() throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(()->"Hello").thenAcceptBoth(CompletableFuture.supplyAsync(()->" World"), (s1, s2)-> System.out.println(s1 + s2));
        System.out.println(completableFuture.get());
    }

    @Test
    public void allOfExample() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        combinedFuture.get();

        assertTrue(future1.isDone());
        assertTrue(future2.isDone());
        assertTrue(future3.isDone());
    }

    @Test
    public void joinExample() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");
        String combined = Stream.of(future1, future2, future3).map(CompletableFuture::join).collect(Collectors.joining(" "));
        assertEquals("Hello Beautiful World", combined);
    }

    @Test
    public void handleTest() throws ExecutionException, InterruptedException {
        String name = null;
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()-> {
            if(name== null) {
                throw new RuntimeException("Value Null");
            }
            return "Hello" + name;
        }).handle((s,t)->s!= null? s: "Hello Stranger");
        assertEquals("Hello Stranger", completableFuture.get());
    }

    @Test
    public void completeExceptionallyTest() throws ExecutionException, InterruptedException {
        String name = null;
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()-> {
            if(name== null) {
                throw new RuntimeException("Value Null");
            }
            return "Hello" + name;
        }).handle((s,t)->s!= null? s: "Hello Stranger");
        completableFuture.completeExceptionally(new RuntimeException("Calculation failed!"));
        assertEquals("Hello Stranger", completableFuture.get());
    }

    @Test
    public void thenApplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(()->"Hello");
        CompletableFuture<String> future = stringCompletableFuture.thenApplyAsync(s->s + " World");
        assertEquals("Hello World", future.get());
    }

}
