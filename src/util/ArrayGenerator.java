package util;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;

/**
 * 数组生成器
 *
 * @author roy f
 */
public class ArrayGenerator {
    private ArrayGenerator(){}

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成一个成都为n的随机数组，每个数字范围是[0,bound)
     * @param n 数组长度
     * @param bound 随机数最大值
     * @return 数组
     */
    public static Integer[] generateRandomArray(int n,int bound) {
        final Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(bound);
        }
        return arr;

    }

}
