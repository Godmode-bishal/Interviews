package leetcode.treeGraphs;

//O(n^2) approach
public class BTFromInPReN2 {
    static int preIndex = 0;
    public TreeNode buildTree(int[] in, int[] pre, int inStart, int inEnd){
        if(inStart> inEnd)
            return null;
        //Pick current node from Preorder using preIndex and increment preIndex
        TreeNode node = new TreeNode(pre[preIndex++]);
        //If this node has no children then return
        if(inStart==inEnd)
            return node;
        //Else find the index of this node in Inorder traversal
        int inIndex = search(in, inStart, inEnd, node.val);
        node.left = buildTree(in,pre, inStart, inIndex-1);
        node.right = buildTree(in, pre, inIndex+1, inEnd);
        return node;
    }
    public int search(int[] in, int inStart, int inEnd, int searchVal) {
        int i;
        for(i=0; i<in.length; i++) {
            if(in[i]==searchVal)
                return i;
        }
        return i;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        return buildTree(inorder, preorder, 0, preorder.length-1);
    }
}
