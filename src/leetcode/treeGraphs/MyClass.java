package leetcode.treeGraphs;

import java.util.HashMap;
import java.util.Map;

public class MyClass {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        String a = "abc";
        String b = new String("abc");
        map.put(a,10);
        map.put(b,20);
        map.put(new String("abc"),30);
        System.out.println(map.get("abc"));
    }
    class A{}
    class B extends A{}
}
