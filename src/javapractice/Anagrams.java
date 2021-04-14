package javapractice;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    boolean isAnagram(String a, String b) {
        if(a=="" || b=="" || a==null || b==null || a.length() != b.length()) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        Map<Character,Integer> map  = new HashMap<>();
        for(int i = 0; i<a.length(); i++) {
            if(map.containsKey(a.charAt(i))) {
                map.put(a.charAt(i), map.get(a.charAt(i)).intValue()+1);
            }
            else {
                map.put(a.charAt(i), 1);
            }
        }
        for(int j = 0; j<b.length(); j++) {
            char letter = a.charAt(j);

            if( ! map.containsKey( letter ) )
                return false;

            Integer frequency = map.get( letter );

            if( frequency == 0 )
                return false;
            else
                map.put( letter, --frequency);
        }
        return true;
    }
}
