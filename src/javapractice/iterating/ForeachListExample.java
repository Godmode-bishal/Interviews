package javapractice.iterating;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ForeachListExample {

    /**/
    /**/
    public static void main(String[] args) {
        /*List<String> names = Arrays.asList("Bishal", "Cishal", "Dishal");
        names.forEach(System.out::println);

        List<String> names2 = Arrays.asList("Alex", "Brian", "Charles");

        Consumer<String> makeUpperCase = new Consumer<String>()
        {
            @Override
            public void accept(String t)
            {
                System.out.println(t.toUpperCase());
            }
        };

        names2.forEach(makeUpperCase);*/


   /* Map<String, String> somemap = new HashMap<String, String>();

    somemap.put("A", "Alex");
    somemap.put("B", "Brian");
    somemap.put("C", "Charles");

    somemap.forEach((k, v) ->
            System.out.println("Key = " + k + ", Value = " + v));*/
        BiConsumer<String, Integer> action = (a,b) ->
        {
            System.out.println("Key is " + a);
            System.out.println("Value is " + b);
        };
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B",2);
        map.put("C",3);
        map.forEach(action);
    }


}