import java.util.*;
import java.util.LinkedList;

/**
 * Created by HP on 07-07-2018.
 */
public class QueueImpl {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < 5; i++) {
            q.add(i);
        }
        //Add elements to queue
        System.out.println("Elements of queue- " +q);

        //Remove the head of the queue
        int removedHead = q.remove();
        System.out.println("Removed element- "+removedHead);

        System.out.println(q);

        //To view head of the queue
        int head = q.peek();
        System.out.println("Head of queue- "+head);

        //Rest all methods of Collection interface can be used as usual
        int size = q.size();
        System.out.println("Size of queue - "+size);
    }
}
