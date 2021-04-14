package leetcode.treeGraphs;

public class KthSmallBST {
    //Complexity is O(n^2)
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        TreeNode parent = root;
        TreeNode resultant = null;
        for(int i = 0; i<k; i++) {
            while(node.left!=null) {
                parent = node;
                node = node.left;
            }
            if(node.right!=null)
                parent.left = node.right;
            else
                parent.left = null;
            resultant = node;
            node = root;
        }
        return resultant.val;
    }
    static int count = 0;
    //O(n) and O(h) extra space inorder traversal of a bst sorts the input.
    public int kthSmallestInorder(TreeNode root, int k) {
        int result =-1;
        if(root.left != null) {
            result = kthSmallest(root.left, k);
            if(result!=-1)
                return result;
        }
        count++;
        if(k==count) {
            result = root.val;
            count = 0;
            return result;
        }
        if(root.right != null) {
            result = kthSmallest(root.right, k);
            if(result!=-1)
                return result;
        }
        return result;
    }

    public int kthSmallestMorris(TreeNode root, int k) {
        TreeNode current = root;
        while(current != null) {
            if(current.left==null) {
                count++;
                if(count==k) {
                    count = 0;
                    break;
                }
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
                    count++;
                    if(count==k) {
                        count = 0;
                        break;
                    }
                    current = current.right;
                }
            }
        }
        return current.val;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.right = node2;
        KthSmallBST obj = new KthSmallBST();
        obj.kthSmallestInorder(node1,2);
    }
}
