package leetcode.sortSearch;

public class SearchMatrixSecond {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix==null)
            return false;
        int checkTillrow, checkTillCol, rowNum = matrix.length, colNum = matrix[0].length;
        checkTillCol = binarySearchRow(matrix, colNum, target);
        checkTillrow = binarySearchCol(matrix, rowNum, target);

        for(int i = 0; i<checkTillrow; i++) {
            if(binarySearch(matrix[i],0,checkTillCol, target))
                    return true;
            }
        return false;
    }

    private int binarySearchRow(int[][] matrix, int colNum, int target) {
        for(int i = 0; i<colNum; i++) {
            if(matrix[0][i]>target)
                return i;
        }
        return colNum;
    }

    private int binarySearchCol(int[][] matrix, int rowNum, int target) {
        for(int i = 0; i<rowNum; i++) {
            if(matrix[i][0]>target)
                return i;
        }
        return rowNum;
    }

    private boolean binarySearch(int[] array, int left, int right, int target) {
        right--;
        int mid;
        while(left<=right){
            mid = left+(right-left)/2;
            if(array[mid]==target) {
                return true;
            }
            else if(array[mid]<target) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return false;
    }

    public boolean searchMatrixEff(int[][] matrix, int target) {
        if(matrix == null || matrix.length==0 || matrix[0].length==0) {
            return false;
        }
        int row = 0,col = matrix[0].length-1;
        while(row<matrix.length && col>=0) {
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col]>target)
                col--;
            else
                row++;
        }
    return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{-5}};
        SearchMatrixSecond obj = new SearchMatrixSecond();
        obj.searchMatrix(matrix,-5);
    }
}
