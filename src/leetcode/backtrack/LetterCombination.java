package leetcode.backtrack;

import java.lang.reflect.Array;
import java.util.*;

public class LetterCombination {
    static List<String> output = new ArrayList<>();
    static Map<String,List<String>> numberLetterMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        numberLetterMap.put("2", Arrays.asList("a","b","c"));
        numberLetterMap.put("3", Arrays.asList("d","e","f"));
        numberLetterMap.put("4", Arrays.asList("g","h","i"));
        numberLetterMap.put("5", Arrays.asList("j","k","l"));
        numberLetterMap.put("6", Arrays.asList("m","n","o"));
        numberLetterMap.put("7", Arrays.asList("p","q","r","s"));
        numberLetterMap.put("8", Arrays.asList("t","u","v"));
        numberLetterMap.put("9", Arrays.asList("w","x","y","z"));
        recursiveCall(digits,"");
        return output;
    }
    public void recursiveCall(String num, String prev) {
        if(num.equalsIgnoreCase("")) {
            if(!prev.equalsIgnoreCase(""))
                output.add(prev);
            return;
        }
        int number = Integer.parseInt(num);
        String dig, nextNum;
        List<String> temp;
        if(number>0) {
            dig = Character.toString(num.charAt(0));
            nextNum = num.substring(1);
            temp = numberLetterMap.get(dig);
            for(String content:temp) {
                prev += content;
                recursiveCall(nextNum,prev);
                prev = prev.substring(0,prev.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        LetterCombination obj = new LetterCombination();
        System.out.println(obj.letterCombinations("2"));
    }

}
