package leetcode.arraysString;

import java.util.*;
//https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/778/

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String string:strs) {
            char[] characters = string.toCharArray();
            Arrays.sort(characters);
            String key =  new String(characters);
            if(!map.containsKey(key)) {
                map.put(key,new ArrayList<String>());
            }
                map.get(key).add(string);
        }
        output.addAll(map.values());
        return output;
    }
}
