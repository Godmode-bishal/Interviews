package prudential;

import java.util.ArrayList;
import java.util.List;

public class Result2 {
    public static int minimum(List<Integer> input) {
        int min = input.get(0);
        for(int i =1; i<input.size(); i++) {
            if(input.get(i)<min) {
                min = input.get(i);
            }
        }
        return min;
    }

    public static int maximum(List<Integer> input) {
        int max = input.get(0);
        for(int i =1; i<input.size(); i++) {
            if(input.get(i)>max) {
                max = input.get(i);
            }
        }
        return max;
    }
    public static int segment(int x, List<Integer> space) {
        // Write your code here
        if(x>space.size()) {
            return maximum(space);
        }
        List<Integer> mins = new ArrayList<>();
        for(int i =0; i<=space.size()-x; i++) {
            List<Integer> input = space.subList(i, i+x);
            mins.add(minimum(input));
        }
        return maximum(mins);
    }

}
