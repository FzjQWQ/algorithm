package queue;

/**
 * 双端队列
 *
 * @author roy f
 */
public class Deque<E> {

    private E[] data;

    private int front, tail;

    private int size;

    public Deque() {
        this(10);
    }

    public Deque(int capacity) {
        this.data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 从队尾插入元素
     *
     * @param e
     */
    public void addLast(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() << 1);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public void addFront(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        // 我们首先需要确定添加新元素的索引位置
        // 这个位置是 front - 1 的地方
        // 但是要注意，如果 front == 0，新的位置是 data.length - 1 的位置
        front = front == 0 ? data.length - 1 : front - 1;
        data[front] = e;
        size++;
    }

    public E removeFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        final E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (getCapacity() >> 1 != 0 && size == getCapacity() >> 2) {
            resize(getCapacity() >> 1);
        }
        return ret;
    }

    // removeLast 是新的方法，请大家注意
    public E removeLast(){

        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        final E ret = data[tail];
        data[tail] = null;
        tail = tail == 0 ? data.length - 1 : tail - 1;
        size--;
        if (getCapacity() >> 1 != 0 && size == getCapacity() >> 2) {
            resize(getCapacity() >> 1);
        }
        return ret;
    }

    public E getFront(){
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    // 因为是双端队列，我们也有一个 getLast 的方法，来获取队尾元素的值
    public E getLast(){
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        // 因为 tail 指向的是队尾元素的下一个位置，我们需要计算一下真正队尾元素的索引
        int index = tail == 0 ? data.length - 1 : tail - 1;
        return data[index];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for (int i = 0; i < size; i++) {
            res.append(data[(i + front) % data.length]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
