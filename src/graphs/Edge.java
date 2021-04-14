package graphs;

public class Edge {
    private Vertex firstVertex;
    private Vertex secondVertex;
    private int distance;

    public Vertex getFirstVertex() {
        return firstVertex;
    }

    public void setFirstVertex(Vertex firstVertex) {
        this.firstVertex = firstVertex;
    }

    public Vertex getSecondVertex() {
        return secondVertex;
    }

    public void setSecondVertex(Vertex secondVertex) {
        this.secondVertex = secondVertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    Edge(Vertex one, Vertex two, int distance) {
        this.firstVertex = one;
        this.secondVertex = two;
        this.distance = distance;
    }
}
