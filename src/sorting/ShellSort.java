package sorting;

public class ShellSort {
    public static void main(String... args) {
        int[] array = {7,4,4,4,8,9,1};
        shellSort(array);
    }

    public static void shellSort(int[] array) {
        //let jump be 3 and decrement be 1
        int temp,h=3;
        while(h>0) {
            for (int i = h; i <= array.length - 1; i++) {
                int j = i;
                int val = array[i];
                while (j - h >= 0 && array[j - h] > val) {
                    array[j] = array[j - h];
                    j -= h;
                }
                array[j] = val;
            }
        if(h-2>=1) {
            h -= 3;
        }
        else {
            h--;
            }
        }
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i] + "-->");
        }
    }
}
