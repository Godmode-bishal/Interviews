package leetcode.math;

public class ExcelSheetColNum {
    public int titleToNumber(String columnTitle) {
        /*int a = columnTitle.charAt(0)-'A'+1;
        System.out.println(a);
        */
        int len = columnTitle.length();
        int result =0;
        for(int i = 0; i<len; i++) {
            result += Math.pow(26,len-i-1)*(columnTitle.charAt(i)-'A'+1);
        }
        return result;
    }
    public static void main(String[] args) {
        ExcelSheetColNum obj = new ExcelSheetColNum();
        obj.titleToNumber("FXSHRXW");
    }
}
