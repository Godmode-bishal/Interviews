package leetcode.math;

import java.util.HashSet;
import java.util.Set;

public class HappyNum {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = SumSquares(n);
        if(sum==1)
            return true;
        while(!set.contains(sum)) {
            set.add(sum);
            sum = SumSquares(sum);
            if(sum==1)
                return true;
        }
        return false;
    }

    private int SumSquares(int n) {
        int digit, sum = 0;
        while(n>0) {
            digit = n%10;
            n /= 10;
            sum += (digit*digit);
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNum obj = new HappyNum();
        obj.isHappy(2);
    }
}
