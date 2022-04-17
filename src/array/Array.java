package array;

/**
 * 二次封装数组
 *
 * @author roy f
 */
public class Array<E> {
    private E[] data;

    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity 初始化数组的长度
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 向所有元素的最后添加一个元素
     *
     * @param e
     */
    public void addLast(E e) {
        this.add(size, e);
    }

    public void addFirst(E e) {
        this.add(0, e);
    }

    /**
     * 在第index个位置插入一个新元素e
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Require index >= 0 and index <= size.");
        }
        if (size == data.length) {
            resize(data.length << 1);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    /**
     * 获取第index个位置的元素
     *
     * @param index 索引
     * @return 元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    /**
     * 修改index索引位置的元素为e
     *
     * @param index 索引
     * @param e     元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否包含元素
     *
     * @param e 元素
     * @return 是否拥有e
     */
    public boolean container(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 从数组中查找元素e并返回索引
     * 返回第一个e的索引
     *
     * @param e 元素
     * @return 索引值，如果没有则为-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     *
     * @param index 索引
     * @return 删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length >> 2 && data.length >> 1 != 0) {
            resize(data.length >> 1);
        }
        return ret;
    }

    public E removeFirst() {
        return this.remove(0);
    }

    public E removeLast() {
        return this.remove(size - 1);
    }

    /**
     * 如果数组中存在元素e则删除
     * 删除第一个e
     * @param e
     */
    public void removeElement(E e) {
        int index = this.find(e);
        if (index != -1) {
            this.remove(index);
        }
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }
}
