package homework;

/**
 * leetcode 1381. 设计一个支持增量操作的栈
 *
 * @author roy f
 * @date 2022/4/19
 */
public class CustomStack {

    int[] data;

    int index;

    public CustomStack(int maxSize) {
        data = new int[maxSize];
        index = -1;
    }

    public void push(int x) {
        if (index != data.length - 1) {
            data[++index] = x;
        }
    }

    public int pop() {
        return index == -1 ? -1 : data[index--];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, index + 1); i++) {
            data[i] += +val;
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        System.out.println(customStack.pop());
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.increment(5, 100);
        customStack.increment(2, 100);
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
    }
}
