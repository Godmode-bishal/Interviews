package leetcode.math;

public class DivieInts {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        int a = dividend<0?-dividend:dividend;
        int b = divisor<0?-divisor:divisor;
        int res = 0,x;
        while(a-b>=0) {
            x = 0;
            while((a-(b<<1<<x))>=0) {
                x++;
            }
            res += 1<<x;
             a -= b<<x;
        }
        res = (dividend<0)==(divisor<0)? res:-res;
        return res;
    }
    public static void main(String[] args) {
        DivieInts obj = new DivieInts();
        System.out.println(obj.divide(-2147483647,-1));
    }
}
