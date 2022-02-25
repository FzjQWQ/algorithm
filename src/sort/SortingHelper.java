package sort;

import java.util.function.Consumer;

/**
 * @author roy f
 */
public class SortingHelper {
    private SortingHelper() {

    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 如果前一个大于后一个说明错误
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> void sortTest(String sortName, Consumer<T[]> consumer, T[] arr) {
        final long startTime = System.nanoTime();
        consumer.accept(arr);
        final long endTime = System.nanoTime();
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortName + " failed");
        }
        double time = (endTime - startTime) / 1000000000.0;
        System.out.printf("%s , n = %d : %f s%n", sortName, arr.length, time);
    }
}
