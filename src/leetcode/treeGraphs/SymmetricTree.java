package leetcode.treeGraphs;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root, TreeNode root2) {
        if(root== null && root2 == null)
            return true;
        if(root!= null && root2 != null && root.val == root2.val && isSymmetric(root.left, root2.right) && isSymmetric(root.right, root2.left)) {
            return true;
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;
        treeNode3.right = treeNode5;
        SymmetricTree obj = new SymmetricTree();
        System.out.println(obj.isSymmetric(treeNode1));
    }
}
