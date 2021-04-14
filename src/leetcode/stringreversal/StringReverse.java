package leetcode.stringreversal;

public class StringReverse {
    public void reverseString(char[] s) {
        int i = 0,j = s.length-1;
        char temp;
        //xor seems faster than using temp variable
        while(i<j) {
            s[i] = (char)(s[i]^s[j]);
            s[j] = (char)(s[i]^s[j]);
            s[i] = (char)(s[i]^s[j]);
            i++;j--;
        }
    }
}
