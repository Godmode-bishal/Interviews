package leetcode.dp;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] scores = new int[m][n];
        scores[0][0] = 1;
        for(int i = 0; i<m; i++) {
            for(int j = 0;j<n; j++) {
                if(i==0 && j==0) {
                    continue;
                }
                scores[i][j] = withinBounds(i-1,j,scores) + withinBounds(i,j-1,scores);
            }
        }
        return scores[m-1][n-1];
    }

    public int withinBounds(int i, int j, int[][] scores) {
        if(i>-1 && i<scores.length && j>-1 && j<scores[0].length) {
            return scores[i][j];
        }
        return 0;
    }
    public static void main(String[] args) {
        UniquePaths obj = new UniquePaths();
        obj.uniquePaths(3,7);
    }
}
