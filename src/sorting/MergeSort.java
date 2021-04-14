package sorting;

public class MergeSort {
    static int[] temp = new int[10];
    public static void main(String... args) {
        int[] array = {7,7,5,14,3,20,1};
        mergeSort(array, 0 , array.length-1);
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i] + "->");
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        int mid = (left+right)/2;
        if(left<right) {
            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            merge(array, left, mid, right);
        }

        /*for(int i=0;i<array.length;i++) {
            array[i]=temp[i];
            System.out.print(array[i]);

        }*/
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int pos = left;
        int pos_left = left;
        int pos_mid = mid;
        while ((left <= pos_mid)&&(mid + 1<= right)) {
            if (array[left] < array[mid + 1]) {
                temp[pos] = array[left];
                left++;
                pos++;
            }
            else{
                temp[pos] = array[mid + 1];
                mid++;
                pos++;
            }
        }

        while(left <= pos_mid) {
            temp[pos] = array[left];
            left++;
            pos++;
        }

        while(mid+1 <= right) {
            temp[pos] = array[mid+1];
            pos++;
            mid++;
        }

        for(int i=pos_left;i<=right; i++) {
            array[i] = temp[i];
        }
    }
}
