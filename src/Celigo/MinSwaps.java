package Celigo;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinSwaps {
    //public static long howManySwaps(List<Integer> arr) {
    // Write your code here
        /*int listSize = arr.size();
        ArrayList <Pair<Integer, Integer>> arrayPairs = new ArrayList<Pair<Integer,Integer>>();
        for (int i = 0; i < listSize; i++)
            arrayPairs.add(new Pair<Integer,Integer>(arr.get(i), i));
        arrayPairs.sort(new Comparator<Pair<Integer, Integer>>()
        {
            @Override
            public int compare(Pair<Integer, Integer> first, Pair<Integer, Integer> second)
            {
                if (first.getKey() > second.getKey())
                    return 1;
                else if (first.getKey().equals(second.getKey()))
                    return 0;
                else
                    return -1;
            }
        });
        Boolean[] visited = new Boolean[listSize];
        Arrays.fill(visited, false);
        int result = 0;
        for (int i = 0; i < listSize; i++)
        {
            if (visited[i] || arrayPairs.get(i).getValue() == i)
                continue;
            int sizeOfCycle = 0;
            int j = i;
            while (!visited[j])
            {
                visited[j] = true;
                j = arrayPairs.get(j).getValue();
                sizeOfCycle++;
            }
            if(sizeOfCycle > 0)
            {
                result += (sizeOfCycle - 1);
            }
        }
        return result;*/
        /*static int merge(int arr[], int temp[],
        int left, int mid, int right)
        {
            int inv_count = 0;

            /* i is index for left subarray*/
    //int i = left;

    /* i is index for right subarray*/
    //int j = mid;

    /* i is index for resultant merged subarray*/
    //int k = left;

            /*while ((i <= mid - 1) && (j <= right))
            {
                if (arr[i] <= arr[j])
                    temp[k++] = arr[i++];
                else
                {
                    temp[k++] = arr[j++];

            /* this is tricky -- see above /
             explanation diagram for merge()*/
    //inv_count = inv_count + (mid - i);
    //   }
    //}

    /* Copy the remaining elements of left
    subarray (if there are any) to temp*/
            /*while (i <= mid - 1)
                temp[k++] = arr[i++];*/

    /* Copy the remaining elements of right
    subarray (if there are any) to temp*/
            /*while (j <= right)
                temp[k++] = arr[j++];*/

    /*Copy back the merged elements
    to original array*/
            /*for (i=left; i <= right; i++)
                arr[i] = temp[i];

            return inv_count;
        }*/

// An auxiliary recursive function that
// sorts the input array and returns
// the number of inversions in the array.
        /*static int _mergeSort(int arr[], int temp[],
        int left, int right)
        {
            int mid, inv_count = 0;
            if (right > left)
            {*/
    // Divide the array into two parts and
    // call _mergeSortAndCountInv() for
    // each of the parts
//                mid = (right + left)/2;

        /* Inversion count will be sum of
        inversions in left-part, right-part
        and number of inversions in merging */
                /*inv_count = _mergeSort(arr, temp,
                        left, mid);

                inv_count += _mergeSort(arr, temp,
                        mid+1, right);

                inv_count += merge(arr, temp,
                        left, mid+1, right);
            }

            return inv_count;
        }*/

    // This function sorts the input
// array and returns the number
// of inversions in the array
        /*static int countSwaps(int arr[], int n)
        {
            int temp[] = new int[n];
            return _mergeSort(arr, temp, 0, n - 1);
        }*/
    //}

    public static long howManySwaps(int[] arr) {
        //selection sort. O(n^2)
 /*   int minIndex;
    int len = arr.length;
    int tmp;
    int swaps = 0;
    for(int i =0; i<len-1; i++) {
        minIndex = i;
        for(int j = i; j<len; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        if(minIndex != i) {
            tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
            swaps++;
        }
    }
    return swaps;*/
 //Important constraint : 1<=arr[i]<=n
        int swaps = 0;
        int size = arr.length;
        int tmp, index2;
        int[] tmpArray = new int[size+1];
        for(int i = 0; i < size; i++) {
            tmpArray[arr[i]] = i;
        }
        for(int i = 0; i<size; i++) {
            index2 = tmpArray[i+1];
            if(i != index2) {
                tmp = arr[i];
                arr[i] = arr[index2];
                arr[index2] = tmp;
                tmpArray[tmp] = index2;
                tmpArray[i+1] = i;
                swaps++;
            }
        }
        return swaps;
    }


}

