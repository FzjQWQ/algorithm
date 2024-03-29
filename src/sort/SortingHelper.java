package sort;

import java.util.function.Consumer;
import java.util.function.Function;

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
        processingTime(SortingHelper.isSorted(arr), sortName, endTime, startTime, arr.length);
    }

    public static <T extends Comparable<T>> void sortResTest(String sortName, Function<T[],T[]> function, T[] arr) {
        final long startTime = System.nanoTime();
        final T[] res = function.apply(arr);
        final long endTime = System.nanoTime();
        processingTime(SortingHelper.isSorted(res), sortName, endTime, startTime, arr.length);
    }

    private static <T extends Comparable<T>> void processingTime(boolean isOrderly, String sortName, long endTime, long startTime, int arr) {
        if (!isOrderly) {
            throw new RuntimeException(sortName + " failed");
        }
        double time = (endTime - startTime) / 1000000000.0;
        System.out.printf("%s , n = %d : %f s%n", sortName, arr, time);
    }
}
