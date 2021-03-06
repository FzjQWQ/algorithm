package homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode第225题：用队列实现栈
 *
 * @author roy f
 */
class MyStack {

    private Queue<Integer> q;

    private int top;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        top = x;
    }

    /**
     * 移除并返回栈顶元素。
     *
     * @return
     */
    public int pop() {
        Queue<Integer> temp = new LinkedList<>();
        while (q.size() > 1) {
            top = q.peek();
            temp.add(q.remove());
        }
        int result = q.remove();
        q = temp;
        return result;
    }

    /**
     * 返回栈顶元素。
     *
     * @return
     */
    public int top() {
        //使用top变量维护top
        //如果不使用top变量则调用pop后将结果重新push进队列
        return top;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

