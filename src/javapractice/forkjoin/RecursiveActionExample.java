package javapractice.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class RecursiveActionExample extends RecursiveAction {
   private long workLoad = 0;

    public RecursiveActionExample(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {
        if(this.workLoad>16) {
            System.out.println("Splitting tasks " + this.workLoad);
            List<RecursiveActionExample> subTasks = new ArrayList<>();
            subTasks.addAll(createSubTasks());
            for(RecursiveAction subtask:subTasks) {
                subtask.fork();
            }
        }
        else {
            System.out.println("Doing workload myself " + this.workLoad);
        }
    }

    private List<RecursiveActionExample> createSubTasks() {
        List<RecursiveActionExample> subTask = new ArrayList<>();
        RecursiveActionExample subTask1 = new RecursiveActionExample(this.workLoad/2);
        RecursiveActionExample subTask2 = new RecursiveActionExample((this.workLoad/2));

        subTask.add(subTask1);
        subTask.add(subTask2);
        return subTask;
    }

    public static void main(String[] args) {
        RecursiveActionExample recursiveActionExample = new RecursiveActionExample(24);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(recursiveActionExample);
    }
}
