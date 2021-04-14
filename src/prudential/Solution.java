package prudential;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int startRow = Integer.parseInt(bufferedReader.readLine().trim());

        int startCol = Integer.parseInt(bufferedReader.readLine().trim());

        int endRow = Integer.parseInt(bufferedReader.readLine().trim());

        int endCol = Integer.parseInt(bufferedReader.readLine().trim());*/

        //int result = Result.minMoves(7, 6, 6, 0, 1);
        List<Integer> arr = new ArrayList<>();
        arr.add(30);
        arr.add(40);
        arr.add(2);
        arr.add(5);
        arr.add(1);
        arr.add(7);
        arr.add(45);
        arr.add(50);
        arr.add(8);
        Result3.minDeletions(arr);
        //Result2.
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}