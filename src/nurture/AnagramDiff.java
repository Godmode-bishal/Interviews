package nurture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramDiff {
    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        // Write your code here
        int[] alphabets = new int[26];
        int modCount = 0;
        String first,second;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<a.size(); i++) {
            first = a.get(i);
            second = b.get(i);
            if(first.length() != second.length()) {
                result.add(i,-1);
                continue;
            }
            for (int j = 0; j < first.length(); j++) {
                alphabets[first.charAt(j) - 'a']++;
            }
            for (int j = 0; j < second.length() ; j++) {
                if(alphabets[second.charAt(j) - 'a']>0)
                    alphabets[second.charAt(j) - 'a']--;
            }
            for (int j = 0; j < alphabets.length; j++) {
                if(alphabets[j]!=0) {
                    modCount += Math.abs(alphabets[j]);
                }
            }
            result.add(i,modCount);
            modCount = 0;
            Arrays.fill(alphabets,0);
        }
        return result;
    }
}
