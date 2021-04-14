package prudential;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
class Result {
    static class Rect {
        int x,y;
        int distance;
        public Rect(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static boolean withinBounds(int x, int y, int N) {
        if(x>=1 && x<=N && y>=1 && y<=N) {
            return true;
        }
        return false;
    }

    public static int minMoves(int n, int startRow, int startCol, int endRow, int endCol) {
        // Write your code here
        int[] moveX = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int[] moveY = { -1, -2, -2, -1, 1, 2, 2, 1 };

        Vector<Rect> vector = new Vector<>();
        vector.add(new Rect(startRow, startCol, 0));
        Rect temp;
        int x, y;
        boolean visited[][] = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                visited[i][j] = false;

        visited[startRow][startCol] = true;
        while (!vector.isEmpty()) {
            temp = vector.firstElement();
            vector.remove(0);
            if (temp.x == endRow && temp.y == endCol)
                return temp.distance;

            for (int i = 0; i < 8; i++) {
                x = temp.x + moveX[i];
                y = temp.y + moveY[i];

                if (withinBounds(x, y, n) && !visited[x][y]) {
                    visited[x][y] = true;
                    vector.add(new Rect(x, y, temp.distance+ 1));
                }
            }
        }
        return -1;
    }
}



