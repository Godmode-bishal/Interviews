package leetcode.treeGraphs;

import java.util.LinkedList;
import java.util.List;

public class Child extends Parent {
    void say(List list) {
        System.out.println("child");
    }
    public static void main(String[] args) {
        Child c = new Child();
        c.say(new LinkedList<String>());
    }
}
