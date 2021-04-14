import java.util.Scanner;

/**
 * Created by HP on 23-06-2018.
 */
public class TotalStrings {
    static int counter =0;
    static void produce(int[] array, int k, int n) {
        if(n < 1) {
            for(int i=0;i< array.length; i++) {
                //System.out.print(array[i]);
            }
            counter++;
        }
        else {
            for(int j = 0; j < k; j++) {
                array[n-1] = j;
                produce(array, k, n-1);
            }
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int array[] = new int[n];
        produce(array, k, n);
        System.out.println("Counter = "+counter);

    }
}
