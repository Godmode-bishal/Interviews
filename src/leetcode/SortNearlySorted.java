package leetcode;

import java.util.Iterator;
import java.util.PriorityQueue;

public class SortNearlySorted {
    public static void kSort(int[] arr, int n, int k) {
        //min heap is automatically implemented ny Priority Queue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i<k+1; i++) {
            priorityQueue.add(arr[i]);
        }
        int index = 0;
        for(int i = k+1; i<n; i++) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }
        Iterator<Integer> itr = priorityQueue.iterator();

        while (itr.hasNext()) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }

    }

    private static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args)
    {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;
        kSort(arr, n, k);
        System.out.println("Following is sorted array");
        printArray(arr, n);
    }
}
