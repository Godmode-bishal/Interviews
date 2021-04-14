package citrix;

import java.util.*;

public class LazySaksham {
    //TODO wrong answer and O(n^2) too long. Try Kruskal's, Prim's or Djikstra's
    public static void main(String[] args) {
        Map<String,Integer> distMap = new HashMap<>();
        Scanner input = new Scanner(System.in);
        int testsNum = input.nextInt();
        List<Integer> points = new ArrayList<>();
        int minDist =0;
        int result, tmpDist, toAdd;
        while(testsNum>0) {
            result = 0;
            int N = input.nextInt();
            points.clear();
            for(int i = 0; i<N; i++) {
                points.add(input.nextInt());
            }
            for(int i = 0; i<N; i++) {
                tmpDist = 0;
                for(int j = 0; j<N ; j++) {
                    if(i==j)
                        continue;
                    if(distMap.get(points.get(i)+","+points.get(j))==null){
                        toAdd = (int) Math.pow(Math.abs(points.get(i)-points.get(j)),3);
                        tmpDist += toAdd;
                        distMap.put(points.get(i)+","+points.get(j), toAdd);
                        distMap.put(points.get(j)+","+points.get(i), toAdd);
                    }
                    else {
                        toAdd = distMap.get(points.get(i)+","+points.get(j));
                        tmpDist += toAdd;
                    }
                }
                if(minDist==0)
                    minDist = tmpDist;
                if(minDist>tmpDist) {
                    minDist = tmpDist;
                    result = points.get(i);
                }
                else if(minDist==tmpDist) {
                    result = Math.min(result,i);
                }
            }
            System.out.println(result);
            testsNum--;
        }
    }
}
