package klc;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<List<Integer>> roads = new ArrayList<>();
        List<Integer> road1 = new ArrayList<>();
        road1.add(1);
        road1.add(2);
        List<Integer> road2 = new ArrayList<>();
        road2.add(1);
        road2.add(3);
        List<Integer> road3 = new ArrayList<>();
       /* road1.add(2);
        road1.add(3);*/
        List<Integer> road4 = new ArrayList<>();
        road4.add(3);
        road4.add(4);
        List<Integer> road5 = new ArrayList<>();
        /*road1.add(4);
        road1.add(5);
        */
        roads.add(road1);
        roads.add(road2);
        //roads.add(road3);
        roads.add(road4);
        //roads.add(road5);
        //System.out.println(CriticalRoads.findCriticalRoads(roads));
    }
}
