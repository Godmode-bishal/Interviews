package deutschBank;

public class NextPalindrome {
    //http://www.ardendertat.com/2011/12/01/programming-interview-questions-19-find-next-palindrome-number/
    public boolean compareArrays(int[] res, char[] input){
        int i = res.length;
        for(int j = 0; j<i; j++) {
            if(res[j]<input[j]-'0')
                return true;
        }
        return false;
    }

    public int[] nextPalindrome(char[] input) {
        int len = input.length;
        int[] result=new int[len];
        int carry = 0, num;
        if(len%2!=0) {
            for(int i = 0; i<=len/2; i++) {
                result[i] = input[i]-'0';
            }
            for(int i = 1; i<=len/2; i++) {
                result[len/2 + i] = input[len/2 - i]-'0';
            }
            if(compareArrays(result,input)) {
                if(result[len/2]!=9) {
                    result[len / 2]++;
                }
                else {
                    carry = 1;
                    for(int i = len/2; i>-1 && carry != 0; i--) {
                        result[i]++;
                        if(result[i]==10) {
                            result[i] = 0;
                            carry = 1;
                        }
                        else
                            carry = 0;
                    }
                    for(int i = 1; i<=len/2; i++) {
                        result[len/2 + i] = result[len/2 - i];
                    }
                }
            }
        }
        else {
            for(int i = 0; i<len/2; i++) {
                result[i] = input[i]-'0';
            }
            for(int i = 0; i<len/2; i++) {
                result[len/2 + i] = input[len/2 - (i+1)]-'0';
            }
            if(compareArrays(result,input)) {
                if(result[len/2 - 1]!=9) {
                    result[len / 2 - 1]++;
                    result[len/2]++;
                }
                else {
                    carry = 1;
                    for(int i = len/2 - 1; i>-1 && carry != 0; i--) {
                        result[i]++;
                        if(result[i]==10) {
                            result[i] = 0;
                            carry = 1;
                        }
                        else
                            carry = 0;
                    }
                    for(int i = 0; i<len/2; i++) {
                        result[len/2 + i] = result[len/2 - (i+1)];
                    }
                }
            }
        }
        return result;
    }
}
