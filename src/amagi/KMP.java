package amagi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KMP_String_Matching {
    void KMPSearch(String pat, String txt)
    {
        int patternLength = pat.length();
        int textLength = txt.length();
        int[] lps = new int[patternLength];
        int j = 0; //index of pat
        computeLPSArray(pat, patternLength, lps);
        int i = 0;
        while(i<textLength) {
            if(pat.charAt(j)==txt.charAt(i)) {
                j++;
                i++;
            }
            if(j==patternLength) {
                System.out.println("Found pattern at index" + (i-j));
                j = lps[j-1];
            }
            else if(i<textLength && pat.charAt(j)!=txt.charAt(i)) {
                if(j!=0)
                    j = lps[j-1];
                else
                    i++;
            }
        }
    }

    /**
     *  lps[i] = the longest proper prefix of pat[0..i]
     *               which is also a suffix of pat[0..i].
     *How to use lps[] to decide next positions (or to know a number of characters to be skipped)?
     *
     * We start comparison of pat[j] with j = 0 with characters of current window of text.
     * We keep matching characters txt[i] and pat[j] and keep incrementing i and j while pat[j] and txt[i] keep matching.
     * When we see a mismatch
     * We know that characters pat[0..j-1] match with txt[i-j…i-1] (Note that j starts with 0 and increment it only when there is a match).
     * We also know (from above definition) that lps[j-1] is count of characters of pat[0…j-1] that are both proper prefix and suffix.
     * From above two points, we can conclude that we do not need to match these lps[j-1] characters with txt[i-j…i-1] because we know that these characters will anyway match.
     * @param pat
     * @param M
     * @param lps
     */
    void computeLPSArray(String pat, int M, int lps[])
    {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i<M) {
            if(pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if(len != 0){
                    len = lps[i-1];
                }
                else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        String txt = "AAAAABAAABA";
        String pat = "AAAA";
        new KMP_String_Matching().KMPSearch(pat, txt);
    }
}
