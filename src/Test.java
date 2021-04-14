import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Test {



    // Complete the getMinimumSeconds function below.
    static int getMinimumSeconds(List<Integer> height, int h, int u, int v) {

        height.sort((o1, o2) -> o2.compareTo(o1));

        int time=0;
        int numberOfCats = 0;
        int totalHeight=0;
        int i=1;
        while(height.get(i-1)>h) {
            i++;
        }
        while(i<=height.size()) {
                totalHeight += height.get(i-1);
                if(totalHeight < h ) {
                    numberOfCats++;
                    i++;
                }
                else {
                    if(numberOfCats<2) {
                        time+=u;
                    }
                    else {
                        time+=v;
                    }
                    totalHeight=0;
                    numberOfCats=0;
                }
        }
        if(numberOfCats<2) {
            time+=u;
        }
        else {
            time+=v;
        }
        return time;
    }

    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int heightCount = Integer.parseInt(bufferedReader.readLine().trim());*/

        List<Integer> height = new ArrayList<Integer>();
        height.add(5);
        height.add(2);
        height.add(3);
        height.add(4);


        /*for (int i = 0; i < 4; i++) {
            int heightItem = Integer.parseInt(bufferedReader.readLine().trim());
            height.add(heightItem);
        }
*/
        int h = 5;

        int u = 2;

        int v = 3;

        int res = getMinimumSeconds(height, h, u, v);
        System.out.println(res);

}
}
