package queue;

import java.util.Random;

/**
 * @author roy f
 */
public class QueueTest {
    /**
     * 测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
     * @param q
     * @param opCount
     * @return
     */
    private static double testQueue(Queue<Integer> q, int opCount) {
        final long startTime = System.nanoTime();

        final Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        final long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        final double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        final double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

    }
}
