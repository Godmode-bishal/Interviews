package leetcode.treeGraphs;

import java.util.HashMap;
import java.util.Map;

/*We can optimize the N^2 solution using hashing. We store indexes of inorder traversal in a hash table. So that search can be done O(1) time. */
public class BTInPreN {
    static int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder, int startIndex, int endIndex, Map<Integer,Integer> inOrderIndexing) {
        if(startIndex>endIndex)
            return null;
        TreeNode treeNode = new TreeNode(preorder[preorderIndex++]);
        int rootPos = inOrderIndexing.get(treeNode.val);
        treeNode.left = buildTree(preorder, inorder, startIndex, rootPos-1,inOrderIndexing);
        treeNode.right = buildTree(preorder, inorder, rootPos+1, endIndex, inOrderIndexing);
        return treeNode;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        Map<Integer,Integer> inOrderIndexing = new HashMap<>();
        for(int i =0; i<inorder.length; i++) {
            inOrderIndexing.put(inorder[i],i);
        }
        return buildTree(preorder,inorder, 0, inorder.length-1, inOrderIndexing);
    }
}
