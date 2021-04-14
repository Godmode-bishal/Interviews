package graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        /*int[][] adjArray = new int[8][8];
        adjArray[0][1] = adjArray[1][0] = 1;
        adjArray[1][2] = adjArray[2][1] = 1;
        adjArray[1][7] = adjArray[7][1] = 1;
        adjArray[2][3] = adjArray[3][2] = 1;
        adjArray[2][4] = adjArray[4][2] = 1;
        adjArray[4][5] = adjArray[5][4] = 1;
        adjArray[4][6] = adjArray[6][4] = 1;
        adjArray[4][7] = adjArray[7][4] = 1;*/
        GraphWithAdjList graph = new GraphWithAdjList(8);
        graph.setEdges(1,2);
        graph.setEdges(2,1);
        graph.setEdges(2,3);
        graph.setEdges(3,2);
        graph.setEdges(2,8);
        graph.setEdges(3,4);
        graph.setEdges(3,5);
        graph.setEdges(2,3);
        graph.setEdges(5,6);
        graph.setEdges(5,7);
        graph.setEdges(5,8);
        int[] visited = new int[8];
        BFSFunction(graph, 0, visited);
        System.out.println("done");
    }

    static void BFSFunction(GraphWithAdjList graph, int vertex, int[] visited) {
        Queue<Integer> queue = new LinkedList();
        ((LinkedList) queue).add(vertex);
        Iterator iterator;
        while(!queue.isEmpty()) {
            vertex = queue.peek();
            visited[vertex] = 1;
            iterator = graph.getAdjList()[queue.poll()].iterator();
            System.out.print(vertex + 1 + "->");
            while(iterator.hasNext()) {
                    vertex = (int)iterator.next();
                    if(visited[vertex] != 1) {
                        ((LinkedList<Integer>) queue).add(vertex);
                    }
            }
        }
    }

}
