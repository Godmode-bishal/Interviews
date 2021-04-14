package leetcode.arraysString;

import java.util.*;

public class LongestSubstringNoRepeat {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        int result = 0;
        int max = 0;
        Map<Character,Integer> charInString = new HashMap<>();
        for(int i = 0; i<s.length(); ) {
            if(charInString.containsKey(s.charAt(i))) {
                result = 0;
                i = charInString.get(s.charAt(i))==i-1?i:charInString.get(s.charAt(i))+1;
                charInString.clear();
                //charInString.put(s.charAt(i),i);
            }
            else {
                result++;
                if(result>max)
                    max = result;
                charInString.put(s.charAt(i),i);
                i++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstringEfficient(String s) {
        int i = 0, j = 0;
        int max = 0;
        HashSet<Character> hashSet = new HashSet<>();
        while (j<s.length()) {
            if(!hashSet.contains(s.charAt(j))) {
                hashSet.add(s.charAt(j));
                j++;
                max  = Math.max(hashSet.size(), max);
            }
            else {
                hashSet.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LongestSubstringNoRepeat obj = new LongestSubstringNoRepeat();
        obj.lengthOfLongestSubstringEfficient(s);
    }
}
