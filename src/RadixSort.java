import java.util.Arrays;

public class RadixSort {
    //A utility function to get maximum value in arr[]
    static int getMax(int[] inputArr, int len) {
        int max = inputArr[0];
        for(int i = 1; i<len; i++) {
            if(max<inputArr[i])
                max = inputArr[i];
        }
        return max;
    }

    static void radixSort(int[] inputArray, int len) {
        int max = getMax(inputArray, len);
        //Do counting sort for each digit
        for(int decPlace = 1; max/decPlace>0; decPlace *= 10)
            countSort(inputArray, len, decPlace);

    }

    //Counting sort digit by digit
    private static void countSort(int[] inputArray, int len, int decPlace) {
        int[] output = new int[len];
        int i ;
        int[] count = new int[10];
        Arrays.fill(count,0);
        //Store count of occurences
        for(i = 0; i<len; i++) {
            count[(inputArray[i]/decPlace)%10]++;
        }
        for(i = 1; i<10; i++)
            count[i] += count[i-1];
        for(i = len-1; i>=0; i--) {
            output[count[(inputArray[i]/decPlace)%10]-1] = inputArray[i];
            count[(inputArray[i]/decPlace)%10]--;
        }
        for (i = 0; i < len; i++)
            inputArray[i] = output[i];
    }
}
