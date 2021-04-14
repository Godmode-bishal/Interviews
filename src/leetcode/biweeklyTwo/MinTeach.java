package leetcode.biweeklyTwo;

public class MinTeach {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        boolean isCommon = false;
        int minCount = 0,first,second;
        for(int i =0; i<friendships.length; i++) {
            first = friendships[i][0];
            second = friendships[i][1];
            for(int k = 0; k<languages[first-1].length; k++) {
                for(int l = 0; l<languages[second-1].length; l++) {
                    if(languages[first-1][k]==languages[second-1][l]) {
                        isCommon = true;
                    }
                }
            }
            if(!isCommon) {
                minCount++;
                int[] toAdd = new int[languages[first-1].length+1];
                int j;
                for(j = 0; j<languages[first-1].length; j++) {
                    toAdd[j] = languages[first-1][j];
                }
                toAdd[j] = languages[second-1][0];
                languages[first-1] = toAdd;
            }
            isCommon = false;
        }
        return minCount;
    }
}
