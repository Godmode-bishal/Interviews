import leetcode.treeGraphs.TreeNode;

public class MorrisInorder {
    public void inorder(TreeNode root) {
        TreeNode current = root;
        while(current != null) {
            if(current.left==null) {
                System.out.print(current.val + " ->");
                current = current.right;
            }
            else {
                TreeNode predecessor = current.left;
                while(predecessor.right!=null && predecessor.right!=current) {
                    predecessor = predecessor.right;
                }
                if(predecessor.right==null) {
                    predecessor.right = current;
                    //For preorder, sout here
                    current = current.left;
                }
                else {
                    predecessor.right = null;
                    //For preorder, remove the next line
                    System.out.print(current.val + "->");
                    current = current.right;
                }
            }
        }
    }
}
