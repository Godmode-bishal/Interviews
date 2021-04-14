package longestIncreasingSubseqence;


import java.util.Arrays;

class DP
{
    /* lis() returns the length of the longest
       increasing subsequence in arr[] of size n */
    static int lis(int arr[],int n)
    {
        int[] T = new int[n];
        T[0] = 0;
        int len = 0, pos;

        for(int i = 1; i<n; i++) {
             if(arr[i]>arr[T[len]]) {
                 len++;
                 T[len] = i;
             }
             else if(arr[i]<=arr[T[0]]) {
                 T[0] = i;
             }
             else {
                 pos = binarySearch(arr, T,arr[i],0,len);
                 T[pos] = i;
             }
        }
        return len+1;
    }

    //nlogn
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    private static int binarySearch(int[] arr, int[] t, int target, int left, int right) {
        int mid = left + (right-left)/2;
        if(arr[t[mid]]>=target && arr[t[mid-1]]<= target)
            return mid;
        else if(arr[t[mid]]<target) {
            left = mid+1;
            return binarySearch(arr, t, target, left, right);
        }
        else if(arr[t[mid]]>target && arr[t[mid-1]]> target) {
            right = mid-1;
            return binarySearch(arr, t, target, left, right);
        }
        return -1;
    }

    public static void main(String args[])
    {
        int arr[] = {4,10,4,3,8,9};
        int n = arr.length;
        System.out.println("Length of lis is "
                + lengthOfLIS( arr) + "\n" );
    }
}