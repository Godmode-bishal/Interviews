package leetcode.treeGraphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextRightPointers {
    public TreeNode connect(TreeNode node, TreeNode parent) {
        if (parent == null || (node == parent.right && parent.next == null)) {
            node.next = null;
        } else if (node != parent.right) {
            node.next = parent.right;
        } else {
            node.next = parent.next.left;
        }
        if (node.left != null)
            connect(node.left, node);
        if (node.right != null)
            connect(node.right, node);
        return node;
    }

    public TreeNode connect(TreeNode root) {
        return connect(root, null);
    }

    //Deque level order traversing
    public TreeNode connectUsingDeque(TreeNode root) {
        if (root == null)
            return root;
        Deque<TreeNode> queue = new ArrayDeque();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int levelsize = queue.size();
            TreeNode prev = null;
            for (int i = 0; i < levelsize; i++) {
                TreeNode node = queue.pollFirst();
                if (prev != null) prev.next = node;
                if (node.left != null) queue.offerLast(node.left);
                if (node.right != null) queue.offerLast(node.right);
                prev = node;
            }
        }
        return root;
    }
}
