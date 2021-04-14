package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathUnweighed {
    private static int source;
    private static int destination;
    private static String path="";
    private static HashSet<Integer> hashSet;
    public static void main(String[] args) {
        GraphWithAdjList graph = new GraphWithAdjList(7);
        graph.setEdges(1,2);
        graph.setEdges(1,4);
        graph.setEdges(2,4);
        graph.setEdges(2,5);
        graph.setEdges(3,1);
        graph.setEdges(3,6);
        graph.setEdges(4,6);
        graph.setEdges(4,7);
        graph.setEdges(5,7);
        graph.setEdges(7,6);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter source node (1-7");
        source = in.nextInt();
        System.out.println("Enter destination node(1-7)");
        destination = in.nextInt();
        int counter = 0;
        boolean found = false;
        int visited[] = new int[7];
        int[] path = new int[7];
        for(int i = 0;i < path.length; i++) {
            path[i] = i;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source-1);
        while(!queue.isEmpty()) {
            hashSet = graph.getAdjList()[queue.peek()];
           for(Integer node: hashSet) {
               if(visited[node] != 1) {
                   queue.add(node);
                   path[node] = queue.peek();
                   visited[node] = 1;
               }
               if(node == destination-1) {
                   found = true;
                   break;
               }
           }
           queue.poll();
           if(found)
               break;
        }
        if(!found) {
            System.out.println("Path does not exist");
            System.exit(1);
        }
        System.out.print("Shortest Path is " + destination);
        int node = destination-1;
        while(node != source-1) {
            System.out.print(" -> " + (path[node]+1));
            node = path[node];
        }
        System.out.println("");

    }
}
