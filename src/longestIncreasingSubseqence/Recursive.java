package longestIncreasingSubseqence;

public class Recursive {
    //Time complexity is exponential. Space complexity is O(1)
    static int max_ref; //stores the longest increasing subsequence length
    static int _lis(int[] arr, int n) {
        //base case
        if(n==1)
            return 1;
        //res holds the result of recursive calls, max_ending_here holds the result of longest increasing subsequence ending with arr[n-1]
        int res, max_ending_here = 1;
        //recursively check the longest increasing subsequence from i=1...x and increase the count if arr[i-1] < arr[n-1] and if increasing count will increase the max till now
        for(int i = 1; i<n; i++) {
            res = _lis(arr,i);
            if(arr[i-1]<arr[n-1] && res+1>max_ending_here)
                max_ending_here = res+1;
        }
        //compare the max till now to the max overall till now
        if(max_ref<max_ending_here)
            max_ref = max_ending_here;
        return max_ending_here;
    }
    static int lis(int[] arr, int n) {
        //this varible holds the result
        max_ref = 1;
        _lis(arr,n);
        return max_ref;
    }

    public static void main(String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is " + lis(arr, n) + "\n");
    }
}
