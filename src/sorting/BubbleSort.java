package sorting;

public class BubbleSort {
    static int swapcount =0;
    public static void main(String... args) {
        int[] array = {8,22,7,9,31,5,13};
        bubbleSort(array);
    }
    static void bubbleSort(int[] array) {
        int n = array.length;
        int swapped;
        int temp;
        for(int i=n-1;i>0;i--){
            swapped = 0;
            for(int j=0;j<=i-1;j++) {
                if(array[j]>array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = 1;
                    swapcount++;
                }
            }
            if(swapped==0) {
                System.out.println("Already sorted. Exiting!!");
                break;
            }
        }
        for(int i=0;i<array.length;i++) {
            //System.out.print("-->" + array[i] );
            System.out.println(swapcount);
        }
    }
}
