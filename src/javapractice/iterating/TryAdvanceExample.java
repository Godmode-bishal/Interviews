package javapractice.iterating;

import java.util.ArrayList;
import java.util.Spliterator;

public class TryAdvanceExample {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(-3);
        arrayList.add(-4);
        arrayList.add(5);

        System.out.println("Contents of arraylist :");
        Spliterator<Integer> spliterator = arrayList.spliterator();
        while(spliterator.tryAdvance(System.out::println));

    }
}
