package goldman;

public class Alpha {
    public static long result = 0;
    public static void cal(String in, int len) {
        if(len==in.length()) {
            result++;
        }
        int agg = 0;
        for(int i = len;i<Integer.min(len+1,in.length()-1); i++) {
            agg= (agg*10)+(in.charAt(i)-'0');
            if(agg>0 && agg<=26)
                cal(in,i+1);
        }
    }
    public static long cal(String in) {
        result = 0;
        cal(in,0);
        return result;
    }

    public static long countDP(String in, int n) {
        int prev=1,secPrev=1;
        int result = 0;
        if(in.charAt(0)=='0')
            return 0;
        for(int i = 2; i<=n; i++) {
            result = 0;
            if(in.charAt(i-1)>'0')
                result = prev;
            if(in.charAt(i-2)=='1' || in.charAt(i-2)=='2' && in.charAt(i-1)<'7')
                result += secPrev;
            secPrev = prev;
            prev = result;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(cal("2112"));
    }
}
