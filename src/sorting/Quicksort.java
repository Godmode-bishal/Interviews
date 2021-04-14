package sorting;

public class Quicksort {
    static int[] temp = new int[10];
    static int count =0;
    public static void main(String... args) {
        int[] array = {4,1,5,3,2};
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            //System.out.print(array[i] + "->");
            System.out.println(count);
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        int pivot;
        if (low < high) {
            count++;
            pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int left = low;
        int right = high;
        int pivot_element = array[low];
        int temp;
        while(left < right) {
            count++;
            while(array[left] <= pivot_element && left < array.length-1) {
                count++;
                left++;
            }
            while(array[right] > pivot_element && right > 0) {
                count++;
                right--;
            }
            if(right > left) {
                count++;
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        array[low] = array[right];
        array[right] = pivot_element;
        return right;
    }
}

