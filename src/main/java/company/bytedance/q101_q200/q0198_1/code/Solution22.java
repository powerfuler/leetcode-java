package company.bytedance.q101_q200.q0198_1.code;

import java.util.Arrays;

class Solution22 {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);

        return Math.max(rob1(nums1), rob1(nums2));
    }

    public int rob1(int[] nums) {
        if (nums == null || nums.length <1) return 0;
        int length = nums.length;
        int dp[] = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[length];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int rob = new Solution22().rob(nums);
        System.out.println(rob);
    }
}