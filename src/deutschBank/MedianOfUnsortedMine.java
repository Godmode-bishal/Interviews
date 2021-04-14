package deutschBank;

public class MedianOfUnsortedMine {
    public double giveMedian(int[] x ) {
        int len = x.length;
        int i, j, first, second, min, tmp;
        boolean hasMinChanged;
        if(len%2 == 0) {
            first = len/2;
            second = first + 1;
            for(j = 0; j < second; j++) {
                min = j;
                hasMinChanged = false;
                for(i = j+1; i < len; i++) {
                    if (x[i] < x[min]) {
                        min = i;
                        hasMinChanged = true;
                    }
                }
                if(hasMinChanged) {
                    tmp = x[min];
                    x[min] = x[j];
                    x[j] = tmp;
                }
            }
            return (x[j-1] + x[j-2])/2;
        }
        else {
            first = len/2 +1 ;
            for(j = 0; j< first; j++) {
                min = j;
                hasMinChanged = false;
                for(i = j+1; i < len; i++) {
                    if(x[i]<x[min]) {
                        min = i;
                        hasMinChanged = true;
                    }
                }
                if(hasMinChanged) {
                    tmp = x[min];
                    x[min] = x[j];
                    x[j] = tmp;
                }
            }
            return x[j-1];
        }
    }

    public static void main(String[] args) {
        int[] x = { 12, 3, 5, 7, 4, 19, 26 };
        MedianOfUnsortedMine obj = new MedianOfUnsortedMine();
        System.out.println(obj.giveMedian(x));
    }
}
