package queue;

import array.Array;

/**
 * 队列接口
 * @author roy f
 */
public interface Queue<E> {

    /**
     * 获取当前元素个数
     * @return
     */
    int getSize();

    boolean isEmpty();

    /**
     * 入队操作
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队操作
     * @return
     */
    E dequeue();

    /**
     * 获取队列头部元素
     * @return
     */
    E getFront();
}
