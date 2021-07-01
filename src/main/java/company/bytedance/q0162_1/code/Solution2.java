package company.bytedance.q0162_1.code;

/**
 * 1. 递归二分查找
 *
 * 递归取值 nums[mid] > nums[mid + 1] 峰值在左
 * nums[mid] < nums[mid + 1] 峰值在右
 * 时间复杂度 : O(log2(n))。每一步都将搜索空间减半。因此，总的搜索空间只需要 log 2(n) 步。其中 nn 为 nums 数组的长度。
 * 空间复杂度: O(log2(n))。每一步都将搜索空间减半。因此，总的搜索空间只需要 log 2(n) 步。于是，递归树的深度为log 2(n)。
 *
 */
public class Solution2 {
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, l, mid);
        }
        return search(nums, mid + 1, r);
    }
}