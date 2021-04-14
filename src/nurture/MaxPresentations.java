package nurture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxPresentations {
    /*private class Info {
        int arrival;
        int duration;
    }
    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        // Write your code here

        int endTime = 0;
        int maxCount = 0,minDuration;
        for(int i =0; i<arrival.size();) {
            if(endTime<=arrival.get(i))
                maxCount++;
            minDuration = duration.get(i);
            while(i+1<arrival.size() && arrival.get(i)==arrival.get(i+1)) {
                if(duration.get(i+1)<minDuration) {
                    minDuration =  duration.get(i+1);
                }
                i++;
            }
            endTime += minDuration;

            i++;
        }
        return maxCount;*/
    public static class Info {
        int arrival, duration;

        Info(int arrival, int duration) {
            this.arrival = arrival;
            this.duration = duration;
        }
    }

    public static int maxEvents(List<Integer> arrival, List<Integer> duration)
    {
        List<Info> performers=new ArrayList<>();
        for(int i=0;i<arrival.size();i++)
        {
            performers.add(new Info(arrival.get(i),duration.get(i)));
        }
        Collections.sort(performers, new Comparator<Info>() {
            @Override
            public int compare(Info p1, Info p2) {
                return Integer.compare(p1.arrival+p1.duration, p2.arrival+p2.duration);
            }
        });
        List<Info> festival=new ArrayList<>();
        System.out.println(performers);
        int currentTime = 1;
        for (Info p:performers) {
            if (p.arrival >= currentTime) {
                currentTime = p.arrival+p.duration;
                festival.add(p);
            }
        }
        return festival.size();
    }
}
