package company.bytedance.q0162_1.code;

/**
 * 1、 线性扫描
 *
 * nums[-1] = nums[n] = -∞
 *
 * 故从左到右，出现 nums[i] > nums[i + 1] i 一定为峰值的一个点
 *
 * 时间复杂度 : O(n)。 我们对长度为 n 的数组 nums 只进行一次遍历。
 * 空间复杂度 : O(1)。 只使用了常数空间。
 */
public class Solution1 {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}