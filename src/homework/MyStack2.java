package homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode第225题：用队列实现栈
 *
 * @author roy f
 */
class MyStack2 {

    private Queue<Integer> q;

    public MyStack2() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        Queue<Integer> q2 = new LinkedList<>();
        // 在队列头部插入数据后再插入老数据
        q2.add(x);
        while(!q.isEmpty()) {
            q2.add(q.remove());
        }
        q = q2;

    }

    /**
     * 移除并返回栈顶元素。
     *
     * @return
     */
    public int pop() {
        return q.remove();
    }

    /**
     * 返回栈顶元素。
     *
     * @return
     */
    public int top() {
        return q.peek();
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
