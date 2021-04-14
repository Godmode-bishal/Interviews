package leetcode.biweekly;

public class MaxBinaryString {
    public String maximumBinaryString(String binary) {
        int len = binary.length();
        char[] backedArray = new char[len];
        binary.getChars(0, len, backedArray, 0);
        int pos = -1;
        if(backedArray[0]=='0') {
            pos = 0;
        }
        for(int i = 1; i < len; i++) {
            if(backedArray[i]=='0' && backedArray[i-1]=='0') {
                backedArray[i-1]='1';
                pos = i;
            }
            else if(backedArray[i]=='0' && pos!=-1) {
                backedArray[pos]='1';
                backedArray[pos+1]='0';
                backedArray[i]='1';
                pos++;
            }
            else if(backedArray[i]=='0') {
                pos = i;
            }
        }
        String result = new String(backedArray);
        return result;
    }
}
