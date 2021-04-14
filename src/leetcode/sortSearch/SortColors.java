package leetcode.sortSearch;

public class SortColors {
    public void sortColors(int[] nums) {
        int lastZeroEncountered = -1, lastOneEncountered = -1, lastTwoEncountered = -1;
        int temp;
        int len = nums.length;
        for(int i = 0; i<len; i++) {
            if(nums[i]==0) {
                temp = nums[i];
                nums[i] = nums[lastZeroEncountered+1];
                nums[lastZeroEncountered+1] = temp;
                lastZeroEncountered++;
            }
        }
        lastOneEncountered = lastZeroEncountered;
        for(int i = lastZeroEncountered+1; i<len; i++) {
            if(nums[i]==1) {
                temp = nums[i];
                nums[i] = nums[lastOneEncountered+1];
                nums[lastOneEncountered+1] = temp;
                lastOneEncountered++;
            }
        }
        for(int i = lastOneEncountered+1; i<len; i++) {
            nums[i] = 2;
        }
    }

    public void sortColorsBetter(int[] nums) {
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        int i ;
        for(i = 0; i<nums.length; i++) {
            if(nums[i]==0)
                zeroCount++;
            else if(nums[i]==1)
                oneCount++;
            else
                twoCount++;
        }
        for(i = 0; i<zeroCount; i++) {
            nums[i] = 0;
        }
        for(i = zeroCount; i<zeroCount+oneCount; i++) {
            nums[i] = 1;
        }
        for(i = oneCount; i<nums.length; i++) {
            nums[i] = 2;
        }
    }
    public static void main(String[] args) {
        SortColors obj = new SortColors();
        int[] nums = {1};
        obj.sortColors(nums);
    }
}
