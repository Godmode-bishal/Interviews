package mapexamples;

import java.util.HashMap;

public class ReplaceAllExample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);
        map.put("key4", 4);
        System.out.println("Map before replacement : " + map.toString());
        map.replaceAll((key, value)->value*value);
        System.out.println("Map after replacement : " +  map.toString());
    }
}
