package leetcode.biweekly;
import java.util.ArrayList;
import java.util.List;
/*
You are given an integer array, nums, and an integer k. nums comprises of only 0's and 1's. In one move, you can choose two adjacent indices and swap their values. Return the minimum number of moves required so that nums has k consecutive 1's.
        Example 1:
        Input: nums = [1,0,0,1,0,1], k = 2
        Output: 1
        Explanation: In 1 move, nums could be [1,0,0,0,1,1] and have 2 consecutive 1's.

        Example 2:
        Input: nums = [1,0,0,0,0,0,1,1], k = 3
        Output: 5
        Explanation: In 5 moves, the leftmost 1 can be shifted right until nums = [0,0,0,0,0,1,1,1].

        Example 3:
        Input: nums = [1,1,0,1], k = 2
        Output: 0
        Explanation: nums already has 2 consecutive 1's.

        Constraints:
        1 <= nums.length <= 105
        nums[i] is 0 or 1.
        1 <= k <= sum(nums)
*/
public class MinAdjSwapKConse {
    public int minMoves(int[] nums, int k) {
        List<Integer> positionStore = new ArrayList<>();
        for(int i = 0;i<nums.length; i++) {
            if(nums[i]==1) {
                positionStore.add(i);
            }
        }
        int len = positionStore.size();
        int[] addElements = new int[len];
        addElements[0] = positionStore.get(0);
        for(int i =1; i<len; i++) {
            addElements[i] = positionStore.get(i)+addElements[i-1];
        }

        int medianPos = k%2!=0?k/2:k/2 -1, right=0, left=0, radius=k%2!=0?(k-1)/2:(k-2)/2, minCost=Integer.MAX_VALUE, cost;
        for(int i =0; i<len-k+1; i++) {
            right += addElements[i+k-1]-addElements[i+medianPos];
            if(i!=0)
                left += addElements[i+medianPos-1] - addElements[i-1];
            else if(i+medianPos!=0)
                left += addElements[i+medianPos-1];
            cost = k%2!=0?(right-left-((radius+1)*radius)):(right-left-positionStore.get(i+medianPos)-((radius+1)*radius)-(radius+1));
            minCost = Integer.min(minCost,cost);
            right = left = 0;
        }
    return minCost;
    }
}
