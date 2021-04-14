package mapexamples;

import java.util.HashMap;
import java.util.Map;

public class ComputeExample {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("Name", "Bishal");
        map.put("place", "Silchar");
        System.out.println("Map before = " + map);
        map.compute("Name",(key, value)->value.concat(" Mazumdar"));
        System.out.println("Map after = " + map);
    }
}
