package javapractice.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskExample extends RecursiveTask<Long> {
    private long workLoad = 0;

    public RecursiveTaskExample(long workLoad) {
        this.workLoad = workLoad;
    }


    @Override
    protected Long compute() {
        if(this.workLoad>16) {
            System.out.println("Splitting workload : " + this.workLoad);
            List<RecursiveTaskExample> subTasks = new ArrayList<>();
            subTasks.addAll(createSubTasks());
            for(RecursiveTaskExample subTask:subTasks) {
                subTask.fork();
            }
            long result = 0;
            for(RecursiveTaskExample subTask:subTasks) {
                result += subTask.join();
            }
            return result;
        }
        else {
            System.out.println("Doing workload myself : " + this.workLoad);
            return workLoad*3;
        }
    }

    private List<RecursiveTaskExample> createSubTasks() {
        List<RecursiveTaskExample> subTask = new ArrayList<>();
        RecursiveTaskExample subTask1 = new RecursiveTaskExample(this.workLoad/2);
        RecursiveTaskExample subTask2 = new RecursiveTaskExample((this.workLoad/2));

        subTask.add(subTask1);
        subTask.add(subTask2);
        return subTask;
    }

    public static void main(String[] args) {
        RecursiveTaskExample recursiveTaskExample = new RecursiveTaskExample(24);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println(forkJoinPool.invoke(recursiveTaskExample));
    }
}
