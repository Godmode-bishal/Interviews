package SimpleThreadPool;

import sun.java2d.pipe.SpanShapeRenderer;
import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleThreadPool {
    //count of threadpools created
    private static AtomicInteger poolCount = new AtomicInteger(0);
    //Queue of Runnables
    private ConcurrentLinkedQueue<Runnable> runnables;
    //Flag to control SimpleThreadPool objects
    private AtomicBoolean execute;
    //Holds the pool of Threads
    private List<SimpleThreadPoolThread> threads;

    /**
     * Thrown when there is a RuntimeException or InterruptedException when executing a runnable from the queue, or awaiting termination
     */
    private class ThreadPoolException extends RuntimeException {
        //TODO find out about Throwable
        public ThreadPoolException(Throwable cause) {
            super(cause);
        }
    }

    /**
     * Inner thread class which represents the threads in the pool. Acts as a wrapper for all runnables in the queue
     */
    private class SimpleThreadPoolThread extends Thread {
        private AtomicBoolean execute;
        private ConcurrentLinkedQueue<Runnable> runnables;

        public SimpleThreadPoolThread(String name, AtomicBoolean execute, ConcurrentLinkedQueue<Runnable> runnables) {
            super(name);
            this.execute = execute;
            this.runnables = runnables;
        }

        @Override
        public void run() {
            try {
                //Continue to execute when the execute flag is true and when there are Runnables in the queue
                while(execute.get() || !runnables.isEmpty()) {
                    Runnable runnable;
                    //Poll a Runnable from the queue and execute it
                    while((runnable = runnables.poll()) != null) {
                        runnable.run();
                    }
                    //Sleep in case there wasn't any runnable in the queue. This helps to avoid hogging the CPU
                    Thread.sleep(1);
                }
            }
            catch(RuntimeException | InterruptedException e) {
                throw new ThreadPoolException(e);
            }
        }
    }
    /**
     * Private constructor to control the creation ofthreadpools. Increments the threadpool whenever a new pool is created.
     * @param threadCount number of simplethreadpools to add to the pool
     */
    private SimpleThreadPool(int threadCount) {
        //Increment thread pool
        poolCount.incrementAndGet();
        this.runnables = new ConcurrentLinkedQueue<>();
        this.execute = new AtomicBoolean(true);
        this.threads = new ArrayList<>();
        for(int threadIndex = 0; threadIndex < threadCount; threadIndex++) {
            SimpleThreadPoolThread thread = new SimpleThreadPoolThread("SimpleThreadpool" + poolCount.get() + "Thread" + threadIndex, this.execute, this.runnables);
            thread.start();
            this.threads.add(thread);
        }
    }

    /**
     * Gets a new Threadpool instance with number of threads equal to the number of processors (or CPU threads) available
     * @return new SimpleThreadPool
     */
    public static SimpleThreadPool getInstance() {
        return getInstance(Runtime.getRuntime().availableProcessors());
    }

    /**
     *Gets a new Threadpool instance with the number of threads specified
     * @param threadCount Threads to add to the pool
     * @return new SimpleThreadPool
     */
    public static SimpleThreadPool getInstance(int threadCount) {
        return new SimpleThreadPool(threadCount);
    }

    /**
     * Adds a Runnable to the queue for processing
     * @param runnable Runnable to be added to the queue
     */
    public void execute(Runnable runnable) {
        if(this.execute.get()) {
            runnables.add(runnable);
        }
        else {
            throw new IllegalStateException("Threadpool terminating, unable to execute runnable");
        }
    }

    /**
     * Awaits upto <b>timeout</b> ms the termination of the thread in threadpool
     *
     * @param timeout timeout in ms
     * @throws java.util.concurrent.TimeoutException Thrown if the termination takes longer than the timeout
     * @throws IllegalStateException Thrown if stop() or terminate() haven't been called before awaiting
     */
    public void awaitTermination(long timeout) throws TimeoutException {
        if(this.execute.get())
            throw new IllegalStateException("threadpool not terminated before awaiting termination");
        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime <= timeout) {
            boolean flag = true;
            for(Thread thread:threads) {
                if(thread.isAlive()){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return;
            }
            try {
                Thread.sleep(1);
            }
            catch(InterruptedException e) {
                throw new ThreadPoolException(e);
            }
        }
        throw  new TimeoutException("Unable to terminate threadpool within the specified timeout ("+timeout+") ms");
    }

    /**
     * Awaits the termination of the threads in the threadpool indefinitely
     *
     * @throws IllegalStateException thrown if the stop() or terminate() methods haven't been called before awaiting
     */
    public void awaitTermination() throws TimeoutException {
        if (this.execute.get()) {
            throw new IllegalStateException("Threadpool not terminated before awaiting termination");
        }
        while (true) {
            boolean flag = true;
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new ThreadPoolException(e);
            }
        }
    }

    /**
     * Clears the queue of runnables and stops the threadpool. Any runnables currently executing will continue to execute.
     */
    public void terminate() {
        runnables.clear();
        stop();
    }

    /**
     * Stops addition of new runnables to the threadpool and terminates the pool once all runnables in the queue are executed.
     */
    public void stop() {
        execute.set(false);
    }
}
