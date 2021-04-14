package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSorting {
    public static void main(String[] args) {
        GraphWithAdjList graph = new GraphWithAdjList(6);
        int[] indegree = new int[6];
        graph.setEdges(6,1);
        indegree[0]++;
        graph.setEdges(6,3);
        indegree[2]++;
        graph.setEdges(5,1);
        indegree[0]++;
        graph.setEdges(5,2);
        indegree[1]++;
        graph.setEdges(4,2);
        indegree[1]++;
        graph.setEdges(3,4);
        indegree[3]++;
        topologicalSort(graph, indegree);
    }

    static void topologicalSort(GraphWithAdjList graph, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        int[] topologicalOrder =  new int[6];
        int counter=0;
        int v, w;
        Iterator iterator;
        for(v=0;v<graph.getVertices();v++) {
            if(indegree[v] == 0) {
                ((LinkedList<Integer>) queue).add(v);
            }
        }
        while(!queue.isEmpty()) {
            v = queue.peek();
            System.out.print(v + "->");
            topologicalOrder[v] = ++counter;
            iterator = graph.getAdjList()[queue.poll()].iterator();
            while(iterator.hasNext()) {
                w = (int)iterator.next();
                if(--indegree[w] == 0) {
                    ((LinkedList<Integer>) queue).add(w);
                }
            }
            if(counter != graph.getVertices()) {
                System.out.println("Graph has cycle");
            }
        }
    }
}
