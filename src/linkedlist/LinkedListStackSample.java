package linkedlist;

import stack.Stack;

/**
 * @author roy f
 */
public class LinkedListStackSample {
    public static void main(String[] args) {
        final Stack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
