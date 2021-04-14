package morganstanley;

import java.util.*;

public class Result {
        static Map<Integer, List<Point>> map = new HashMap<>();
        static class Point {
            int x,y;
            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        public static void closestNumbers(List<Integer> numbers) {
            // Write your code here
            Collections.sort(numbers);
            int difference = Integer.MAX_VALUE;
            int n = numbers.size();
            for(int i = 0; i<n ; i++) {
                if(map.get(numbers.get(i+1) - numbers.get(i)) != null) {
                    List tempList = map.get(numbers.get(i+1) - numbers.get(i));
                    tempList.add(new Point(numbers.get(i+1),numbers.get(i)));
                    map.put(numbers.get(i+1) - numbers.get(i), tempList);
                }
                else {
                    List<Point> list = new ArrayList<>();
                    list.add(new Point(numbers.get(i+1),numbers.get(i)));
                    map.put(numbers.get(i+1) - numbers.get(i), list);
                }
                if(numbers.get(i+1) - numbers.get(i)<difference) {
                    difference = numbers.get(i+1)-numbers.get(i);
                }
            }

            List list = map.get(difference);
            Collections.sort(list, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    int result = Integer.compare(o1.x, o2.x);
                    if(result==0) {
                        result = Integer.compare(o1.y,o2.y);
                    }
                    return result;
                }
            });
            for(Point p:map.get(difference)) {
                System.out.println(p.y + " " + p.x);
            }
        }
}
