package leetcode.dp;

import java.util.Arrays;

public class LIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] lis = new int[len];
        lis[0]=1;
        for(int i = 1; i<len; i++) {
            if(nums[i]>nums[i-1])
                lis[i] = lis[i-1] + 1;
            else
                lis[i] = lis[i-1];
        }
        return lis[len-1];
    }
    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        LIS obj = new LIS();
        obj.lengthOfLIS(nums);
    }
}
