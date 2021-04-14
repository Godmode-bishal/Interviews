package leetcode.biweekly;
//Find max sum of k consecutive elements in an array
public class SlidingWindowExample {
    public int maxConsecutiveSum(int[] array, int k) {
        int n = array.length;
        if(n<k) {
            System.out.println("Invalid");
            return -1;
        }
        //Compute sum of 1st window of size k
        int max_sum = 0;
        for(int i = 0; i<k ; i++)
            max_sum += array[i];
        int window_sum = max_sum;
        for(int i = k; i<n; i++) {
            window_sum += array[i]-array[i-k];
            max_sum = Math.max(max_sum,window_sum);
        }
        return max_sum;
    }
}
