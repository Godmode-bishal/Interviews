package citrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO Learnings : System.out.println() and Scanner is slow. Use PrintWriter and
 */
public class ParkingLot {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); PrintWriter out = new PrintWriter(System.out);) {
            String first = reader.readLine();
            String[] firstLine = first.split(" ");
            long N = Long.parseLong(firstLine[0]);
            int M = Integer.parseInt(firstLine[1]);
            int K = Integer.parseInt(firstLine[2]);
            Set<Long> A = new HashSet<>();
            for(int i = 0; i< M; i++) {
                A.add(Long.parseLong(reader.readLine()));
            }
            for(int i = 0; i<K; i++) {
                if(A.contains(Long.parseLong(reader.readLine())))
                    out.println(1);
                else
                    out.println(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
