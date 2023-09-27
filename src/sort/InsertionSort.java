package sort;

import util.ArrayGenerator;

import java.util.Arrays;

/**
 * 插入排序，时间复杂度为O(n^2)
 *
 * @author roy f
 */
public class InsertionSort {
    private InsertionSort() {

    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
//            System.out.println("Random Array : ");
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("InsertionSort", InsertionSort::sort, arr);
//            SortingHelper.sortTest("SelectionSort", SelectionSort::sort, arr2);
//
//            System.out.println();
//
//            System.out.println("Ordered Array : ");
//            arr = ArrayGenerator.generateOrderedArray(n);
//            arr2 = Arrays.copyOf(arr, arr.length);
//            SortingHelper.sortTest("InsertionSort", InsertionSort::sort2, arr);
//            SortingHelper.sortTest("SelectionSort", SelectionSort::sort, arr2);
//            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("InsertionSort2", InsertionSort::sort2, arr2);

        }
    }

    /**
     * 正常逻辑
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j > 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    swap(arr, j, j - 1);
//                } else {
//                    break;
//                }
//            }
//            int j = i;
//            while (j > 0 && arr[j].compareTo(arr[j - 1]) < 0) {
//                swap(arr, j, j - 1);
//                j--;
//            }
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    /**
     * 优化版，性能更好
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E t = arr[i];
            int j;
            for (j = i; j > 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    /**
     * 以相反顺序进行排序，逻辑相同
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            E t = arr[i];
            int j;
            for (j = i; j < arr.length - 1 && t.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
