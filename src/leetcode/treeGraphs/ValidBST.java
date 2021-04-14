/*
package leetcode.treeGraphs;

public class ValidBST {
    //a bst in inorder traversal sorts
    TreeNode prev;
    public boolean isValid(TreeNode root) {
        if (root != null) {
            if (!isValid(root.left))
                return false;
            if (prev != null && prev.val >= root.val)
                return false;
            prev = root;
            return isValid(root.right);
        }
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return isValid(root);
    }

    }
}
*/
