package queue;

import java.util.Arrays;

/**
 * 循环队列
 * 定义：front==tail数组为空
 * (tail+1) % capacity == front数组为满
 *
 * @author roy f
 */
public class LoopQueue<E> implements Queue<E> {
    E[] data;

    /**
     * 队首存在的索引，队列最后一个元素下一个索引
     */
    private int front, tail;

    private int size;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 获取最多能放几个元素
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            this.resize(getCapacity() << 1);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (this.getCapacity() >> 1 != 0 && size == this.getCapacity() >> 2) {
            this.resize(this.getCapacity() >> 1);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
