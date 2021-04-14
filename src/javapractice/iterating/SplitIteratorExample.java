package javapractice.iterating;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SplitIteratorExample {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(-3);
        arrayList.add(-4);
        arrayList.add(5);
        Stream<Integer> stream = arrayList.stream();
        Spliterator<Integer> spliterator = stream.spliterator();
        System.out.println("Estimated size = " + spliterator.estimateSize());
        System.out.println("Exact size : " + spliterator.getExactSizeIfKnown());
        System.out.println(spliterator.hasCharacteristics(spliterator.characteristics()));
        System.out.println("Content of arraylist : ");
        spliterator.forEachRemaining(System.out::println);

        spliterator = arrayList.stream().spliterator();
        Spliterator<Integer> spliterator1 = spliterator.trySplit();
        if(spliterator1 != null) {
            System.out.println("Output from 2nd split : ");
            spliterator1.forEachRemaining(System.out::println);
        }
        System.out.println("Output from 1st split : ");
        spliterator.forEachRemaining(System.out::println);
    }
}
