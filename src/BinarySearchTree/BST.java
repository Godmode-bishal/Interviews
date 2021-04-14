package BinarySearchTree;

import javax.xml.soap.Node;

/**
 * Created by HP on 22-07-2018.
 */
public class BST {
    public static void main(String[] args) {
        NodeBST root = new NodeBST(6);
        root.left = new NodeBST(2);
        NodeBST succ = null;
        NodeBST pred = null;

        //Finding an element (Recursive)
        //boolean found = findRecursion(root, 10);
        //Finding an element (without Recursion)
        //boolean found = findNoRecursion(root, 10);
        //System.out.println("data found ? =" + found);
        //Finding least element with recursion
        //System.out.println("The least element in the BST :" + findLeastRecursion(root));
        //Finding least element without recursion
        //System.out.println("The least element in the BST :" + findLeastNoRecursion(root));
        //Inorder predecessor
        //inOrderPredecessorSuccessor(root, 50, pred, succ);
        //insertion- recursive
        //insertNonRecursive(root, 5);
        //recusive deletion
        deleteNonRecursive(root, 6);
    }

    static boolean findRecursion(NodeBST root, int data) {
        if (root == null) {
            return false;
        } else {
            if (data == root.key) {
                return true;
            } else {
                if (data < root.key) {
                    return findRecursion(root.left, data);
                } else {
                    return findRecursion(root.right, data);
                }
            }
        }
    }

    static boolean findNoRecursion(NodeBST root, int data) {
        if (root == null) {
            return false;
        } else {
            while (root != null) {
                if (data == root.key) {
                    return true;
                } else if (data < root.key) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return false;
        }
    }

    static int findLeastRecursion(NodeBST root) {
        if(root == null) {
            return -1;
        }
        else {
            if (root.left != null) {
                return findLeastRecursion(root.left);
            }
            else {
                return root.key;
            }
        }
    }

    static int findLeastNoRecursion(NodeBST root) {
        if(root == null) {
            return -1;
        }
        else {
            while(root.left != null) {
                    root = root.left;
                }
            return root.key;
        }
    }

    static void inOrderPredecessorSuccessor(NodeBST node, int data, NodeBST pred, NodeBST succ) {
        if (node == null) {
            //TODO
            return;
        }
        if(node.key == data) {
            //predecessor
            if(node.left != null) {
                NodeBST temp = node.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                pred = temp;
            }
            //successor
            if(node.right != null) {
                NodeBST temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                succ = temp;
            }
            return;
        }
        else if(node.key < data) {
            pred = node;
            inOrderPredecessorSuccessor(node.right, data, pred, succ);
        }
        else {
            succ = node;
            inOrderPredecessorSuccessor(node.left, data, pred, succ);
        }
     }

    static NodeBST insertRecursive(NodeBST root, int data) {
        if(root == null) {
            root = new NodeBST(data);
            return root;
        }
        else {
            if(data == root.key) {
                System.out.println("Node already present int the BST. Exiting !!");
                return null;
            }
            else if (data < root.key) {
                if(root.left != null) {
                    return insertRecursive(root.left, data);
                }
                else {
                    root.left = new NodeBST(data);
                    return root;
                }
            }
            else {
                if (root.right != null) {
                    return insertRecursive(root.right, data);
                } else {
                    root.right = new NodeBST(data);
                    return root;
                }
            }
        }
    }

    static NodeBST insertNonRecursive(NodeBST root, int data) {
        if(root == null) {
            root = new NodeBST(data);
            return root;
        }
        else {
            while(root != null) {
                if(data == root.key) {
                    System.out.println("Node already present int the BST. Exiting !!");
                    return null;
                }
                else if (data < root.key) {
                    if(root.left != null) {
                        root = root.left;
                    }
                    else {
                        root.left = new NodeBST(data);
                        return root;
                    }
                }
                else {
                    if(root.right != null) {
                        root = root.right;
                    }
                    else {
                        root.right= new NodeBST(data);
                        return root;
                    }
                }
            }
            return null;
        }
    }
//https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
    static NodeBST deleteNonRecursive(NodeBST root, int data) {
        NodeBST temp, parent=null, original = root;
        if (root == null) {
            System.out.println("Root is null. Exiting");
            return null;
        }
        else {
            while(root != null) {
                if (root.key > data) {
                    parent = root;
                    root = root.left;
                } else if (root.key < data) {
                    parent = root;
                    root = root.right;
                } else {
                    if (root.right != null && root.left != null) {
                        temp = findMax(root.left);
                        root.key = temp.key;
                        parent = root;
                        root = root.left;
                        data = temp.key;
                    } else {
                        if (root.right == null) {
                            if (parent == null) {
                                if(root.right == null) {
                                    root = root.left;
                                    original = root;
                                }
                                if(root.left == null) {
                                    root = root.right;
                                    original = root;
                                }
                            }
                            else if(parent.left == root) {
                                parent.left = root.left;
                                root = root.right;
                            }
                            else if(parent.right == root) {
                                parent.right = root.left;
                                root = root.left;
                            }
                        } else if (root.left == null) {
                            if (parent == null) {
                                root = root.right;
                            }
                            if(parent.left == root) {
                                parent.left = root.right;
                                root = root.right;
                            }
                            else if(parent.right == root) {
                                parent.right = root.left;
                                root = root.left;
                            }
                        }
                        else {
                            if(parent.left == root) {
                                parent.left = null;
                            }
                            else {
                                parent.right = null;
                            }
                        }
                    }
                }
            }
            return root;
        }
    }

    static NodeBST findMax(NodeBST node) {
        while(node.right != null) {
                node = node.right;
        }
        return node;
    }
}
