package graphs.leetcodeDeepCopy;

import java.util.*;

public class Driver {
    public static void getAdjList(Node node) {
        if(node == null) {
            return;
        }
        //TODO Find out why List<Map<int,int>> is not allowed
        Map<Integer, List<Integer>> mapToBeReturned = new HashMap<>();
        Set<Node> visiting = new HashSet<>();
        visiting.add(node);
        Iterator<Node> itr = visiting.iterator();
        Node tempNode;
        List<Integer> neighborList;
        while (itr.hasNext()) {
            tempNode = itr.next();
            neighborList = new ArrayList<>();
            for (int i = 0; i < tempNode.neighbors.size(); i++) {
                if (mapToBeReturned.get(tempNode.neighbors.get(i).val) == null) {
                    neighborList.add(tempNode.neighbors.get(i).val);
                    visiting.add(tempNode.neighbors.get(i));
                }
                else {
                    if (!mapToBeReturned.get(tempNode.neighbors.get(i).val).contains(tempNode.val)) {
                        neighborList.add(tempNode.neighbors.get(i).val);
                        visiting.add(tempNode.neighbors.get(i));
                    }
                }
            }
            mapToBeReturned.put(tempNode.val,neighborList);
            visiting.remove(tempNode);
            if(!visiting.isEmpty()) {
                itr = visiting.iterator();
            }
        }
        System.out.println(mapToBeReturned);
    }
    public static void main(String args[]) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        getAdjList(node1);
        DeepCopy deepCopy = new DeepCopy();
        Node resultNode = deepCopy.cloneGraph(node1);
        getAdjList(resultNode);

    }
}
