package heap;

/**
 * Created by HP on 07-07-2018.
 */
public class Node {
    int key;
    Node left, right;
    Node(int item) {
        key = item;
        left = right = null;
    }

    @Override
    public String toString() {
        return Integer.toString(key);
    }
}
