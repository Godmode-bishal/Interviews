package deutschBank;

import com.sun.java.swing.plaf.windows.WindowsDesktopIconUI;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MedianOfMedianUnsorted {
    static int left=-1,right=-1;
    public int findPivot(int[] arr, int low, int high) {
        List<Integer> tempList = new ArrayList<>();
        for(int i = low; i<high; i++) {
            tempList.add(arr[i]);
        }
        int size = high - low;
        while(size>5) {
            for(int i = 0; i<size; i += 5){
                if(i+5<=size) {
                    Collections.sort(tempList.subList(i,i+5));
                    tempList.add(arr[i]);
                }
                else {
                    Collections.sort(tempList.subList(i, size));
                    tempList.add(tempList.get(i+(size-i)/2));
                }
            }
            tempList.subList(0,size).clear();
            size = tempList.size();
        }
        Collections.sort(tempList);
        if(size%2==0) {
            return tempList.get(size/2-1);
        }
        else {
            return tempList.get(size/2);
        }
    }

    public int[] swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
        return arr;
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = this.findPivot(arr,low,high);
        int pivotIndex = -1;
        for(int tmp = 0; tmp<high; tmp++) {
            if(arr[tmp]==pivot) {
                pivotIndex = tmp;
                break;
            }
        }
        if(pivotIndex==-1)
            throw new Error("Pivot not found");
        int i = 0,j=high-1;
        while(i<j) {
            while(i<arr.length && arr[i]<=arr[pivotIndex])
                i++;
            while(j>=0 && arr[i]>arr[pivotIndex])
                j--;
            if(i<j)
                swap(arr,i,j);
        }
        if(j!=pivotIndex && 0<=j && j<high) {
            swap(arr,i,pivotIndex);
            pivotIndex = j;
        }
        return pivotIndex;
    }

    public void driver(int[] array, int low, int high) {
        int index = partition(array, low, high);
        if(array.length%2 !=0) {
            if(index==array.length/2) {
                left = array[index];
                right = left;
            }
            else if(index<array.length/2) {
                driver(array, index+1, high);
            }
            else {
                driver(array, low, index);
            }
        }
        else {
            if(index==array.length/2) {
                right = array[index];
                if(left==-1)
                    driver(array, low, index);
            }
            else if(index==array.length/2-1) {
                left = array[index];
                if(right==-1)
                    driver(array, index+1, high);
            }
            else if(index<array.length/2-1) {
                driver(array, index+1, high);
            }
            else {
                driver(array,low,index);
            }
        }
    }

    public double calculateMedian(int[] arr, int low, int high) {
        driver(arr, low, high);
        return (double)(left+right)/2;
    }

    public static void main(String[] args) {
        MedianOfMedianUnsorted obj = new MedianOfMedianUnsorted();
        int[] array = new int[] {1,2,3};
        System.out.println(obj.calculateMedian(array,0,array.length));
    }
}
