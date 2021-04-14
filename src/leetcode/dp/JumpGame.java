package leetcode.dp;

public class JumpGame {
    public boolean canJump(int[] nums) {
        //Tried out using subset sum problem DP. Didn't work
        /*if(nums.length==0)
            return true;
        int sumToFind = nums.length-1;
        boolean[][] subsetSumMatrix = new boolean[sumToFind+1][sumToFind+1];
        for(int i = 0; i<sumToFind+1; i++)
            subsetSumMatrix[i][0] = true;
        for(int i = 0; i<sumToFind+1; i++) {
            for(int j = 1; j<sumToFind+1; j++) {
                if(j<nums[i]) {
                    subsetSumMatrix[i][j]=i-1>-1?subsetSumMatrix[i-1][j]:false;
                }
                else if(j==nums[i])
                    subsetSumMatrix[i][j] = true;
                else {
                    if(i-1>-1 && j-nums[i]>-1)
                        subsetSumMatrix[i][j] = subsetSumMatrix[i - 1][j] || subsetSumMatrix[i - 1][j - nums[i]];
                    else
                        subsetSumMatrix[i][j] = false;
                }
                if(j==sumToFind && subsetSumMatrix[i][j])
                    return true;
            }
        }
        return false;*/
        //This is greedy
        int len = nums.length;
        int lastReachablePos = len-1;
        for(int i = len-1; i>-1; i--) {
            if(i+nums[i]>=lastReachablePos) {
                lastReachablePos = i;
            }
        }
        return lastReachablePos==0;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        JumpGame obj = new JumpGame();
        System.out.println(obj.canJump(nums));
    }
}
