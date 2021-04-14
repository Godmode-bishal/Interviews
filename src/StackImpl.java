import java.util.Stack;

/**
 * Created by HP on 07-07-2018.
 */
public class StackImpl {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack_push(stack);
        stack_pop(stack);
        stack_push(stack);
        stack_peep(stack);
        stack_search(stack, 2);
        stack_search(stack, 6);
    }

    //Pushing element on top of stack
    static void stack_push(Stack stack) {
        for(int i=1; i<=5; i++) {
            stack.push(i);
        }
    }

    //popping elements from top of stack
    static void stack_pop(Stack stack) {
        System.out.println("Pop : ");
        for(int i=1;i<=5;i++) {
            int y = (Integer)stack.pop();
            System.out.println(y);
        }
    }

    //displaying element on top of stack
    static void stack_peep(Stack stack) {
        int element = (Integer)stack.peek();
        System.out.println("Element on stack top "+element);
    }

    //search element in the stack
    static void stack_search(Stack stack, int element) {
        int pos = (Integer)stack.search(element);
        if(pos == -1) {
            System.out.println("Element not found");
        }
        else {
            System.out.println("Element found at "+pos);
        }
    }
}
