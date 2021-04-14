package graphs;

public class GraphWithAdjMatrix {
    private int vertices;
    private int edges;
    private int[][] adjMatrix;

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public int getEdges() {
        return edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    GraphWithAdjMatrix(int vertices, int edges, int[][] adjMatrix) {
        this.vertices = vertices;
        this.edges = edges;
        this.adjMatrix = adjMatrix;
    }
}
