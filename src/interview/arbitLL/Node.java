package interview.arbitLL;

public class Node {
    private int value;
    private Node next;

    Node() {}
    Node(Node node) {
        this.value = node.getValue();
        this.next = node.getNext();
        this.arbit = node.getArbit();
    }

    Node(int value, Node next, Node arbit) {
        this.value = value;
        this.next = next;
        this.arbit = arbit;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getArbit() {
        return arbit;
    }

    public void setArbit(Node arbit) {
        this.arbit = arbit;
    }

    private Node arbit;


}
