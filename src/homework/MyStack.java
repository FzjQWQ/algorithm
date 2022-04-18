package homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * livecode第225题：用队列实现栈
 * @author roy f
 */
class MyStack {

    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {

    }

    public int pop() {
        return 0;
    }

    public int top() {
        return 0;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
