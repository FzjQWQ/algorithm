package homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * livecode第225题：用队列实现栈
 *
 * @author roy f
 */
class MyStack {

    private Queue<Integer> q;

    private static Queue<Integer> temp = new LinkedList<>();

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
    }

    /**
     * 移除并返回栈顶元素。
     *
     * @return
     */
    public int pop() {
        if (this.empty()) {
            return -1;
        }
        temp = new LinkedList<>();
        int result = 0;
        int size = q.size();
        for (int i = 0; i <= size; i++) {
            if (q.peek() == null) {
                break;
            }
            temp.add(result = q.poll());
        }
        size = temp.size();
        for (int i = 1; i < size; i++) {
            q.add(temp.poll());
        }
        return result;
    }

    /**
     * 返回栈顶元素。
     *
     * @return
     */
    public int top() {
        if (this.empty()) {
            return -1;
        }
        temp = new LinkedList<>();
        int result = 0;
        int size = q.size();
        for (int i = 0; i <= size; i++) {
            if (q.peek() == null) {
                break;
            }
            result = q.peek();
            temp.add(q.poll());
        }
        size = temp.size();
        for (int i = 1; i <= size; i++) {
            q.add(temp.poll());
        }
        return result;
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
