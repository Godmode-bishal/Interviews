package leetcode.backtrack;

import java.util.Arrays;

public class WordSearch {
    public boolean withinBounds(int i, int j, int rows, int cols) {
        if(i>-1 && i<rows && j>-1 && j<cols )
            return true;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if(board.length==0 || word==null || word.length()==0)
            return false;
        int maxRows = board.length;
        int maxCols = board[0].length;
        boolean[][] visited = new boolean[maxRows][maxCols];
        boolean result = false;
        for(int i = 0; i<maxRows; i++) {
            for(int j = 0; j<maxCols; j++) {
                if(board[i][j]==word.charAt(0)) {
                    visited[i][j] = true;
                    result = search(board, word.substring(1,word.length()), i, j, visited);
                    visited[i][j] = false;
                }
                if(result)
                    return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, boolean[][] visited) {
        if(word.length()==0)
            return true;
        int[] X = {0,0,-1,1};
        int[] Y = {-1,1, 0,0};
        int x,y;
        for(int k = 0; k<X.length; k++) {
            x = i + X[k];
            y = j + Y[k];
            if(withinBounds(x,y,board.length, board[0].length) && !visited[x][y] && board[x][y]==word.charAt(0)) {
                visited[x][y] = true;
                if(search(board, word.substring(1,word.length()),x,y, visited)) {
                    return true;
                }
                visited[x][y] = false;
            }
        }
        return false;
    }

    public boolean existEfficient(char[][] board, String word) {
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[i].length; j++) {
                if(board[i][j] == word.charAt(0) && dfs(board, i,j,0,word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int count, String word) {
        if(count==word.length()) {
            return true;
        }
        if(i<0 || i>= board.length || j<0 || j>= board[i].length || board[i][j]!=word.charAt(count)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, i+1, j, count+1, word) || dfs(board, i-1, j, count+1, word) || dfs(board, i, j-1, count+1, word) || dfs(board, i, j+1, count+1, word);
        board[i][j] = temp;
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABAB";
        WordSearch obj = new WordSearch();
        obj.exist(board,word);
    }
}
