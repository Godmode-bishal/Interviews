package graphs.leetcodeDeepCopy;

import java.util.*;

public class MyDeepCopy {
    public Node cloneGraph(Node node) {
        if(node==null)
            return node;
        Node original = node;

        Set<Node> visiting = new HashSet<>();
        Map<Node, Node> oldToNewMap = new HashMap<>();

        Node tempNode, newNode;
        visiting.add(node);
        Iterator<Node> itr = visiting.iterator();
        while(itr.hasNext()) {
            node = itr.next();
            newNode = oldToNewMap.get(node);
            if(newNode == null) {
                newNode = new Node(node.val);
                oldToNewMap.put(node, newNode);
            }
            for(int i = 0; i<node.neighbors.size(); i++) {
                tempNode = oldToNewMap.get(node.neighbors.get(i));
                if(tempNode == null) {
                    tempNode = new Node(node.neighbors.get(i).val);
                }
                newNode.neighbors.add(tempNode);
                if(!oldToNewMap.containsKey(node.neighbors.get(i))) {
                    visiting.add(node.neighbors.get(i));
                    oldToNewMap.put(node.neighbors.get(i), tempNode);
                }
            }

            visiting.remove(node);
            itr = visiting.iterator();
        }
        return oldToNewMap.get(original);
    }
}

