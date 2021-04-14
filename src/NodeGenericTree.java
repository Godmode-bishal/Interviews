/**
 * Created by HP on 16-07-2018.
 */
public class NodeGenericTree {
    int value;
    NodeGenericTree firstChild;
    NodeGenericTree nextSibling;
    NodeGenericTree(int value) {
        this.value = value;
        firstChild = null;
        nextSibling = null;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
