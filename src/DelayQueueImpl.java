import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueImpl {
    public static void main(String[] args) {
        BlockingQueue<DelayedWorker> queue = new DelayQueue<>();
        try {
            queue.put(new DelayedWorker(1000, "This is 1st message"));
            queue.put(new DelayedWorker(10000, "This is 2nd message"));
            queue.put(new DelayedWorker(4000, "This is 3rd message"));
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        while(!queue.isEmpty()) {
            try {
                System.out.println( queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DelayedWorker implements Delayed {

    private long duration;
    private String message;

    public DelayedWorker(long duration, String message) {
        this.duration = System.currentTimeMillis() + duration;
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        //convert(long sourceDuration, TimeUnit sourceUnit)
        //Converts the given time duration in the given unit to this unit.
        return unit.convert(duration-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if(this.duration < ((DelayedWorker)o).getDuration()) {
            return -1;
        }

        else if(this.duration > ((DelayedWorker)o).getDuration()) {
            return 1;
        }

        return 0;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
