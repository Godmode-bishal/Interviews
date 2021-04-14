package leetcode.sortSearch;

public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int[] out = new int[2];
        int left = 0, right = nums.length-1, firstOc =-1, lastOc=-1;
        firstOc = findLeftBounds(nums, left, right, target);
        lastOc = findRightBounds(nums, left, right, target);
        out[0] = firstOc;
        out[1] = lastOc;
        return out;
    }
    private int findLeftBounds(int[] nums, int left, int right, int target) {
        int mid, index =-1 ;
        while(left<=right) {
            mid =  (left+right)/2;
            if(nums[mid]>=target) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
            if(nums[mid]==target)
                index = mid;
        }
        return index;
    }

    private int findRightBounds(int[] nums, int left, int right, int target) {
        int mid, index =-1 ;
        while(left<=right) {
            mid =  (left+right)/2;
            if(nums[mid]<=target) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
            if(nums[mid]==target)
                index = mid;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        SearchForRange obj = new SearchForRange();
        obj.searchRange(nums, 8);
    }
}
