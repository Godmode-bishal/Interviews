package leetcode.sortSearch;

import heap.BinaryHeap;

import java.util.PriorityQueue;

public class KLargest {


    public static void main(String[] args) {
        int[] nums = {2,1};
        int k = 2;
        KLargest obj = new KLargest();
        obj.findKthLargest(nums,k);
    }

    private int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int num:nums) {
            priorityQueue.add(num);
            if(priorityQueue.size()>k) {
                priorityQueue.remove();
            }
        }
        return priorityQueue.remove();
    }

}
