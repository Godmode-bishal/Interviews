package graphs;

import java.util.*;

public class DFS {
   public static void main(String[] args) {
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
       int[] visited = new int[9];
       DFSFunction(graph, 0, visited);
       System.out.println("done");
   }

   static void DFSFunction(GraphWithAdjList graph, int vertex, int[] visited) {
       System.out.print(vertex + "->");
       visited[vertex] = 1;
       Iterator iterator = graph.getAdjList()[vertex].iterator();
       while (iterator.hasNext()) {
           vertex = (int)iterator.next();
           if(visited[vertex]!=1) {
               DFSFunction(graph,vertex,visited);
           }
       }
   }
}