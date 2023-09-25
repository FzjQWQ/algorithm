package linkedlist;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 链表数据结构
 *
 * @author roy f
 */
public class LinkedList<E> implements Iterable<E> {


    /**
     * 使用虚拟节点代替head
     */
    private Node dummyHead;

    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加新的元素e
     *
     * @param e 元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e
     * 在链表中不是一个常用的操作,仅作为练习使用 :)
     *
     * @param index 插入的位置
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;

    }

    /**
     * 在链表的末尾添加新的元素e
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表的第index个元素
     * 在链表中不是一个常用的操作,仅作为练习使用 :)
     *
     * @param index 位置
     * @return 元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     *
     * @return result
     */
    public E getFirst() {
        return dummyHead.next.e;
    }

    /**
     * 获取链表的最后一个元素
     *
     * @return result
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表第index给位置的元素e
     * 在链表中不是一个常用的操作,仅作为练习使用 :)
     *
     * @param index 位置
     * @param e     元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e
     *
     * @param e 元素
     * @return 是否存在
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除第index个元素
     * 仅练习
     * @param index 位置
     * @return 删除元素
     */
    public E remove(int index) {
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node cur = prev.next;
        prev.next = cur.next;
        cur.next = null;
        size--;
        return cur.e;
    }

    /**
     * 从链表中删除第一个元素
     * @return 删除元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素
     * @return 删除元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        // while等价于for(Node cur = dummyHead.next; cur != null; cur = cur.next)
        while (cur != null) {
            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public LinkedList(E[] arr) {
        this();
        for (E e : arr) {
            size++;
            getNext(dummyHead).next = new Node(e);
        }
    }

    private Node getNext(Node head) {
        return head.next == null ? head : getNext(head.next);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Spliterator<E> spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public void forEach(Consumer action) {
        Node node = dummyHead.next;
        for (int i = 0; i < size; i++) {
            action.accept(node);
            node = node.getNext();
        }
    }

    /**
     * 设置为私有内部类，对于用户而言，不需要知道Node是如何实现的
     */
    private class Node {
        public E e;

        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        public Node getNext() {
            return next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

}
