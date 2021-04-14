package leetcode.arraysString;

import java.util.*;

public class ThreeSum {
    static List<List<Integer>> answer;
    static HashSet<Integer> numChecked;
    public void findPair(int[] nums, int sum, int pos) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> store = new HashSet<>();
        if(!numChecked.contains(sum)) {
            for (int i = 0; i < nums.length; i++) {
                if (i == pos)
                    continue;
                if (!store.contains(sum - nums[i]))
                    store.add(nums[i]);
                else {
                    result.add(-sum);
                    result.add(nums[i]);
                    result.add(sum - nums[i]);
                    numChecked.add(nums[i]);
                    numChecked.add(sum - nums[i]);
                    answer.add(result);
                    result = new ArrayList<>();
                }
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        answer = new ArrayList<>();
        numChecked = new  HashSet<>();
        for(int i = 0; i<nums.length; i++) {
            if(!numChecked.contains(nums[i]))
                findPair(nums, -nums[i], i);
            numChecked.add(nums[i]);
        }
        return answer;
    }


    public List<List<Integer>> threeSumSorted(int[] num) {
        Arrays.parallelSort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            //num[i] != num[i-1] ensures that same sum is not evaluated multiple times
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        int[] nums = new int[]{0,0,0,0};
        for(List<Integer> teamp: obj.threeSumSorted(nums)) {
            for(int temp:teamp)
                System.out.print(teamp+"->");
            System.out.println();
        }
        //obj.findTriplets(nums,4);
    }
}
