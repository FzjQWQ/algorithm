package queue;

/**
 * @author roy f
 */
public class QueueSample {
    public static void main(String[] args) {
//        final ArrayQueue<Integer> queue = new ArrayQueue<>();
//        for (int i = 0; i < 10; i++) {
//            queue.enqueue(i);
//            System.out.println(queue);
//            if (i % 3 == 2) {
//                queue.dequeue();
//                System.out.println(queue);
//            }
//        }
        loopQueue();
    }

    private static void loopQueue() {
        final LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}
