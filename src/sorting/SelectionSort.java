package sorting;

public class SelectionSort {
    public static void main(String... args) {
        int[] array = {1,2,3,4,5};
        selectionSort(array);
    }

    static void selectionSort(int[] array) {
        int min=0,temp;
        for(int i=0;i<array.length-1;i++) {
            min = i;
            for(int j=i+1;j<array.length;j++) {
                if(array[min] > array[j]) {
                    temp = array[min];
                    array[min] = array[j];
                    array[j] = temp;
                }
            }
        }
        for(int i=0;i<array.length;i++) {
            System.out.print("-->" + array[i]);
        }
    }
}
