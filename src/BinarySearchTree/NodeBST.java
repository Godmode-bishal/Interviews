package BinarySearchTree;

/**
 * Created by HP on 07-07-2018.
 */
public class NodeBST {
    int key;
    NodeBST left, right;
    NodeBST(int item) {
        key = item;
        left = right = null;
    }

    @Override
    public String toString() {
        return Integer.toString(key);
    }
}
