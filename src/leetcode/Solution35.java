package leetcode;

/**
 * 35. 搜索插入位置
 * 二分查找 大于等于x的最小下标
 * @author roy f
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = nums.length;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6, 7};
        final Solution35 solution35 = new Solution35();
        System.out.println(solution35.searchInsert(nums, 2));
    }
}
