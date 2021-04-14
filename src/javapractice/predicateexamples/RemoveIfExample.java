package javapractice.predicateexamples;

import java.util.ArrayList;
import java.util.List;

public class RemoveIfExample {
public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(30);
    list.add(31);
    list.add(32);
    list.add(33);

    list.removeIf(n->n%3==0);
    for(int i:list)
        System.out.println(i);
}
}
