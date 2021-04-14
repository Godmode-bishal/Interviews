package interview.arbitLL;

public class CopyArbitLLWithExtraSpace {
    static Node[] saveOriginal(Node head, int n) {
        int i = 0;
        Node[] nodeArray = new Node[n];
        while (i<n) {
            nodeArray[i] = head;
            head = head.getNext();
            i++;
        }
        return nodeArray;
    }
    static Node createLLCopy(Node head) {
        Node newHead;
        Node oldNode, newNode;
        newHead = new Node(head.getValue(), head.getNext(),head.getArbit());
        oldNode = newHead;
        while(head.getNext() != null) {
            head = head.getNext();
            newNode =  new Node(head.getValue(), head.getNext(),head.getArbit());
            oldNode.setNext(newNode);
        }
        return newHead;
    }

    static void copyArbitLLWithExtraSpace(Node head) {
    //Saving the original LL nodes with forward pointers using newHead and creating copy
    Node saveOrigHead = createLLCopy(head);
    Node copy = createLLCopy(head);


    }
    public static void main(String[] args) {
        Node node1, node2 ,node3, node4, node5;
        node1 = new Node();
        node2 = new Node();
        node3 = new Node();
        node4 = new Node();
        node5 = new Node();
        //For node1
        node1.setValue(1);node1.setNext(node2);node1.setArbit(node3);
        //For node2
        node2.setValue(2);node2.setNext(node3);node2.setArbit(node1);
        //For node3
        node3.setValue(3);node3.setNext(node4);node3.setArbit(node5);
        //For node4
        node4.setValue(4);node4.setNext(node5);node4.setArbit(node3);
        //For node5
        node5.setValue(5);node5.setNext(null);node1.setArbit(node2);
        Node[] nodeRefArray = saveOriginal(node1, 5);
        copyArbitLLWithExtraSpace(node1);


    }
}
