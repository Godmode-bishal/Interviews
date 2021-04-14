package leetcode.sortSearch;

import java.util.*;

public class TopKFreqElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] output = new int[k];
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            frequencyMap.put(nums[i],frequencyMap.getOrDefault(nums[i],0)+1);
        }
        //Sort the hashmap according to value
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(frequencyMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>()
        {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(int i = 0; i<k; i++) {
            output[i] = list.get(i).getKey();
        }
        return output;
    }

    public int[] topKFrequentEfficient(int[] nums, int k) {
        Map<Integer, Integer> frequencies = getFrequencies(nums);
        LinkedList<Integer>[] buckets = bucketSort(frequencies, nums.length);

        int[] ans = new int[k];
        int i = 0;

        for (LinkedList<Integer> bucket : buckets) {
            if (bucket == null) continue;

            for (int num : bucket) {
                ans[i++] = num;
                if (i == k) return ans;
            }
        }

        return ans;
    }

    public Map<Integer, Integer> getFrequencies(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int num : nums) {
            frequencies.compute(num, (k, x) -> x != null ? x + 1 : 1);
        }

        return frequencies;
    }

    public LinkedList<Integer>[] bucketSort(Map<Integer, Integer> frequencies, int max) {
        LinkedList<Integer>[] buckets = new LinkedList[max];

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            int index = max - frequency;

            if (buckets[index] == null) buckets[index] = new LinkedList<>();
            buckets[index].addFirst(num);
        }

        return buckets;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        TopKFreqElements obj = new TopKFreqElements();
        obj.topKFrequentEfficient(nums,k);
    }
}
