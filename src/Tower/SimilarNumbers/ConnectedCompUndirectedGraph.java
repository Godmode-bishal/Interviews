package Tower.SimilarNumbers;

import java.util.ArrayList;

/**
 * Connected components in an undirected graph
 */

public class ConnectedCompUndirectedGraph {
    int V;
    ArrayList<ArrayList<Integer>> adjListArray;
    ConnectedCompUndirectedGraph(int V) {
        this.V = V;
        adjListArray = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adjListArray.add(i, new ArrayList<>());
        }
    }

    void addEdge(int src, int dest) {
        adjListArray.get(src).add(dest);
        adjListArray.get(dest).add(src);
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + "->");
        for(int x : adjListArray.get(v)) {
            if(!visited[x])
                DFSUtil(x, visited);
        }
    }

    void connectedComponents() {
        boolean[] visited = new boolean[V];
        for(int v = 0; v < V; ++v) {
            if(!visited[v]) {
                DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ConnectedCompUndirectedGraph obj = new ConnectedCompUndirectedGraph(5);
        obj.addEdge(1,0);
        obj.addEdge(2,3);
        obj.addEdge(3,4);
        System.out.println("Following are the connected components");
        obj.connectedComponents();
    }
}
