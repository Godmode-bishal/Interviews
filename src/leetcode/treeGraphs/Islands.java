package leetcode.treeGraphs;

import java.util.Vector;

public class Islands {
    private class Cell {
        int x;
        int y;
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static boolean withinBounds(int i, int j, int rows, int cols) {
        if(i>=0 && i<rows && j>=0 && j<cols)
            return true;
        return false;
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        int[] moveX = {0,0,-1,1};
        int[] moveY = {-1,1,0,0};
        int rows = grid.length;
        int cols = grid[0].length;
        int cellX, cellY;
        Cell extractedCell;
        boolean[][] visited  = new boolean[rows][cols];
        Vector<Cell> vector = new Vector<>();
        for(int i = 0; i<rows; i++) {
            for(int j = 0; j<cols; j++) {
                if(!visited[i][j] && grid[i][j]=='1') {
                    vector.add(new Cell(i,j));
                    count++;
                    while (!vector.isEmpty()) {
                        extractedCell = vector.firstElement();
                        vector.remove(0);
                        cellX = extractedCell.x;
                        cellY = extractedCell.y;
                        for (int k = 0; k < 4; k++) {
                            if (withinBounds(cellX + moveX[k], cellY + moveY[k], rows, cols) && !visited[cellX + moveX[k]][cellY + moveY[k]] && grid[cellX + moveX[k]][cellY + moveY[k]]=='1') {
                                visited[cellX + moveX[k]][cellY + moveY[k]] = true;
                                vector.add(new Cell(cellX + moveX[k], cellY + moveY[k]));
                            }
                        }
                        visited[cellX][cellY] = true;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Islands obj = new Islands();
        System.out.println(obj.numIslands(grid));
    }
}
