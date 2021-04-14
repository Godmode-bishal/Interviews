package leetcode.arraysString;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean[] colZeroIndicator = new boolean[numCols];
        for(int i = 0; i<numRows; i++) {
            for(int j = 0; j<numCols; j++) {
                if(matrix[i][j]==0)
                    colZeroIndicator[j]=true;
            }
        }
        boolean rowHasZero ;
        for(int i = 0; i<numRows; i++) {
            rowHasZero = false;
            for(int j = 0; j<numCols; j++) {
                if(matrix[i][j]==0) {
                    rowHasZero = true;
                    break;
                }
            }
            for(int j = 0; j<numCols; j++) {
                if(colZeroIndicator[j] || rowHasZero)
                    matrix[i][j]=0;
            }
        }
    }
}
