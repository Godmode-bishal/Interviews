package javapractice.iterating;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AndThenExample {
    public static void main(String[] rags) {
        Consumer<List<Integer>> modify = list-> {
            for(int i = 0; i < list.size(); i++) {
                list.set(i, 2*list.get(i));
            }
        };

        Consumer<List<Integer>> display = list -> {
            list.stream().forEach(a-> System.out.println(a));
        };
        List<Integer> list = new ArrayList<>();
        list.add(2); list.add(1); list.add(3);
        modify.andThen(display).accept(list);
    }
}
