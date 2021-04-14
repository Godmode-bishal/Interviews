package deutschBank;

import sun.nio.cs.ext.IBM037;

public class MedianSortedDiffSize {
    public double median(int[] x, int[] y) {
        if(x.length>y.length)
            median(y,x);
        int start, end, partitionX, partitionY, maxLeftX, maxLeftY, minRightX, minRightY;
        start = 0;
        end = x.length;
        while(start<end) {
            partitionX = (start + end) / 2;
            partitionY = (x.length + y.length + 1) / 2 - partitionX;
            maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : x[partitionX - 1];
            maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : y[partitionY - 1];
            minRightX = partitionX == x.length? Integer.MAX_VALUE : x[partitionX];
            minRightY = partitionY == y.length? Integer.MAX_VALUE : y[partitionY];
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x.length + y.length) % 2 == 0) {
                    return ((double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))) / 2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                end = partitionX-1;
            } else {
                start = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    public double medianPac(int[] input1, int[] input2) {
        if(input1.length>input2.length)
            medianPac(input2, input1);
        int x = input1.length;
        int y = input2.length;
        int low = 0;
        int high = x;
        int maxLeftX, maxLeftY, minRightX,minRightY, partitionX, partitionY;
        while(low<high) {
            partitionX = (low+high)/2;
            partitionY = (x+y)/2 - partitionX;
            maxLeftX = partitionX==0?Integer.MIN_VALUE:input1[partitionX-1];
            maxLeftY = partitionY==0?Integer.MIN_VALUE:input2[partitionX-1];
            minRightX = partitionX==x?Integer.MAX_VALUE:input1[partitionX];
            minRightY = partitionY==y?Integer.MAX_VALUE:input2[partitionY];
            if(maxLeftX<=minRightY && maxLeftY<=minRightX) {
                if((x+y)%2==0)
                    return (Integer.max(maxLeftX,maxLeftY)+Integer.min(minRightX,minRightY))/2;
                else
                    return (double)Integer.max(maxLeftX,maxLeftY);
            }
            else if(maxLeftX>minRightX)
                high = partitionX-1;
            else
                low = partitionX+1;

        }
throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] X = {1,3,8,9,15};
        int[] y = {7,11,18, 19,21,25};
        MedianSortedDiffSize obj = new MedianSortedDiffSize();
        System.out.println(obj.median(X,y));
    }
}
