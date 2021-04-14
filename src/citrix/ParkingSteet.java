package citrix;

import java.util.Scanner;

public class ParkingSteet {
    public static void main(String args[] ) throws Exception {
        String name;
        int len, result;
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        boolean flag = true;
        while(N>0) {
            result = 0;
            flag = true;
            name = s.next();
            len = name.length();
            for (int i = 0; i < len; i++) {
                if (name.charAt(i) == '-') {
                    if((i-1>-1 && name.charAt(i - 1) == 'S') || (i+1<len && (name.charAt(i + 1) == 'B' || name.charAt(i + 1) == 'S')) || (i+2<len && name.charAt(i + 2) == 'B')){
                        flag = false;
                    }
                    if(flag)
                        result++;
                }
                flag = true;
            }
                System.out.println(result);
                N--;
        }
    }
}
