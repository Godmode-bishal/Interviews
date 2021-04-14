package mapexamples;

import java.util.HashMap;

public class MergeExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1,"A");
        map1.put(2,"B");
        System.out.println("Old Hashmap" + map1);
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1,"A");
        map2.put(2,"D");

        map2.forEach((key, value)->
                map1.merge(key, value,(v1,v2)->
                        v1.equalsIgnoreCase(v2)? v1 : v1+","+v2)
                        );
        System.out.println("New Hashmap" + map1);
    }

}
