package leetcode.sortSearch;

public class RotatedSorted {
    public int search(int[] nums, int target) {
        if(nums.length==0 || nums == null)
            return -1;
        int left = 0, right = nums.length-1, mid;
        while(left<right) {
            mid = left+(right-left)/2;
            if(nums[mid]>nums[right]) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        int start = left;
        left = 0;
        right = nums.length-1;

        if(nums[start]<=target && nums[right]>=target) {
            left = start;
        }
        else {
            right = start;
        }
        while(left<=right) {
            mid = left + (right-left)/2;
            if(nums[mid]==target) {
                return mid;
            }
            else if(nums[mid]<target) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return -1;
    }
}
