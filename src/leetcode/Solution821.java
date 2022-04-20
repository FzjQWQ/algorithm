package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 821. 字符的最短距离
 *
 * @author roy f
 * @date 2022/4/19
 */
public class Solution821 {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        for (int i = 0, idx = -n; i < n; i++) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = i - idx;
        }
        for (int i = n - 1, idx = n << 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = Math.min(ans[i], idx - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution821 solution821 = new Solution821();
        for (int i : solution821.shortestToChar("abaa", 'b')) {
            System.out.print(i);
        }
    }
}
