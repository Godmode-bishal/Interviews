package morganstanley;

import java.util.Arrays;

public class TwoXRepeatingElements {
    int binarySearch(int[] input, int i, int j, int num) {
        int mid;
        if(i<j) {
          mid = i+j/2;
          if(input[mid]==num)
              return mid;
          else if(input[mid]<num)
              return binarySearch(input,mid+1,j,num);
          else
              return binarySearch(input, 0, mid-1, num);
        }
        return -1;
    }
    void findTwoX(int[] input, int num) {
        Arrays.sort(input);
        int i = 0,j = input.length-1, mid;
        mid = binarySearch(input,i,j,num);
        while(mid!= -1) {
            System.out.println("Found" + num);
            num *= 2;
            i = mid+1;
            mid = binarySearch(input,i,j,num);
        }
    }
    public static void main(String[] args) {

    }
}
