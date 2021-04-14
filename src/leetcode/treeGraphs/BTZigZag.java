package leetcode.treeGraphs;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTZigZag {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root == null)
            return output;
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        //push the root
        currentLevel.push(root);
        boolean leftToRight = true;
        List<Integer> contents = new ArrayList<>();
        while(!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.pop();
            contents.add(node.val);
            if(leftToRight) {
                if(node.left!=null)
                    nextLevel.push(node.left);
                if(node.right!=null)
                    nextLevel.push(node.right);
            }
            else {
                if(node.right!=null)
                    nextLevel.push(node.right);
                if(node.left!=null)
                    nextLevel.push(node.left);
            }
            if(currentLevel.isEmpty()) {
                output.add(contents);
                leftToRight = !leftToRight;
                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
                contents = new ArrayList<>();
;            }
        }
        return output;
    }
}
