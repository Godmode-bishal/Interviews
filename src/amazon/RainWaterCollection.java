package amazon;

import java.util.HashMap;
import java.util.Map;

public class RainWaterCollection {
    public static int maxRain(int[] heights) {
        int len = heights.length;
        int left = 0;
        int right = len-1;
        int result = -1;
        while(left<right) {
            result = Math.max(result, Math.min(heights[left],heights[right])*(right-left-1));
            //the already lower height may get to a higher height moving forward or backward
            if(heights[left]< heights[right])
                left++;
            else
                right--;
        }
        return result;
    }
}
