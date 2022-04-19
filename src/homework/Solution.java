package homework;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 1441. 用栈操作构建数组
 * @author roy f
 * @date 2022/4/19
 */
public class Solution {
    public List<String> buildArray(int[] target, int n) {
        int index = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            if (index == target.length) {
                break;
            }
            list.add("Push");
            if (target[index] == i) {
                index++;
            } else {
                list.add("Pop");
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 2;
        System.out.println(solution.buildArray(arr, 4));
    }
}
