package 剑指.q42_连续子数组的最大和;

/**
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            cur += num;
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }

}