package company.bytedance.q0162_1.code;

/**
 * 1. 迭代二分查找
 *
 * 时间复杂度 : O(log 2(n))。 每一步都将搜索空间减半。因此，总的搜索空间只需要log2(n) 步。其中 nn 为 nums 数组的长度。
 * 空间复杂度 : O(1)。 只使用了常数空间。
 */
public class Solution3 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}