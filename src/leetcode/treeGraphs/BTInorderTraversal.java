package leetcode.treeGraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BTInorderTraversal {
    public void BTInorder(TreeNode root, List<Integer> out) {
        if(root.left != null)
            BTInorder(root.left, out);
        out.add(root.val);
        if(root.right != null)
            BTInorder(root.right, out);
    }
    public  List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output =  new ArrayList<>();
        if(root!=null)
            BTInorder(root,output);
        return output;
    }
    public List<Integer> inorderTraversalStack(TreeNode root) {
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }
        while(!st.isEmpty()){
            TreeNode curr = st.poll();
            result.add(curr.val);
            curr = curr.right;
            while(curr!=null)
            {
                st.push(curr);
                curr=curr.left;
            }
        }
        return result;
    }
}
