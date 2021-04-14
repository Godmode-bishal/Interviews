package disjointSet;

import com.sun.deploy.net.proxy.pac.PACFunctions;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    private Map<Long, Node> map = new HashMap<>();
    class Node {
        long data;
        Node parent;
        int rank;
    }

    /**
     *  Create a set with only one element
     */
    public void makeSet(long data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }

    /**
     * Combines two sets into one. Does union by rank
     */
    public void union(long data1, long data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);
        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);
        //If findSent is same for both nodes, no need to proceed
        if(parent1.data == parent2.data) {
            return;
        }
        if(parent1.rank >= parent2.rank) {
            parent1.rank = parent1.rank == parent2.rank?parent1.rank+1:parent1.rank;
            parent2.parent = parent1;
        }
        else {
            parent1.parent = parent2;
        }
    }

    /**
     * Find the representative of this set
     */
    public long findSet(long node) {
        return findSet(map.get(node)).data;
    }

    /**
     * Find representative as well as path compression
     */
    private Node findSet(Node node) {
        if(node.parent==node) {
            return node;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet();
        disjointSet.makeSet(1);
        disjointSet.makeSet(2);
        disjointSet.makeSet(3);
        disjointSet.makeSet(4);
        disjointSet.makeSet(5);
        disjointSet.makeSet(6);
        disjointSet.makeSet(7);
        disjointSet.union(1,2);
        disjointSet.union(2,3);
        disjointSet.union(4,5);
        disjointSet.union(6,7);
        disjointSet.union(5,6);
        disjointSet.union(3,7);
        System.out.println(disjointSet.findSet(1));
        System.out.println(disjointSet.findSet(2));
        System.out.println(disjointSet.findSet(3));
        System.out.println(disjointSet.findSet(4));
        System.out.println(disjointSet.findSet(5));
        System.out.println(disjointSet.findSet(6));
        System.out.println(disjointSet.findSet(7));
    }
}
