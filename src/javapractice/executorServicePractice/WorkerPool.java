package javapractice.executorServicePractice;

import java.util.concurrent.*;
/*
public class WorkerPool {
    public static void main(String[] args) throws InterruptedException {
        RejectedExecutionHandlerImpl rejectedExecutionHandler = new RejectedExecutionHandlerImpl();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        /*Notice that while initializing the ThreadPoolExecutor, we are keeping initial pool size as 2, maximum pool size to 4 and work queue size as 2.
        So if there are 4 running tasks and more tasks are submitted, the work queue will hold only 2 of them and the rest of them will be handled by RejectedExecutionHandlerImpl.
        * */
        /*ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,3,10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectedExecutionHandler);
        MyMonitorThread monitor = new MyMonitorThread(threadPoolExecutor, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();
        for(int i = 0; i<10; i++) {
            threadPoolExecutor.execute(new WorkerThread("cmd"+i));
        }
        Thread.sleep(30000);
        threadPoolExecutor.shutdown();
        Thread.sleep(5000);
        monitor.shutDown();
    }
}*/

        public class WorkerPool {
            public static void main(String[] args) throws InterruptedException {
                ThreadFactory threadFactory = Executors.defaultThreadFactory();
                RejectedExecutionHandlerImpl rejectedExecutionHandler = new RejectedExecutionHandlerImpl();
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,3,10, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2), threadFactory,rejectedExecutionHandler);
                MyMonitorThread monitor = new MyMonitorThread(threadPoolExecutor, 3);
                Thread monitorThread = new Thread(monitor);
                monitorThread.start();
                for(int i =0; i<10; i++) {
                    threadPoolExecutor.execute(new WorkerThread("cmd"+i));
                }
                Thread.sleep(30000);
                threadPoolExecutor.shutdown();
                Thread.sleep(5000);
                monitor.shutDown();
            }
        }
