package mergesort;

import sort.SortingHelper;
import util.ArrayGenerator;

import java.util.Arrays;

/**
 * @author roy f
 */
public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        MergeSort.sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        MergeSort.sort(arr, l, mid);
        MergeSort.sort(arr, mid + 1, r);
        MergeSort.merge(arr, l, mid, r);
    }

    /**
     * 合并两个有序的区间 arr[l, mid]和arr[mid + 1, r]
     *
     * @param arr 数组
     * @param l   开始区间
     * @param mid 中间
     * @param r   关闭区间
     * @param <E> 元素
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        final Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("MergeSort", MergeSort::sort, arr);

    }

}
