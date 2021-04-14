package leetcode.sortSearch;

public class FindPeak {
    /*i found it hard to understand why this works. I think i figured it out: when you check the middle, if the element on the left subarray is greater than the middle element we know that it either continues to grow and reaches a peak at the end of the subarray (since the bounds are -inf), or it eventually shrinks. Either way, we know that there must exist a peak on the left. The same is true for the right subarray.*/
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
            int mid = (left + right)/2;
            if(nums[mid]<nums[mid+1]) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,3,5,10,10,10,10,10};
        FindPeak obj = new FindPeak();
        obj.findPeakElement(nums);
    }
}
