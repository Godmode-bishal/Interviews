/*
package klc;


import java.util.*;

public class CriticalRoads {

    private class Graph {
        private int v;
        private LinkedList<Integer> adj[];
        Graph(int v) {

        }
    }
    static int X = 0;
    static int result = 0;
    public static void utilityFunc(int i, boolean[] doneVisiting, int[] find, int[] earliest, int[] supernode, List<List<Integer>> roads) {
        doneVisiting[i] = true;
        find[i] = ++X;
        earliest[i] = find[i];
        if (i < roads.size()) {
            Iterator<Integer> it = roads.get(i).iterator();
            while (it.hasNext()) {
                int vertex = it.next() - 1;
                if (!doneVisiting[vertex]) {
                    supernode[vertex] = i;
                    utilityFunc(vertex, doneVisiting, find, earliest, supernode, roads);
                    earliest[i] = Math.min(earliest[i], earliest[vertex]);
                    if (earliest[vertex] > find[i])
                        result++;
                } else if (vertex != supernode[i])
                    earliest[i] = Math.min(earliest[i], find[vertex]);
            }
        }
    }
    public static int findCriticalRoads(List<List<Integer>> roads) {
        int node=0;
        int[] test = new int[roads.size()*2];
        Arrays.fill(test,-1);
        for(List<Integer> road: roads) {
            for(int someRoad:road) {
                if(test[someRoad]==-1) {
                    node++;
                    test[someRoad]= someRoad;
                }
            }
        }
        int vertices = roads.size();
        boolean[] doneVisiting = new boolean[node];
        int[] find = new int[node];
        int[] earliest = new int[node];
        int[] supernode = new int[node];
        for(int i =0; i<node; i++) {
            supernode[i] = -1;
            doneVisiting[i] = false;
        }
        for(int i = 0; i<vertices; i++) {
            if(!doneVisiting[i])
                utilityFun  c(i, doneVisiting, find, earliest, supernode, roads);
        }
        return result;
    }
}
*/
