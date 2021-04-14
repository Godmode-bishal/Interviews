package javapractice.worksteal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimeNumbers extends RecursiveAction {
    private int lowerBound;
    private int upperBound;
    private int granularity;
    private AtomicInteger noOfPrimeNumbers;

    static final List<Integer> granularities = Arrays.asList(1,10,100,1000,10000);
    PrimeNumbers(int lowerBound, int upperBound, int granularity, AtomicInteger noOfPrimeNumbers) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.granularity = granularity;
        this.noOfPrimeNumbers = noOfPrimeNumbers;
    }

    private List<PrimeNumbers> subTasks() {
        List<PrimeNumbers> subTasks = new ArrayList<>();
        for(int i = 1; i<=this.upperBound/granularity; i++) {
            int upper = i*granularity;
            int lower = (upper-granularity)+1;
            subTasks.add(new PrimeNumbers(lower, upper, granularity, noOfPrimeNumbers));
        }
        return subTasks;
    }

    @Override
    protected void compute() {
        if(((upperBound+1)-lowerBound)>granularity) {
            ForkJoinTask.invokeAll(subTasks());
        }
        else {
            findPrimeNumbers();
        }
    }

    void findPrimeNumbers() {
        for(int num = lowerBound; num<=upperBound; num++) {
            /*if(isPrime(num)) {
                noOfPrimeNumbers.getAndIncrement();
            }*/
        }
    }

    public int noOfPrimeNumbers() {
        return noOfPrimeNumbers.intValue();
    }
}
