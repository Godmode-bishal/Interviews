package leetcode.math;

public class FactorialTrailingZeroes {
    //https://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
    public int trailingZeroes(int n) {
        int count = 0;
        for(int i = 5; n/i>=1; i *= 5) {
            count += n/i;
        }
        return count;
    }
    public static void main(String[] args) {
        FactorialTrailingZeroes obj = new FactorialTrailingZeroes();
        obj.trailingZeroes(5);
    }
}
