package leetcode.treeGraphs;

import java.util.Set;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        Person p1 = new Person("ABC");
        Person p2 = new Person("BCD");
        Person p3 = new Person("DEF");
        Person p4 = new Person("ABC");
        Set<Person> t = new TreeSet<>();
        t.add(p1);
        t.add(p2);
        t.add(p3);
        t.add(p4);
        System.out.println(t.size());
    }
}
