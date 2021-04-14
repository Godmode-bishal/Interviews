 package heap;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Heapify {
    static BinaryHeap convertTreeToHeap(Node root, int type) {
        int i = 0;
        BinaryHeap binaryHeap = new BinaryHeap(type);
        int[] array = binaryHeap.getArray();
        array = new int[15];
        Queue<Node> queue = new LinkedList<>();
        if(root == null) {
            System.out.println("Tree passed is null");
            return null;
        }
        queue.add(root);
        while(queue.peek() != null){
            if(queue.peek().left!=null || queue.peek().right!=null) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
            }
                array[i++] = (int)queue.remove().key;
        }
        binaryHeap.setArray(array);
        binaryHeap.setCount(i);
        binaryHeap.setCapacity(array.length);
        return binaryHeap;
    }

    static int findParent(BinaryHeap binaryHeap, int i) {
        if(i<=0 || i >= binaryHeap.getCount()) {
            return -1;
        }
        else {
            return ((i-1)/2);
        }
    }

    static int leftChild(BinaryHeap binaryHeap, int i) {
        int left = 2*i + 1;
        if(left >= binaryHeap.getCount()) {
            return  -1;
        }
        else {
            return left;
        }
    }

    static int rightChild(BinaryHeap binaryHeap, int i) {
        int right = 2*i + 2;
        if(right >= binaryHeap.getCount()) {
            return  -1;
        }
        else {
            return right;
        }
    }

    static int getMin(BinaryHeap binaryHeap) {
        if(binaryHeap.getCount()==0) {
            return -1;
        }
        else {
            return binaryHeap.getArray()[0];
        }
    }

    static void percolateDown(BinaryHeap binaryHeap, int i) {
        int left = leftChild(binaryHeap, i);
        int right = rightChild(binaryHeap, i);
        int max, temp;
        int[] array = binaryHeap.getArray();
        if(left != -1 && array[left] > array[i] ) {
            max  = left;
        }
        else {
            max = i;
        }
        if(right != -1 && array[right] > array[max]) {
            max = right;
        }
        if(max != i) {
            temp = array[i];
            array[i] = array[max];
            array[max] = temp;
            binaryHeap.setArray(array);
            percolateDown(binaryHeap, max);
        }
    }

    static BinaryHeap delete(BinaryHeap binaryHeap) {
        if(binaryHeap.getCount() == 0) {
            System.out.println("BinaryHeap is null");
            return null;
        }
        int[] array = binaryHeap.getArray();
        array[0] = array[binaryHeap.getCount() - 1];
        array[binaryHeap.getCount() - 1] = 0;
        binaryHeap.setArray(array);
        binaryHeap.setCount(binaryHeap.getCount() - 1);
        percolateDown(binaryHeap, 0);
        return binaryHeap;
    }

    static BinaryHeap insert(BinaryHeap binaryHeap, int data) {
        int[] array = binaryHeap.getArray();
        if(binaryHeap.getCapacity() == binaryHeap.getCount()) {
            array = new int[binaryHeap.getCapacity()*2];
            binaryHeap.setCapacity(binaryHeap.getCapacity()*2);
        }
        int i = binaryHeap.getCount();
        array[i] = data;
        binaryHeap.setCount(binaryHeap.getCount()+1);
        int temp;
        while(i > 0) {
            if(array[i] > array[(i-1)/2]) {
                temp = array[i];
                array[i] = array[(i-1)/2];
                array[(i-1)/2] = temp;
            }
            i = (i-1)/2;
        }
        binaryHeap.setArray(array);
        return binaryHeap;
    }

    static BinaryHeap buildHeap(int[] array) {
        BinaryHeap binaryHeap = new BinaryHeap(1);
        binaryHeap.setArray(array);
        binaryHeap.setCount(binaryHeap.getArray().length);
        binaryHeap.setCapacity(binaryHeap.getArray().length);
        for(int i=(array.length-1)/2;i>=0;i--) {
            percolateDown(binaryHeap, i);
        }

        return binaryHeap;
    }

    public static void main(String[] args) {
        /*Node node = new Node(1);
        node.left = new Node(5);
        node.right = new Node(14);
        node.left.left = new Node(2);
        node.left.right = new Node(10);
        node.right.left = new Node(21);
        node.right.right = new Node(18);
        node.left.left.left = new Node(3);
        node.left.left.right = new Node(11);
        node.left.right.left = new Node(8);
        node.left.right.right = new Node(7);
        node.right.left.left = new Node(12);*/
        //BinaryHeap binaryHeap = convertTreeToHeap(node, 1);
        //System.out.println("sorting.Parent of element at position 3 is at position " + findParent(binaryHeap, 3));
        //System.out.println("Min element in the binary heap is "+getMin(binaryHeap));
        //System.out.println("Culprit element "+binaryHeap.getArray()[1]);
        //percolateDown(binaryHeap, 1);
        //binaryHeap = delete(binaryHeap);
        //binaryHeap = insert(binaryHeap, 19);
        int[] array = {1,5,14,2,10,21,18,3,11,8,7,12};
        BinaryHeap binaryHeap = buildHeap(array);
        int old_size = binaryHeap.getCount();
        int temp;
        int i = binaryHeap.getCount()-1;
        for(; i>0; i--) {
            array = binaryHeap.getArray();
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            binaryHeap.setCount(i);
            binaryHeap.setArray(array);
            percolateDown(binaryHeap,0);
        }
        binaryHeap.setCount(old_size);
    }
}

