package leetcode.treeGraphs;


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public  TreeNode next;
    public TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
