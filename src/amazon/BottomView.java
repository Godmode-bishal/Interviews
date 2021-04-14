package amazon;

import java.util.*;

public class BottomView {
    private class NodeHeight {
        List<Integer> value;
        int height;
        NodeHeight(List<Integer> value, int height) {
            this.height = height;
            this.value = value;
        }
    }
    void bottomViewUtility(TreeNode node, int height, int distance, Map<Integer,NodeHeight> map) {
        if(node==null) {
            return;
        }
        NodeHeight obj = map.get(distance);
        if(obj==null)
            map.put(distance,new NodeHeight(new ArrayList<Integer>(){
                {
                    add(node.val);
                }
            },height));
        else {
            if (obj.height<height) {
                map.put(distance,new NodeHeight(new ArrayList<Integer>(){
                    {
                        add(node.val);
                    }
                },height));
            }
            else if(obj.height==height)
                obj.value.add(node.val);
        }
        bottomViewUtility(node.left,height+1,distance-1,map);
        bottomViewUtility(node.right,height+1,distance+1,map);
    }
    void bottomView(TreeNode root) {
        //map to store horizontal distance, value, height
        Map<Integer, NodeHeight> map = new LinkedHashMap<>();
        bottomViewUtility(root,0,0,map);
        Map<Integer,NodeHeight> output = new TreeMap<>(map);
        for (Integer sKey : output.keySet()) {
            for(int temp:output.get(sKey).value)
                System.out.print(temp+"->");
        }
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(20);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(22);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(3);
        TreeNode nodeX = new TreeNode(4);
        TreeNode node6 = new TreeNode(25);
        node2.left = node4;
        node2.right = node5;
        node3.left = nodeX;
        node3.right = node6;
        TreeNode node7 = new TreeNode(10);
        TreeNode node8 = new TreeNode(14);
        node5.left = node7;
        node5.right = node8;
        BottomView obj = new BottomView();
        obj.bottomView(node1);
    }
}
