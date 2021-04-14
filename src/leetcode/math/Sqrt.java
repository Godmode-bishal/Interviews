package leetcode.math;

public class Sqrt {
    public int mySqrt(int x) {
        if(x==0)
            return 0;
       return binarySearch(x, 1, x);
    }

    public int mySqrtEff(int x) {
        long left = 1;
        long right = x / 2;

        while (left <= right){
            long mid = left + (right - left) / 2;
            long prod = mid * mid ;
            if (prod == x) return (int)mid;
            else if(prod < x) left = mid + 1;
            else right = mid - 1;
        }
        if (left * left == x) return (int)left;
        return (int)right;
    }

    public int binarySearch(int target, int left, int right) {
        if(left>right)
            return right;
        int mid = left +(right-left)/2;
        mid =  mid<0?-mid:mid;
        int res, prev;
        try {
            res = Math.multiplyExact(mid, mid);
            prev = (mid-1)*(mid-1);
            if(res > target && prev<target) {
                return mid-1;
            }
            else if(res==target) {
                return mid;
            }
            else if(res < target) {
                left = mid+1;
                return binarySearch(target, left, right);
            }
            else {
                right = mid-1;
                return binarySearch(target, left, right);
            }
        }
        catch(ArithmeticException e) {
            right = mid-1;
            return binarySearch(target, left, right);
        }
    }
    public static void main(String[] args) {
        Sqrt obj = new Sqrt();
        obj.mySqrt(2147483647);
    }
}
