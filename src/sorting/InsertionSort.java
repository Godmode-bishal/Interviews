package sorting;

public class InsertionSort {
    public static void main(String... args) {
        int[] array = {5,4,3,2,1};
        insertionSort(array);
    }

    public static void insertionSort(int[] array) {
        int j, val;
        for(int i = 1; i<array.length; i++) {
            j = i;
            val = array[i];
            while(j>=1 && array[j-1] > val ) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = val;
        }
        for(int value:array) {
            System.out.print(value + "->");
        }
    }

}
