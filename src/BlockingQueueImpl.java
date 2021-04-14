import java.util.concurrent.BlockingQueue;

class FirstWorker implements  Runnable{
    private BlockingQueue<Integer> blockingQueue;

    FirstWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int counter = 0;
        while(true) {
            try {
                blockingQueue.put(counter);
                System.out.println("Putting item to the queue "+counter);
                counter++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SecondWorker implements  Runnable{
    private BlockingQueue<Integer> blockingQueue;

    SecondWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int counter = 0;
        while(true) {
            try {
                blockingQueue.take();
                counter++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
