import java.util.*;
import java.util.LinkedList;

/**
 * Created by HP on 07-07-2018.
 */
public class BinaryTree {
    Node root;
    BinaryTree() {
        root = null;
    }
    BinaryTree(int item) {
        root = new Node(item);
    }
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        System.out.println("Preorder traversal");
        //preOrder(binaryTree.root);
        //preOrderWithoutRecursion(binaryTree.root);
        //inOrder(binaryTree.root);
        //inOrderWithoutRecursion(binaryTree.root);
        //postOrderWithoutRecursion(binaryTree.root);
        levelOrder(binaryTree.root);
    }

    static void preOrder(Node root) {
        if(root != null) {
            System.out.print(root + "-->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    static  void preOrderWithoutRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        while(true) {
            while(root != null) {
                System.out.print(root + "-->");
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()) {
                break;
            }
            else {
                    root = stack.pop().right;
                }
        }
    }
    static void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root + "-->");
            inOrder(root.right);
        }
    }
    static  void inOrderWithoutRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        while(true) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()) {
                break;
            }
            else {
                root = stack.pop();
                System.out.print(root + "-->");
                root = root.right;
            }
        }
    }
    static void postOrder(Node root) {
        if(root != null) {
            preOrder(root.left);
            preOrder(root.right);
            System.out.print(root + "-->");
        }
    }
    static  void postOrderWithoutRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        int counter = 0;
        while (!stack.isEmpty() || counter == 0) {
            counter++;
            while (root != null) {
                if (root.right != null) {
                    stack.push(root.right);
                }
                stack.push(root);
                root = root.left;

            }
            root = stack.pop();
            if (!stack.isEmpty() && root.right != null && stack.peek() == root.right) {
                stack.pop();
                stack.push(root);
                root = root.right;
            } else {
                System.out.print(root.key + " -->");
                root = null;
            }
        }
    }

    static  void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node node = null;
        while(!queue.isEmpty()) {
            node = queue.poll();
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
            System.out.print(node+" -->");
        }
    }
}
