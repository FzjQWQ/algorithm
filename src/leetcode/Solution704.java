package leetcode;

/**
 * 704. 二分查找
 * @author roy f
 */
public class Solution704 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
