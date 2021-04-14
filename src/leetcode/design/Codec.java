package leetcode.design;

import amazon.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Codec {

    int maxDepth(TreeNode node)
    {
        if (node == null)
            return 0;
        else
        {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public String serializeEff(TreeNode root) {
        if(root == null)
            return "X,";
        String left = serializeEff(root.left);
        String right = serializeEff(root.right);
        return root.val + "," + left + right;
    }

    public TreeNode deserializeEff(String data) {
        Queue<String> nodesLeft = new LinkedList<>();
        nodesLeft.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodesLeft);
    }

    public TreeNode deserializeHelper(Queue<String> nodesLeft) {
        String value = nodesLeft.poll();
        if(value.equalsIgnoreCase("X"))
            return null;
        TreeNode newNode = new TreeNode(Integer.valueOf(value));
        newNode.left = deserializeHelper(nodesLeft);
        newNode.right = deserializeHelper(nodesLeft);
        return newNode;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String output = "";
        TreeNode temp;
        if(root==null)
            return  null;
        int height = maxDepth(root);
        Integer[] nodeValArray = new Integer[(int)Math.pow(2,height)-1];
        Arrays.fill(nodeValArray,null);
       int i = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        nodeValArray[i] = root.val;
        while(!queue.isEmpty() && 2*i+1<nodeValArray.length) {
            temp = queue.poll();
            if(temp!=null) {
                queue.add(temp.left);
                if(nodeValArray[2*i+1]==null && temp.left!=null)
                    nodeValArray[2*i+1] = temp.left.val;
                queue.add(temp.right);
                if(nodeValArray[2*i+2]==null && temp.right!=null)
                    nodeValArray[2*i+2] = temp.right.val;
            }
            i++;
        }
        for(Integer tmp:nodeValArray) {
            if(tmp!=null)
                output += tmp+",";
            else
                output += "null,";
        }
        return output.substring(0,output.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] outs = data.split(",");
        TreeNode[] array = new TreeNode[outs.length];
        Arrays.fill(array, null);
        TreeNode temp = null, xTemp = null;
        for(int i = 0; i<=outs.length/2; i++) {
            if(!outs[i].equalsIgnoreCase("null")) {
                if(array[i]==null) {
                    temp = new TreeNode(Integer.parseInt(outs[i]));
                    array[i] = temp;
                }
                else {
                    temp = array[i];
                }
            }

            if(2*i+1<outs.length && !outs[2*i+1].equalsIgnoreCase("null")) {
                if(array[2*i+1]==null) {
                    xTemp = new TreeNode(Integer.parseInt(outs[2*i+1]));
                    array[2*i+1] = xTemp;
                    temp.left = xTemp;
                }
            }

            if(2*i+2<outs.length && !outs[2*i+2].equalsIgnoreCase("null")) {
                if(array[2*i+2]==null) {
                    xTemp = new TreeNode(Integer.parseInt(outs[2*i+2]));
                    array[2*i+2] = xTemp;
                    temp.right = xTemp;
                }
            }
        }
        return array[0];
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node4.left = node6;
        node4.right = node7;
        Codec obj = new Codec();

        String re = obj.serialize(node1);
        obj.deserialize(re);

    }
}
