package leetcode.sortSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1)
            return intervals;
        Arrays.sort(intervals, (array1, array2)->Integer.compare(array1[0],array2[0]));
        List<int[]> output = new ArrayList<>();
        int[] current_interval = intervals[0];
        output.add(current_interval);
        for(int[] interval:intervals) {
            int curr_start = current_interval[0];
            int curr_end = current_interval[1];
            int next_start = interval[0];
            int next_end = interval[1];
            if(curr_end>=next_start) {
                current_interval[1] = Math.max(curr_end,next_end);
            }
            else {
                current_interval = interval;
                output.add(current_interval);
            }
        }
        return output.toArray(new int[output.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals obj = new MergeIntervals();
        obj.merge(intervals);
    }
}
