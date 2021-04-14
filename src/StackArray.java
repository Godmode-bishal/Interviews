import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by HP on 23-06-2018.
 */
//TODO create stack with an array
    //TODO support underflow overflow
    //TODO push(), pop(), top(), size(), isEmptyStack(), isFullStack()
public class StackArray {
    static int top = -1;
    static int stackArray[] = new int[20];
    public static void main(String... args) {
        for(int i = 1; i< 5; i++) {
            push(i);
        }
        for (int i = top;i >=  0; i--) {
            System.out.print(stackArray[i]+" ->");
        }
        System.out.println("");
        for(int i=0;i<2; i++) {
            pop();
        }
        for (int i = top;i >=  0; i--) {
            System.out.print(stackArray[i]+" ->");
        }
        System.out.println("");
        System.out.println("The top most element is stored at "+(top()+1)+ " and the element is "+stackArray[top]);
        size();
        isEmpty();
        isFullStack();
    }
    static void push(int entry) {
        top++;
        stackArray[top] = entry;
    }
    static void pop() {
        stackArray[top] = 0;
        top--;
    }
    static int top() {
        return top;
    }
    static void size() {
        System.out.println("Size of the stack is " + (top+1));
    }
    static void isEmpty() {
        if(top == -1) {
            System.out.println("Stack is empty");
        }
        else {
            System.out.println("Stack is not empty");
        }
    }
    static void isFullStack() {
        if(top ==stackArray.length-1) {
            System.out.println("Stack is full");
        }
        else {
            System.out.println("Stack is not full");
        }
    }
}
