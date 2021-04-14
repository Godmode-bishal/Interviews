package graphs;
import sorting.Parent;

public class Child extends Parent {
    public void test() {
        System.out.println(x);
        Parent parent = new Parent();
       // System.out.println(parent.x);
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.test();
    }
}
