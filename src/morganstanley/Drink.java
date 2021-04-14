package morganstanley;

import java.util.TreeSet;

public class Drink implements Comparable {
    public String name;
    @Override
    public int compareTo(Object o) {
        return 0;
    }
    public static void main(String[] args) {
        Drink one = new Drink();
        Drink two = new Drink();
        one.name = "Coffee";
        two.name = "Tea";
        TreeSet set = new TreeSet();
        set.add(one);
        set.add(two);
        for(Object o : set) {
            if(o instanceof Drink) {
                System.out.println(((Drink) o).name);
            }
        }
    }
}
