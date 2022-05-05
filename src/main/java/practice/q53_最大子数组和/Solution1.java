package practice.q53_最大子数组和;

/**
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 */
class Solution1 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        int ans = f[0];

        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(nums[i], f[i - 1] + nums[i]);
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

}