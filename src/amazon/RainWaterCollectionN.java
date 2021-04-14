package amazon;

public class RainWaterCollectionN {
    public static int maxRain(int[] heights) {
        int result = -1;
        int len = heights.length;
        for(int i= 0; i<len; i++) {
            for(int j = i+2; j<len; j++) {
                result = Math.max(result, Math.min(heights[i], heights[j])*(j-i-1));
            }
        }
        return result;
    }
}
