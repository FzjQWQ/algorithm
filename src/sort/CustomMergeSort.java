package sort;


import util.ArrayGenerator;

/**
 * 主观实现归并排序
 *
 * @author roy f
 */
public class CustomMergeSort {

    public static void main(String[] args) {

        final CustomMergeSort sort = new CustomMergeSort();
//        final int[] sorted = sort.sort(new int[]{1, 8, 2, 5, 8, 7, 0, 5, 5, 8, 3});
//        final Integer[] sorted = sort.sort(ArrayGenerator.generateRandomIntegerArray(100, 1000));
//        for (int i : sorted) {
//            System.out.print(i + " ");
//        }
//        final boolean success = SortingHelper.isSorted(sorted);
//        System.out.println(success);
        SortingHelper.sortResTest("CustomMergeSort", CustomMergeSort::sort, ArrayGenerator.generateRandomIntegerArray(10000, 100000));

    }

    private static Integer[] sort(Integer[] arr) {
        int l = 0;
        int r = arr.length - 1;
        return CustomMergeSort.childSort(arr, l, r);
    }

    private static Integer[] childSort(Integer[] arr, int l, int r) {
        int mid = (l + r) / 2;
        if (l + 1 == r) {
            if (arr[l] < arr[r]) {
                return new Integer[]{arr[l], arr[r]};
            } else {
                return new Integer[]{arr[r], arr[l]};
            }
        }
        if (l >= r) {
            return new Integer[]{arr[r]};
        }
        return CustomMergeSort.merge(CustomMergeSort.childSort(arr, l, mid), CustomMergeSort.childSort(arr, mid + 1, r));
    }

    private static Integer[] merge(Integer[] arr1, Integer[] arr2) {
        Integer[] res = new Integer[arr1.length + arr2.length];
        int arr1Index = 0;
        int arr2Index = 0;
        for (int i = 0; i < res.length; i++) {
            if (arr1Index == arr1.length) {
                res[i] = arr2[arr2Index++];
                continue;
            }
            if (arr2Index == arr2.length) {
                res[i] = arr1[arr1Index++];
                continue;
            }
            if (arr1[arr1Index] < arr2[arr2Index]) {
                res[i] = arr1[arr1Index++];
            } else {
                res[i] = arr2[arr2Index++];
            }
        }
        return res;
    }

}
