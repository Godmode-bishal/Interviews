package Celigo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestPairsnlogn {
    private static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int compareX(ClosestPairsnlogn.Point p1, ClosestPairsnlogn.Point p2) {
        return p1.x-p2.x;
    }

    public int compareY(ClosestPairsnlogn.Point p1, ClosestPairsnlogn.Point p2) {
        return p1.y-p2.y;
    }

    double dist(ClosestPairsnlogn.Point p1, ClosestPairsnlogn.Point p2) {
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
    }

    double bruteForce(ClosestPairsnlogn.Point[] P, int n, int offset) {
        double min = Double.MAX_VALUE;
        for(int i =0+offset; i<n+offset; i++) {
            for(int j = i+1; j<n+offset; j++) {
                if(dist(P[i],P[j])<min)
                    min = dist(P[i],P[j]);
            }
        }
        return min;
    }

    double stripClosest(List<ClosestPairsnlogn.Point> strip, int size, double d) {
        double min = d;
        int count = 0;
        for(int i = 0; i<size; ++i)
            for(int j = i+1; j<size && (strip.get(j).y-strip.get(i).y)<min; ++j)
                if(dist(strip.get(i),strip.get(j))<min) {
                    min = dist(strip.get(i), strip.get(j));
                    count++;
                }
        System.out.println(count);
        return min;
    }

    public double closestUtil(ClosestPairsnlogn.Point[] Px, ClosestPairsnlogn.Point[] Py, int n, int offset) {
        if(n<=3)
            return bruteForce(Px,n, offset);
        int mid = n/2;
        ClosestPairsnlogn.Point midPoint = Px[mid+offset];
        Point[] Pyl = new Point[mid];
        Point[] Pyr = new Point[n-mid];
        int li = 0, ri = 0;
        for(int i = 0; i<n; i++) {
            if(Py[i].x<=midPoint.x && li<mid)
                Pyl[li++] = Py[i];
            else
                Pyr[ri++] = Py[i];
        }
        double dl = closestUtil(Px,Py, mid,0);
        double dr = closestUtil(Px, Py,n-mid,mid);
        double d = Double.min(dl,dr);
        List<ClosestPairsnlogn.Point> strip = new ArrayList<>();
        int j = 0;
        for(int i = 0;i<n; i++)
            if(Math.abs(Py[i].x - midPoint.x)<d) {
                strip.add(Py[i]);
                j++;
            }
        return Double.min(d,stripClosest(strip,j,d));
    }

    public double closest(ClosestPairsnlogn.Point[] P, int n) {
        Point[] Px = new Point[n];
        Point[] Py = new Point[n];
        for(int i = 0; i<n; i++) {
            Px[i] = P[i];
            Py[i] = P[i];
        }
        Arrays.sort(Px,this::compareX);
        Arrays.sort(Py,this::compareY);
        return closestUtil(Px,Py,n,0);
    }

    public static void main(String[] args) {
        ClosestPairsnlogn.Point point1 = new ClosestPairsnlogn.Point(2,3);
        ClosestPairsnlogn.Point point2 = new ClosestPairsnlogn.Point(12,30);
        ClosestPairsnlogn.Point point3 = new ClosestPairsnlogn.Point(40,50);
        ClosestPairsnlogn.Point point4 = new ClosestPairsnlogn.Point(5,1);
        ClosestPairsnlogn.Point point5 = new ClosestPairsnlogn.Point(12,10);
        ClosestPairsnlogn.Point point6 = new ClosestPairsnlogn.Point(3,4);
        ClosestPairsnlogn.Point[] P = {point1,point2, point3, point4, point5, point6};
        ClosestPairsnlogn obj = new ClosestPairsnlogn();
        System.out.println("The smallest distance = " + obj.closest(P,P.length));
    }
}
