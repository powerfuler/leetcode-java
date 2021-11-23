package company.bytedance.q701_q800.q0704_1.code;

/**
 *
 *
 */
public class Solution1 {
    public int search(int[] nums, int t) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= t) l = mid;
            else r = mid - 1;
        }
        return nums[r] == t ? r : -1;
    }
}