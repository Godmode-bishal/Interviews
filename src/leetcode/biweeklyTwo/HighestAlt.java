package leetcode.biweeklyTwo;

public class HighestAlt {
    public int largestAltitude(int[] gain) {
        int[] altitudes = new int[gain.length+1];
        altitudes[0] = 0;
        int maxAlt = 0;
        for(int i = 0; i<gain.length; i++) {
            altitudes[i+1] = altitudes[i]+gain[i];
            if(altitudes[i+1]>maxAlt) {
                maxAlt = altitudes[i+1];
            }
        }
        return maxAlt;
    }
}
