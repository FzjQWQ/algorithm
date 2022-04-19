package homework;

/**
 * leetcode 622. 设计循环队列
 *
 * @author roy f
 * @date 2022/4/19
 */
public class MyCircularQueue {
    private final int[] data;

    private int front, tail;

    public MyCircularQueue(int k) {
        data = new int[k + 1];
        tail = 0;
        front = 0;
    }

    /**
     * 向循环队列插入一个元素。如果成功插入则返回真。
     *
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        data[tail] = value;
        if (tail + 1 == data.length) {
            tail = 0;
        } else {
            tail++;
        }
        return true;
    }

    /**
     * 从循环队列中删除一个元素。如果成功删除则返回真。
     *
     * @return
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (front + 1 == data.length) {
            front = 0;
        } else {
            front++;
        }
        return true;
    }

    /**
     * 从队首获取元素。如果队列为空，返回 -1 。
     *
     * @return
     */
    public int Front() {
        return isEmpty() ? -1 : data[front];
    }

    /**
     * 获取队尾元素。如果队列为空，返回 -1 。
     *
     * @return
     */
    public int Rear() {
        return isEmpty() ? -1 : data[tail - 1 == -1 ? data.length - 1 : tail - 1];
    }

    public boolean isEmpty() {
        return front == tail;
    }

    public boolean isFull() {
        return (tail + 1) % data.length == front;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
        //------------------------------------
//        System.out.println(myCircularQueue.enQueue(3));
//        System.out.println(myCircularQueue.enQueue(9));
//        System.out.println(myCircularQueue.enQueue(5));
//        System.out.println(myCircularQueue.enQueue(0));
//        System.out.println(myCircularQueue.deQueue());
//        System.out.println(myCircularQueue.deQueue());
//        System.out.println(myCircularQueue.isEmpty());
//        System.out.println(myCircularQueue.isEmpty());
//        System.out.println(myCircularQueue.Rear());
//        System.out.println(myCircularQueue.Rear());
//        System.out.println(myCircularQueue.deQueue());
        //------------------------------------
    }
}
