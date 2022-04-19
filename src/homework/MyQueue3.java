package homework;

import java.util.Stack;

/**
 * leetcode第232题：用栈实现队列
 * @author roy f
 * @date 2022/4/19
 */
class MyQueue3 {
    private Stack<Integer> stack;

    int front;

    public MyQueue3() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (empty()) {
            front = x;
        }
        stack.push(x);
    }

    public int pop() {
        Stack<Integer> stack2 = new Stack<>();
        while (stack.size() > 1) {
            front = stack.peek();
            stack2.push(stack.pop());
        }
        int result = stack.pop();
        while (!stack2.empty()) {
            stack.push(stack2.pop());
        }
        return result;
    }

    public int peek() {
        return front;
    }



    public boolean empty() {
        return stack.empty();
    }

}