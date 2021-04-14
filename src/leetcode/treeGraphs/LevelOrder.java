package leetcode.treeGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return null;
        List<List<Integer>> traversalList = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> nextLevelQueue = new LinkedList<>();
        queue.add(root);
        TreeNode tmp;
        while(!queue.isEmpty()) {
            tmp = queue.poll();
            level.add(tmp.val);
            if(tmp.left!=null)
                nextLevelQueue.add(tmp.left);
            if(tmp.right != null)
                nextLevelQueue.add(tmp.right);
            if(queue.isEmpty()) {
                traversalList.add(level);
                level = new ArrayList<>();
                queue.clear();
                for(TreeNode temp : nextLevelQueue) {
                    queue.add(temp);
                }
                nextLevelQueue.clear();
            }
        }
        return traversalList;
    }
}
