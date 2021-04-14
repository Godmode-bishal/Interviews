package AVL;

public class NodeAVL {
    int data;
    NodeAVL left;
    NodeAVL right;
    int height;

    public NodeAVL(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void getHeight(NodeAVL node) {
        if(node == null) {

        }
        else if(node.left != null && node.right != null){
            this.height += 1;
            getHeight(node.left);
            getHeight(node.right);
        }
    }
}
