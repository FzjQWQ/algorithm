package homework;

import java.util.Stack;

/**
 * leetcode第232题：用栈实现队列
 * fzj的笨方法1
 * @author roy f
 * @date 2022/4/19
 */
class MyQueue {
    private Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        int[] temp = new int[stack.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = stack.pop();
        }
        for (int i = temp.length - 2; i >= 0; i--) {
            stack.push(temp[i]);
        }
        return temp[temp.length - 1];
    }

    public int peek() {
        int[] temp = new int[stack.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = stack.pop();
        }
        for (int i = temp.length - 1; i >= 0; i--) {
            stack.push(temp[i]);
        }
        return temp[temp.length - 1];
    }

    public boolean empty() {
        return stack.empty();
    }

}