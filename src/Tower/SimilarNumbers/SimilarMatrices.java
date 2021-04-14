package Tower.SimilarNumbers;

import java.util.*;

public class SimilarMatrices {
    int[][] visited;
    List<List<String>> regions1 = new ArrayList<>();
    List<List<String>> regions2 = new ArrayList<>();

    public int compareRegions(List<List<String>> regions1, List<List<String>> regions2) {
        int count = 0;
        for(List<String> _region1:regions1) {
            for(List<String> _region2:regions2) {
                if (_region2.containsAll(_region1) && _region1.containsAll(_region2))
                    count++;
            }
        }
        return count;
    }

    public void DFS(int i, int j, List<String> list, String[] grid, int size) {
        String newCell = ""+ i +"," + j;
        list.add(newCell);
        if( i>=0 && i<size && j-1>=0 && j-1<size  && visited[i][j-1]!=1 && grid[i].charAt(j-1)=='1' ) {
            visited[i][j-1] = 1;
            DFS(i, j - 1, list, grid, size);
        }
        if(i>=0 && i<size && j+1>=0 && j+1<size && visited[i][j+1]!=1 && grid[i].charAt(j+1)=='1') {
            visited[i][j+1]=1;
            DFS(i, j + 1, list, grid, size);
        }
        if(i-1>=0 && i-1<size && j>=0 && j<size && visited[i-1][j]!=1 && grid[i-1].charAt(j)=='1') {
            visited[i-1][j]=1;
            DFS(i - 1, j, list, grid, size);
        }
        if(i+1>=0 && i+1<size && j>=0 && j<size && visited[i+1][j]!=1 && grid[i+1].charAt(j)=='1') {
            visited[i+1][j]=1;
            DFS(i + 1, j, list, grid, size);
        }
    }

    public void populateRegions(int size, String[] grid1, String[] grid2) {
        visited = new int[size][size];
        for(int i =0; i<size; i++) {
            for(int j =0; j<size; j++) {
                char ch = grid1[i].charAt(j);
                if(ch=='1' && visited[i][j]!=1) {
                    visited[i][j] = 1;
                    List<String> list = new ArrayList<>();
                    DFS(i,j,list, grid1, size);
                    regions1.add(list);
                }
                else {
                    visited[i][j] = 1;
                }
            }
        }
        for(int[] row:visited)
            Arrays.fill(row,0);
        for(int i =0; i<size; i++) {
            for(int j =0; j<size; j++) {
                char ch = grid2[i].charAt(j);
                if(ch=='1' && visited[i][j]!=1) {
                    visited[i][j] = 1;
                    List<String> list = new ArrayList<>();
                    DFS(i,j,list, grid2, size);
                    regions2.add(list);
                }
                else {
                    visited[i][j] = 1;
                }
            }
        }
        System.out.println(compareRegions(regions1, regions2));
    }
}
