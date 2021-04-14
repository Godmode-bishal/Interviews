package javapractice.iterating;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEachRemainingExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Grapes");
        fruits.add("Orange");
        Iterator<String> iterator = fruits.iterator();
        iterator.forEachRemaining(System.out::println);
    }
}
