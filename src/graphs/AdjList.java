package graphs;

public class AdjList {
    private int value;
    private AdjList next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AdjList getNext() {
        return next;
    }

    public void setNext(AdjList next) {
        this.next = next;
    }

    AdjList(int value) {
        this.value = value;
    }
}
