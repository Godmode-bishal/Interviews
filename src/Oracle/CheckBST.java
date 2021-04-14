package Oracle;
//to check if a bt is a bst
public class CheckBST {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    Node prev;
    /*
    public boolean isBST(Node node, int min, int max) {
        if(node.left == null && node.right == null)
            return true;
        else if (node.left.data<=node.data && node.right.data>=node.data && node.left.data>= min && node.right.data<=max) {
            return (isBST(node.left,min, node.data) && isBST(node.right, node.data, max));
        }
        else {
            return false;
        }
    }*/

    public boolean isBST(Node node) {
        if(node != null) {
            if (!isBST(node.left))
                return false;
            if(prev!=null && node.data<=prev.data)
                return false;
            prev = node;
            return isBST(node.right);
        }
        return true;
    }

    public static void main(String[] args) {
        CheckBST checkBST = new CheckBST();
        CheckBST.Node node = checkBST.new Node(5,null, null);
        CheckBST.Node node1 = checkBST.new Node(1,null, null);
        CheckBST.Node node2 = checkBST.new Node(10, null, null);
        CheckBST.Node node3 = checkBST.new Node(0, null, null);
        CheckBST.Node node4 = checkBST.new Node(4, null, null);
        CheckBST.Node node5 = checkBST.new Node(4, null, null);
        CheckBST.Node node6 = checkBST.new Node(12, null, null);
        node1.left = node3;
        node1.right = node4;
        node.left = node1;
        node.right = node2;
        node2.left = node5;
        node2.right = node6;
        System.out.println(checkBST.isBST(node));
    }
}
