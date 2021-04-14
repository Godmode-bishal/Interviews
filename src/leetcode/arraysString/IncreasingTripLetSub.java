package leetcode.arraysString;

import java.util.Arrays;

public class IncreasingTripLetSub {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3)
            return false;
        int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE;
        for(int x = 0; x<nums.length; x++) {
            if(nums[x]<i)
                i = nums[x];
            else if(nums[x]<j)
                j = nums[x];
            else
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {2,1,5,0,6};
        IncreasingTripLetSub obj = new IncreasingTripLetSub();
        System.out.println(obj.increasingTriplet(nums));
    }
}
