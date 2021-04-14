/**
 * Created by HP on 16-07-2018.
 */
public class GenericTree {
     static NodeGenericTree root = null;
    GenericTree() {
        root = new NodeGenericTree(1);
        root.firstChild = new NodeGenericTree(2);
        root.firstChild.nextSibling = new NodeGenericTree(3);
        root.firstChild.nextSibling.nextSibling = new NodeGenericTree(4);
        root.firstChild.nextSibling.nextSibling.firstChild = new NodeGenericTree(5);
    }
    public static void main(String... args) {
        GenericTree genericTree = new GenericTree();
        traverse(root);
    }

    static void traverse(NodeGenericTree root) {
        if(root != null) {
            System.out.print(root + " ->");
            traverse(root.nextSibling);
            traverse(root.firstChild);
        }

    }
}
