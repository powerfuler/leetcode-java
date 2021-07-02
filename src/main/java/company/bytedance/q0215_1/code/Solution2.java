package company.bytedance.q0215_1.code;

import java.util.Arrays;

/**
 *
 * 一共 6 个元素，找第 2 大，索引是 4；
 * 一共 6 个元素，找第 4 大，索引是 2。
 *
 */

public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }
}