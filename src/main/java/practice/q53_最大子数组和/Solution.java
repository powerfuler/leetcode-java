package practice.q53_最大子数组和;

/**
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        int cur = 0;
        int max = Integer.MIN_VALUE;
        int length = 0;
        for (int num : nums) {
            cur += num;
            if(max < cur){
                length++;
            }
            max = Math.max(max, cur);

            cur = cur < 0 ? 0 : cur;
            length = cur == 0 ? 0 : length;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        new Solution1().maxSubArray(nums);
    }

}