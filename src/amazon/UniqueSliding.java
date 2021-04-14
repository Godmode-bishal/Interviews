package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqueSliding {
    int[] uniqueElements(int[] input, int[] moments, int slidingWindowSize) {
        int[] intermediateoutput = new int[input.length-slidingWindowSize+1];
        int[] output = new int[moments.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i= 0; i<slidingWindowSize; i++) {
            map.put(input[i],map.getOrDefault(input[i],0)+1);
        }
        intermediateoutput[0] = map.size();
        for(int i = 1;i<input.length-slidingWindowSize+1; i++) {
            if(map.get(input[i-1])== 1)
                map.remove(input[i-1]);
            else
                map.put(input[i-1],map.get(input[i-1])-1);
            map.put(input[i+slidingWindowSize-1],map.getOrDefault(input[i+slidingWindowSize-1],0)+1);
            intermediateoutput[i] = map.size();
        }
        for(int i = 0; i<moments.length; i++) {
            output[i] = intermediateoutput[moments[i]];
        }
        return output;
    }

    int countWindow(int[] arr, int k) {
        int count  = 0,i,j;
        for(i = 0; i<k; i++) {
            for(j = 0; j<i; j++) {
                if(arr[i]==arr[j])
                    break;
            }
            if(i==j)
                count++;
        }
        return count;
    }

    void noExtraSpaceSolution(int[] arr, int k) {
        for(int i = 0; i<=arr.length-k; i++) {
            System.out.println(countWindow(Arrays.copyOfRange(arr,i,arr.length),k));
        }
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
        int k = 4;
        int[] moments = {0,2,3};
        UniqueSliding obj = new UniqueSliding();
        obj.noExtraSpaceSolution(arr,k);
    }
}
