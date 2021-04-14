package leetcode.arraysString;

public class LongestPalindromeSub {
    public String longestPalindrome(String s) {
        int max  = 0, j ;
        if(s.length()==1)
            return s;
        String out = s.substring(0,1);
        for(int i = s.length(); i>1; i--) {
            j = 0;
            while(j+i<=s.length()) {
                if(isPalindrome(s.substring(j,j+i))) {
                    return s.substring(j,j+i);
                }
                j++;
            }
        }
        return out;
    }

    public String longestPalindromeEfficient(String s){
        if(s==null || s.length()<1)return "";
        int start = 0, end = 0, len1, len2, len;
        for(int i = 0; i<s.length(); i++) {
            len1 = expandFromMid(s,i,i);
            len2 = expandFromMid(s,i,i+1);
            len = Math.max(len1,len2);
            if(len>end-start) {
                start = i-(len-1)/2;
                end = i+(len)/2;
            }
        }
        return s.substring(start,end+1);
    }

    public int expandFromMid(String s, int left, int right) {
        if(s==null || left>right)return 0;
        while(left>-1 && right<s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1;
    }

    private boolean isPalindrome(String substring) {
        int i = 0, j = substring.length() - 1;
        while (i < j) {
            if (substring.charAt(i) != substring.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        LongestPalindromeSub obj = new LongestPalindromeSub();
        System.out.println(obj.longestPalindromeEfficient("babad"));
    }
}
