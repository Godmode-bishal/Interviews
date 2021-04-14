package deutschBank;

import java.util.Collections;
import java.util.List;

public class MinDiffInList {
    public int minDiff(List<Integer> input) {
        Collections.sort(input);
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i<input.size()-1; i++) {
            if(input.get(i+1)-input.get(i)<diff) {
                diff = input.get(i+1)-input.get(i);
            }
        }
        return diff;
    }
}
