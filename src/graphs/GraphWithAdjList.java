package graphs;

import java.util.HashSet;
import java.util.LinkedList;

public class GraphWithAdjList {
    private int vertices;

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public HashSet<Integer>[] getAdjList() {
        return adjList;
    }

    public void setAdjList(HashSet<Integer>[] adjList) {
        this.adjList = adjList;
    }

    private int edges;
    private HashSet<Integer> adjList[];

    GraphWithAdjList(int vertices) {
        this.vertices = vertices;
        this.adjList = new HashSet[vertices];
        for(int i=0;i<vertices;i++) {
            adjList[i] = new HashSet<Integer>();
        }
    }

    public void setEdges(int from, int to) {
        //for undirected graph
        /*if(this.adjList[to-1] == null || !this.adjList[to-1].contains(from-1)){
            this.adjList[from-1].add(to-1);
        }*/
        //for directed graph
        this.adjList[from-1].add(to-1);
    }
}

