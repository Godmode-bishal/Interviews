package leetcode.stringreversal;

public class Driver {
    public static void main(String[] args) {
        char[] source = new char[]{'h', 'e', 'l', 'l', 'o'};
        StringReverse obj = new StringReverse();
        obj.reverseString(source);
        System.out.println(source);
    }
}
