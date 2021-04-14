package longestIncreasingSubseqence;

import java.util.Arrays;

public class BinarySearch {

    static int ceilIndex(int[] arr, int[] T, int start, int len, int num) {
        while (start <= len) {
            if (arr[T[(start + len) / 2]] >= num) {
                if (arr[T[(start + len) / 2 - 1]] < num)
                    return (start + len) / 2;
                else
                    return ceilIndex(arr, T, start, (start + len) / 2, num);
            } else {
                return ceilIndex(arr, T, (start + len) / 2 + 1, len, num);
            }
        }
        return -1;
    }

    static int lis(int[] arr) {
        int[] T = new int[arr.length];
        //Don't think R array is needed
        //int[] R = new int[arr.length];
        //Arrays.fill(R,-1);
        int len = 0;
        T[0] = 0;
        for(int i =1; i<arr.length; i++) {
            if(arr[i]>arr[T[len]]) {
                T[len+1] = i;
                len++;
                //R[i] = T[len-1];
            }
            else if(arr[i]<T[0]) {
                T[0] = i;
            }
            else {
                int index = ceilIndex(arr, T, 0, len, arr[i]);
                T[index] = i;
                //R[T[index]] = T[index-1];
            }
        }
        int j = len;
        while(j>-1) {
            System.out.print(arr[T[j]] + "->");
            j--;
        }
        return len+1;
    }

    public static void main(String[] args) {
        int arr[] = { 3,4,-1,5,8,2,3,12,7,9,10};
        System.out.println(BinarySearch.lis(arr));
    }
}
