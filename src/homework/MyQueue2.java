package homework;

import java.util.Stack;

/**
 * leetcode第232题：用栈实现队列
 * @author roy f
 * @date 2022/4/19
 */
class MyQueue2 {
    private Stack<Integer> stack;

    public MyQueue2() {
        stack = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> stack2 = new Stack<>();
        while (!stack.empty()) {
            stack2.push(stack.pop());
        }
        stack2.push(x);
        while (!stack2.empty()) {
            stack.push(stack2.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }

}