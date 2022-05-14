package linkedlist;

/**
 * @author roy f
 */
public class LinkedListSample {
    public static void main(String[] args) {
        Integer[] arr = new Integer[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        final LinkedList<Integer> integerLinkedList = new LinkedList<>(arr);
//        integerLinkedList.forEach(System.out::println);
        System.out.println(integerLinkedList.get(3));
        System.out.println(integerLinkedList.getFirst());
        integerLinkedList.set(3, 888);
        System.out.println(integerLinkedList.get(3));
        System.out.println(integerLinkedList.contains(5));
        System.out.println(integerLinkedList);
//        System.out.println("size = "+integerLinkedList.getSize());
    }
}
