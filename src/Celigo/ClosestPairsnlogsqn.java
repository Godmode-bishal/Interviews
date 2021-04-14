package Celigo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestPairsnlogsqn {
    private static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int compareX(Point p1, Point p2) {
        return p1.x-p2.x;
    }

    public int compareY(Point p1, Point p2) {
        return p1.y-p2.y;
    }

    double dist(Point p1, Point p2) {
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
    }

    double bruteForce(Point[] P, int n, int offset) {
        double min = Double.MAX_VALUE;
        for(int i =0+offset; i<n+offset; i++) {
            for(int j = i+1; j<n+offset; j++) {
                if(dist(P[i],P[j])<min)
                    min = dist(P[i],P[j]);
            }
        }
        return min;
    }

    double stripClosest(List<Point> strip, int size, double d) {
        double min = d;
        Collections.sort(strip,this::compareY);
        for(int i = 0; i<size; ++i)
            for(int j = i+1; j<size && (strip.get(j).y-strip.get(i).y)<min; ++j)
                if(dist(strip.get(i),strip.get(j))<min)
                    min = dist(strip.get(i),strip.get(j));
        return min;
    }

    public double closestUtil(Point[] P, int n, int offset) {
        if(n<=3)
            return bruteForce(P,n, offset);
        int mid = n/2;
        Point midPoint = P[mid+offset];
        double dl = closestUtil(P, mid,0);
        double dr = closestUtil(P,n-mid,mid);
        double d = Double.min(dl,dr);
        List<Point> strip = new ArrayList<>();
        int j = 0;
        for(int i = 0;i<n; i++)
            if(Math.abs(P[i].x - midPoint.x)<d) {
                strip.add(P[i]);
                j++;
            }
        return Double.min(d,stripClosest(strip,j,d));
    }

    public double closest(Point[] P, int n) {
        Arrays.sort(P,this::compareX);
        return closestUtil(P,n,0);
    }

    public static void main(String[] args) {
        Point point1 = new Point(2,3);
        Point point2 = new Point(12,30);
        Point point3 = new Point(40,50);
        Point point4 = new Point(5,1);
        Point point5 = new Point(12,10);
        Point point6 = new Point(3,4);
        Point[] P = {point1,point2, point3, point4, point5, point6};
        ClosestPairsnlogsqn obj = new ClosestPairsnlogsqn();
        System.out.println("The smallest distance = " + obj.closest(P,P.length));
    }
}
