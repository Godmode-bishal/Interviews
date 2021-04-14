package deutschBank;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        /*String[] inputs = new String[]{"25012","12325","37986","4512","1234","1997"};
        NextPalindrome obj = new NextPalindrome();
        for(String input : inputs) {
            System.out.println(obj.nextPalindrome(input.toCharArray()).toString());
        }*/
        MinDiffInList obj = new MinDiffInList();
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(5);
        input.add(3);
        input.add(19);
        input.add(18);
        input.add(25);
        System.out.println(obj.minDiff(input));
    }
}
