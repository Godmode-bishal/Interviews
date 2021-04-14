package Fortigo;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CodeDriver {
    public static void  main(String[] args) {
        List<FutureTask<String>> taskList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i =0; i<50; i++) {
            FutureTask<String> futureTask = new FutureTask<>(new UniqueGen());
            taskList.add(futureTask);
            executorService.submit(futureTask);
        }
        Set<String> codeSet = new HashSet<>();
        for(FutureTask<String> task:taskList) {
            try {
                codeSet.addAll(Collections.singleton(task.get()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        System.out.println("Codes extracted are : ");
        for(String code:codeSet) {
            System.out.println(code);
        }
    }
}
