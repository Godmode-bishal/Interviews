package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    static List<String> output = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        String initialString = "(";
        recurse(initialString,1,n);
        return output;
    }
    public void recurse(String strTillNow, int len, int n) {
        if(len==n*2) {
            if(check(strTillNow)) {
                output.add(strTillNow);
            }
            return;
        }
        List<String> toTraverse = new ArrayList<String>(){{add("(");add(")");}};
        for(String string:toTraverse) {
                strTillNow += string;
                recurse(strTillNow, len+1, n);
                strTillNow = strTillNow.substring(0, len);
            }
    }

    private boolean check(String strTillNow) {
        if(strTillNow.startsWith(")") || strTillNow.endsWith("("))
            return false;
        int count = 0;
        for(int i = strTillNow.length()-1; i>-1; i--) {
            if(count==0 && strTillNow.charAt(i)=='(' )
                return false;
            if(strTillNow.charAt(i)=='(')
                count--;
            else
                count++;
        }
        if(count==0) {
            return true;
        }
        return false;
    }

    public List<String> generateParenthesisEfficient(int n) {
        List<String> output_arr = new ArrayList<>();
        backTrack(output_arr,"",0,0,n);
        return output_arr;
    }

    private void backTrack(List<String> output_arr, String current_str, int open, int close, int n) {
        if(current_str.length()==n*2) {
            output_arr.add(current_str);
            return;
        }
        if(open<n)
            backTrack(output_arr,current_str+"(",open+1,close,n);
        if(close<open)
            backTrack(output_arr,current_str+")",open, close+1,n);
    }

    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        obj.generateParenthesis(1);
    }
}
