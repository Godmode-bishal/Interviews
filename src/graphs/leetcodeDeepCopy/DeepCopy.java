package graphs.leetcodeDeepCopy;

import java.util.HashMap;
import java.util.Map;

public class DeepCopy
{
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Integer, Node> oldToNewMap = new HashMap<>();
        return cloneDFS(node, oldToNewMap);
    }

    public Node cloneDFS(Node node, Map<Integer, Node> oldToNewMap) {
        if(oldToNewMap.containsKey(node.val)) {
           return oldToNewMap.get(node.val);
        }
        Node copy = new Node(node.val);
        oldToNewMap.put(node.val, copy);
        for(Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneDFS(neighbor,oldToNewMap));
        }
        return copy;
    }
}
