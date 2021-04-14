package leetcode.treeGraphs.kthSmallBST;

public class AugmentedTree
{
    public TreeNode insert(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        // If a node is inserted in left subtree, then
        // lCount of this node is increased. For simplicity,
        // we are assuming that all keys (tried to be
        // inserted) are distinct.
        //TODO What if non-distinct elements are inserted
        if (val < root.data) {
            root.left = insert(root.left, val);
            root.lCount++;
        } else if (val > root.data)
            root.right = insert(root.right, val);
        return root;
    }

    public TreeNode kthSmallest(TreeNode root, int k) {
        // base case
        if (root == null)
            return null;
        int count = root.lCount + 1;
        if (count == k)
            return root;
        if (count > k)
            return kthSmallest(root.left, k);
        // else search in right subtree
        return kthSmallest(root.right, k - count);
    }
}
