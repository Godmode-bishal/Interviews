package Celigo;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SuperStack {
    /*
     * Complete the function below.
     */
    static void superStack(String[] operations) {
        Stack<Integer> sStack = new Stack<>();
        String[] splitInput;
        int i, v;
                for (String input : operations) {
                splitInput = input.split(" ");
                if (input.startsWith("push")) {
                    sStack.push(Integer.parseInt(splitInput[1]));
                } else if (input.startsWith("pop")) {
                    if(!sStack.isEmpty())
                        sStack.pop();
                } else if (input.startsWith("inc")) {
                    i = Integer.parseInt(splitInput[1]);
                    v = Integer.parseInt(splitInput[2]);
                    for (int j = 0; j < i; j++) {
                        sStack.set(j, sStack.get(j) + v);
                    }
                }
                    if(!sStack.isEmpty())
                        System.out.println(sStack.peek());
                    else
                        System.out.println("EMPTY");

                }
    }
}
